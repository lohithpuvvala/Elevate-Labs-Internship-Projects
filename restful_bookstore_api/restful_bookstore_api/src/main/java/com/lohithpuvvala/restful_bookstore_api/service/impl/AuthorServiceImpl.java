package com.lohithpuvvala.restful_bookstore_api.service.impl;

import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDto;
import com.lohithpuvvala.restful_bookstore_api.dto.CreateAuthorDto;
import com.lohithpuvvala.restful_bookstore_api.dto.UpdateAuthorDto;
import com.lohithpuvvala.restful_bookstore_api.exception.ResourceNotFoundException;
import com.lohithpuvvala.restful_bookstore_api.mapper.DtoMapper;
import com.lohithpuvvala.restful_bookstore_api.model.Author;
import com.lohithpuvvala.restful_bookstore_api.repository.AuthorRepository;
import com.lohithpuvvala.restful_bookstore_api.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(DtoMapper::toAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDetailDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + id));
        return DtoMapper.toAuthorDetailDto(author);
    }

    @Override
    public AuthorDto createAuthor(CreateAuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());

        Author savedAuthor = authorRepository.save(author);
        return DtoMapper.toAuthorDto(savedAuthor);
    }



    @Override
    public AuthorDto updateAuthor(Long id, UpdateAuthorDto authorDto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id :: "+id));

        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());

        Author updated = authorRepository.save(author);
        return DtoMapper.toAuthorDto(updated);
    }

    @Override
    public void deleteAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id :: "+id));

        authorRepository.delete(author);
    }
}
