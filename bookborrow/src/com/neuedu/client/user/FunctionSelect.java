package com.neuedu.client.user;

import com.neuedu.client.admin.BookManage;
import com.neuedu.controller.BookController;
import com.neuedu.controller.BorrowBackInfoController;
import com.neuedu.controller.UserController;
import com.neuedu.po.Book;
import com.neuedu.po.BorrowBackInfo;
import com.neuedu.po.User;
import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.util.List;
import java.util.Scanner;

public class FunctionSelect {
    private Scanner sc = new Scanner(System.in);
    private UserController uc = new UserController();
    private BookController bc = new BookController();
    private BorrowBackInfoController bbic = new BorrowBackInfoController();
    private BookManage bm = new BookManage();
    public boolean functionSelectClient() {
        System.out.println("1:登录\t 2:注册\t 3:忘记密码\t 0:退出");
        int funflag = RepeatInputUtil.getInputInt("请选择功能模块");
        switch (funflag) {
            case 0:
                return true;
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("请寻找管理员...");
                break;
        }
        return false;
    }
    public void login() {
        System.out.println("请输入用户名");
        String UserName = sc.next();
        System.out.println("请输入密码");
        String Password = sc.next();
        List<User> users = uc.viewAll();
        if (users == null) {
            System.out.println("查找不到用户,请联系管理员.");
            return;
        }
        for (User u : users) {
            if (u.getUserName().equals(UserName) && u.getPassword().equals(Password)) {
                if (u.getState() == 0 || u.getState()==2) {
                    System.out.println("无法登录，账号未审核或已被删除，详情私聊管理员");
                    return;
                }
                //登录成功，进入用户登录界面
                while (true) {
                    //进入用户功能选择模块，要有返回值
                    if (funSelect(u)) {
                        break;
                    }
                }
                return;
            }
        }
        System.out.println("\033[31m"+ConstantUtil.ERROR_LOGIN+"\033[0m");
    }
    public boolean funSelect(User u) {
        PrintUtil.printWelcome(5,"用户功能选择模块");
        System.out.println("1:密码修改\t 2:图书借阅\t 3:图书归还\t 0:退出");
        int funFlag = RepeatInputUtil.getInputInt("请选择功能：");
        switch (funFlag){
            case 0:
                return true;
            case 1:
                //密码修改功能
                while(true){
                    if (changePassword(u)){
                        break;
                    }
                }
                break;
            case 2:
                //借阅图书功能
                borrowBook(u);
                break;
            case 3:
                //图书归还功能
                returnBook(u);
                break;
            default:
                System.out.println("\033[31m"+ConstantUtil.ERROR_PRINT+"\033[0m");
        }
        return false;
    }
    //归还图书
    private void returnBook(User u) {
        PrintUtil.printWelcome(3,"归还图书功能");
        int bbiId = RepeatInputUtil.getInputInt("请输入要归还的Id");
        BorrowBackInfo bbi = bbic.viewInfo(bbiId);
        if (bbi == null) {
            System.out.println(ConstantUtil.BORROW_RETURN_FAIL);
            return;
        }
        Book book = bc.viewBookInfo(bbi.getBookId());
        if (book == null) {
            System.out.println("查找不到此书");
            return;
        }
        String message = bbic.returnBook(bbiId,book);
        System.out.println(message);
    }
    //借阅图书
    private void borrowBook(User u) {
        PrintUtil.printWelcome(3,"借阅图书功能");;
        bm.viewBook();
        int bookId = RepeatInputUtil.getInputInt("请输入要借阅的书Id");
        Book book = bc.viewBookInfo(bookId);
        BorrowBackInfo bbi = new BorrowBackInfo(bookId,book.getBookName(),u.getUserId(),u.getUserName());
        String message = bbic.add(bbi,book);
        System.out.println(message);
    }
    //修改密码
    private boolean changePassword(User u) {
        PrintUtil.printWelcome(3,"修改密码功能");
        System.out.println("请输入原密码");
        String pass1 = sc.next();
        if (pass1.equals(u.getPassword())){
            System.out.println("请输入修改后的密码");
            String pass2 = sc.next();
            String message = uc.changePass(u.getUserId(),pass2);
            System.out.println(message);
            return true;
        }else {
            System.out.println("原密码输入不一致，请重新输入");
            return false;
        }
    }

    public void register() {
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
    }


}
