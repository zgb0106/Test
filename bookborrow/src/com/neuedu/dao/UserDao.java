package com.neuedu.dao;

import com.neuedu.po.User;
import com.neuedu.utils.ListUtil;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface UserDao {
    List<User> users = new ArrayList<>();

    public User getUserByUserName(String userName);

    public User getUserByUserId(int userId);

    public boolean add(User user);


    public boolean delete(User user);



    public List<User> viewAll();

    public List<User> viewUserNoDel();
//    public static void main(String[] args) {
////        User user = new User("a","a","a","a");
////        users.add(user);
////        List<User> temp = new ArrayList<>();
////        ListUtil.copy(temp,users);
////        for (User u:temp) {
////            System.out.println(u.toString());
////        }
////        UserDao ud = new UserDao();
////        User user = new User("admin","admin","admin","123456");
////        User user1 = new User("admina1","admin","admin","123456");
////        users.add(user);
////        users.add(user1);
////        boolean flag = ud.delete(user1);
////        List flag1 = ud.viewAll();
////        for(Object u:flag1) {
////            System.out.println(u.toString());
////        }
//    }

    public boolean changePass(User user,String userPass);

    public boolean checkUser(User user);


    public boolean deleteYSC();
}
