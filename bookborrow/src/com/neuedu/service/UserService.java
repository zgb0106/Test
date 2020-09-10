package com.neuedu.service;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.po.User;
import com.neuedu.utils.ConstantUtil;

import java.util.List;

public interface UserService {
    UserDao ud = new UserDaoImpl();

    public boolean add(User user);

    public boolean delete(int userId);

    public List<User> viewAll();

    public List<User> viewUserNoDel();

    public boolean changePass(int userId,String userPass);

    public boolean checkUser(String userName);

    public boolean deleteYSC();
}
