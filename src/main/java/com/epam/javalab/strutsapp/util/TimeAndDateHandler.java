package com.epam.javalab.strutsapp.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeAndDateHandler {

    private TimeAndDateHandler(){}

    public static String setDate(long time, Locale locale) {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        Date date = new Date(time);
        return dateFormatter.format(date);
    }
}
