package com.neuedu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringToTime {
    public  Date stringToTime(String str) {
        try {
            return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.US).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
