package com.neuedu.utils;

import com.neuedu.dao.impl.UserDaoIOImpl;

public class MaxId {
    public static int maxId() {
        UserDaoIOImpl ud = new UserDaoIOImpl();
        return ud.maxId();
    }


}
