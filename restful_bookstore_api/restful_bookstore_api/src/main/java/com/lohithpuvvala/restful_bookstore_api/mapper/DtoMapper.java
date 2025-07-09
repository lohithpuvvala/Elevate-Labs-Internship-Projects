package com.lohithpuvvala.restful_bookstore_api.mapper;

import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDetailDto;
import com.lohithpuvvala.restful_bookstore_api.dto.AuthorDto;
import com.lohithpuvvala.restful_bookstore_api.dto.BookDto;
import com.lohithpuvvala.restful_bookstore_api.model.Author;
import com.lohithpuvvala.restful_bookstore_api.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

//    Convert Author to AuthorDto
    public static AuthorDto toAuthorDto(Author author){
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        return dto;
    }

//    Convert Book to BookDto
    public static BookDto toBookDto(Book book){
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setGenre(book.getGenre());
        dto.setPublicationYear(book.getPublicationYear());
        return dto;
    }

//    Convert Author to AuthoDetailDto (with books)
    public static AuthorDetailDto toAuthorDetailDto(Author author){
        AuthorDetailDto dto = new AuthorDetailDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());

        List<BookDto> bookDtos = author.getBooks()
                .stream()
                .map(DtoMapper::toBookDto)
                .collect(Collectors.toList());

        dto.setBooks(bookDtos);
        return dto;
    }
}
