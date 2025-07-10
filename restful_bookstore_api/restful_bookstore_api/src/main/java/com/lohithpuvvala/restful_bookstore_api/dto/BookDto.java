package com.lohithpuvvala.restful_bookstore_api.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String genre;
    private int publicationYear;
    private Long authorId;
}
