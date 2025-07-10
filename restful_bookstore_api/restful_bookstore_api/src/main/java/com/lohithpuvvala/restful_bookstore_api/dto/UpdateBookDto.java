package com.lohithpuvvala.restful_bookstore_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBookDto {
    @NotBlank(message = "Book Title is required!")
    private String title;

    @NotBlank(message = "Book Genre is required!")
    private String genre;

    @Min(value = 1500, message = "Book publication year should be valid!")
    private int publicationYear;

    @NotNull(message = "Author Id is required!")
    private Long authorId;
}
