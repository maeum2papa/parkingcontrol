package com.dwips.parkingcontrol.api.v1.component;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommonComponent {

    // "0000-00-00 00:00:00" -> LocalDateTime
    public LocalDateTime stringDateTimeToLocalDateTime(String dateString) {

        // DateTimeFormatter를 사용하여 문자열을 LocalDateTime으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);

    }

    // LocalDateTime -> "0000-00-00 00:00:00"
    public String localDateTimeToStringDateTime(LocalDateTime dateTime) {
        // DateTimeFormatter를 사용하여 LocalDateTime을 문자열로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    // "0000-00-00" -> LocalDate
    public LocalDate stringDateToLocalDate(String dateString) {

        // DateTimeFormatter를 사용하여 문자열을 LocalDate로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);

    }


    // LocalDate -> "0000-00-00"
    public String localDateToStringDate(LocalDate dateTime) {
        // DateTimeFormatter를 사용하여 LocalDate을 문자열로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTime.format(formatter);
    }


    // "0000-00-00" -> LocalDateTime(type "to" = 0000-00-00 23:59:59, type "from" = 0000-00-00 00:00:00)
    public LocalDateTime stringDateToLocalDateTime(String dateString, String type) {

        if(dateString.length() == 10){
            if(type == "to"){
                dateString = dateString + " 23:59:59";
            }else{
                dateString = dateString + " 00:00:00";
            }
        }

        return stringDateTimeToLocalDateTime(dateString);
    }


}
