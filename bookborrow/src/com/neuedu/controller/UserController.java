package com.neuedu.controller;

import com.neuedu.po.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.utils.ConstantUtil;

import java.util.List;

public class UserController {
    private UserService us = new UserServiceImpl();
    //用户添加
    public String add(User user) {
        boolean flag = us.add(user);
        if (flag) {
            return ConstantUtil.USER_ADD_SUCCESS;
        }
        return ConstantUtil.USER_ADD_FAIL;
    }
    //用户删除
    public String delete(int userId) {
        boolean flag = us.delete(userId);
        if (flag) {
            return ConstantUtil.USER_DELETE_SUCCESS;
        }
        return ConstantUtil.USER_DELETE_FAIL;
    }

    public List<User> viewAll() {
       return us.viewAll();
    }

    public List<User> viewUserNoDel() {
        return us.viewUserNoDel();
    }
    public String changePass(int userId, String userPass) {
        boolean flag = us.changePass(userId,userPass);
        if (flag) {
            return ConstantUtil.USER_CHANGEPASS_SUCCESS;
        }
        return ConstantUtil.USER_CHANGEPASS_FAIL;
    }

    public String checkUser(String userName) {
        boolean flag = us.checkUser(userName);
        if (flag) {
            return  ConstantUtil.USER_CHECKUSER_SUCCESS;
        }
        return ConstantUtil.USER_CHECKUSER_FAIL;
    }

    public String deleteYSC() {
        boolean flag = us.deleteYSC();
        if (flag) {
            return  ConstantUtil.USER_DELETE_SUCCESS;
        }
        return ConstantUtil.USER_DELETE_FAIL;
    }
}
