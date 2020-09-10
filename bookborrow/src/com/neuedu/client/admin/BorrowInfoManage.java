package com.neuedu.client.admin;

import com.neuedu.controller.BorrowBackInfoController;
import com.neuedu.po.BorrowBackInfo;
import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class BorrowInfoManage {
//    private Scanner sc = new Scanner(System.in);
//    private BookManage bm = new BookManage();
    private BorrowBackInfoController bbic = new BorrowBackInfoController();
    public boolean borrowInfoManage() {
        PrintUtil.printWelcome(3,"借阅信息管理");
        viewAll();
        System.out.println("1:借阅信息查询\t 2.归还信息查询\t 0:退出借阅信息管理");
        int flag = RepeatInputUtil.getInputInt("请输入选择的功能：");
        switch (flag) {
            case 0:
                return true;
            case 1:
                //借阅信息查询
                borrowInfoQuery();
                break;
            case 2:
                //归还信息查询
                returnInfoQuery();
                break;
            default:
                System.out.println(ConstantUtil.ERROR_INPUT_FAIL);
        }
        return false;
    }

    //借阅信息查询
    public void borrowInfoQuery() {
        PrintUtil.printWelcome(3,"借阅信息查询");
        BorrowBackInfo bbi = bbic.borrowInfoQuery();
        System.out.println("借阅归还ID\t 书ID\t 书名\t 借书者ID\t 借阅者用户名\t 借阅时间");
        if (bbi == null) {
            return;
        }
        System.out.println(bbi.getBorrowBackId()+"\t"+bbi.getBookId()+"\t"+bbi.getBookName()+"\t"+bbi.getBorrowUserId()+"\t"+bbi.getBorrowUserName()+"\t"+bbi.getBorrowTimeStr());
    }
    //归还信息查询
    public void returnInfoQuery() {
        PrintUtil.printWelcome(3,"归还信息查询");
        BorrowBackInfo bbi = bbic.returnInfoQuery();
        System.out.println("借阅归还ID\t 书ID\t 书名\t 借书者ID\t 借阅者用户名\t 借阅时间\t 归还时间");
        if (bbi == null) {
            return;
        }
        System.out.println(bbi.getBorrowBackId()+"\t"+bbi.getBookId()+"\t"+bbi.getBookName()+"\t"+bbi.getBorrowUserId()+"\t"+bbi.getBorrowUserName()+"\t"+bbi.getBorrowTimeStr()+"\t"+bbi.getBackTimeStr());
    }

    //所有信息查阅
    public void viewAll() {
        List<BorrowBackInfo> bbis = bbic.viewAll();
        System.out.println("借阅归还ID\t 书ID\t 书名\t 借书者ID\t 借阅者用户名\t 借阅状态");
        for (BorrowBackInfo bbi:bbis) {
            if (bbi == null) {
                return;
            }
            System.out.println(bbi.getBorrowBackId()+"\t"+bbi.getBookId()+"\t"+bbi.getBookName()+"\t"+bbi.getBorrowUserId()+"\t"+bbi.getBorrowUserName()+"\t"+bbi.getBorrowStateStr());
        }
    }
}
