// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob.specialized.cryptography;

import com.azure.core.cryptography.AsyncKeyEncryptionKey;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelinePosition;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.test.TestMode;
import com.azure.core.test.utils.TestUtils;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.ProgressListener;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.json.JsonProviders;
import com.azure.json.JsonReader;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.BlobUrlParts;
import com.azure.storage.blob.ProgressReceiver;
import com.azure.storage.blob.models.BlobDownloadHeaders;
import com.azure.storage.blob.models.BlobDownloadResponse;
import com.azure.storage.blob.models.BlobErrorCode;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.models.BlobProperties;
import com.azure.storage.blob.models.BlobRange;
import com.azure.storage.blob.models.BlobRequestConditions;
import com.azure.storage.blob.models.BlobStorageException;
import com.azure.storage.blob.models.BlobType;
import com.azure.storage.blob.models.BlockBlobItem;
import com.azure.storage.blob.models.BlockListType;
import com.azure.storage.blob.models.DownloadRetryOptions;
import com.azure.storage.blob.models.LeaseStateType;
import com.azure.storage.blob.models.LeaseStatusType;
import com.azure.storage.blob.models.ParallelTransferOptions;
import com.azure.storage.blob.options.BlobParallelUploadOptions;
import com.azure.storage.blob.specialized.BlobClientBase;
import com.azure.storage.blob.specialized.BlobInputStream;
import com.azure.storage.blob.specialized.BlockBlobClient;
import com.azure.storage.common.implementation.Constants;
import com.azure.storage.common.test.shared.extensions.LiveOnly;
import com.azure.storage.common.test.shared.policy.PerCallVersionPolicy;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.BlobEncryptionPolicy;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.security.GeneralSecurityException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static com.azure.core.test.utils.TestUtils.assertArraysEqual;
import static com.azure.storage.blob.specialized.cryptography.CryptographyConstants.ENCRYPTION_DATA_KEY;
import static com.azure.storage.blob.specialized.cryptography.CryptographyConstants.GCM_ENCRYPTION_REGION_LENGTH;
import static com.azure.storage.blob.specialized.cryptography.CryptographyConstants.NONCE_LENGTH;
import static com.azure.storage.blob.specialized.cryptography.CryptographyConstants.TAG_LENGTH;
import static com.azure.storage.common.test.shared.StorageCommonTestUtils.convertInputStreamToByteArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("deprecation")
public class EncryptedBlockBlobApiTests extends BlobCryptographyTestBase {
    private static final String KEY_ID = "keyId";
    private EncryptedBlobClient bec; // encrypted client
    private BlobContainerClient cc;
    private FakeKey fakeKey;
    private FakeKeyResolver fakeKeyResolver;
    private static final HttpHeaderName X_MS_META_ENCRYPTIONDATA
        = HttpHeaderName.fromString("x-ms-meta-encryptiondata");

    @Override
    protected void beforeTest() {
        super.beforeTest();
        fakeKey = new FakeKey(KEY_ID, (getTestMode() == TestMode.LIVE) ? getRandomByteArray(256) : MOCK_RANDOM_DATA);
        fakeKeyResolver = new FakeKeyResolver(fakeKey);

        cc = getServiceClientBuilder(ENV.getPrimaryAccount()).buildClient()
            .getBlobContainerClient(generateContainerName());
        cc.create();

        bec = getEncryptionClient(EncryptionVersion.V1);
    }

    EncryptedBlobClient getEncryptionClient(EncryptionVersion version) {
        return getEncryptionClient(version, null);
    }

