package com.neuedu.po;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoIOImpl;
import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.MaxId;

public class User {

    private static int  USER_ID = 1;
//    private static Object id = new MaxId();
//    private static int USER_ID = (int)id;
    private int userId;
    private String userName;
    private String password;
    private String realName;
    private String phone;
    private int state;   //0：未审核  1:已审核  2.已删除

    public User() {
    }

    public User(String userName, String password, String realName, String phone) {
        this.userId = USER_ID++;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.phone = phone;
        this.state = 0;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public String getStateStr () {
        switch (state){
            case 0:
                return "未审核";
            case 1:
                return "已审核";
            case 2:
                return "已删除";
        }
        return "";
    }
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  userId +
                "," + userName +
                "," + password +
                "," + realName +
                "," + phone +
                "," + state +",";
    }
}
