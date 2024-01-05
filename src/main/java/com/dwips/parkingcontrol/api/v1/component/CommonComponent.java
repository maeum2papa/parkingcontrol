package com.dwips.parkingcontrol.api.v1.component;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommonComponent {

    // "0000-00-00 00:00:00" -> LocalDateTime
    public LocalDateTime stringToLocalDateTime(String dateString) {

        // DateTimeFormatter를 사용하여 문자열을 LocalDateTime으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);

    }

    // LocalDateTime -> "0000-00-00 00:00:00"
    public String localDateTimeToString(LocalDateTime dateTime) {
        // DateTimeFormatter를 사용하여 LocalDateTime을 문자열로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    // "0000-00-00" -> LocalDate
    public LocalDate stringToLocalDate(String dateString) {

        // DateTimeFormatter를 사용하여 문자열을 LocalDate로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);

    }

    // LocalDate -> "0000-00-00"
    public String localDateToString(LocalDate dateTime) {
        // DateTimeFormatter를 사용하여 LocalDate을 문자열로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTime.format(formatter);
    }

}
