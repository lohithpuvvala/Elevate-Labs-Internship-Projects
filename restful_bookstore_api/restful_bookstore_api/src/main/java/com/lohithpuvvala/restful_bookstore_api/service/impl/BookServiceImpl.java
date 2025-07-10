package com.lohithpuvvala.restful_bookstore_api.service.impl;

import com.lohithpuvvala.restful_bookstore_api.dto.BookDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.BookDto;
import com.lohithpuvvala.restful_bookstore_api.exception.ResourceNotFoundException;
import com.lohithpuvvala.restful_bookstore_api.mapper.DtoMapper;
import com.lohithpuvvala.restful_bookstore_api.model.Author;
import com.lohithpuvvala.restful_bookstore_api.model.Book;
import com.lohithpuvvala.restful_bookstore_api.repository.AuthorRepository;
import com.lohithpuvvala.restful_bookstore_api.repository.BookRepository;
import com.lohithpuvvala.restful_bookstore_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final AuthorRepository authorRepository;

    BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDetailDto createBook(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id :: "+bookDto.getAuthorId()));

        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setPublicationYear(bookDto.getPublicationYear());
        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);
        return DtoMapper.toBookDetailDto(savedBook);
    }

    @Override
    public BookDetailDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id :: "+id));
        return DtoMapper.toBookDetailDto(book);
    }

    @Override
    public List<BookDetailDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(DtoMapper::toBookDetailDto)
                .toList();
    }

    @Override
    public BookDetailDto updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id :: "+id));
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id :: "+bookDto.getAuthorId()));

        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setPublicationYear(bookDto.getPublicationYear());
        book.setAuthor(author);

        Book updatedBook = bookRepository.save(book);
        return DtoMapper.toBookDetailDto(updatedBook);
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id :: "+id));

        bookRepository.delete(book);
    }
}
