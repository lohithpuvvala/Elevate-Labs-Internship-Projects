package com.lohithpuvvala.restful_bookstore_api.service.impl;

import com.lohithpuvvala.restful_bookstore_api.dto.BookDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.BookDto;
import com.lohithpuvvala.restful_bookstore_api.model.Book;
import com.lohithpuvvala.restful_bookstore_api.repository.BookRepository;
import com.lohithpuvvala.restful_bookstore_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDetailDto createBook(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDetailDto getBookById(Long id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public BookDetailDto updateBook(Long id, BookDto bookDto) {
        return null;
    }

    @Override
    public void deleteBookById(Long id) {

    }
}
