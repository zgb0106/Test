package com.neuedu.controller;

import com.neuedu.po.Book;
import com.neuedu.po.BorrowBackInfo;
import com.neuedu.service.BorrowBackInfoService;
import com.neuedu.service.impl.BorrowBackInfoServiceImpl;
import com.neuedu.utils.ConstantUtil;

import java.util.List;

public class BorrowBackInfoController {
    BorrowBackInfoService bbis = new BorrowBackInfoServiceImpl();
    public BorrowBackInfo borrowInfoQuery() {
        return bbis.borrowInfoQuery();
    }

    public BorrowBackInfo returnInfoQuery() {
        return bbis.returnInfoQuery();
    }

    public List<BorrowBackInfo> viewAll() {
        return bbis.viewAll();
    }

    public String add(BorrowBackInfo bbi, Book book) {
        boolean flag = bbis.add(bbi,book);
        if (flag) {
            return ConstantUtil.BORROW_ADD_SUCCESS;
        }
        return ConstantUtil.BORROW_ADD_FAIL;
    }

    public BorrowBackInfo viewInfo(int bbiId) {
        return  bbis.viewInfo(bbiId);
    }

    public String returnBook(int bbiId,Book book) {
        boolean flag = bbis.returnBook(bbiId,book);
        if (flag) {
            return ConstantUtil.BORROW_RETURN_SUCCESS;
        }else {
            return ConstantUtil.BORROW_RETURN_FAIL;
        }
    }
}
