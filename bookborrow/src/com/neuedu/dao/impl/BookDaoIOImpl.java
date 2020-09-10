package com.neuedu.dao.impl;

import com.neuedu.dao.BookDao;
import com.neuedu.po.Book;
import com.neuedu.po.User;
import com.neuedu.utils.IOUtil;
import com.neuedu.utils.StringToTime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookDaoIOImpl implements BookDao {
    @Override
    public Book getBookByBookName(String bookName) {
        List<Book> books = getBooks();
        for (Book b : books) {
            if (b.getBookName().equals(bookName)){
                return b;
            }
        }
        return null;
    }

    @Override
    public Book getBookByBookId(int bookId) {
        List<Book> books = getBooks();
        for (Book b : books) {
            if ( bookId == b.getBookId()){
                return b;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        List<Book> books = new CopyOnWriteArrayList();

        FileReader fr = null;
        BufferedReader br = null;
        try {
            File file = new File("db/book_table.data");
            if(!file.exists()) {
                file.createNewFile();
            }

            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String book_info = "";
            while((book_info= br.readLine()) != null) {
                String[] attrs = book_info.split(",");
                Book book = new Book();
                book.setBookId(Integer.valueOf(attrs[0]));
                book.setBookName(attrs[1]);
                book.setBookAuthor(attrs[2]);
                book.setBookDesc(attrs[3]);
                book.setBookStock(Integer.valueOf(attrs[4]));
                StringToTime stt = new StringToTime();
                book.setCreatTime(stt.stringToTime(attrs[5]));

                books.add(book);
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
        return books;
    }
    @Override
    public boolean add(Book book) {
        return IOUtil.append(book.toString(),"book_table.data",true);
    }

    @Override
    public boolean delete(Book book) {
        List<Book> temp = getBooks();
        if(temp != null) {
            for (Book b:temp) {
               if (book.getBookId() == b.getBookId()) {
                   temp.remove(b);

                   //删除原文件
                   File file = new File("db/book_table.data");
                   file.delete();

                   for (Book c:temp) {

                       IOUtil.append(c.toString(),"book_table.data",true);
                   }
                   if (file.exists()) {
                       return true;
                   }
               }
            }
        }
        return false;
    }

    @Override
    public Book changeBook(int bookId) {
        return getBookByBookId(bookId);
    }

    @Override
    public Book viewBookInfo(int bookId) {
        return getBookByBookId(bookId);
    }

    @Override
    public boolean changeBookName(Book book, String bookName) {
        List<Book> books = getBooks();
        if (book != null) {
            for (Book b:books) {
                if (b.getBookId() == book.getBookId()) {
                    b.setBookName(bookName);
                }
            }

            File file = new File("db/book_table.data");
            file.delete();

            for (Book b1: books) {
                IOUtil.append(b1.toString(),"book_table.data",true);
            }
            if (file.exists()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean changeBookAuthor(Book book, String bookAuthor) {
        List<Book> books = getBooks();
        if (book != null) {
            for (Book b:books) {
                if (b.getBookId() == book.getBookId()) {
                    b.setBookAuthor(bookAuthor);
                }
            }

            File file = new File("db/book_table.data");
            file.delete();

            for (Book b1: books) {
                IOUtil.append(b1.toString(),"book_table.data",true);
            }
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeBookDesc(Book book, String bookDesc) {
        List<Book> books = getBooks();
        if (book != null) {
            for (Book b:books) {
                if (b.getBookId() == book.getBookId()) {
                    b.setBookDesc(bookDesc);
                }
            }

            File file = new File("db/book_table.data");
            file.delete();

            for (Book b1: books) {
                IOUtil.append(b1.toString(),"book_table.data",true);
            }
            if (file.exists()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean changeBookStock(Book book, int bookStock) {
        List<Book> books = getBooks();
        if (book != null) {
            for (Book b:books) {
                if (b.getBookId() == book.getBookId()) {
                    b.setBookStock(bookStock);
                }
            }

            File file = new File("db/book_table.data");
            file.delete();

            for (Book b1: books) {
                IOUtil.append(b1.toString(),"book_table.data",true);
            }
            if (file.exists()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Book> viewBook() {
        return getBooks();
    }
}
