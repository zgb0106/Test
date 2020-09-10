package com.neuedu.service.impl;

import com.neuedu.dao.BorrowBackInfoDao;
import com.neuedu.dao.impl.BorrowBackInfoDaoImpl;
import com.neuedu.po.Book;
import com.neuedu.po.BorrowBackInfo;
import com.neuedu.service.BorrowBackInfoService;

import java.util.List;

public class BorrowBackInfoServiceImpl implements BorrowBackInfoService {
    BorrowBackInfoDao bbid = new BorrowBackInfoDaoImpl();
    public BorrowBackInfo borrowInfoQuery() {
        return bbid.borrowInfoQuery();
    }

    public BorrowBackInfo returnInfoQuery() {
        return bbid.returnInfoQuery();
    }

    public List<BorrowBackInfo> viewAll() {
        return bbid.viewAll();
    }

    public boolean add(BorrowBackInfo bbi, Book book) {
        return bbid.add(bbi,book);
    }

    public BorrowBackInfo viewInfo(int bbiId) {
        return bbid.viewInfo(bbiId);
    }

    public boolean returnBook(int bbiId,Book book) {
        return bbid.returnBook(bbiId,book);
    }
}
