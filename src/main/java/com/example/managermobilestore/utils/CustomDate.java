package com.example.managermobilestore.utils;

import com.example.managermobilestore.constant.DateTimeConstant;

import java.text.SimpleDateFormat;

public class CustomDate {
    private CustomDate() {
    }

    public static SimpleDateFormat configFormatAndParseDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateTimeConstant.DATE_FORMAT);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }
}
