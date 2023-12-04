package com.example.apiusermonitoring.domain.utils;

import com.example.apiusermonitoring.domain.exception.InvalidDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDate convertToDate(String inputDate) {

        LocalDate outputDate;
        try {
            outputDate = LocalDate.parse(inputDate, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException();
        }

        return outputDate;
    }

}
