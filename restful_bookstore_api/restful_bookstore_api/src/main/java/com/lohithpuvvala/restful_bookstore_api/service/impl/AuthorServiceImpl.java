package com.lohithpuvvala.restful_bookstore_api.service.impl;

import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDto;
import com.lohithpuvvala.restful_bookstore_api.mapper.DtoMapper;
import com.lohithpuvvala.restful_bookstore_api.model.Author;
import com.lohithpuvvala.restful_bookstore_api.repository.AuthorRepository;
import com.lohithpuvvala.restful_bookstore_api.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(DtoMapper::toAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto createAuthor(Author author) {
        return null;
    }

    @Override
    public AuthorDetailDto getAuthorById(long id) {
        return null;
    }


    @Override
    public AuthorDto updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteAuthorById(long id) {

    }
}