    EncryptedBlobClient getEncryptionClient(EncryptionVersion version, String blobName) {
        blobName = blobName == null ? generateBlobName() : blobName;
        return new EncryptedBlobClient(
            mockAesKey(getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl(), version).blobName(blobName).buildEncryptedBlobAsyncClient()));
    }

    @LiveOnly
    @ParameterizedTest
    @ValueSource(
        ints = {
            3000,
            5 * 1024 * 1024 - 10,
            20 * 1024 * 1024 - 10,
            4 * 1024 * 1024,
            4 * 1024 * 1024 - 10,
            8 * 1024 * 1024 })
    public void v2DownloadTest(int dataSize) {
        ByteBuffer data = getRandomData(dataSize);
        bec = getEncryptionClient(EncryptionVersion.V2);
        bec.uploadWithResponse(new BlobParallelUploadOptions(BinaryData.fromByteBuffer(data)), null, null);
        ByteArrayOutputStream plaintextOut = new ByteArrayOutputStream();

        bec.downloadStream(plaintextOut);

        assertArraysEqual(data.array(), plaintextOut.toByteArray());
    }

    // Key and key resolver null
    @Test
    public void createEncryptionClientFails() {
        assertThrows(IllegalArgumentException.class,
            () -> getEncryptedClientBuilder(null, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl()).blobName(generateBlobName()).buildEncryptedBlobClient());
    }

    // Check that all valid ways to specify the key and keyResolver work
    @ParameterizedTest
    @CsvSource(value = { "true,false", "false,true", "true,true" })
    public void createEncryptionClientSucceeds(boolean passKey, boolean passKeyResolver) {
        FakeKey key = passKey ? fakeKey : null;
        FakeKeyResolver keyResolver = passKeyResolver ? fakeKeyResolver : null;

        assertDoesNotThrow(() -> getEncryptedClientBuilder(key, keyResolver, ENV.getPrimaryAccount().getCredential(),
            cc.getBlobContainerUrl()).blobName(generateBlobName()).buildEncryptedBlobClient());
    }

    // This test checks that encryption is not just a no-op
    @ParameterizedTest
    @EnumSource(EncryptionVersion.class)
    public void encryptionNoANoop(EncryptionVersion version) {
        bec = getEncryptionClient(version);
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        bec.upload(DATA.getDefaultBinaryData());
        cc.getBlobClient(bec.getBlobName()).download(os);

        assertFalse(Arrays.equals(DATA.getDefaultBytes(), os.toByteArray()));
    }

    // This test uses an encrypted client to encrypt and decrypt data
    // Tests buffered upload with different bytebuffer sizes
    @ParameterizedTest
    @CsvSource(
        value = {
            "5,2", // 0 Two buffers smaller than an encryption block.
            "8,2", // 1 Two buffers that equal an encryption block.
            "10,1", // 2 One buffer smaller than an encryption block.
            "10,2", // 3 A buffer that spans an encryption block.
            "16,1", // 4 A buffer exactly the same size as an encryption block.
            "16,2", // 5 Two buffers the same size as an encryption block.
            "20,1", // 6 One buffer larger than an encryption block.
            "20,2", // 7 Two buffers larger than an encryption block.
            "100,1" // 8 One buffer containing multiple encryption blocks
        })
    public void encryption(int size, int byteBufferCount) {
        encryptionTestHelper(size, byteBufferCount);
    }

    @LiveOnly
    @ParameterizedTest
    @CsvSource(value = { "5120,1024", "10485760,2" })
    public void encryptionLarge(int size, int byteBufferCount) {
        encryptionTestHelper(size, byteBufferCount);
    }

    @LiveOnly
    @ParameterizedTest
    @CsvSource(
        value = {
            "5,2", // 0 Two buffers smaller than an encryption block.
            "2097152,2", // 1 Two buffers that equal an encryption block.
            "1024,1", // 2 One buffer smaller than an encryption block.
            "4193280,2", // 3 A buffer that spans an encryption block.
            "4194304,1", // 4 A buffer exactly the same size as an encryption block.
            "4194304,2", // 5 Two buffers the same size as an encryption block.
            "4194314,1", // 6 One buffer larger than an encryption block.
            "4194314,2", // 7 Two buffers larger than an encryption block.
            "4194334,1", // 8 One buffer containing multiple encryption blocks
            "5120,4096", // 9 Large number of small buffers.
            "20971520,2" // 10 Small number of large buffers.
        })
    public void encryptionV2(int size, int byteBufferCount) {
        bec = getEncryptionClient(EncryptionVersion.V2);

        encryptionTestHelper(size, byteBufferCount);
    }

    @LiveOnly
    @ParameterizedTest
    @ValueSource(ints = { 3000, 5 * 1024 * 1024 - 10, 20 * 1024 * 1024 - 10 })
    public void encryptionV2ManualDecryption(int dataSize) throws IOException, GeneralSecurityException {
        bec = getEncryptionClient(EncryptionVersion.V2);
        byte[] data = getRandomByteArray(dataSize);

        bec.upload(BinaryData.fromBytes(data));

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        BlobDownloadResponse downloadResponse = cc.getBlobClient(bec.getBlobName())
            .downloadStreamWithResponse(outStream, null, null, null, false, null, null);
        byte[] ciphertextRawBites = outStream.toByteArray();
        ByteArrayInputStream ciphertextInputStream = new ByteArrayInputStream(ciphertextRawBites);
        ByteArrayOutputStream plaintextOutputStream = new ByteArrayOutputStream();

        EncryptionData encryptionData;
        try (JsonReader jsonReader = JsonProviders
            .createReader(downloadResponse.getDeserializedHeaders().getMetadata().get(ENCRYPTION_DATA_KEY))) {
            encryptionData = EncryptionData.fromJson(jsonReader);
        }
        byte[] cek
            = fakeKey
                .unwrapKey(encryptionData.getWrappedContentKey().getAlgorithm(),
                    encryptionData.getWrappedContentKey().getEncryptedKey())
                .block();
        ByteArrayInputStream keyStream = new ByteArrayInputStream(cek);
        byte[] protocolBytes = new byte[3];
        keyStream.read(protocolBytes);
        for (int i = 0; i < 5; i++) {
            keyStream.read();
        }
        byte[] strippedKeyBytes = new byte[256 / 8];
        keyStream.read(strippedKeyBytes);
        SecretKeySpec keySpec = new SecretKeySpec(strippedKeyBytes, CryptographyConstants.AES);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        int numChunks = (int) Math.ceil(data.length / (4 * 1024 * 1024.0));

        for (int i = 0; i < numChunks; i++) {
            byte[] iv = new byte[12];
            ciphertextInputStream.read(iv);
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, iv);

            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

            int bufferSize = Math.min(ciphertextInputStream.available(), (4 * 1024 * 1024) + 16);
            byte[] buffer = new byte[bufferSize];
            ciphertextInputStream.read(buffer);
            plaintextOutputStream.write(cipher.doFinal(buffer));
        }

        assertArrayEquals(data, plaintextOutputStream.toByteArray());
    }

    private void encryptionTestHelper(int size, int byteBufferCount) {
        // Sending a sequence of buffers allows us to test encryption behavior in different cases when the buffers do
        // or do not align on encryption boundaries.
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (int i = 0; i < byteBufferCount; i++) {
            ByteBuffer buffer = getRandomData(size);
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            os.write(bytes, 0, bytes.length);
        }
        byte[] combinedBytes = os.toByteArray();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(combinedBytes);

        // Test buffered upload.
        ParallelTransferOptions parallelTransferOptions
            = new ParallelTransferOptions().setBlockSizeLong((long) size).setMaxConcurrency(2);
        bec.uploadWithResponse(
            new BlobParallelUploadOptions(byteArrayInputStream).setParallelTransferOptions(parallelTransferOptions),
            null);

        ByteArrayOutputStream newOs = new ByteArrayOutputStream();
        bec.downloadStream(newOs);

        assertArrayEquals(os.toByteArray(), newOs.toByteArray());
    }

    // Requires specific container set up coordinated between languages. Should only be run manually.
    @Disabled
    @Test
    public void testForCrossPlat() {
        NoOpKey kek = new NoOpKey();

        EncryptedBlobClient downloadClient
            = new EncryptedBlobClientBuilder(EncryptionVersion.V2).endpoint(ENV.getPrimaryAccount().getBlobEndpoint())
                .containerName("clientsideencryptionv2crossplat")
                .blobName("python_plaintext_1")
                .key(kek, "None")
                .credential(ENV.getPrimaryAccount().getCredential())
                .buildEncryptedBlobClient();

        EncryptedBlobClient decryptionClient
            = new EncryptedBlobClientBuilder(EncryptionVersion.V2).endpoint(ENV.getPrimaryAccount().getBlobEndpoint())
                .containerName("clientsideencryptionv2crossplat")
                .blobName("python_encrypted_1")
                .key(kek, "None")
                .credential(ENV.getPrimaryAccount().getCredential())
                .buildEncryptedBlobClient();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        downloadClient.downloadStream(outStream);
        ByteArrayOutputStream decryptStream = new ByteArrayOutputStream();
        decryptionClient.downloadStream(decryptStream);

        assertArraysEqual(outStream.toByteArray(), decryptStream.toByteArray());

        byte[] data = getRandomByteArray(20 * Constants.MB);
        BlobClient uploadClient = new BlobClientBuilder().endpoint(ENV.getPrimaryAccount().getBlobEndpoint())
            .containerName("clientsideencryptionv2crossplat")
            .blobName("java_plaintext_1")
            .credential(ENV.getPrimaryAccount().getCredential())
            .buildClient();
        EncryptedBlobClient encryptClient
            = new EncryptedBlobClientBuilder(EncryptionVersion.V2).endpoint(ENV.getPrimaryAccount().getBlobEndpoint())
                .containerName("clientsideencryptionv2crossplat")
                .blobName("java_encrypted_1")
                .key(kek, "None")
                .credential(ENV.getPrimaryAccount().getCredential())
                .buildEncryptedBlobClient();

        uploadClient.upload(BinaryData.fromBytes(data), true);
        encryptClient.upload(BinaryData.fromBytes(data), true);
    }

    static class NoOpKey implements AsyncKeyEncryptionKey {
        @Override
        public Mono<String> getKeyId() {
            return Mono.just("local:key1");
        }

        @Override
        public Mono<byte[]> wrapKey(String algorithm, byte[] key) {
            if (!"None".equals(algorithm)) {
                throw new IllegalArgumentException();
            }
            return Mono.just(key);
        }

        @Override
        public Mono<byte[]> unwrapKey(String algorithm, byte[] encryptedKey) {
            if (!"None".equals(algorithm)) {
                throw new IllegalArgumentException();
            }
            return Mono.just(encryptedKey);
        }
    }

    @LiveOnly
    @ParameterizedTest
    @MethodSource("encryptionComputeMd5Supplier")
    public void encryptionComputeMd5(Long maxSingleUploadSize, Long blockSize, int byteBufferCount,
        EncryptionVersion version) {
        bec = getEncryptionClient(version);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        for (int i = 0; i < byteBufferCount; i++) {
            ByteBuffer buffer = getRandomData(1024);
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            outputStream.write(bytes, 0, bytes.length);
        }
        byte[] combinedBytes = outputStream.toByteArray();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(combinedBytes);

        ParallelTransferOptions parallelTransferOptions
            = new ParallelTransferOptions().setMaxSingleUploadSizeLong(maxSingleUploadSize).setBlockSizeLong(blockSize);

        Response<BlockBlobItem> response = bec.uploadWithResponse(
            new BlobParallelUploadOptions(byteArrayInputStream).setParallelTransferOptions(parallelTransferOptions)
                .setComputeMd5(true),
            null);
        assertEquals(201, response.getStatusCode());
    }

    private static Stream<Arguments> encryptionComputeMd5Supplier() {
        return Stream.of(Arguments.of(null, null, 1, EncryptionVersion.V1), // Simple case where uploadFull is called.
            Arguments.of((long) Constants.KB, (long) 500 * Constants.KB, 1000, EncryptionVersion.V1), // uploadChunked 2 blocks staged
            Arguments.of((long) Constants.KB, (long) 5 * Constants.KB, 1000, EncryptionVersion.V1), // uploadChunked 100 blocks staged
            Arguments.of(null, null, 1, EncryptionVersion.V2), // Simple case where uploadFull is called.
            Arguments.of((long) Constants.KB, (long) 500 * Constants.KB, 1000, EncryptionVersion.V2), // uploadChunked 2 blocks staged
            Arguments.of((long) Constants.KB, (long) 5 * Constants.KB, 1000, EncryptionVersion.V2) // uploadChunked 100 blocks staged
        );
    }

    // This test checks that HTTP headers are successfully set on the encrypted client
    @ParameterizedTest
    @CsvSource(value = { ",,,,,", "control,disposition,encoding,language,,type" })
    public void encryptionHttpHeaders(String cacheControl, String contentDisposition, String contentEncoding,
        String contentLanguage, byte[] contentMd5, String contentType) {
        BlobHttpHeaders headers = new BlobHttpHeaders().setCacheControl(cacheControl)
            .setContentDisposition(contentDisposition)
            .setContentEncoding(contentEncoding)
            .setContentLanguage(contentLanguage)
            .setContentMd5(contentMd5)
            .setContentType(contentType);

        // Buffered upload
        ParallelTransferOptions parallelTransferOptions
            = new ParallelTransferOptions().setBlockSizeLong(DATA.getDefaultDataSizeLong()).setMaxConcurrency(2);

        bec.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultBinaryData())
            .setParallelTransferOptions(parallelTransferOptions)
            .setHeaders(headers), null);

        Response<BlobProperties> response = bec.getPropertiesWithResponse(null, null, null);

        assertEquals(200, response.getStatusCode());
        validateBlobProperties(response, cacheControl, contentDisposition, contentEncoding, contentLanguage, contentMd5,
            contentType == null ? "application/octet-stream" : contentType, contentMd5 != null);
    }

    // This test checks that metadata in encryption is successfully set
    @LiveOnly
    @ParameterizedTest
    @CsvSource(value = { ",,,", "foo,bar,fizz,buzz" })
    public void encryptionMetadata(String key1, String value1, String key2, String value2) {
        Map<String, String> metadata = new HashMap<>();
        if (key1 != null) {
            metadata.put(key1, value1);
        }
        if (key2 != null) {
            metadata.put(key2, value2);
        }

        bec.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultBinaryData()).setMetadata(metadata), null);
        assertEquals(metadata, bec.getProperties().getMetadata());

        // Buffered upload
        ParallelTransferOptions parallelTransferOptions
            = new ParallelTransferOptions().setBlockSizeLong(DATA.getDefaultDataSizeLong()).setMaxConcurrency(2);

        bec.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultBinaryData())
            .setParallelTransferOptions(parallelTransferOptions)
            .setMetadata(metadata), null);
        assertEquals(metadata, bec.getProperties().getMetadata());
    }

    // This test checks that access conditions in encryption clients are successfully set
    @ParameterizedTest
    @MethodSource("validACSupplier")
    public void encryptionAC(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseId) {
        bec.upload(DATA.getDefaultBinaryData());
        String etag = setupBlobMatchCondition(bec, match);
        leaseId = setupBlobLeaseCondition(bec, leaseId);

        BlobRequestConditions bac = new BlobRequestConditions().setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(etag)
            .setIfNoneMatch(noneMatch)
            .setLeaseId(leaseId);

        assertEquals(
            201, bec
                .uploadWithResponse(
                    new BlobParallelUploadOptions(DATA.getDefaultBinaryData()).setRequestConditions(bac), null)
                .getStatusCode());

        etag = setupBlobMatchCondition(bec, match);
        bac.setIfMatch(etag);

        ParallelTransferOptions parallelTransferOptions
            = new ParallelTransferOptions().setBlockSizeLong(DATA.getDefaultDataSizeLong()).setMaxConcurrency(2);

        assertEquals(201,
            bec.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultBinaryData()).setRequestConditions(bac)
                .setParallelTransferOptions(parallelTransferOptions), null).getStatusCode());
    }

    // This test checks that access conditions in encryption clients are unsuccessful with invalid data
    @ParameterizedTest
    @MethodSource("invalidACSupplier")
    public void encryptionACFail(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseId) {
        bec.upload(DATA.getDefaultBinaryData());
        noneMatch = setupBlobMatchCondition(bec, noneMatch);
        setupBlobLeaseCondition(bec, leaseId);
        BlobRequestConditions bac = new BlobRequestConditions().setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)
            .setLeaseId(leaseId);

        ParallelTransferOptions parallelTransferOptions
            = new ParallelTransferOptions().setBlockSizeLong(DATA.getDefaultDataSizeLong()).setMaxConcurrency(2);

        BlobStorageException e = assertThrows(BlobStorageException.class,
            () -> bec.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultBinaryData())
                .setParallelTransferOptions(parallelTransferOptions)
                .setRequestConditions(bac), null));

        assertTrue(e.getErrorCode() == BlobErrorCode.CONDITION_NOT_MET
            || e.getErrorCode() == BlobErrorCode.LEASE_ID_MISMATCH_WITH_BLOB_OPERATION);
    }

    // This test checks the upload to file method on an encrypted client
    @LiveOnly
    @ParameterizedTest
    @EnumSource(EncryptionVersion.class)
    public void encryptedUploadFile(EncryptionVersion version) throws IOException {
        bec = getEncryptionClient(version);

        byte[] data = getRandomByteArray(Constants.MB);
        File file = File.createTempFile(CoreUtils.randomUuid().toString(), ".txt");
        Files.write(file.toPath(), data);

        bec.uploadFromFile(file.toPath().toString());

        assertArrayEquals(data, bec.downloadContent().toBytes());
        Files.deleteIfExists(file.toPath());
    }

    // This test checks the download to file method on an encrypted client
    @ParameterizedTest
    @EnumSource(EncryptionVersion.class)
    public void encryptedDownloadFile(EncryptionVersion version) throws IOException {
        String path = CoreUtils.randomUuid() + ".txt";
        bec = getEncryptionClient(version);

        bec.upload(DATA.getDefaultBinaryData());
        bec.downloadToFile(path);

        compareDataToFile(DATA.getDefaultFlux(), new File(path));

        Files.deleteIfExists(new File(path).toPath());
    }

    @Test
    public void encryptionV2DowngradeAttack() {
        bec = getEncryptionClient(EncryptionVersion.V2);
        bec.upload(DATA.getDefaultBinaryData());

        Map<String, String> metadata = bec.getProperties().getMetadata();
        String encryptionDataStr = metadata.get(ENCRYPTION_DATA_KEY);
        encryptionDataStr = encryptionDataStr.replace("2.0", "1.0");
        metadata.put(ENCRYPTION_DATA_KEY, encryptionDataStr);
        bec.setMetadata(metadata);

        assertThrows(Exception.class, () -> bec.downloadStream(new ByteArrayOutputStream()));
    }

    @Test
    public void downloadUnencryptedData() {
        // Create client
        BlobContainerClient cac = getServiceClientBuilder(ENV.getPrimaryAccount()).buildClient()
            .getBlobContainerClient(generateContainerName());
        cac.create();
        String blobName = generateBlobName();

        BlockBlobClient normalClient = cac.getBlobClient(blobName).getBlockBlobClient();

        // Uses builder method that takes in regular blob clients
        EncryptedBlobClient client = new EncryptedBlobClient(mockAesKey(
            getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(), cac.getBlobContainerUrl())
                .blobName(blobName)
                .buildEncryptedBlobAsyncClient()));

        // Upload encrypted data with regular client
        normalClient.uploadWithResponse(DATA.getDefaultInputStream(), DATA.getDefaultDataSizeLong(), null, null, null,
            null, null, null, null);

        // Download data with encrypted client - command should fail
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        client.download(os);

        assertArraysEqual(DATA.getDefaultBytes(), os.toByteArray());
    }

    @Test
    public void downloadUnencryptedDataRange() {
        // Create client
        BlobContainerClient cac = getServiceClientBuilder(ENV.getPrimaryAccount()).buildClient()
            .getBlobContainerClient(generateContainerName());
        cac.create();
        String blobName = generateBlobName();

        BlockBlobClient normalClient = cac.getBlobClient(blobName).getBlockBlobClient();

        // Uses builder method that takes in regular blob clients
        EncryptedBlobClient client = new EncryptedBlobClient(mockAesKey(
            getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(), cac.getBlobContainerUrl())
                .blobName(blobName)
                .buildEncryptedBlobAsyncClient()));

        // Upload encrypted data with regular client
        normalClient.uploadWithResponse(DATA.getDefaultInputStream(), DATA.getDefaultDataSizeLong(), null, null, null,
            null, null, null, null);

        // Download data with encrypted client - command should fail
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        client.downloadWithResponse(os, new BlobRange(3, 2L), null, null, false, null, null);

        assertArraysEqual(DATA.getDefaultBytes(), 3, os.toByteArray(), 0, 2);
    }

    // Tests key resolver
    @ParameterizedTest
    @CsvSource(
        value = {
            "5,2", // 0 Two buffers smaller than an encryption block.
            "8,2", // 1 Two buffers that equal an encryption block.
            "10,1", // 2 One buffer smaller than an encryption block.
            "10,2", // 3 A buffer that spans an encryption block.
            "16,1", // 4 A buffer exactly the same size as an encryption block.
            "16,2", // 5 Two buffers the same size as an encryption block.
            "20,1", // 6 One buffer larger than an encryption block.
            "20,2", // 7 Two buffers larger than an encryption block.
            "100,1" // 8 One buffer containing multiple encryption blocks
        })
    public void keyResolverUsedToDecryptData(int size, int byteBufferCount) {
        keyResolverTestHelper(size, byteBufferCount);
    }

    // Tests key resolver
    @LiveOnly
    @ParameterizedTest
    @CsvSource(value = { "5120,1024", "10485760,2" })
    public void keyResolvedUsedToDecryptDataLarge(int size, int byteBufferCount) {
        keyResolverTestHelper(size, byteBufferCount);
    }

    private void keyResolverTestHelper(int size, int byteBufferCount) {
        String blobName = generateBlobName();

        EncryptedBlobClient decryptResolverClient = new EncryptedBlobClient(
            mockAesKey(getEncryptedClientBuilder(null, fakeKeyResolver, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl()).blobName(blobName).buildEncryptedBlobAsyncClient()));

        EncryptedBlobClient encryptClient = new EncryptedBlobClient(mockAesKey(
            getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(), cc.getBlobContainerUrl())
                .blobName(blobName)
                .buildEncryptedBlobAsyncClient()));

        // Sending a sequence of buffers allows us to test encryption behavior in different cases when the buffers do
        // or do not align on encryption boundaries.
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (int i = 0; i < byteBufferCount; i++) {
            ByteBuffer buffer = getRandomData(size);
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            os.write(bytes, 0, bytes.length);
        }

        byte[] combinedBytes = os.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(combinedBytes);

        // Test buffered upload.
        ParallelTransferOptions parallelTransferOptions
            = new ParallelTransferOptions().setBlockSizeLong((long) size).setMaxConcurrency(2);
        encryptClient.uploadWithResponse(
            new BlobParallelUploadOptions(byteArrayInputStream).setParallelTransferOptions(parallelTransferOptions),
            null);

        BinaryData response = decryptResolverClient.downloadContent();
        assertArrayEquals(combinedBytes, response.toBytes());
    }

    // TODO:
    // Upload with old SDK download with new SDK.
    @LiveOnly
    @Test
    public void crossPlatformTestUploadOldDownloadNew() throws Exception {
        String blobName = generateBlobName();
        String containerName = cc.getBlobContainerName();

        CloudStorageAccount v8Account = CloudStorageAccount.parse(ENV.getPrimaryAccount().getConnectionString());
        CloudBlobClient blobClient = v8Account.createCloudBlobClient();
        CloudBlobContainer container = blobClient.getContainerReference(containerName);
        CloudBlockBlob v8EncryptBlob = container.getBlockBlobReference(blobName);
        BlobEncryptionPolicy uploadPolicy = new BlobEncryptionPolicy(fakeKey, null);
        BlobRequestOptions uploadOptions = new BlobRequestOptions();
        uploadOptions.setEncryptionPolicy(uploadPolicy);

        EncryptedBlobClient decryptClient
            = getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl()).blobName(blobName).buildEncryptedBlobClient();

        int streamSize = Constants.KB + 1;
        byte[] data = getRandomByteArray(streamSize);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

        // Upload with v8
        v8EncryptBlob.upload(inputStream, streamSize, null, uploadOptions, null);

        // Download with current version
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        decryptClient.download(outputStream);

        assertArraysEqual(data, outputStream.toByteArray());
    }

    // Upload with new SDK download with old SDK.
    @LiveOnly
    @Test
    public void crossPlatformTestUploadNewDownloadOld() throws Exception {
        String blobName = generateBlobName();
        String containerName = cc.getBlobContainerName();

        EncryptedBlobClient encryptClient
            = getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl()).blobName(blobName).buildEncryptedBlobClient();

        CloudStorageAccount v8Account = CloudStorageAccount.parse(ENV.getPrimaryAccount().getConnectionString());
        CloudBlobClient blobClient = v8Account.createCloudBlobClient();
        CloudBlobContainer container = blobClient.getContainerReference(containerName);
        container.createIfNotExists();
        CloudBlockBlob v8DecryptBlob = container.getBlockBlobReference(blobName);
        BlobEncryptionPolicy policy = new BlobEncryptionPolicy(fakeKey, null);
        BlobRequestOptions downloadOptions = new BlobRequestOptions();
        downloadOptions.setEncryptionPolicy(policy);

        // Upload with current version
        encryptClient.upload(DATA.getDefaultBinaryData());

        // Download with v8
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        v8DecryptBlob.download(stream, null, downloadOptions, null);

        assertArraysEqual(DATA.getDefaultBytes(), stream.toByteArray());
    }

    // TODO: cross platform v2 tests
    @Test
    public void encryptedClientFileUploadOverwriteFalse() throws IOException {
        File file = getRandomFile(Constants.KB);
        bec.uploadFromFile(file.toPath().toString());

        assertThrows(IllegalArgumentException.class, () -> bec.uploadFromFile(file.toPath().toString()));
        Files.deleteIfExists(file.toPath());
    }

    @Test
    public void encryptedClientFileUploadOverwriteTrue() throws IOException {
        File file = getRandomFile(Constants.KB);

        bec.uploadFromFile(file.toPath().toString());
        assertDoesNotThrow(() -> bec.uploadFromFile(file.toPath().toString(), true));

        Files.deleteIfExists(file.toPath());
    }

    @Test
    public void encryptedClientUploadOverwriteFalse() {
        bec.upload(DATA.getDefaultBinaryData());

        assertThrows(BlobStorageException.class, () -> bec.upload(DATA.getDefaultBinaryData()));
    }

    @Test
    public void encryptedClientUploadOverwriteTrue() {
        bec.upload(DATA.getDefaultBinaryData());

        assertDoesNotThrow(() -> bec.upload(DATA.getDefaultBinaryData(), true));
    }

    @Test
    public void bufferedUploadNonMarkableStream() throws IOException {
        File file = getRandomFile(10);
        FileInputStream fileStream = new FileInputStream(file);
        File outFile = getRandomFile(10);

        bec.upload(fileStream, file.length());

        bec.downloadToFile(outFile.toPath().toString(), true);
        compareFiles(file, outFile, 0, file.length());
    }

    @Test
    public void builderBearerTokenValidation() {
        String endpoint = BlobUrlParts.parse(bec.getBlobUrl()).setScheme("http").toString();

        assertThrows(IllegalArgumentException.class,
            () -> new EncryptedBlobClientBuilder().credential(new DefaultAzureCredentialBuilder().build())
                .endpoint(endpoint)
                .buildEncryptedBlobClient());
    }

    @Test
    public void downloadAllNull() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bec.upload(DATA.getDefaultBinaryData());
        BlobDownloadResponse response = bec.downloadWithResponse(stream, null, null, null, false, null, null);
        BlobDownloadHeaders headers = response.getDeserializedHeaders();

        assertArraysEqual(DATA.getDefaultBytes(), stream.toByteArray());
        assertNotNull(headers.getContentLength());
        assertNotNull(headers.getContentType());
        assertNull(headers.getContentRange());
        assertNotNull(headers.getContentMd5());
        assertNull(headers.getContentEncoding());
        assertNull(headers.getCacheControl());
        assertNull(headers.getContentDisposition());
        assertNull(headers.getContentLanguage());
        assertNull(headers.getBlobSequenceNumber());
        assertEquals(BlobType.BLOCK_BLOB, headers.getBlobType());
        assertNull(headers.getCopyCompletionTime());
        assertNull(headers.getCopyStatusDescription());
        assertNull(headers.getCopyId());
        assertNull(headers.getCopyProgress());
        assertNull(headers.getCopySource());
        assertNull(headers.getCopyStatus());
        assertNull(headers.getLeaseDuration());
        assertEquals(LeaseStateType.AVAILABLE, headers.getLeaseState());
        assertEquals(LeaseStatusType.UNLOCKED, headers.getLeaseStatus());
        assertEquals("bytes", headers.getAcceptRanges());
        assertNull(headers.getBlobCommittedBlockCount());
        assertNotNull(headers.isServerEncrypted());
        assertNull(headers.getBlobContentMD5());
    }

    /*
    This is to test the appropriate integration of DownloadResponse, including setting the correct range values on
    HttpGetterInfo.
     */

    @ParameterizedTest
    @EnumSource(EncryptionVersion.class)
    public void downloadWithRetryRange(EncryptionVersion version) {
        // We are going to make a request for some range on a blob. The output returned will throw an exception, forcing
        // a retry per the DownloadRetryOptions. The next request should have the same range header, which was generated
        // from the count and offset values in HttpGetterInfo that was constructed on the initial call to download. We
        // don't need to check the data here, but we want to ensure that the correct range is set each time. This will
        // test the correction of a bug that was found which caused HttpGetterInfo to have an incorrect offset when it
        // was constructed in BlobClient.download().
        HttpPipelinePolicy mockPolicy = new MockRetryRangeResponsePolicy(version);
        EncryptedBlobClientBuilder builder = getEncryptedClientBuilder(fakeKey, null,
            ENV.getPrimaryAccount().getCredential(), bec.getBlobUrl(), version, mockPolicy);

        bec = new EncryptedBlobClient(mockAesKey(builder.buildEncryptedBlobAsyncClient()));
        bec.upload(DATA.getDefaultBinaryData());

        BlobRange range = new BlobRange(2, 5L);
        DownloadRetryOptions options = new DownloadRetryOptions().setMaxRetryRequests(3);

        // Because the dummy output always throws an error. This will also validate that an IllegalArgumentException is
        // NOT thrown because the types would not match.
        RuntimeException e = assertThrows(RuntimeException.class,
            () -> bec.downloadWithResponse(new ByteArrayOutputStream(), range, options, null, false, null, null));
        assertInstanceOf(IOException.class, e.getCause());
    }

    @ParameterizedTest
    @EnumSource(EncryptionVersion.class)
    public void downloadMin(EncryptionVersion version) {
        bec = getEncryptionClient(version, bec.getBlobName());
        bec.upload(DATA.getDefaultBinaryData());

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        bec.download(outStream);

        assertArraysEqual(DATA.getDefaultBytes(), outStream.toByteArray());
    }

    @ParameterizedTest
    @MethodSource("downloadRangeSupplier")
    public void downloadRange(int offset, Long count, String expectedData) {
        BlobRange range = (count == null) ? new BlobRange(offset) : new BlobRange(offset, count);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        bec.upload(DATA.getDefaultBinaryData());
        bec.downloadWithResponse(outStream, range, null, null, false, null, null);

        assertEquals(expectedData, outStream.toString());
    }

    private static Stream<Arguments> downloadRangeSupplier() {
        return Stream.of(Arguments.of(0, null, DATA.getDefaultText()),
            Arguments.of(0, 5L, DATA.getDefaultText().substring(0, 5)),
            Arguments.of(3, 2L, DATA.getDefaultText().substring(3, 5)));
    }

    @LiveOnly
    @ParameterizedTest
    @MethodSource("downloadRangeV2Supplier")
    public void downloadRangeV2(int offset, int count) {
        bec = getEncryptionClient(EncryptionVersion.V2);
        byte[] data = getRandomByteArray(20 * Constants.MB);
        bec.upload(BinaryData.fromBytes(data));
        BlobRange range = new BlobRange(offset, (long) count);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        bec.downloadWithResponse(outStream, range, null, null, false, null, null);

        assertArraysEqual(data, offset, outStream.toByteArray(), 0, count);
    }

    private static Stream<Arguments> downloadRangeV2Supplier() {
        return Stream.of(Arguments.of(0, 20 * Constants.MB), // whole blob
            Arguments.of(4 * Constants.MB, 4 * Constants.MB), // Exact region boundary
            Arguments.of(3000000, 15000000), // Bounds are in the middle of the regions. Expands to whole blob
            Arguments.of(5000000, 5000000), // Expands to adjacent regions in middle of blob
            Arguments.of(5000000, 10000000), // Expands to regions in middle of the blob with one region in between
            Arguments.of(500300, 600000) // All in one region
        );
    }

    @ParameterizedTest
    @MethodSource("validACSupplier")
    public void downloadAC(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseId) {
        bec.upload(DATA.getDefaultBinaryData());
        match = setupBlobMatchCondition(bec, match);
        leaseId = setupBlobLeaseCondition(bec, leaseId);
        BlobRequestConditions bac = new BlobRequestConditions().setLeaseId(leaseId)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified);

        assertEquals(200,
            bec.downloadWithResponse(new ByteArrayOutputStream(), null, null, bac, false, null, null).getStatusCode());
    }

    @ParameterizedTest
    @MethodSource("invalidACSupplier")
    public void downloadACFail(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseId) {
        bec.upload(DATA.getDefaultBinaryData());
        setupBlobLeaseCondition(bec, leaseId);
        BlobRequestConditions bac = new BlobRequestConditions().setLeaseId(leaseId)
            .setIfMatch(match)
            .setIfNoneMatch(setupBlobMatchCondition(bec, noneMatch))
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified);

        assertThrows(BlobStorageException.class,
            () -> bec.downloadWithResponse(new ByteArrayOutputStream(), null, null, bac, false, null, null)
                .getStatusCode());
    }

    @Test
    public void downloadError() {
        bec = new EncryptedBlobClient(mockAesKey(new EncryptedBlobClientBuilder().key(fakeKey, "keyWrapAlgorithm")
            .blobClient(cc.getBlobClient(generateBlobName()))
            .buildEncryptedBlobAsyncClient()));

        assertThrows(NullPointerException.class, () -> bec.download(null));
    }

    @Test
    public void downloadSnapshot() {
        bec.upload(DATA.getDefaultBinaryData());
        ByteArrayOutputStream originalStream = new ByteArrayOutputStream();
        bec.download(originalStream);

        BlobClientBase bc2 = bec.createSnapshot();
        bec.upload(new ByteArrayInputStream("ABC".getBytes()), "ABC".getBytes().length, true);

        ByteArrayOutputStream snapshotStream = new ByteArrayOutputStream();
        bc2.download(snapshotStream);

        assertArraysEqual(originalStream.toByteArray(), snapshotStream.toByteArray());
    }

    @Test
    public void downloadToFileExists() throws IOException {
        bec.upload(DATA.getDefaultBinaryData());
        File testFile = Files.createTempFile(prefix, "txt").toFile();

        // Default overwrite is false so this should fail
        UncheckedIOException ex
            = assertThrows(UncheckedIOException.class, () -> bec.downloadToFile(testFile.getPath()));
        assertInstanceOf(FileAlreadyExistsException.class, ex.getCause());

        Files.deleteIfExists(testFile.toPath());
    }

    @Test
    public void downloadToFileExistsSucceeds() throws IOException {
        bec.upload(DATA.getDefaultBinaryData());

        File testFile = new File(prefix + ".txt");
        Files.deleteIfExists(testFile.toPath());

        bec.downloadToFile(testFile.getPath(), true);

        assertArraysEqual(DATA.getDefaultBytes(), Files.readAllBytes(testFile.toPath()));

        Files.deleteIfExists(testFile.toPath());
    }

    @Test
    public void downloadToFileDoesNotExist() throws IOException {
        bec.upload(DATA.getDefaultBinaryData());

        File testFile = new File(prefix + ".txt");
        Files.deleteIfExists(testFile.toPath());

        bec.downloadToFile(testFile.getPath());

        assertArraysEqual(DATA.getDefaultBytes(), Files.readAllBytes(testFile.toPath()));

        Files.deleteIfExists(testFile.toPath());
    }

    @Test
    public void downloadFileDoesNotExistOpenOptions() throws IOException {
        bec.upload(DATA.getDefaultBinaryData());

        File testFile = new File(prefix + ".txt");
        Files.deleteIfExists(testFile.toPath());

        Set<OpenOption> openOptions = new HashSet<>(
            Arrays.asList(StandardOpenOption.CREATE_NEW, StandardOpenOption.READ, StandardOpenOption.WRITE));
        bec.downloadToFileWithResponse(testFile.getPath(), null, null, null, null, false, openOptions, null, null);

        assertArraysEqual(DATA.getDefaultBytes(), Files.readAllBytes(testFile.toPath()));

        Files.deleteIfExists(testFile.toPath());
    }

    @Test
    public void downloadFileExistOpenOptions() throws IOException {
        bec.upload(DATA.getDefaultBinaryData());

        File testFile = new File(prefix + ".txt");
        Files.deleteIfExists(testFile.toPath());

        Set<OpenOption> openOptions = new HashSet<>(Arrays.asList(StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.READ, StandardOpenOption.WRITE));
        bec.downloadToFileWithResponse(testFile.getPath(), null, null, null, null, false, openOptions, null, null);

        assertArraysEqual(DATA.getDefaultBytes(), Files.readAllBytes(testFile.toPath()));

        Files.deleteIfExists(testFile.toPath());
    }

    @LiveOnly
    @ParameterizedTest
    @MethodSource("downloadFileSupplier")
    public void downloadFile(int fileSize, EncryptionVersion version) throws IOException {
        File file = getRandomFile(fileSize);
        bec = getEncryptionClient(version);
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(testResourceNamer.randomName(prefix, 60) + ".txt");
        Files.deleteIfExists(outFile.toPath());

        BlobProperties properties = bec
            .downloadToFileWithResponse(outFile.toPath().toString(), null,
                new ParallelTransferOptions().setBlockSizeLong((long) (4 * 1024 * 1024)), null, null, false, null, null)
            .getValue();

        assertEquals(BlobType.BLOCK_BLOB, properties.getBlobType());
        compareFiles(file, outFile, 0, fileSize);

        Files.deleteIfExists(outFile.toPath());
        Files.deleteIfExists(file.toPath());
    }

    @LiveOnly
    @ParameterizedTest
    @MethodSource("downloadFileSupplier")
    public void downloadStream(int fileSize, EncryptionVersion version) throws IOException {
        byte[] data = getRandomByteArray(fileSize);
        File file = File.createTempFile(CoreUtils.randomUuid().toString(), ".txt");
        Files.write(file.toPath(), data);

        bec = getEncryptionClient(version);
        bec.uploadFromFile(file.toPath().toString());

        BlobInputStream stream = bec.openInputStream();
        TestUtils.assertArraysEqual(convertInputStreamToByteArray(stream), data);

        Files.deleteIfExists(file.toPath());
    }

    private static Stream<Arguments> downloadFileSupplier() {
        return Stream.of(Arguments.of(0, EncryptionVersion.V1), // empty file
            Arguments.of(20, EncryptionVersion.V1), // small file
            Arguments.of(16 * 1024 * 1024, EncryptionVersion.V1), // medium file in several chunks
            Arguments.of(8 * 1026 * 1024 + 10, EncryptionVersion.V1), // medium file not aligned to block
            Arguments.of(50 * Constants.MB, EncryptionVersion.V1), // large file requiring multiple requests
            Arguments.of(0, EncryptionVersion.V2), // empty file
            Arguments.of(20, EncryptionVersion.V2), // small file
            Arguments.of(16 * 1024 * 1024, EncryptionVersion.V2), // medium file in several chunks
            Arguments.of(8 * 1026 * 1024 + 10, EncryptionVersion.V2), // medium file not aligned to block
            Arguments.of(50 * Constants.MB, EncryptionVersion.V2), // large file requiring multiple requests
            Arguments.of((4 * Constants.MB) + 1, EncryptionVersion.V2), // 4mb file bug
            Arguments.of(4 * Constants.MB, EncryptionVersion.V2), // 4mb file bug
            Arguments.of((4 * Constants.MB) + 27, EncryptionVersion.V2), // 4mb file bug
            Arguments.of(16 * Constants.MB, EncryptionVersion.V2) // 4mb file bug
        );
    }

    // Tests downloading a file using a default client that doesn't have a HttpClient passed to it.
    @LiveOnly
    @ParameterizedTest
    @ValueSource(ints = { 0, 20, 16 * 1024 * 1024, 8 * 1026 * 1024 + 10, 50 * Constants.MB })
    public void downloadFileBufferCopy(int fileSize) throws IOException {
        String containerName = generateContainerName();
        BlobServiceClient blobServiceClient
            = new BlobServiceClientBuilder().endpoint(ENV.getPrimaryAccount().getBlobEndpoint())
                .credential(ENV.getPrimaryAccount().getCredential())
                .buildClient();

        EncryptedBlobClient encryptedBlobClient = new EncryptedBlobClientBuilder().key(fakeKey, "keyWrapAlgorithm")
            .blobClient(blobServiceClient.createBlobContainer(containerName).getBlobClient(generateBlobName()))
            .buildEncryptedBlobClient();

        File file = getRandomFile(fileSize);
        encryptedBlobClient.uploadFromFile(file.toPath().toString());
        File outFile = new File(testResourceNamer.randomName(prefix, 60) + ".txt");
        Files.deleteIfExists(outFile.toPath());

        BlobProperties properties = encryptedBlobClient
            .downloadToFileWithResponse(outFile.toPath().toString(), null,
                new ParallelTransferOptions().setBlockSizeLong((long) (4 * 1024 * 1024)), null, null, false, null, null)
            .getValue();

        assertEquals(BlobType.BLOCK_BLOB, properties.getBlobType());
        compareFiles(file, outFile, 0, fileSize);

        Files.deleteIfExists(outFile.toPath());
        Files.deleteIfExists(file.toPath());
    }

    @LiveOnly
    @ParameterizedTest
    @MethodSource("downloadFileRangeSupplier")
    public void downloadFileRange(BlobRange range, EncryptionVersion version) throws IOException {
        File file = getRandomFile(DATA.getDefaultDataSize());
        bec = getEncryptionClient(version);
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(testResourceNamer.randomName(prefix, 60));
        Files.deleteIfExists(outFile.toPath());

        bec.downloadToFileWithResponse(outFile.toPath().toString(), range, null, null, null, false, null, null);

        compareFiles(file, outFile, range.getOffset(), range.getCount());

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    private static Stream<Arguments> downloadFileRangeSupplier() {
        return Stream.of(Arguments.of(new BlobRange(0, DATA.getDefaultDataSizeLong()), EncryptionVersion.V1), // Exact count
            Arguments.of(new BlobRange(1, DATA.getDefaultDataSizeLong() - 1), EncryptionVersion.V1), // Offset and exact count
            Arguments.of(new BlobRange(3, 2L), EncryptionVersion.V1), // Narrow range in middle
            Arguments.of(new BlobRange(0, DATA.getDefaultDataSizeLong() - 1), EncryptionVersion.V1), // Count that is less than total
            Arguments.of(new BlobRange(0, 10 * 1024L), EncryptionVersion.V1), // Count much larger than remaining data
            Arguments.of(new BlobRange(0, DATA.getDefaultDataSizeLong()), EncryptionVersion.V2), // Exact count
            Arguments.of(new BlobRange(1, DATA.getDefaultDataSizeLong() - 1), EncryptionVersion.V2), // Offset and exact count
            Arguments.of(new BlobRange(3, 2L), EncryptionVersion.V2), // Narrow range in middle
            Arguments.of(new BlobRange(0, DATA.getDefaultDataSizeLong() - 1), EncryptionVersion.V2), // Count that is less than total
            Arguments.of(new BlobRange(0, 10 * 1024L), EncryptionVersion.V2) // Count much larger than remaining data
        );
    }

    // This is to exercise some additional corner cases and ensure there are no arithmetic errors that give false success.
    @LiveOnly
    @Test
    public void downloadFileRangeFail() throws IOException {
        File file = getRandomFile(DATA.getDefaultDataSize());
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(prefix);
        Files.deleteIfExists(outFile.toPath());

        assertThrows(BlobStorageException.class, () -> bec.downloadToFileWithResponse(outFile.toPath().toString(),
            new BlobRange(34), null, null, null, false, null, null));

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    @LiveOnly
    @Test
    public void downloadFileCountNull() throws IOException {
        File file = getRandomFile(DATA.getDefaultDataSize());
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(prefix);
        Files.deleteIfExists(outFile.toPath());

        bec.downloadToFileWithResponse(outFile.toPath().toString(), new BlobRange(0), null, null, null, false, null,
            null);

        compareFiles(file, outFile, 0, DATA.getDefaultDataSize());

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    @LiveOnly
    @ParameterizedTest
    @MethodSource("validACSupplier")
    public void downloadFileAC(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseId) throws IOException {
        File file = getRandomFile(DATA.getDefaultDataSize());
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(prefix);
        Files.deleteIfExists(outFile.toPath());

        match = setupBlobMatchCondition(bec, match);
        leaseId = setupBlobLeaseCondition(bec, leaseId);
        BlobRequestConditions bro = new BlobRequestConditions().setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)
            .setLeaseId(leaseId);

        assertDoesNotThrow(() -> bec.downloadToFileWithResponse(outFile.toPath().toString(), null, null, null, bro,
            false, null, null));

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    private static Stream<Arguments> validACSupplier() {
        return Stream.of(Arguments.of(null, null, null, null, null), Arguments.of(OLD_DATE, null, null, null, null),
            Arguments.of(null, NEW_DATE, null, null, null), Arguments.of(null, null, RECEIVED_ETAG, null, null),
            Arguments.of(null, null, null, GARBAGE_ETAG, null),
            Arguments.of(null, null, null, null, RECEIVED_LEASE_ID));
    }

    @LiveOnly
    @ParameterizedTest
    @MethodSource("invalidACSupplier")
    public void downloadFileACFail(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseId) throws IOException {
        File file = getRandomFile(DATA.getDefaultDataSize());
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(prefix);
        Files.deleteIfExists(outFile.toPath());

        noneMatch = setupBlobMatchCondition(bec, noneMatch);
        setupBlobLeaseCondition(bec, leaseId);
        BlobRequestConditions bro = new BlobRequestConditions().setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)
            .setLeaseId(leaseId);

        BlobStorageException e = assertThrows(BlobStorageException.class, () -> bec
            .downloadToFileWithResponse(outFile.toPath().toString(), null, null, null, bro, false, null, null));

        assertTrue(e.getErrorCode() == BlobErrorCode.CONDITION_NOT_MET
            || e.getErrorCode() == BlobErrorCode.LEASE_ID_MISMATCH_WITH_BLOB_OPERATION);

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    private static Stream<Arguments> invalidACSupplier() {
        return Stream.of(Arguments.of(NEW_DATE, null, null, null, null), Arguments.of(null, OLD_DATE, null, null, null),
            Arguments.of(null, null, GARBAGE_ETAG, null, null), Arguments.of(null, null, null, RECEIVED_ETAG, null),
            Arguments.of(null, null, null, null, GARBAGE_LEASE_ID));
    }

    @LiveOnly
    @Test
    public void downloadFileEtagLock() throws IOException {
        File file = getRandomFile(Constants.MB);
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(prefix);
        Files.deleteIfExists(file.toPath());
        AtomicInteger counter = new AtomicInteger();

        EncryptedBlobClient bcUploading
            = getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(), bec.getBlobUrl())
                .buildEncryptedBlobClient();

        HttpPipelinePolicy policy = (context, next) -> next.process().doOnNext(r -> {
            if (counter.incrementAndGet() == 2) {
                // When the download begins trigger an upload to overwrite the downloading blob
                // so that the download is able to get an ETag before it is changed.
                Mono.fromCallable(() -> bcUploading
                    .uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultInputStream()), null))
                    .subscribeOn(Schedulers.boundedElastic())
                    .thenReturn(r)
                    .subscribe();
            }
            Mono.just(r);
        });

        EncryptedBlobClient bcDownloading
            = getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(), bec.getBlobUrl())
                .addPolicy(policy)
                .buildEncryptedBlobClient();

        // Setup the download to happen in small chunks so many requests need to be sent, this will give the upload time
        // to change the ETag therefore failing the download.
        ParallelTransferOptions options = new ParallelTransferOptions().setBlockSizeLong((long) Constants.KB);

        /*
         * This is done to prevent onErrorDropped exceptions from being logged at the error level. If no hook is
         * registered for onErrorDropped the error is logged at the ERROR level.
         *
         * onErrorDropped is triggered once the reactive stream has emitted one element, after that exceptions are
         * dropped.
         */
        Hooks.onErrorDropped(ignored -> {
            /* do nothing with it */ });

        try {
            bcDownloading.downloadToFileWithResponse(outFile.toPath().toString(), null, options, null, null, false,
                null, null);
        } catch (Exception exception) {
            assertTrue(Exceptions.unwrapMultiple(exception).stream().anyMatch(e -> {
                Throwable e2 = Exceptions.unwrap(e);
                if (exception instanceof BlobStorageException) {
                    assertEquals(412, ((BlobStorageException) e2).getStatusCode());
                    return true;
                }
                return false;
            }));
        }

        // Give the file a chance to be deleted by the download operation before verifying its deletion
        sleepIfRunningAgainstService(500);
        assertFalse(outFile.exists());

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    @LiveOnly
    @ParameterizedTest
    @ValueSource(ints = { 100, 8 * 1026 * 1024 + 10 })
    public void downloadFileProgressReceiver(int fileSize) throws IOException {
        File file = getRandomFile(fileSize);
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(prefix);
        Files.deleteIfExists(outFile.toPath());

        List<Long> progress = new ArrayList<>();
        ProgressReceiver mockReceiver = progress::add;
        int numBlocks = fileSize / (4 * 1024 * 1024);

        bec.downloadToFileWithResponse(outFile.toPath().toString(), null,
            new ParallelTransferOptions().setProgressReceiver(mockReceiver),
            new DownloadRetryOptions().setMaxRetryRequests(3), null, false, null, null);

        // We should receive at least one notification reporting an intermediary value per block, but possibly more
        // notifications will be received depending on the implementation. We specify numBlocks - 1 because the last
        // block will be the total size as above. Finally, we assert that the number reported monotonically increases.
        if (numBlocks == 0) {
            numBlocks++;
        }
        assertTrue(progress.stream().filter(it -> it != file.length()).count() >= numBlocks - 1);

        // Should receive at least one notification indicating completed progress, multiple notifications may be
        //received if there are empty buffers in the stream.
        assertTrue(progress.stream().anyMatch(it -> it == fileSize));

        // There should be NO notification with a larger than expected size.
        assertTrue(progress.stream().noneMatch(it -> it > fileSize));

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    @LiveOnly
    @ParameterizedTest
    @ValueSource(ints = { 100, 8 * 1026 * 1024 + 10 })
    public void downloadFileProgressListener(int fileSize) throws IOException {
        File file = getRandomFile(fileSize);
        bec.uploadFromFile(file.toPath().toString());
        File outFile = new File(prefix);
        Files.deleteIfExists(outFile.toPath());

        List<Long> progress = new ArrayList<>();
        ProgressListener mockListener = progress::add;
        int numBlocks = fileSize / (4 * 1024 * 1024);

        bec.downloadToFileWithResponse(outFile.toPath().toString(), null,
            new ParallelTransferOptions().setProgressListener(mockListener),
            new DownloadRetryOptions().setMaxRetryRequests(3), null, false, null, null);

        // We should receive at least one notification reporting an intermediary value per block, but possibly more
        // notifications will be received depending on the implementation. We specify numBlocks - 1 because the last
        // block will be the total size as above. Finally, we assert that the number reported monotonically increases.
        if (numBlocks == 0) {
            numBlocks++;
        }

        assertTrue(progress.stream().filter(it -> it != file.length()).count() >= numBlocks - 1);

        // Should receive at least one notification indicating completed progress, multiple notifications may be
        // received if there are empty buffers in the stream.
        assertTrue(progress.stream().anyMatch(it -> it == fileSize));

        // There should be NO notification with a larger than expected size.
        assertTrue(progress.stream().noneMatch(it -> it > fileSize));

        Files.deleteIfExists(file.toPath());
        Files.deleteIfExists(outFile.toPath());
    }

    @Test
    public void downloadRequiresEncryption() {
        String blobName = bec.getBlobName();
        getBlobClientBuilder(ENV.getPrimaryAccount().getCredential(), cc.getBlobContainerUrl()).blobName(blobName)
            .buildClient()
            .upload(DATA.getDefaultBinaryData());

        // Sync min
        bec = getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
            cc.getBlobContainerUrl()).blobName(blobName).requiresEncryption(true).buildEncryptedBlobClient();

        assertThrows(IllegalStateException.class, () -> bec.download(new ByteArrayOutputStream()));

        // Sync max
        assertThrows(IllegalStateException.class,
            () -> bec.downloadWithResponse(new ByteArrayOutputStream(), null, null, null, false, null, null));
    }

    @Test
    public void encryptionUploadISOverwriteFails() {
        bec.upload(DATA.getDefaultBinaryData());
        byte[] randomData = getRandomByteArray(Constants.KB);
        ByteArrayInputStream input = new ByteArrayInputStream(randomData);

        assertThrows(BlobStorageException.class, () -> bec.upload(input));
    }

    @Test
    public void encryptionUploadISOverwrite() {
        bec.upload(DATA.getDefaultBinaryData());

        byte[] randomData = getRandomByteArray(Constants.KB);
        ByteArrayInputStream input = new ByteArrayInputStream(randomData);
        bec.upload(input, Constants.KB, true);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bec.downloadWithResponse(stream, null, null, null, false, null, null);

        assertArraysEqual(randomData, stream.toByteArray());
    }

    // This test checks that encryption is not just a no-op
    @Test
    public void encryptionUploadISNotANoop() {
        ByteBuffer byteBuffer = getRandomData(Constants.KB);
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        bec.upload(new ByteArrayInputStream(byteBuffer.array()), byteBuffer.remaining());
        cc.getBlobClient(bec.getBlobName()).download(os);

        assertFalse(Arrays.equals(byteBuffer.array(), os.toByteArray()));
    }

    @LiveOnly
    @Test
    public void encryptionUploadISLargeData() {
        byte[] randomData = getRandomByteArray(20 * Constants.MB);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ByteArrayInputStream input = new ByteArrayInputStream(randomData);
        ParallelTransferOptions pto = new ParallelTransferOptions().setMaxSingleUploadSizeLong((long) Constants.MB);

        // Uses blob output stream under the hood.
        bec.uploadWithResponse(input, 20 * Constants.MB, pto, null, null, null, null, null, null);
        bec.download(os);

        assertArraysEqual(randomData, os.toByteArray());
    }

    @LiveOnly
    @ParameterizedTest
    @CsvSource(value = { "0,,0", "1024,,0", "1048576,,0", "3145728,1048576,4" })
    public void encryptionUploadISNumBlocks(int size, Long maxUploadSize, int numBlocks) {
        byte[] randomData = getRandomByteArray(size);
        ByteArrayInputStream input = new ByteArrayInputStream(randomData);
        ParallelTransferOptions pto
            = new ParallelTransferOptions().setBlockSizeLong(maxUploadSize).setMaxSingleUploadSizeLong(maxUploadSize);

        bec.uploadWithResponse(input, size, pto, null, null, null, null, null, null);

        assertEquals(numBlocks,
            cc.getBlobClient(bec.getBlobName())
                .getBlockBlobClient()
                .listBlocks(BlockListType.ALL)
                .getCommittedBlocks()
                .size());
    }

    @Test
    public void encryptionUploadISNoLength() {
        byte[] randomData = getRandomByteArray(Constants.KB);
        ByteArrayInputStream input = new ByteArrayInputStream(randomData);

        bec.upload(input);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bec.downloadStream(stream);

        assertArraysEqual(randomData, stream.toByteArray());
    }

    @Test
    public void encryptionUploadISNoLengthWithOptions() {
        byte[] randomData = getRandomByteArray(Constants.KB);
        ByteArrayInputStream payloadAsInputStream = new ByteArrayInputStream(randomData);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BlobParallelUploadOptions blobParallelUploadOptions = new BlobParallelUploadOptions(payloadAsInputStream);

        bec.uploadWithResponse(blobParallelUploadOptions, null, Context.NONE);
        bec.downloadStream(os);

        assertArraysEqual(randomData, os.toByteArray());
    }

    @ParameterizedTest
    @MethodSource("modifyUserAgentSupplier")
    public void modifyUserAgent(EncryptionVersion encryptionVersion) {
        String expectedUserAgentString
            = "azstorage-clientsideencryption/" + (encryptionVersion == EncryptionVersion.V2 ? "2.0" : "1.0");

        EncryptedBlobClient ebc = new EncryptedBlobClient(
            mockAesKey(getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl(), encryptionVersion).blobName(generateBlobName())
                    .addPolicy(getUserAgentHeaderPolicy(expectedUserAgentString))
                    .buildEncryptedBlobAsyncClient()));

        // the getUserAgentHeaderPolicy will check that the user agent is set correctly
        ebc.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultInputStream()), null, null);
    }

    @ParameterizedTest
    @MethodSource("modifyUserAgentSupplier")
    public void modifyUserAgentWithApplicationId(EncryptionVersion encryptionVersion) {
        String applicationId = "log-options-id";
        String expectedUserAgentString = applicationId + " azstorage-clientsideencryption/"
            + (encryptionVersion == EncryptionVersion.V2 ? "2.0" : "1.0");

        EncryptedBlobClient ebc = new EncryptedBlobClient(
            mockAesKey(getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl(), encryptionVersion).blobName(generateBlobName())
                    .addPolicy(getUserAgentHeaderPolicy(expectedUserAgentString))
                    .httpLogOptions(new HttpLogOptions().setApplicationId(applicationId))
                    .buildEncryptedBlobAsyncClient()));

        // the getUserAgentHeaderPolicy will check that the user agent is set correctly
        ebc.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultInputStream()), null, null);
    }

    private static Stream<Arguments> modifyUserAgentSupplier() {
        return Stream.of(Arguments.of(EncryptionVersion.V1), Arguments.of(EncryptionVersion.V2));
    }

    private static HttpPipelinePolicy getUserAgentHeaderPolicy(String expectedUserAgentString) {
        return new HttpPipelinePolicy() {
            @Override
            public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
                String userAgent = context.getHttpRequest().getHeaders().getValue(HttpHeaderName.USER_AGENT);
                assertTrue(userAgent.startsWith(expectedUserAgentString));
                return next.process();
            }

            @Override
            public HttpPipelinePosition getPipelinePosition() {
                return HttpPipelinePosition.PER_CALL;
            }
        };
    }

    private static HttpPipelinePolicy getPerCallVersionPolicy() {
        return new PerCallVersionPolicy("2017-11-09");
    }

    // This tests the policy is in the right place because if it were added per retry, it would be after the credentials
    // and auth would fail because we changed a signed header.
    @DisabledIf("hasServiceVersion")
    @Test
    public void perCallPolicy() {
        EncryptedBlobClient client = new EncryptedBlobClient(
            mockAesKey(getEncryptedClientBuilder(fakeKey, fakeKeyResolver, ENV.getPrimaryAccount().getCredential(),
                bec.getBlobUrl(), getPerCallVersionPolicy()).buildEncryptedBlobAsyncClient()));

        client.upload(new ByteArrayInputStream(new byte[0]), 0);

        assertEquals("2017-11-09",
            client.getPropertiesWithResponse(null, null, null).getHeaders().getValue("x-ms-version"));
    }

    @ParameterizedTest
    @MethodSource("encryptionDataCaseInsensitivitySupplier")
    public void encryptionDataCaseInsensitivity(String newKey, EncryptionVersion version) {
        byte[] data = getRandomByteArray(Constants.KB);
        bec = getEncryptionClient(version, generateBlobName());
        bec.upload(BinaryData.fromBytes(data));
        // change casing of encryption data key
        Map<String, String> metadata = bec.getProperties().getMetadata();
        String encryptionData = metadata.get(ENCRYPTION_DATA_KEY);
        Map<String, String> encryptionMetadata = new HashMap<>();
        encryptionMetadata.put(newKey, encryptionData);
        bec.setMetadata(encryptionMetadata);
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // call with downloadStream to test code path for non-specified BlobRange
        bec.downloadStream(os);
        assertArrayEquals(data, os.toByteArray());
        // now call downloadStreamWithResponse with BlobRange passed to ensure ranged download is working
        os = new ByteArrayOutputStream();
        bec.downloadStreamWithResponse(os, new BlobRange(0, (long) Constants.KB), null, null, false, null,
            Context.NONE);
        assertArrayEquals(data, os.toByteArray());
    }

    @ParameterizedTest
    @MethodSource("encryptionDataCaseInsensitivitySupplier")
    public void encryptionDataCaseInsensitivityDownloadToFile(String newKey, EncryptionVersion version)
        throws IOException {
        bec = getEncryptionClient(version, generateBlobName());
        File file = getRandomFile(Constants.KB);
        FileInputStream fileStream = new FileInputStream(file);
        File outFile = getRandomFile(Constants.KB);
        if (outFile.exists()) {
            outFile.delete();
        }
        bec.upload(fileStream, file.length());
        // change casing of encryption data key
        Map<String, String> metadata = bec.getProperties().getMetadata();
        String encryptionData = metadata.get(ENCRYPTION_DATA_KEY);
        Map<String, String> encryptionMetadata = new HashMap<>();
        encryptionMetadata.put(newKey, encryptionData);
        bec.setMetadata(encryptionMetadata);
        // call with downloadToFile to test code path for non-specified BlobRange
        bec.downloadToFile(outFile.toPath().toString(), true);
        compareFiles(file, outFile, 0, file.length());
        File outFile2 = getRandomFile(Constants.KB);
        if (outFile2.exists()) {
            outFile2.delete();
        }
        // now call downloadToFileWithResponse with BlobRange passed to ensure ranged download is working
        bec.downloadToFileWithResponse(outFile2.toString(), new BlobRange(0, (long) Constants.KB), null, null, null,
            false, null, Context.NONE);
        compareFiles(file, outFile, 0, file.length());
    }

    @ParameterizedTest
    @MethodSource("uploadAndDownloadDifferentRegionLengthSupplier")
    public void uploadAndDownloadDifferentRegionLength(int regionLength, int dataSize) {
        ByteBuffer data = getRandomData(dataSize);
        bec = new EncryptedBlobClient(mockAesKey(getEncryptedClientBuilder(fakeKey, null,
            ENV.getPrimaryAccount().getCredential(), cc.getBlobContainerUrl(), EncryptionVersion.V2_1)
                .blobName(generateBlobName())
                .clientSideEncryptionOptions(
                    new BlobClientSideEncryptionOptions().setAuthenticatedRegionDataLengthInBytes(regionLength))
                .buildEncryptedBlobAsyncClient()));
        bec.uploadWithResponse(new BlobParallelUploadOptions(BinaryData.fromByteBuffer(data.duplicate())), null, null);

        ByteArrayOutputStream plaintextOut = new ByteArrayOutputStream();
        bec.downloadStream(plaintextOut);

        assertArraysEqual(data.array(), plaintextOut.toByteArray());
    }

    @ParameterizedTest
    @MethodSource("uploadAndDownloadFileDifferentRegionLengthSupplier")
    public void uploadAndDownloadToFileDifferentRegionLength(int regionLength, int fileSize) throws IOException {
        File file = getRandomFile(fileSize);
        bec = new EncryptedBlobClient(mockAesKey(getEncryptedClientBuilder(fakeKey, null,
            ENV.getPrimaryAccount().getCredential(), cc.getBlobContainerUrl(), EncryptionVersion.V2_1)
                .blobName(generateBlobName())
                .clientSideEncryptionOptions(
                    new BlobClientSideEncryptionOptions().setAuthenticatedRegionDataLengthInBytes(regionLength))
                .buildEncryptedBlobAsyncClient()));
        bec.uploadFromFile(file.toPath().toString());

        File outFile = new File(testResourceNamer.randomName(prefix, 60) + ".txt");
        Files.deleteIfExists(outFile.toPath());

        bec.downloadToFile(outFile.toPath().toString(), true);
        compareFiles(file, outFile, 0, fileSize);

        Files.deleteIfExists(outFile.toPath());
        Files.deleteIfExists(file.toPath());
    }

    @ParameterizedTest
    @MethodSource("uploadAndDownloadDifferentRegionLengthSupplier")
    public void uploadAndDownloadRegionLengthWithDiffBlobClients(int regionLength, int dataSize) {
        ByteBuffer data = getRandomData(dataSize);
        String blobName = generateBlobName();
        bec = new EncryptedBlobClient(mockAesKey(getEncryptedClientBuilder(fakeKey, null,
            ENV.getPrimaryAccount().getCredential(), cc.getBlobContainerUrl(), EncryptionVersion.V2_1)
                .blobName(blobName)
                .clientSideEncryptionOptions(
                    new BlobClientSideEncryptionOptions().setAuthenticatedRegionDataLengthInBytes(regionLength))
                .buildEncryptedBlobAsyncClient()));
        bec.uploadWithResponse(new BlobParallelUploadOptions(BinaryData.fromByteBuffer(data.duplicate())), null, null);

        ByteArrayOutputStream plaintextOut = new ByteArrayOutputStream();

        // Create another client without the authenticated region data length set
        // This client should be using the default 4MB region size
        EncryptedBlobClient ebc2 = new EncryptedBlobClient(
            mockAesKey(getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl(), EncryptionVersion.V2_1).blobName(blobName).buildEncryptedBlobAsyncClient()));

        ebc2.downloadStream(plaintextOut);

        assertArraysEqual(data.array(), plaintextOut.toByteArray());
    }

    @ParameterizedTest
    @MethodSource("uploadAndDownloadV21WithOlderVersionsSupplier")
    public void uploadAndDownloadV21WithOlderVersions(int regionLength, int dataSize, EncryptionVersion version) {
        ByteBuffer data = getRandomData(dataSize);
        String blobName = generateBlobName();
        bec = new EncryptedBlobClient(mockAesKey(getEncryptedClientBuilder(fakeKey, null,
            ENV.getPrimaryAccount().getCredential(), cc.getBlobContainerUrl(), EncryptionVersion.V2_1)
                .blobName(blobName)
                .clientSideEncryptionOptions(
                    new BlobClientSideEncryptionOptions().setAuthenticatedRegionDataLengthInBytes(regionLength))
                .buildEncryptedBlobAsyncClient()));
        bec.uploadWithResponse(new BlobParallelUploadOptions(BinaryData.fromByteBuffer(data.duplicate())), null, null);

        ByteArrayOutputStream plaintextOut = new ByteArrayOutputStream();

        // Setting the encryption version to something other than V2_1 should not impact the
        // ability to download and decrypt the blob as the downloaded uses the blob metadata
        // to dictate what encryption protocol version to use.
        EncryptedBlobClient ebc2 = new EncryptedBlobClient(
            mockAesKey(getEncryptedClientBuilder(fakeKey, null, ENV.getPrimaryAccount().getCredential(),
                cc.getBlobContainerUrl(), version).blobName(blobName).buildEncryptedBlobAsyncClient()));

        ebc2.downloadStream(plaintextOut);

        assertArraysEqual(data.array(), plaintextOut.toByteArray());
    }

    private static Stream<Arguments> validateContentEncryptionKeyProtocolSupplier() {
        return Stream.of(Arguments.of(EncryptionVersion.V2, "2.0"), Arguments.of(EncryptionVersion.V2_1, "2.1"));
    }

    @ParameterizedTest
    @MethodSource("validateContentEncryptionKeyProtocolSupplier")
    public void validateContentEncryptionKeyProtocol(EncryptionVersion version, String expectedVersion)
        throws IOException {
        bec = getEncryptionClient(version, generateBlobName());
        bec.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultInputStream()), null, null);
        Response<BlobProperties> response = bec.getPropertiesWithResponse(null, null, null);
        String encryptionMetadata = response.getHeaders().get(X_MS_META_ENCRYPTIONDATA).getValue();
        EncryptionData encryptionData;
        try (JsonReader jsonReader = JsonProviders.createReader(encryptionMetadata)) {
            encryptionData = EncryptionData.fromJson(jsonReader);
        }
        byte[] cek
            = fakeKey
                .unwrapKey(encryptionData.getWrappedContentKey().getAlgorithm(),
                    encryptionData.getWrappedContentKey().getEncryptedKey())
                .block();

        ByteArrayInputStream keyStream = new ByteArrayInputStream(cek);
        byte[] protocolBytes = new byte[3];
        keyStream.read(protocolBytes);

        assertEquals(ByteBuffer.wrap(expectedVersion.getBytes(StandardCharsets.UTF_8)), ByteBuffer.wrap(protocolBytes));
    }

    private static Stream<Arguments> validateEncryptionProtocolUploadSupplier() {
        return Stream.of(Arguments.of(EncryptionVersion.V1, "1.0"), Arguments.of(EncryptionVersion.V2, "2.0"),
            Arguments.of(EncryptionVersion.V2_1, "2.1"));
    }

    @ParameterizedTest
    @MethodSource("validateEncryptionProtocolUploadSupplier")
    public void validateEncryptionProtocolUpload(EncryptionVersion version, String expectedVersion) throws IOException {
        bec = getEncryptionClient(version, generateBlobName());
        bec.uploadWithResponse(new BlobParallelUploadOptions(DATA.getDefaultInputStream()), null, null);
        Response<BlobProperties> response = bec.getPropertiesWithResponse(null, null, null);
        String encryptionMetadata = response.getHeaders().get(X_MS_META_ENCRYPTIONDATA).getValue();

        EncryptionData encryptionData;
        try (JsonReader jsonReader = JsonProviders.createReader(encryptionMetadata)) {
            encryptionData = EncryptionData.fromJson(jsonReader);
        }

        assertEquals(expectedVersion, encryptionData.getEncryptionAgent().getProtocol());
    }

    private static Stream<Arguments> uploadAndDownloadDifferentRegionLengthSupplier() {
        return Stream.of(Arguments.of(4 * Constants.KB, 4 * Constants.MB), Arguments.of(Constants.KB, 8 * Constants.MB),
            Arguments.of(10 * Constants.KB, 4 * Constants.MB), // unaligned
            Arguments.of(16, Constants.KB), // minimum boundary
            Arguments.of(25, Constants.KB), // unaligned
            Arguments.of(6 * Constants.MB, Constants.KB), // testing region smaller than data size
            Arguments.of(6 * Constants.MB, 8 * Constants.MB) // testing greater than default 4MB region size
        );
    }

    private static Stream<Arguments> uploadAndDownloadFileDifferentRegionLengthSupplier() {
        return Stream.of(Arguments.of(4 * Constants.KB, 4 * Constants.MB), // tests 4MB V2 download bug
            Arguments.of(Constants.KB, 8 * Constants.MB), // tests 4MB V2 download bug
            Arguments.of(10 * Constants.KB, 4 * Constants.MB), // unaligned
            Arguments.of(16, Constants.KB), // minimum boundary
            Arguments.of(25, Constants.KB), // unaligned
            Arguments.of(6 * Constants.MB, Constants.KB), // testing region smaller than data size
            Arguments.of(6 * Constants.MB, 8 * Constants.MB), // testing greater than default 4MB region size
            Arguments.of(Constants.KB, 16 * Constants.MB) // 4mb download bug
        );
    }

    private static Stream<Arguments> uploadAndDownloadV21WithOlderVersionsSupplier() {
        return Stream.of(Arguments.of(4 * Constants.KB, 4 * Constants.MB, EncryptionVersion.V1),
            Arguments.of(4 * Constants.KB, 4 * Constants.MB, EncryptionVersion.V2),
            Arguments.of(10 * Constants.KB, 4 * Constants.MB, EncryptionVersion.V1), // unaligned
            Arguments.of(10 * Constants.KB, 4 * Constants.MB, EncryptionVersion.V2), // unaligned
            Arguments.of(16, Constants.KB, EncryptionVersion.V1), // minimum boundary
            Arguments.of(16, Constants.KB, EncryptionVersion.V2), // minimum boundary
            Arguments.of(6 * Constants.MB, 8 * Constants.MB, EncryptionVersion.V1), // testing greater than default 4MB region size
            Arguments.of(6 * Constants.MB, 8 * Constants.MB, EncryptionVersion.V2) // testing greater than default 4MB region size
        );
    }

    private static Stream<Arguments> encryptionDataCaseInsensitivitySupplier() {
        return Stream.of(Arguments.of("ENCRYPTIONDATA", EncryptionVersion.V1),
            Arguments.of("EncryptionData", EncryptionVersion.V1), Arguments.of("eNcRyPtIoNdAtA", EncryptionVersion.V1),
            Arguments.of("ENCRYPTIONDATA", EncryptionVersion.V2), Arguments.of("EncryptionData", EncryptionVersion.V2),
            Arguments.of("eNcRyPtIoNdAtA", EncryptionVersion.V2));
    }

    @Test
    public void clientsUnsupported() {
        assertThrows(UnsupportedOperationException.class, () -> bec.getAppendBlobClient());
        assertThrows(UnsupportedOperationException.class, () -> bec.getBlockBlobClient());
        assertThrows(UnsupportedOperationException.class, () -> bec.getPageBlobClient());
    }

    @Test
    public void queryUnsupported() {
        assertThrows(UnsupportedOperationException.class, () -> bec.query(null, null));
        assertThrows(UnsupportedOperationException.class, () -> bec.queryWithResponse(null, null, null));
        assertThrows(UnsupportedOperationException.class, () -> bec.openQueryInputStream(null));
        assertThrows(UnsupportedOperationException.class, () -> bec.openQueryInputStreamWithResponse(null));
    }

    static class MockRetryRangeResponsePolicy implements HttpPipelinePolicy {
        private final String expectedRangeHeader;

        MockRetryRangeResponsePolicy(EncryptionVersion version) {
            this.expectedRangeHeader = (version == EncryptionVersion.V1)
                ? "bytes=0-15"
                : "bytes=0-" + (GCM_ENCRYPTION_REGION_LENGTH + NONCE_LENGTH + TAG_LENGTH - 1);
        }

        @Override
        public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
            return next.process().flatMap(response -> {
                if (response.getRequest().getHttpMethod() == HttpMethod.GET
                    && !expectedRangeHeader.equals(response.getRequest().getHeaders().getValue("x-ms-range"))) {
                    return Mono.error(new IllegalArgumentException("The range header was not set correctly on retry."));
                } else if (response.getRequest().getHttpMethod() == HttpMethod.GET) {
                    // ETag can be a dummy value. It's not validated, but DownloadResponse requires one
                    return Mono.just(new MockDownloadHttpResponse(response, 206, Flux.error(new IOException())));
                } else {
                    return Mono.just(response);
                }
            });
        }
    }

    public static boolean hasServiceVersion() {
        return ENV.getServiceVersion() != null;
    }
}
