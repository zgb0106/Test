package com.neuedu.dao;

import com.neuedu.po.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookDao {
    List<Book> books = new ArrayList<>();
    public Book getBookByBookName(String bookName);

    public Book getBookByBookId(int bookId);

    public boolean add(Book book);

    public boolean delete(Book b);


    public Book changeBook(int bookId);

    public Book viewBookInfo(int bookId);

    public boolean changeBookName(Book book, String bookName);

    public boolean changeBookAuthor(Book book, String bookAuthor);

    public boolean changeBookDesc(Book book, String bookDesc);

    public boolean changeBookStock(Book book, int bookStock);

    public List<Book> viewBook();
}
