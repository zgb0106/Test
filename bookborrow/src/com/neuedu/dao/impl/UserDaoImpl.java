package com.neuedu.dao.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.po.User;
import com.neuedu.utils.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
//        private static final List<User> users = new ArrayList();

        public User getUserByUserName(String userName){
            for (User u:users){
                if (userName.equals(u.getUserName())) {
                    return u;
                }
            }
            return null;
        }
        public User getUserByUserId(int userId) {
            for (User u:users) {
                if (userId == u.getUserId()) {
                    return u;
                }
            }
            return null;
        }
        public boolean add(User user) {
            return users.add(user);
        }

        public boolean delete(User user) {
            user.setState(2);
            if (user.getState() == 2) {
                return true;
            }
            return false;
        }

        public List<User> viewAll() {
            List<User> temp = new ArrayList<>();
            ListUtil.copy(temp,users);
            return temp;
        }

        public List<User> viewUserNoDel() {
            List<User> temp = new ArrayList<>();
            List<User> temp2 = new ArrayList<>();
            ListUtil.copy(temp,users);
            for (User u:temp){
                if (u.getState() !=2) {
                    temp2.add(u);
                }
            }
            return temp2;
        }
        public static void main(String[] args) {
//        User user = new User("a","a","a","a");
//        users.add(user);
//        List<User> temp = new ArrayList<>();
//        ListUtil.copy(temp,users);
//        for (User u:temp) {
//            System.out.println(u.toString());
//        }
//        UserDao ud = new UserDao();
//        User user = new User("admin","admin","admin","123456");
//        User user1 = new User("admina1","admin","admin","123456");
//        users.add(user);
//        users.add(user1);
//        boolean flag = ud.delete(user1);
//        List flag1 = ud.viewAll();
//        for(Object u:flag1) {
//            System.out.println(u.toString());
//        }
        }

        public boolean changePass(User user,String userPass) {
            user.setPassword(userPass);
            if (user.getPassword().equals(userPass)) {
                return true;
            }
            return false;
        }

        public boolean checkUser(User user) {
            user.setState(1);
            if (user.getState() == 1) {
                return true;
            }
            return false;
        }


        public boolean deleteYSC() {
            for (User u : users) {
                if (u.getState()==2){
                    users.remove(u);
                    return true;
                }
            }
            return false;
        }
}
