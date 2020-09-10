package com.neuedu.dao.impl;

import com.neuedu.dao.BookDao;
import com.neuedu.po.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {
    public Book getBookByBookName(String bookName) {
        for (Book b:books) {
            if (bookName.equals(b.getBookName())){
                return b;
            }
        }
        return null;
    }
    public Book getBookByBookId(int bookId) {
        for (Book b:books) {
            if (bookId == b.getBookId()){
                return b;
            }
        }
        return null;
    }

    public boolean add(Book book) {
        return  books.add(book);
    }

    public boolean delete(Book b) {
        return books.remove(b);
    }


    public Book changeBook(int bookId) {
        return getBookByBookId(bookId);
    }

    public Book viewBookInfo(int bookId) {
        return getBookByBookId(bookId);
    }

    public boolean changeBookName(Book book, String bookName) {
        book.setBookName(bookName);
        if (book.getBookName().equals(bookName)) {
            return true;
        }
        return false;
    }

    public boolean changeBookAuthor(Book book, String bookAuthor) {
        book.setBookAuthor(bookAuthor);
        if (book.getBookAuthor().equals(bookAuthor)) {
            return true;
        }
        return false;
    }

    public boolean changeBookDesc(Book book, String bookDesc) {
        book.setBookDesc(bookDesc);
        if (book.getBookDesc().equals(bookDesc)) {
            return true;
        }
        return false;
    }

    public boolean changeBookStock(Book book, int bookStock) {
        book.setBookStock(bookStock);
        if (book.getBookStock() == bookStock) {
            return true;
        }
        return false;
    }

    public List<Book> viewBook() {
        return books;
    }
}
