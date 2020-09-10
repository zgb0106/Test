package com.neuedu.utils;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str) || "null".equals(str)||str.contains(" ")) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
