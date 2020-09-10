package com.neuedu.service;

import com.neuedu.dao.BookDao;
import com.neuedu.dao.impl.BookDaoIOImpl;
import com.neuedu.dao.impl.BookDaoImpl;
import com.neuedu.po.Book;

import java.util.List;

public interface BookService {


    public boolean add(Book book);

    public boolean delete(int bookId);

    public Book changeBook(int bookId);

    public Book viewBookInfo(int bookId);

    public boolean changeBookName(Book book, String bookName);

    public boolean changeBookAuthor(Book book, String bookAuthor);

    public boolean changeBookDesc(Book book, String bookDesc);

    public boolean changeBookStock(Book book, int bookStock);

    public List<Book> viewBook();
}
