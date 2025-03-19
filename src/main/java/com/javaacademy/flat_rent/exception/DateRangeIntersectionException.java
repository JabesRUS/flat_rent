package com.javaacademy.flat_rent.exception;

import java.time.LocalDate;

public class DateRangeIntersectionException extends RuntimeException {
    public DateRangeIntersectionException(LocalDate startDate, LocalDate endDate) {
        super("Date ranges overlap: %s - %s".formatted(startDate, endDate));
    }
}
