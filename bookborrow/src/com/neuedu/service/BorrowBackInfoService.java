package com.neuedu.service;

import com.neuedu.dao.BorrowBackInfoDao;
import com.neuedu.dao.impl.BorrowBackInfoDaoImpl;
import com.neuedu.po.Book;
import com.neuedu.po.BorrowBackInfo;

import java.util.List;

public interface BorrowBackInfoService {

    public BorrowBackInfo borrowInfoQuery();

    public BorrowBackInfo returnInfoQuery();

    public List<BorrowBackInfo> viewAll() ;

    public boolean add(BorrowBackInfo bbi, Book book);

    public BorrowBackInfo viewInfo(int bbiId);

    public boolean returnBook(int bbiId,Book book);
}
