package com.lohithpuvvala.restful_bookstore_api.service;

import com.lohithpuvvala.restful_bookstore_api.dto.BookDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.BookDto;
import com.lohithpuvvala.restful_bookstore_api.model.Book;

import java.util.List;

public interface BookService {
    BookDetailDto createBook(BookDto bookDto);
    BookDetailDto getBookById(Long id);
    List<BookDetailDto> getAllBooks();
    BookDetailDto updateBook(Long id, BookDto bookDto);
    void deleteBookById(Long id);
}
