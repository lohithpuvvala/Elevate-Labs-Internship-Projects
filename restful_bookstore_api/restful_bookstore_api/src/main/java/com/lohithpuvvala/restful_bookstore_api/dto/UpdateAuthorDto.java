package com.lohithpuvvala.restful_bookstore_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateAuthorDto {
    @NotBlank(message = "Author name is requred!")
    private String name;

    @NotBlank(message = "Email is requred!")
    @Email(message = "Invalid Email Format!")
    private String email;
}
