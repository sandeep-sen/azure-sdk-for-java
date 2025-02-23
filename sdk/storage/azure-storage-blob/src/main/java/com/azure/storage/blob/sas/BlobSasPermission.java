// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob.sas;

import com.azure.storage.common.implementation.Constants;

import java.util.Locale;

/**
 * This is a helper class to construct a string representing the permissions granted by a ServiceSAS to a blob. Setting
 * a value to true means that any SAS which uses these permissions will grant permissions for that operation. It is
 * possible to construct the permissions string without this class, but the order of the permissions is particular and
 * this class guarantees correctness.
 */
public final class BlobSasPermission {
    private boolean readPermission;
    private boolean addPermission;
    private boolean createPermission;
    private boolean writePermission;
    private boolean deletePermission;
    private boolean deleteVersionPermission;
    private boolean permanentDeletePermission;
    private boolean tagsPermission;
    private boolean listPermission;
    private boolean movePermission;
    private boolean executePermission;
    private boolean immutabilityPolicyPermission;

    /**
     * Initializes a {@code BlobSasPermission} object with all fields set to false.
     */
    public BlobSasPermission() {
    }

    /**
     * Creates a {@code BlobSasPermission} from the specified permissions string. This method will throw an
     * {@code IllegalArgumentException} if it encounters a character that does not correspond to a valid permission.
     *
     * @param permissionString A {@code String} which represents the {@code BlobSasPermission}.
     * @return A {@code BlobSasPermission} generated from the given {@code String}.
     * @throws IllegalArgumentException If {@code permString} contains a character other than r, a, c, w, d, x, l, t,
     * m, e or i.
     */
    public static BlobSasPermission parse(String permissionString) {
        BlobSasPermission permissions = new BlobSasPermission();

        for (int i = 0; i < permissionString.length(); i++) {
            char c = permissionString.charAt(i);
            switch (c) {
                case 'r':
                    permissions.readPermission = true;
                    break;

                case 'a':
                    permissions.addPermission = true;
                    break;

                case 'c':
                    permissions.createPermission = true;
                    break;

                case 'w':
                    permissions.writePermission = true;
                    break;

                case 'd':
                    permissions.deletePermission = true;
                    break;

                case 'x':
                    permissions.deleteVersionPermission = true;
                    break;

                case 'y':
                    permissions.permanentDeletePermission = true;
                    break;

                case 't':
                    permissions.tagsPermission = true;
                    break;

                case 'l':
                    permissions.listPermission = true;
                    break;

                case 'm':
                    permissions.movePermission = true;
                    break;

                case 'e':
                    permissions.executePermission = true;
                    break;

                case 'i':
                    permissions.immutabilityPolicyPermission = true;
                    break;

                default:
                    throw new IllegalArgumentException(String.format(Locale.ROOT,
                        Constants.ENUM_COULD_NOT_BE_PARSED_INVALID_VALUE, "Permissions", permissionString, c));
            }
        }
        return permissions;
    }

    /**
     * Gets the read permission status.
     *
     * @return the read permission status.
     */
    public boolean hasReadPermission() {
        return readPermission;
    }

    /**
     * Sets the read permission status.
     *
     * @param hasReadPermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setReadPermission(boolean hasReadPermission) {
        this.readPermission = hasReadPermission;
        return this;
    }

    /**
     * Gets the add permission status.
     *
     * @return the add permission status.
     */
    public boolean hasAddPermission() {
        return addPermission;
    }

    /**
     * Sets the add permission status.
     *
     * @param hasAddPermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setAddPermission(boolean hasAddPermission) {
        this.addPermission = hasAddPermission;
        return this;
    }

    /**
     * Gets the create permission status.
     *
     * @return the create permission status.
     */
    public boolean hasCreatePermission() {
        return createPermission;
    }

    /**
     * Sets the create permission status.
     *
     * @param hasCreatePermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setCreatePermission(boolean hasCreatePermission) {
        this.createPermission = hasCreatePermission;
        return this;
    }

    /**
     * Gets the write permission status.
     *
     * @return the write permission status.
     */
    public boolean hasWritePermission() {
        return writePermission;
    }

    /**
     * Sets the write permission status.
     *
     * @param hasWritePermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setWritePermission(boolean hasWritePermission) {
        this.writePermission = hasWritePermission;
        return this;
    }

    /**
     * Gets the delete permission status.
     *
     * @return the delete permission status.
     */
    public boolean hasDeletePermission() {
        return deletePermission;
    }

