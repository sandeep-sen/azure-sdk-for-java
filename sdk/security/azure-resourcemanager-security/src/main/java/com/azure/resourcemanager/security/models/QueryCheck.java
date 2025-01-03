// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The rule query details.
 */
@Fluent
public final class QueryCheck implements JsonSerializable<QueryCheck> {
    /*
     * The rule query.
     */
    private String query;

    /*
     * Expected result.
     */
    private List<List<String>> expectedResult;

    /*
     * Column names of expected result.
     */
    private List<String> columnNames;

    /**
     * Creates an instance of QueryCheck class.
     */
    public QueryCheck() {
    }

    /**
     * Get the query property: The rule query.
     * 
     * @return the query value.
     */
    public String query() {
        return this.query;
    }

    /**
     * Set the query property: The rule query.
     * 
     * @param query the query value to set.
     * @return the QueryCheck object itself.
     */
    public QueryCheck withQuery(String query) {
        this.query = query;
        return this;
    }

    /**
     * Get the expectedResult property: Expected result.
     * 
     * @return the expectedResult value.
     */
    public List<List<String>> expectedResult() {
        return this.expectedResult;
    }

    /**
     * Set the expectedResult property: Expected result.
     * 
     * @param expectedResult the expectedResult value to set.
     * @return the QueryCheck object itself.
     */
    public QueryCheck withExpectedResult(List<List<String>> expectedResult) {
        this.expectedResult = expectedResult;
        return this;
    }

    /**
     * Get the columnNames property: Column names of expected result.
     * 
     * @return the columnNames value.
     */
    public List<String> columnNames() {
        return this.columnNames;
    }

    /**
     * Set the columnNames property: Column names of expected result.
     * 
     * @param columnNames the columnNames value to set.
     * @return the QueryCheck object itself.
     */
    public QueryCheck withColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("query", this.query);
        jsonWriter.writeArrayField("expectedResult", this.expectedResult,
            (writer, element) -> writer.writeArray(element, (writer1, element1) -> writer1.writeString(element1)));
        jsonWriter.writeArrayField("columnNames", this.columnNames, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of QueryCheck from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of QueryCheck if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the QueryCheck.
     */
    public static QueryCheck fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            QueryCheck deserializedQueryCheck = new QueryCheck();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("query".equals(fieldName)) {
                    deserializedQueryCheck.query = reader.getString();
                } else if ("expectedResult".equals(fieldName)) {
                    List<List<String>> expectedResult
                        = reader.readArray(reader1 -> reader1.readArray(reader2 -> reader2.getString()));
                    deserializedQueryCheck.expectedResult = expectedResult;
                } else if ("columnNames".equals(fieldName)) {
                    List<String> columnNames = reader.readArray(reader1 -> reader1.getString());
                    deserializedQueryCheck.columnNames = columnNames;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedQueryCheck;
        });
    }
}
