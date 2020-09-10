package com.neuedu.dao.impl;

import com.neuedu.dao.BookDao;
import com.neuedu.dao.BorrowBackInfoDao;
import com.neuedu.po.Book;
import com.neuedu.po.BorrowBackInfo;
import com.neuedu.utils.IOUtil;
import com.neuedu.utils.ListUtil;
import com.neuedu.utils.StringToTime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BorrowBackInfoIODaoimpl implements BorrowBackInfoDao {
    public List<BorrowBackInfo> getBorrowBackInfo() {
        List<BorrowBackInfo> bbis = new CopyOnWriteArrayList();

        FileReader fr = null;
        BufferedReader br = null;
        try {
            File file = new File("db/borrowbackinfo_table.data");
            if(!file.exists()) {
                file.createNewFile();
            }

            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String borrowBack_info = "";
            while((borrowBack_info= br.readLine()) != null) {
                String[] attrs = borrowBack_info.split(",");
                BorrowBackInfo bbi = new BorrowBackInfo();
                bbi.setBorrowBackId(Integer.valueOf(attrs[0]));
                bbi.setBookId(Integer.valueOf(attrs[1]));
                bbi.setBookName(attrs[2]);
                bbi.setBorrowUserId(Integer.valueOf(attrs[3]));
                bbi.setBorrowUserName(attrs[4]);
                StringToTime stt = new StringToTime();
                bbi.setBorrowTime(stt.stringToTime(attrs[5]));
                bbi.setBorrowState(Integer.valueOf(attrs[6]));
                bbi.setBackTime(stt.stringToTime(attrs[7]));
                bbis.add(bbi);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bbis;
    }

    @Override
    public BorrowBackInfo getBorrowBackInfoById(int bbiId) {
        List<BorrowBackInfo> bbis = getBorrowBackInfo();
        for (BorrowBackInfo bbi:bbis) {
            if (bbiId == bbi.getBorrowBackId()) {
                return bbi;
            }
        }
        return null;
    }

    @Override
    public BorrowBackInfo borrowInfoQuery() {
        List<BorrowBackInfo> bbis = getBorrowBackInfo();
        for (BorrowBackInfo bbi:bbis) {
            if (bbi.getBorrowState() == 1) {
                return bbi;
            }
        }
        return null;
    }

    @Override
    public BorrowBackInfo returnInfoQuery() {
        List<BorrowBackInfo> bbis = getBorrowBackInfo();
        for (BorrowBackInfo bbi:bbis) {
            if (bbi.getBorrowState() == 2) {
                return bbi;
            }
        }
        return null;
    }

    @Override
    public List<BorrowBackInfo> viewAll() {
        return getBorrowBackInfo();
    }

    @Override
    public boolean add(BorrowBackInfo bbi, Book book) {
//        List<BorrowBackInfo> bbis = getBorrowBackInfo();
        BookDao bd = new BookDaoIOImpl();
        if (bbi != null) {
            bbi.setBorrowState(1);
            if (book.getBookStock() >= 1) {
                bd.changeBookStock(book,(book.getBookStock()-1));
                return IOUtil.append(bbi.toString(),"borrowbackinfo_table.data",true);
            }

        }
        return false;
    }

    @Override
    public BorrowBackInfo viewInfo(int bbiId) {
        return getBorrowBackInfoById(bbiId);
    }

    @Override
    public boolean returnBook(int bbiId, Book book) {
        BorrowBackInfo bbi = getBorrowBackInfoById(bbiId);

        List<BorrowBackInfo> temp = getBorrowBackInfo();

        BookDao bd = new BookDaoIOImpl();
        if (bbi == null) {
            return false;
        }
        bd.changeBookStock(book,book.getBookStock()+1);
        temp.remove(bbi.getBorrowBackId()-1);

        bbi.setBorrowState(2);
        bbi.setBackTime(new Date());
        temp.add(bbi);


        File file = new File("borrowbackinfo_table.data");
        file.delete();

        for (BorrowBackInfo bbi1:temp) {
            return IOUtil.append(bbi1.toString(),"borrowbackinfo_table.data",true);
        }
        return true;
    }
}
