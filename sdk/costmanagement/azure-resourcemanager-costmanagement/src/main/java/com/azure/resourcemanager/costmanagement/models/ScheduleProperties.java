// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The properties of the schedule.
 */
@Fluent
public final class ScheduleProperties implements JsonSerializable<ScheduleProperties> {
    /*
     * Frequency of the schedule.
     */
    private ScheduleFrequency frequency;

    /*
     * UTC time at which cost analysis data will be emailed.
     */
    private Integer hourOfDay;

    /*
     * Day names in english on which cost analysis data will be emailed. This property is applicable when frequency is
     * Weekly or Monthly.
     */
    private List<DaysOfWeek> daysOfWeek;

    /*
     * Weeks in which cost analysis data will be emailed. This property is applicable when frequency is Monthly and used
     * in combination with daysOfWeek.
     */
    private List<WeeksOfMonth> weeksOfMonth;

    /*
     * UTC day on which cost analysis data will be emailed. Must be between 1 and 31. This property is applicable when
     * frequency is Monthly and overrides weeksOfMonth or daysOfWeek.
     */
    private Integer dayOfMonth;

    /*
     * The start date and time of the scheduled action (UTC).
     */
    private OffsetDateTime startDate;

    /*
     * The end date and time of the scheduled action (UTC).
     */
    private OffsetDateTime endDate;

    /**
     * Creates an instance of ScheduleProperties class.
     */
    public ScheduleProperties() {
    }

    /**
     * Get the frequency property: Frequency of the schedule.
     * 
     * @return the frequency value.
     */
    public ScheduleFrequency frequency() {
        return this.frequency;
    }

    /**
     * Set the frequency property: Frequency of the schedule.
     * 
     * @param frequency the frequency value to set.
     * @return the ScheduleProperties object itself.
     */
    public ScheduleProperties withFrequency(ScheduleFrequency frequency) {
        this.frequency = frequency;
        return this;
    }

    /**
     * Get the hourOfDay property: UTC time at which cost analysis data will be emailed.
     * 
     * @return the hourOfDay value.
     */
    public Integer hourOfDay() {
        return this.hourOfDay;
    }

    /**
     * Set the hourOfDay property: UTC time at which cost analysis data will be emailed.
     * 
     * @param hourOfDay the hourOfDay value to set.
     * @return the ScheduleProperties object itself.
     */
    public ScheduleProperties withHourOfDay(Integer hourOfDay) {
        this.hourOfDay = hourOfDay;
        return this;
    }

    /**
     * Get the daysOfWeek property: Day names in english on which cost analysis data will be emailed. This property is
     * applicable when frequency is Weekly or Monthly.
     * 
     * @return the daysOfWeek value.
     */
    public List<DaysOfWeek> daysOfWeek() {
        return this.daysOfWeek;
    }

    /**
     * Set the daysOfWeek property: Day names in english on which cost analysis data will be emailed. This property is
     * applicable when frequency is Weekly or Monthly.
     * 
     * @param daysOfWeek the daysOfWeek value to set.
     * @return the ScheduleProperties object itself.
     */
    public ScheduleProperties withDaysOfWeek(List<DaysOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
        return this;
    }

    /**
     * Get the weeksOfMonth property: Weeks in which cost analysis data will be emailed. This property is applicable
     * when frequency is Monthly and used in combination with daysOfWeek.
     * 
     * @return the weeksOfMonth value.
     */
    public List<WeeksOfMonth> weeksOfMonth() {
        return this.weeksOfMonth;
    }

    /**
     * Set the weeksOfMonth property: Weeks in which cost analysis data will be emailed. This property is applicable
     * when frequency is Monthly and used in combination with daysOfWeek.
     * 
     * @param weeksOfMonth the weeksOfMonth value to set.
     * @return the ScheduleProperties object itself.
     */
    public ScheduleProperties withWeeksOfMonth(List<WeeksOfMonth> weeksOfMonth) {
        this.weeksOfMonth = weeksOfMonth;
        return this;
    }

