package com.lohithpuvvala.restful_bookstore_api.controller;

import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDto;
import com.lohithpuvvala.restful_bookstore_api.dto.CreateAuthorDto;
import com.lohithpuvvala.restful_bookstore_api.dto.UpdateAuthorDto;
import com.lohithpuvvala.restful_bookstore_api.service.impl.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorServiceImpl authorServiceImpl;

    AuthorController(AuthorServiceImpl authorServiceImpl){
        this.authorServiceImpl = authorServiceImpl;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody CreateAuthorDto createAuthorDto){
        AuthorDto savedAuthor = authorServiceImpl.createAuthor(createAuthorDto);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        return ResponseEntity.ok(authorServiceImpl.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDetailDto> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorServiceImpl.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, @RequestBody UpdateAuthorDto authorDto){
        return ResponseEntity.ok(authorServiceImpl.updateAuthor(id,authorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long id){
        authorServiceImpl.deleteAuthorById(id);
        return ResponseEntity
                .ok("Author with id :: "+id+" deleted successfully");
    }
}
