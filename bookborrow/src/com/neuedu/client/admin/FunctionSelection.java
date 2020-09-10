package com.neuedu.client.admin;

import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.util.Scanner;

public class FunctionSelection {

    public boolean funSelect(){
        PrintUtil.printWelcome(3,"管理员功能选择模块");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("管理员功能:1.用户管理\t  2.图书管理\t    3.借阅信息管理\t  0.退出管理员登录功能模块");

        int funFlag = RepeatInputUtil.getInputInt("请输入功能：");
        switch (funFlag) {
            case 0:
                return true;
            case 1:
                //进入用户管理界面
                UserManage um = new UserManage();
                while (true){
                    if (um.userManageClient()){
                        break;
                    }
                }
                break;
            case 2:
                //进入图书管理界面
                BookManage bm = new BookManage();
                while (true) {
                    if (bm.bookManageClient()){
                        break;
                    }
                }
                break;
            case 3:
                //进入借阅信息管理届面
                BorrowInfoManage bim = new BorrowInfoManage();
                while(true) {
                    if (bim.borrowInfoManage()) {
                        break;
                    }
                }
                break;
            default:
                System.out.println("\033[31m"+ConstantUtil.ERROR_PRINT+"\033[0m");
                break;
        }
        return false;
    }

}
