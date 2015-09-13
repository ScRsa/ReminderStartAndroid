package ru.scrsa.reminder;

import java.text.SimpleDateFormat;

public class Utils {

    public static String getDate(long date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(date);
    }

    public static String getTime(long date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

}
