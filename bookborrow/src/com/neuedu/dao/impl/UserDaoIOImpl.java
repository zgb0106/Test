package com.neuedu.dao.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.po.User;
import com.neuedu.utils.IOUtil;
import com.neuedu.utils.ListUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserDaoIOImpl implements UserDao {
    @Override
    public User getUserByUserName(String userName) {
        List<User> users = getUsersByUsers();
        for (User u :users) {
            if (u.getUserName() .equals(userName)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getUserByUserId(int userId) {
        List<User> users = getUsersByUsers();
            for (User u :users) {
                if (u.getUserId() == userId) {
                    return u;
                }
            }
        return null;
    }
    public  List<User> getUsersByUsers() {
        List users = new CopyOnWriteArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            File file = new File("db/user_table.data");
            if(!file.exists()) {
                file.createNewFile();
            }

            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String user_info = "";
            while((user_info = br.readLine()) != null) {
                String[] attrs = user_info.split(",");
                User user = new User();
                user.setUserId(Integer.valueOf(attrs[0]));
                user.setUserName(attrs[1]);
                user.setPassword(attrs[2]);
                user.setRealName(attrs[3]);
                user.setPhone(attrs[4]);

                user.setState(Integer.valueOf(attrs[5]));
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    @Override
    public boolean add(User user) {
        return IOUtil.append(user.toString(),"user_table.data",true);
    }

    @Override
    public boolean delete(User user) {
        List<User> users = getUsersByUsers();
        if(users != null) {
            for (User u : users) {
                if (u.getUserId() == user.getUserId()) {
                    //将原来的文件干掉
                    u.setState(2);
                    File file = new File("db/user_table.data");
                    file.delete();
                    //将list中的数据，会写到文件中
                    for (User v : users) {
                        IOUtil.append(v.toString(), "user_table.data", true);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<User> viewAll() {
        List<User> users = getUsersByUsers();
        return users;
    }

    @Override
    public List<User> viewUserNoDel() {
        List<User> users = getUsersByUsers();
        List<User> temp = new CopyOnWriteArrayList<>();
        for (User u:users){
            if (u.getState() == 0 || u.getState() == 1) {
                temp.add(u);
            }
        }
        return temp;
    }

    @Override
    public boolean changePass(User user, String userPass) {
        List<User> users = getUsersByUsers();
            for (User u : users) {
                if (user != null) {
                    if (u.getUserId() == user.getUserId()) {
                        u.setPassword(userPass);
                        //将原来的文件干掉
                        File file = new File("db/user_table.data");
                        file.delete();
                        //将list中的数据，会写到文件中
                        for (User v : users) {
                            IOUtil.append(v.toString(), "user_table.data", true);
                        }
                        return true;
                    }
                }
            }
        return false;
    }

    @Override
    public boolean checkUser(User user) {
        List<User> users = getUsersByUsers();
        if (user != null) {
            for (User u : users) {
                    if (u.getUserId() == user.getUserId()) {
                            //将原来的文件干掉
                            u.setState(1);
                            File file = new File("db/user_table.data");
                            file.delete();
                            //将list中的数据，会写到文件中
                            for (User v : users) {
                                IOUtil.append(v.toString(), "user_table.data", true);
                            }
                            return true;
                    }
            }
        }
        return false;
    }

    @Override
    public boolean deleteYSC() {
        List<User> users = getUsersByUsers();
        //将list中的数据进行删除
        for (User u: users) {
            if (u.getState() == 2) {
                users.remove(u);
            }
        }

        //将原来的文件干掉
        if (users != null) {
            File file = new File("db/user_table.data");
            file.delete();
            //将list中的数据，会写到文件中
            for (User u : users) {
                IOUtil.append(u.toString(), "user_table.data", true);
            }
            return true;
        }
        return false;
    }
    public int maxId() {
        List<User> users = getUsersByUsers();
        List ids = new ArrayList();
        if (users != null) {
            for (User u : users) {
                ids.add(u.getUserId());
            }
            int Maxid = (int) Collections.max(ids);
            return Maxid;
        }
        return 1;
    }
}
