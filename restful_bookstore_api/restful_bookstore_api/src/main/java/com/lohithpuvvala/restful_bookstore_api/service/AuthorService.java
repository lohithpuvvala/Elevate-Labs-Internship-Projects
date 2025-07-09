package com.lohithpuvvala.restful_bookstore_api.service;

import com.lohithpuvvala.restful_bookstore_api.model.Author;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthorById(long id);
    List<Author> getAllAuthors();
    Author updateAuthor(Author author);
    void deleteAuthorById(long id);
}
