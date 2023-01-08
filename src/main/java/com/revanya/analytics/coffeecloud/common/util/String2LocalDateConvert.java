package com.revanya.analytics.coffeecloud.common.util;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class String2LocalDateConvert {

    public static final String DATE_FORMAT = "dd-MM-yyyy";

    public static LocalDate convertString2LocalDate(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(dateString, formatter);
    }
}
