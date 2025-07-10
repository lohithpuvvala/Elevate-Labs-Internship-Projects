package com.lohithpuvvala.restful_bookstore_api.service;

import com.lohithpuvvala.restful_bookstore_api.dto.BookDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.BookDto;
import com.lohithpuvvala.restful_bookstore_api.dto.CreateBookDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    BookDetailDto createBook(CreateBookDto bookDto);
    BookDetailDto getBookById(Long id);
    List<BookDetailDto> getAllBooks();
    BookDetailDto updateBook(Long id, BookDto bookDto);
    void deleteBookById(Long id);
    Page<BookDetailDto> getBooks(String genre, Integer publicationYear, int page, int size, String sortBy);
}
