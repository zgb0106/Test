package com.neuedu.dao.impl;

import com.neuedu.dao.BorrowBackInfoDao;
import com.neuedu.po.Book;
import com.neuedu.po.BorrowBackInfo;

import java.util.Date;
import java.util.List;

public class BorrowBackInfoDaoImpl implements BorrowBackInfoDao {
    public BorrowBackInfo getBorrowBackInfoById(int bbiId) {
        for (BorrowBackInfo bbi:bbis) {
            if (bbiId == bbi.getBorrowBackId()) {
                return bbi;
            }
        }
        return null;
    }
    public BorrowBackInfo borrowInfoQuery() {
        for (BorrowBackInfo bbi:bbis) {
            if (bbi.getBorrowState() == 1) {
                return bbi;
            }
        }
        return null;
    }

    public BorrowBackInfo returnInfoQuery() {
        for (BorrowBackInfo bbi:bbis) {
            if (bbi.getBorrowState() == 2) {
                return bbi;
            }
        }
        return null;
    }

    public List<BorrowBackInfo> viewAll() {
        return bbis;
    }


    public boolean add(BorrowBackInfo bbi, Book book) {
        bbi.setBorrowState(1);
        if (book.getBookStock() >= 1) {
            book.setBookStock(book.getBookStock()-1);
            return bbis.add(bbi);
        }
        else {
            return false;
        }
    }

    public BorrowBackInfo viewInfo(int bbiId) {
        return getBorrowBackInfoById(bbiId);
    }

    public boolean returnBook(int bbiId,Book book) {
        BorrowBackInfo bbi = getBorrowBackInfoById(bbiId);
        if (bbi == null) {
            return false;
        }
        book.setBookStock(book.getBookStock()+1);
        bbi.setBorrowState(2);
        bbi.setBackTime(new Date());
        return true;
    }
}
