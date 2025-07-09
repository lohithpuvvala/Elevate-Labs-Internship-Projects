package com.lohithpuvvala.restful_bookstore_api.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private long id;
    private String name;
    private String email;
}
