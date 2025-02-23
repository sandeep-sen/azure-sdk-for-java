// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.datalake.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/**
 * An enumeration of blobs.
 */
@Fluent
public final class ListBlobsHierarchySegmentResponse implements XmlSerializable<ListBlobsHierarchySegmentResponse> {
    /*
     * The ServiceEndpoint property.
     */
    private String serviceEndpoint;

    /*
     * The ContainerName property.
     */
    private String containerName;

    /*
     * The Prefix property.
     */
    private String prefix;

    /*
     * The Marker property.
     */
    private String marker;

    /*
     * The MaxResults property.
     */
    private int maxResults;

    /*
     * The Delimiter property.
     */
    private String delimiter;

    /*
     * The Segment property.
     */
    private BlobHierarchyListSegment segment;

    /*
     * The NextMarker property.
     */
    private String nextMarker;

    /**
     * Creates an instance of ListBlobsHierarchySegmentResponse class.
     */
    public ListBlobsHierarchySegmentResponse() {
    }

    /**
     * Get the serviceEndpoint property: The ServiceEndpoint property.
     * 
     * @return the serviceEndpoint value.
     */
    public String getServiceEndpoint() {
        return this.serviceEndpoint;
    }

    /**
     * Set the serviceEndpoint property: The ServiceEndpoint property.
     * 
     * @param serviceEndpoint the serviceEndpoint value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
        return this;
    }

    /**
     * Get the containerName property: The ContainerName property.
     * 
     * @return the containerName value.
     */
    public String getContainerName() {
        return this.containerName;
    }

    /**
     * Set the containerName property: The ContainerName property.
     * 
     * @param containerName the containerName value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setContainerName(String containerName) {
        this.containerName = containerName;
        return this;
    }

    /**
     * Get the prefix property: The Prefix property.
     * 
     * @return the prefix value.
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * Set the prefix property: The Prefix property.
     * 
     * @param prefix the prefix value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Get the marker property: The Marker property.
     * 
     * @return the marker value.
     */
    public String getMarker() {
        return this.marker;
    }

    /**
     * Set the marker property: The Marker property.
     * 
     * @param marker the marker value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setMarker(String marker) {
        this.marker = marker;
        return this;
    }

    /**
     * Get the maxResults property: The MaxResults property.
     * 
     * @return the maxResults value.
     */
    public int getMaxResults() {
        return this.maxResults;
    }

    /**
     * Set the maxResults property: The MaxResults property.
     * 
     * @param maxResults the maxResults value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setMaxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    /**
     * Get the delimiter property: The Delimiter property.
     * 
     * @return the delimiter value.
     */
    public String getDelimiter() {
        return this.delimiter;
    }

    /**
     * Set the delimiter property: The Delimiter property.
     * 
     * @param delimiter the delimiter value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    /**
     * Get the segment property: The Segment property.
     * 
     * @return the segment value.
     */
    public BlobHierarchyListSegment getSegment() {
        return this.segment;
    }

    /**
     * Set the segment property: The Segment property.
     * 
     * @param segment the segment value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setSegment(BlobHierarchyListSegment segment) {
        this.segment = segment;
        return this;
    }

    /**
     * Get the nextMarker property: The NextMarker property.
     * 
     * @return the nextMarker value.
     */
    public String getNextMarker() {
        return this.nextMarker;
    }

    /**
     * Set the nextMarker property: The NextMarker property.
     * 
     * @param nextMarker the nextMarker value to set.
     * @return the ListBlobsHierarchySegmentResponse object itself.
     */
    public ListBlobsHierarchySegmentResponse setNextMarker(String nextMarker) {
        this.nextMarker = nextMarker;
        return this;
    }

    @Override
    public XmlWriter toXml(XmlWriter xmlWriter) throws XMLStreamException {
        return toXml(xmlWriter, null);
    }

    @Override
    public XmlWriter toXml(XmlWriter xmlWriter, String rootElementName) throws XMLStreamException {
        rootElementName = CoreUtils.isNullOrEmpty(rootElementName) ? "EnumerationResults" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeStringAttribute("ServiceEndpoint", this.serviceEndpoint);
        xmlWriter.writeStringAttribute("ContainerName", this.containerName);
        xmlWriter.writeStringElement("Prefix", this.prefix);
        xmlWriter.writeStringElement("Marker", this.marker);
        xmlWriter.writeIntElement("MaxResults", this.maxResults);
        xmlWriter.writeStringElement("Delimiter", this.delimiter);
        xmlWriter.writeXml(this.segment, "Blobs");
        xmlWriter.writeStringElement("NextMarker", this.nextMarker);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of ListBlobsHierarchySegmentResponse from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @return An instance of ListBlobsHierarchySegmentResponse if the XmlReader was pointing to an instance of it, or
     * null if it was pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the ListBlobsHierarchySegmentResponse.
     */
    public static ListBlobsHierarchySegmentResponse fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of ListBlobsHierarchySegmentResponse from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of ListBlobsHierarchySegmentResponse if the XmlReader was pointing to an instance of it, or
     * null if it was pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the ListBlobsHierarchySegmentResponse.
     */
    public static ListBlobsHierarchySegmentResponse fromXml(XmlReader xmlReader, String rootElementName)
        throws XMLStreamException {
        String finalRootElementName = CoreUtils.isNullOrEmpty(rootElementName) ? "EnumerationResults" : rootElementName;
        return xmlReader.readObject(finalRootElementName, reader -> {
            ListBlobsHierarchySegmentResponse deserializedListBlobsHierarchySegmentResponse
                = new ListBlobsHierarchySegmentResponse();
            deserializedListBlobsHierarchySegmentResponse.serviceEndpoint
                = reader.getStringAttribute(null, "ServiceEndpoint");
            deserializedListBlobsHierarchySegmentResponse.containerName
                = reader.getStringAttribute(null, "ContainerName");
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                QName elementName = reader.getElementName();

                if ("Prefix".equals(elementName.getLocalPart())) {
                    deserializedListBlobsHierarchySegmentResponse.prefix = reader.getStringElement();
                } else if ("Marker".equals(elementName.getLocalPart())) {
                    deserializedListBlobsHierarchySegmentResponse.marker = reader.getStringElement();
                } else if ("MaxResults".equals(elementName.getLocalPart())) {
                    deserializedListBlobsHierarchySegmentResponse.maxResults = reader.getIntElement();
                } else if ("Delimiter".equals(elementName.getLocalPart())) {
                    deserializedListBlobsHierarchySegmentResponse.delimiter = reader.getStringElement();
                } else if ("Blobs".equals(elementName.getLocalPart())) {
                    deserializedListBlobsHierarchySegmentResponse.segment
                        = BlobHierarchyListSegment.fromXml(reader, "Blobs");
                } else if ("NextMarker".equals(elementName.getLocalPart())) {
                    deserializedListBlobsHierarchySegmentResponse.nextMarker = reader.getStringElement();
                } else {
                    reader.skipElement();
                }
            }

            return deserializedListBlobsHierarchySegmentResponse;
        });
    }
}
