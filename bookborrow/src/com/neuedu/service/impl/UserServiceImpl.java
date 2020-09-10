package com.neuedu.service.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.po.User;
import com.neuedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();
    public boolean add(User user) {
        User user1 = ud.getUserByUserName(user.getUserName());
        if (user1 == null) {
            return ud.add(user);
        }
        return false;
    }

    public boolean delete(int userId) {
        User user = ud.getUserByUserId(userId);
        if (user != null) {
            return ud.delete(user);
        }
        return false;
    }

    public List<User> viewAll() {
        return ud.viewAll();
    }

    public List<User> viewUserNoDel() {
        return ud.viewUserNoDel();
    }
    public boolean changePass(int userId,String userPass) {
        User user =  ud.getUserByUserId(userId);
        return ud.changePass(user,userPass);

    }

    public boolean checkUser(String userName) {
        User user = ud.getUserByUserName(userName);
        return ud.checkUser(user);

    }

    public boolean deleteYSC() {
        return ud.deleteYSC();
    }
}