    /**
     * Sets the delete permission status.
     *
     * @param hasDeletePermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setDeletePermission(boolean hasDeletePermission) {
        this.deletePermission = hasDeletePermission;
        return this;
    }

    /**
     * Gets the delete version permission status.
     *
     * @return the delete version permission status.
     */
    public boolean hasDeleteVersionPermission() {
        return deleteVersionPermission;
    }

    /**
     * Sets the delete version permission status.
     *
     * @param hasDeleteVersionPermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setDeleteVersionPermission(boolean hasDeleteVersionPermission) {
        this.deleteVersionPermission = hasDeleteVersionPermission;
        return this;
    }

    /**
     * Gets the permanent delete permission status.
     *
     * @return the permanent delete permission status.
     */
    public boolean hasPermanentDeletePermission() {
        return permanentDeletePermission;
    }

    /**
     * Sets the permanent delete permission status.
     *
     * @param permanentDeletePermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setPermanentDeletePermission(boolean permanentDeletePermission) {
        this.permanentDeletePermission = permanentDeletePermission;
        return this;
    }

    /**
     * Gets the tags permission status.
     *
     * @return the tags permission status.
     */
    public boolean hasTagsPermission() {
        return tagsPermission;
    }

    /**
     * Sets the tags permission status.
     *
     * @param tagsPermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setTagsPermission(boolean tagsPermission) {
        this.tagsPermission = tagsPermission;
        return this;
    }

    /**
     * Gets the list permission status.
     *
     * @return the list permission status.
     */
    public boolean hasListPermission() {
        return listPermission;
    }

    /**
     * Sets the list permission status.
     *
     * @param hasListPermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setListPermission(boolean hasListPermission) {
        this.listPermission = hasListPermission;
        return this;
    }

    /**
     * Gets the move permission status.
     *
     * @return the move permission status.
     */
    public boolean hasMovePermission() {
        return movePermission;
    }

    /**
     * Sets the move permission status.
     *
     * @param hasMovePermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setMovePermission(boolean hasMovePermission) {
        this.movePermission = hasMovePermission;
        return this;
    }

    /**
     * Gets the execute permission status.
     *
     * @return the execute permission status.
     */
    public boolean hasExecutePermission() {
        return executePermission;
    }

    /**
     * Sets the execute permission status.
     *
     * @param hasExecutePermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setExecutePermission(boolean hasExecutePermission) {
        this.executePermission = hasExecutePermission;
        return this;
    }

    /**
     * Gets the set immutability policy permission status.
     * 
     * @return the set immutability policy permission status.
     */
    public boolean hasImmutabilityPolicyPermission() {
        return immutabilityPolicyPermission;
    }

    /**
     * Sets the set immutability policy permission status.
     *
     * @param immutabilityPolicyPermission Permission status to set
     * @return the updated BlobSasPermission object.
     */
    public BlobSasPermission setImmutabilityPolicyPermission(boolean immutabilityPolicyPermission) {
        this.immutabilityPolicyPermission = immutabilityPolicyPermission;
        return this;
    }

    /**
     * Converts the given permissions to a {@code String}. Using this method will guarantee the permissions are in an
     * order accepted by the service.
     *
     * @return A {@code String} which represents the {@code BlobSasPermission}.
     */
    @Override
    public String toString() {
        // The order of the characters should be as specified here to ensure correctness:
        // https://docs.microsoft.com/en-us/rest/api/storageservices/constructing-a-service-sas

        final StringBuilder builder = new StringBuilder();

        if (this.readPermission) {
            builder.append('r');
        }

        if (this.addPermission) {
            builder.append('a');
        }

        if (this.createPermission) {
            builder.append('c');
        }

        if (this.writePermission) {
            builder.append('w');
        }

        if (this.deletePermission) {
            builder.append('d');
        }

        if (this.deleteVersionPermission) {
            builder.append('x');
        }

        if (this.permanentDeletePermission) {
            builder.append('y');
        }

        if (this.listPermission) {
            builder.append('l');
        }

        if (this.tagsPermission) {
            builder.append('t');
        }

        if (this.movePermission) {
            builder.append('m');
        }

        if (this.executePermission) {
            builder.append('e');
        }

        if (this.immutabilityPolicyPermission) {
            builder.append('i');
        }

        return builder.toString();
    }
}
