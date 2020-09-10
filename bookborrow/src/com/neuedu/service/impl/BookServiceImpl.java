package com.neuedu.service.impl;

import com.neuedu.dao.BookDao;
import com.neuedu.dao.impl.BookDaoImpl;
import com.neuedu.po.Book;
import com.neuedu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bd = new BookDaoImpl();
    public boolean add(Book book) {
        Book b = bd.getBookByBookName(book.getBookName());
        if (b == null) {
            return bd.add(book);
        }
        return false;
    }

    public boolean delete(int bookId) {
        Book b = bd.getBookByBookId(bookId);
        if (b != null) {
            return bd.delete(b);
        }
        return false;
    }

    public Book changeBook(int bookId) {
        return bd.changeBook(bookId);
    }

    public Book viewBookInfo(int bookId) {
        return bd.viewBookInfo(bookId);
    }

    public boolean changeBookName(Book book, String bookName) {
        return  bd.changeBookName(book,bookName);
    }

    public boolean changeBookAuthor(Book book, String bookAuthor) {
        return  bd.changeBookAuthor(book,bookAuthor);
    }

    public boolean changeBookDesc(Book book, String bookDesc) {
        return  bd.changeBookDesc(book,bookDesc);
    }

    public boolean changeBookStock(Book book, int bookStock) {
        return  bd.changeBookStock(book,bookStock);
    }

    public List<Book> viewBook() {
        return bd.viewBook();
    }
}
