package com.neuedu.client.admin;

import com.neuedu.controller.BookController;
import com.neuedu.po.Book;
import com.neuedu.utils.ConstantUtil;
import com.neuedu.utils.PrintUtil;
import com.neuedu.utils.RepeatInputUtil;

import java.util.List;
import java.util.Scanner;

public class BookManage {
    private Scanner sc = new Scanner(System.in);
    private BookController bc = new BookController();
    public boolean bookManageClient() {
        PrintUtil.printWelcome(3,"图书管理模块");
        viewBook();
        System.out.println("1:添加图书\t 2:删除图书\t 3:修改图书\t 4:查询图书信息\t 0:退出图书管理模块");
        int flag = RepeatInputUtil.getInputInt("请选择功能模块");
        switch (flag) {
            case 0:
                return true;
            case 1:
                //添加图书功能
                add();
                break;
            case 2:
                //删除图书功能
                delete();
                break;
            case 3:
                //修改图书功能
                changeBook();
                break;
            case 4:
                //查询图书信息
                viewBookInfo();
                break;
            default:
                System.out.println("\033[31m"+ConstantUtil.ERROR_PRINT+"\033[0m");
        }
        return false;
    }

    //添加图书
    public void add() {
        PrintUtil.printWelcome(1,"添加图书功能");
        System.out.println();
        String bookName = RepeatInputUtil.repeatInput("请输入书名");
        String bookAuthor = RepeatInputUtil.repeatInput("请输入作者");
        String bookDesc =  RepeatInputUtil.repeatInput("请描述书籍");
        int bookStock = RepeatInputUtil.getInputInt("请输入库存");
        Book book = new Book(bookName,bookAuthor,bookDesc,bookStock);
        String message = bc.add(book);
        System.out.println(message);
        viewBook();
    }

    //删除图书
    public void delete(){
        PrintUtil.printWelcome(1,"删除图书功能");
        System.out.println();

        int bookId = RepeatInputUtil.getInputInt("请输入要删除的图书id");
        String message = bc.delete(bookId);
        System.out.println(message);
        viewBook();
    }
    //修改图书
    public void changeBook(){
        PrintUtil.printWelcome(1,"修改图书功能");
        int bookId = RepeatInputUtil.getInputInt("请输入要修改的图书id");
        Book book = bc.changeBook(bookId);
        if (book == null) {
            System.out.println(ConstantUtil.BOOK_CHANGE_FAIL);
            return;
        }
        BookChangeBookClient bcbc = new BookChangeBookClient();
        while (true) {
            if ( bcbc.changeBookClient(book)) {
                break;
            }
        }
        viewBook();
    }
    //查询图书
    public void viewBookInfo(){
        PrintUtil.printWelcome(1,"查询图书功能");
        int bookId = RepeatInputUtil.getInputInt("请输入要查询的图书id");
        Book b = bc.viewBookInfo(bookId);
        System.out.println("\033[92m"+"---------------------------------------------------------"+"\033[0m");
        System.out.println("\033[91m"+"图书id\t 书名\t 作者\t 描述\t 库存\t 创建时间"+"\033[0m");
        System.out.println("\033[92m"+"---------------------------------------------------------"+"\033[0m");
        if (b == null) {
            System.out.println(ConstantUtil.BOOK_VIEW_FAIL);
            return;
        }
        System.out.println("  "+b.getBookId()+"\t   "+b.getBookName()+"\t   "+b.getBookAuthor()+"\t    "+b.getBookDesc()+"\t   "+b.getBookStock()+"\t"+b.getCreatTimeStr());
    }
    public void viewBook() {
        System.out.println("\033[92m"+"---------------------------------------------------------------------------"+"\033[0m");
        System.out.println("\033[91m"+"图书id\t 书名\t      作者\t    描述\t    库存\t 创建时间"+"\033[0m");
        System.out.println("\033[92m"+"---------------------------------------------------------------------------"+"\033[0m");
        List<Book> books = bc.viewBook();
        for (Book b:books) {
            if (b != null) {
                System.out.println("  "+b.getBookId()+"\t   "+b.getBookName()+"\t "+b.getBookAuthor()+"\t "+b.getBookDesc()+"\t   "+b.getBookStock()+"\t"+b.getCreatTimeStr());
            }
        }
    }
}
