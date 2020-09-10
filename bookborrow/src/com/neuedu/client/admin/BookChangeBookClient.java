package com.neuedu.client.admin;

import com.neuedu.controller.BookController;
import com.neuedu.po.Book;
import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.util.Scanner;

public class BookChangeBookClient {
    private Scanner sc = new Scanner(System.in);
    private BookController bc = new BookController();
    public boolean changeBookClient(Book book) {
        System.out.println("1:修改书名\t 2:修改作者\t 3:修改描述\t 4:修改库存\t 0:退出");
        int flag = RepeatInputUtil.getInputInt("请输入选择的功能");
        switch (flag) {
            case 0:
                return true;
            case 1:
                //修改书名功能
                changeBookName(book);
                break;
            case 2:
                //修改作者功能
                changeBookAuther(book);
                break;
            case 3:
                //修改描述功能
                changeBookDesc(book);
                break;
            case 4:
                //修改库存功能
                changeBookStock(book);
                break;
            default:
                System.out.println(ConstantUtil.ERROR_INPUT_FAIL);
        }
        return true;
    }

    private void changeBookName(Book book) {
        PrintUtil.printWelcome(1,"修改书名");
        String bookName = RepeatInputUtil.repeatInput("请输入修改后的书名：");
        String message = bc.changeBookName(book,bookName);
        System.out.println(message);
    }
    private void changeBookAuther(Book book) {
        PrintUtil.printWelcome(1,"修改作者");
        String bookAuthor = RepeatInputUtil.repeatInput("请输入修改后的作者：");
        String message = bc.changeBookAuthor(book,bookAuthor);
        System.out.println(message);
    }
    private void changeBookDesc(Book book) {
        PrintUtil.printWelcome(1,"修改描述");
        String bookDesc = RepeatInputUtil.repeatInput("请输入修改后的描述：");
        String message = bc.changeBookDesc(book,bookDesc);
        System.out.println(message);
    }
    private void changeBookStock(Book book) {
        PrintUtil.printWelcome(1,"修改库存");
        int bookStock = RepeatInputUtil.getInputInt("请输入修改后的库存：");
        String message = bc.changeBookStock(book,bookStock);
        System.out.println(message);
    }

}
