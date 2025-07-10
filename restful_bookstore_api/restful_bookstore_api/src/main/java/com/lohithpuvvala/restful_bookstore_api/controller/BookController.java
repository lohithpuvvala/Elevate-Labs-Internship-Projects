package com.lohithpuvvala.restful_bookstore_api.controller;

import com.lohithpuvvala.restful_bookstore_api.dto.BookDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.CreateBookDto;
import com.lohithpuvvala.restful_bookstore_api.dto.UpdateBookDto;
import com.lohithpuvvala.restful_bookstore_api.service.impl.BookServiceImpl;
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
    private final BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl){
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping
    public ResponseEntity<BookDetailDto> createBook(@RequestBody CreateBookDto bookDto){
        BookDetailDto created = bookServiceImpl.createBook(bookDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDetailDto>> getAllBooks(){
        return ResponseEntity.ok(bookServiceImpl.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailDto> getBookById(@PathVariable Long id){
        BookDetailDto bookDetailDto = bookServiceImpl.getBookById(id);
        return ResponseEntity.ok(bookDetailDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BookDetailDto> updateBook(@PathVariable Long id, @RequestBody UpdateBookDto bookDto){
        BookDetailDto updated = bookServiceImpl.updateBook(id,bookDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        bookServiceImpl.deleteBookById(id);
        return ResponseEntity
                .ok("Book with id :: "+id+" deleted successfully");
    }

    @GetMapping("/filter")
    public Page<BookDetailDto> getBooks(@RequestParam(required = false) String genre,
                                         @RequestParam(required = false) Integer publicationYear,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size,
                                         @RequestParam(defaultValue = "title") String sortBy){
        return bookServiceImpl.getBooks(genre,publicationYear,page,size,sortBy);
    }
}
