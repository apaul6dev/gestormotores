package com.grapes.mmotor.util;

import jakarta.persistence.AttributeConverter;

import java.sql.Date;
import java.time.LocalDate;

public class MyLocalDateTimeConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : java.sql.Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null : date.toLocalDate();
    }
}
