package com.lohithpuvvala.restful_bookstore_api.dto;

import lombok.Data;

@Data
public class BookDetailDto {
    private long id;
    private String title;
    private String genre;
    private int publicationYear;
    private AuthorDto author;
}
