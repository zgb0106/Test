package com.neuedu.utils;

import com.neuedu.po.User;

import java.util.List;

public class ListUtil {
    public static List<User>  copy(List<User> dest, List<User> src) {
        for (User u:src){
            dest.add(u);
        }
        return dest;
    }
}
