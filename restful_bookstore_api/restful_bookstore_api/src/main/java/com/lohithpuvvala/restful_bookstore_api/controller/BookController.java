package com.lohithpuvvala.restful_bookstore_api.controller;

import com.lohithpuvvala.restful_bookstore_api.dto.BookDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.BookDto;
import com.lohithpuvvala.restful_bookstore_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDetailDto> createBook(@RequestBody BookDto bookDto){
        BookDetailDto created = bookService.createBook(bookDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDetailDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailDto> getBookById(@PathVariable Long id){
        BookDetailDto bookDetailDto = bookService.getBookById(id);
        return ResponseEntity.ok(bookDetailDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BookDetailDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        BookDetailDto updated = bookService.updateBook(id,bookDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity
                .ok("Book with id :: "+id+" deleted successfully");
    }

    @GetMapping("/filter")
    public Page<BookDetailDto> getBooks(@RequestParam(required = false) String genre,
                                         @RequestParam(required = false) Integer publicationYear,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size,
                                         @RequestParam(defaultValue = "title") String sortBy){
        return bookService.getBooks(genre,publicationYear,page,size,sortBy);
    }
}
