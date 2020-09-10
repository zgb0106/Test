package com.neuedu.po;

import com.neuedu.utils.StringToTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowBackInfo {
    StringToTime stt = new StringToTime();
    private Date currentDate = stt.stringToTime("Thu Jan 01 00:00:00 CST 1970");
    private static int ID = 1;
    private int borrowBackId;
    private int bookId;
    private String bookName;
    private int borrowUserId;
    private String borrowUserName;
    private Date borrowTime;
    private int borrowState;  //1.借阅  2.归还
    private Date backTime;

    public BorrowBackInfo() {
        this.borrowBackId = ID++;
        this.borrowState = 1;
    }

    public BorrowBackInfo(int bookId, String bookName, int borrowUserId, String borrowUserName) {
        this.borrowBackId = ID++;
        this.bookId = bookId;
        this.bookName = bookName;
        this.borrowUserId = borrowUserId;
        this.borrowUserName = borrowUserName;
        this.borrowState = 1;
        this.borrowTime = new Date();
        this.backTime = currentDate;
    }

    public int getBorrowBackId() {
        return borrowBackId;
    }

    public void setBorrowBackId(int borrowBackId) {
        this.borrowBackId = borrowBackId;
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

    public int getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(int borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    @Override
    public String toString() {
        return  borrowBackId +
                "," + bookId +
                "," + bookName +
                "," + borrowUserId +
                "," + borrowUserName +
                "," + borrowTime +
                "," + borrowState +
                "," + backTime+",";
    }

    public String getBorrowTimeStr() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(borrowTime);
    }

    public int getBorrowState() {
        return borrowState;
    }

    public String getBorrowStateStr() {
        switch (borrowState) {
            case 1:
                return "借阅";
            case 2:
                return "归还";
        }
        return "";
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public void setBorrowState(int borrowState) {
        this.borrowState = borrowState;
    }

    public Date getBackTime() {
        return backTime;
    }
    public String getBackTimeStr() {
        if (backTime.equals(currentDate)) {
            return null;
        }
        String str =  new SimpleDateFormat("yyyy年MM月dd日").format(backTime);
        return str;
    }

    public void setBackTime(Date date) {
        this.backTime = date;
    }
}
