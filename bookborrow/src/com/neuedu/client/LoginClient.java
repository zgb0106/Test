package com.neuedu.client;

import com.neuedu.client.admin.FunctionSelection;
import com.neuedu.client.user.FunctionSelect;
import com.neuedu.controller.UserController;
import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.po.User;
import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.util.List;
import java.util.Scanner;

public class LoginClient {
    private Scanner sc = new Scanner(System.in);
    private static final String ADMIN_USERNAME = "a";
    private static final String ADMIN_PASSWORD = "a";
    public void adiminLogin(){
        FunctionSelection fs = new FunctionSelection();

        PrintUtil.printWelcome(3,"管理员登录模块");
        System.out.println("请输入管理员用户名");
        String adminUserName = sc.next();
        System.out.println("请输入管理员的密码");
        String adminPassword = sc.next();

        if (ADMIN_USERNAME.equals(adminUserName) && ADMIN_PASSWORD.equals(adminPassword)){
            //登录成功，进入管理员界面
            while (true) {
                    //进入管理员功能选择模块，要有返回值
                if (fs.funSelect()){
                    break;
                }
            }
        }else {
            System.out.println("\033[31m"+ConstantUtil.ERROR_LOGIN+"\033[0m");
        }

    }

    public void userLogin(){
        FunctionSelect fs = new FunctionSelect();
        PrintUtil.printWelcome(3,"普通用户登录模块");
        while (true) {
            if (fs.functionSelectClient()) {
                break;
            }
        }
    }

    }
