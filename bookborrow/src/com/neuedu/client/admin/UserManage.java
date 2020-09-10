package com.neuedu.client.admin;

import com.neuedu.controller.UserController;
import com.neuedu.po.User;
import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.util.List;
import java.util.Scanner;

public class UserManage {
   private Scanner sc = new Scanner(System.in);
   private UserController uc = new UserController();
   public boolean userManageClient() {
       PrintUtil.printWelcome(3,"用户管理模块");
       System.out.println();
       viewUserNoDelInfo();
       System.out.println("1：添加用户\t 2：删除用户\t 3：查看用户信息\t 4:用户密码修改\t 5：用户审核\t 0:退出本模块");
       int flag = RepeatInputUtil.getInputInt("请输入选择的功能：");
       switch (flag) {
           case 0:
               return true;
           case 1:
               //添加用户功能
               add();
               break;
           case 2:
               //删除用户功能
               delete();
               break;
           case 3:
               //查看用户信息
               viewUserInfo();
               break;
           case 4:
               //用户密码修改功能
               changePassword();
               break;
           case 5:
               //用户审核功能
               checkUser();
               break;
           default:
               System.out.println("\033[31m"+ConstantUtil.ERROR_PRINT+"\033[0m");
       }
       return false;
   }
    //添加用户
    public void add() {
        PrintUtil.printWelcome(1,"添加用户功能");
        System.out.println();
        String userName = RepeatInputUtil.repeatInput("请输入用户名");
        String userPass = RepeatInputUtil.repeatInput("请输入密码");
        String userPass2 = RepeatInputUtil.repeatInput("请再次输入密码");
        String userRealName = RepeatInputUtil.repeatInput("请输入用户真实姓名");
        String userPhone = RepeatInputUtil.repeatInput("请输入手机号");

        if (userPass.equals(userPass2)){
            User user = new User(userName,userPass,userRealName,userPhone);
            String flag = uc.add(user);
            System.out.println(flag);
        }else {
            System.out.println("\033[31m"+ConstantUtil.ERROR_PASSWORD_TEST+"\033[0m");
        }
        viewUserNoDelInfo();
    }
    //删除用户
    public void delete() {
        PrintUtil.printWelcome(1,"删除用户功能");
        System.out.println();
        System.out.println("请输入要删除的用户id");
        int userId = sc.nextInt();
        String flag = uc.delete(userId);
        System.out.println(flag);
        viewUserNoDelInfo();
    }
    //查看用户信息
    public void viewUserInfo() {
        List<User> users = uc.viewAll();
        PrintUtil.printWelcome(1,"查看所有用户信息");
        System.out.println();
        System.out.println("用户id\t 用户名\t 姓名\t 手机号\t 状态");
        for (User u:users) {
            System.out.println(u.getUserId()+"\t"+u.getUserName()+"\t"+u.getRealName()+"\t"+u.getPhone()+"\t"+u.getStateStr());
        }
        while (true) {
            if (deleteYSC()) {
                break;
            }
        }
    }

    public boolean deleteYSC() {
        System.out.println("是否需要清理\t1:需要 0:退出");
        int flag = sc.nextInt();
        switch (flag) {
            case 0:
                return true;
            case 1:
                String message = uc.deleteYSC();
                System.out.println(message);
                return false;
            default:
                System.out.println(ConstantUtil.ERROR_INPUT_FAIL);
        }
        return true;
    }

    //查看未删除的用户
    public void viewUserNoDelInfo() {
        List<User> users = uc.viewUserNoDel();
        System.out.println("\033[92m"+"---------------------------------------------------------"+"\033[0m");
        System.out.println("\033[91m"+"用户id\t用户名\t姓名\t   手机号\t  状态"+"\033[0m");
        System.out.println("\033[92m"+"---------------------------------------------------------"+"\033[0m");
        for (User u:users) {
            System.out.println("   "+u.getUserId()+"\t"+u.getUserName()+"\t"+u.getRealName()+"\t"+u.getPhone()+"\t"+u.getStateStr());
        }
    }
    //修改用户密码
    public void changePassword() {
        PrintUtil.printWelcome(1,"修改用户密码");
        System.out.println();
        System.out.println("请输入要修改的用户id");
        int userId = sc.nextInt();
        System.out.println("请输入修改后的密码");
        String userPass = sc.next();
        String flag = uc.changePass(userId,userPass);
        System.out.println(flag);
    }
    //用户审核功能
    public void checkUser() {
        PrintUtil.printWelcome(1,"用户审核功能");
        System.out.println();
        System.out.println("请输入要审核的用户名");
        String userName = sc.next();
        String message = uc.checkUser(userName);
        System.out.println(message);
    }
}
