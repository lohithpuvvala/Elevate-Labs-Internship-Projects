package com.lohithpuvvala.restful_bookstore_api.service;

import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDto;
import com.lohithpuvvala.restful_bookstore_api.model.Author;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(Author author);
    AuthorDetailDto getAuthorById(long id);
    List<AuthorDto> getAllAuthors();
    AuthorDto updateAuthor(Author author);
    void deleteAuthorById(long id);
}
