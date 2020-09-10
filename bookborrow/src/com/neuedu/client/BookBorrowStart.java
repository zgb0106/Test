package com.neuedu.client;

import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.util.Scanner;

public class BookBorrowStart {
//    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        PrintUtil.printWelcome(5,"欢迎来到Happy Read图书借阅系统");
        while(true) {
           if (selsectLogin()){
               break;
           }
        }
    }

    public static boolean selsectLogin(){

            LoginClient lc = new LoginClient();
            System.out.println("\033[91m"+"系统功能：1.管理员登录    2.普通用户登录     0.退出");

            int funFlag = RepeatInputUtil.getInputInt("请输入选择的功能：");
            if (funFlag == 0) {
                System.out.println("\033[95m"+"欢迎再来");
                return true;
            }

            if (funFlag !=1 && funFlag != 2) {
                System.out.println("\033[31m"+ConstantUtil.ERROR_PRINT+"\033[0m");
                return false;
            }
            switch (funFlag) {
                case 1:
                    //进入管理员登录功能
                    lc.adiminLogin();
                    break;

                case 2:
                    //进入普通用户登录功能
                    lc.userLogin();
                    break;
            }
            return false;
        }

}
