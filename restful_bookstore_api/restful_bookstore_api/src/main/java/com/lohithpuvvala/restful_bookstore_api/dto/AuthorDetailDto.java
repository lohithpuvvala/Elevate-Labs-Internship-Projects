package com.lohithpuvvala.restful_bookstore_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDetailDto {
    private long id;
    private String name;
    private String email;
    private List<BookDto> books;
}