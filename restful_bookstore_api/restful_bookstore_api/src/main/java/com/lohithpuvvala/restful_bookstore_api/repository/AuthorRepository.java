package com.lohithpuvvala.restful_bookstore_api.repository;

import com.lohithpuvvala.restful_bookstore_api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> { }
