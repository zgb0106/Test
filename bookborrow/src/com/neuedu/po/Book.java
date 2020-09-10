package com.neuedu.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    private static int BOOK_ID = 1;
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookDesc;    //描述
    private int bookStock;
    private Date creatTime;

    public Book() {
    }

    @Override
    public String toString() {
        return
                + bookId +
                "," + bookName +
                "," + bookAuthor +
                "," + bookDesc +
                "," + bookStock +
                "," + creatTime +
                ',';
    }

    public Book(String bookName, String bookAuthor, String bookDesc, int bookStock) {
        this.bookId = BOOK_ID++;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDesc = bookDesc;
        this.bookStock = bookStock;
        this.creatTime = new Date();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public Date getCreatTime() {
        return creatTime;
    }
    public String getCreatTimeStr() {
        if (creatTime != null) {
            return new SimpleDateFormat("yyyy年MM月dd日").format(creatTime);
        }
        return "";
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