    /**
     * Get the dayOfMonth property: UTC day on which cost analysis data will be emailed. Must be between 1 and 31. This
     * property is applicable when frequency is Monthly and overrides weeksOfMonth or daysOfWeek.
     * 
     * @return the dayOfMonth value.
     */
    public Integer dayOfMonth() {
        return this.dayOfMonth;
    }

    /**
     * Set the dayOfMonth property: UTC day on which cost analysis data will be emailed. Must be between 1 and 31. This
     * property is applicable when frequency is Monthly and overrides weeksOfMonth or daysOfWeek.
     * 
     * @param dayOfMonth the dayOfMonth value to set.
     * @return the ScheduleProperties object itself.
     */
    public ScheduleProperties withDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

    /**
     * Get the startDate property: The start date and time of the scheduled action (UTC).
     * 
     * @return the startDate value.
     */
    public OffsetDateTime startDate() {
        return this.startDate;
    }

    /**
     * Set the startDate property: The start date and time of the scheduled action (UTC).
     * 
     * @param startDate the startDate value to set.
     * @return the ScheduleProperties object itself.
     */
    public ScheduleProperties withStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get the endDate property: The end date and time of the scheduled action (UTC).
     * 
     * @return the endDate value.
     */
    public OffsetDateTime endDate() {
        return this.endDate;
    }

    /**
     * Set the endDate property: The end date and time of the scheduled action (UTC).
     * 
     * @param endDate the endDate value to set.
     * @return the ScheduleProperties object itself.
     */
    public ScheduleProperties withEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (frequency() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property frequency in model ScheduleProperties"));
        }
        if (startDate() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property startDate in model ScheduleProperties"));
        }
        if (endDate() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property endDate in model ScheduleProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ScheduleProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("frequency", this.frequency == null ? null : this.frequency.toString());
        jsonWriter.writeStringField("startDate",
            this.startDate == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startDate));
        jsonWriter.writeStringField("endDate",
            this.endDate == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.endDate));
        jsonWriter.writeNumberField("hourOfDay", this.hourOfDay);
        jsonWriter.writeArrayField("daysOfWeek", this.daysOfWeek,
            (writer, element) -> writer.writeString(element == null ? null : element.toString()));
        jsonWriter.writeArrayField("weeksOfMonth", this.weeksOfMonth,
            (writer, element) -> writer.writeString(element == null ? null : element.toString()));
        jsonWriter.writeNumberField("dayOfMonth", this.dayOfMonth);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ScheduleProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ScheduleProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ScheduleProperties.
     */
    public static ScheduleProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ScheduleProperties deserializedScheduleProperties = new ScheduleProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("frequency".equals(fieldName)) {
                    deserializedScheduleProperties.frequency = ScheduleFrequency.fromString(reader.getString());
                } else if ("startDate".equals(fieldName)) {
                    deserializedScheduleProperties.startDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("endDate".equals(fieldName)) {
                    deserializedScheduleProperties.endDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("hourOfDay".equals(fieldName)) {
                    deserializedScheduleProperties.hourOfDay = reader.getNullable(JsonReader::getInt);
                } else if ("daysOfWeek".equals(fieldName)) {
                    List<DaysOfWeek> daysOfWeek
                        = reader.readArray(reader1 -> DaysOfWeek.fromString(reader1.getString()));
                    deserializedScheduleProperties.daysOfWeek = daysOfWeek;
                } else if ("weeksOfMonth".equals(fieldName)) {
                    List<WeeksOfMonth> weeksOfMonth
                        = reader.readArray(reader1 -> WeeksOfMonth.fromString(reader1.getString()));
                    deserializedScheduleProperties.weeksOfMonth = weeksOfMonth;
                } else if ("dayOfMonth".equals(fieldName)) {
                    deserializedScheduleProperties.dayOfMonth = reader.getNullable(JsonReader::getInt);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedScheduleProperties;
        });
    }
}
