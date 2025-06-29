package com.skp.test1.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Date toDate(String dateString) {
        try {
            Date date = sdf.parse(dateString);
            return stripTime(date);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Use dd/MM/yyyy");
        }
    }

    public static String format(Date date) {
        return sdf.format(date);
    }

    public static Date stripTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
