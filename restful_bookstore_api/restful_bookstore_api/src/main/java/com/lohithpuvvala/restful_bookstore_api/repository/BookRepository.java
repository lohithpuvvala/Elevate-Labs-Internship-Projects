package com.lohithpuvvala.restful_bookstore_api.repository;

import com.lohithpuvvala.restful_bookstore_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> { }
