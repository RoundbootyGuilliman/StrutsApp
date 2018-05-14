package com.epam.javalab.strutsapp.util;

import com.epam.javalab.strutsapp.entity.News;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeAndDateHandler {

    private TimeAndDateHandler(){}

    public static void setDate(News news, Locale locale) {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        Date date = new Date(news.getTime());
        //news.setDate(dateFormatter.format(date));
    }
}
