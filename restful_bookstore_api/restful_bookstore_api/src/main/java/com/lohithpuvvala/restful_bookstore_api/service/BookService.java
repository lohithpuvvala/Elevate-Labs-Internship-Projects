package com.lohithpuvvala.restful_bookstore_api.service;

import com.lohithpuvvala.restful_bookstore_api.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(long id);
    void deleteBookById(long id);
    void updateBook(Book book);
    List<Book> getAllBooks();
}
