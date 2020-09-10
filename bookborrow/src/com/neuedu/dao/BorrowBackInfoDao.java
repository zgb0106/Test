package com.neuedu.dao;

import com.neuedu.po.Book;
import com.neuedu.po.BorrowBackInfo;

import java.util.ArrayList;
import java.util.List;

public interface BorrowBackInfoDao {
    List<BorrowBackInfo> bbis = new ArrayList<>();
//    BorrowBackInfo bbi = new BorrowBackInfo(1,"lala",1,"admin");
    public BorrowBackInfo getBorrowBackInfoById(int bbiId);

    public BorrowBackInfo borrowInfoQuery();

    public BorrowBackInfo returnInfoQuery();

    public List<BorrowBackInfo> viewAll();

    public boolean add(BorrowBackInfo bbi, Book book);

    public BorrowBackInfo viewInfo(int bbiId);

    public boolean returnBook(int bbiId,Book book);
}
