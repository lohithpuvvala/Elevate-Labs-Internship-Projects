package com.lohithpuvvala.restful_bookstore_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String genre;
    private int publicationYear;
    private Long authorId;
}
