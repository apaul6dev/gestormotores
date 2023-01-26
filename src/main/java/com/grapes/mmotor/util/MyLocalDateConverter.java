package com.grapes.mmotor.util;

import jakarta.persistence.AttributeConverter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MyLocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime == null ? null : java.sql.Timestamp.valueOf(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }
}
