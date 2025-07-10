package com.lohithpuvvala.restful_bookstore_api.config;

import com.lohithpuvvala.restful_bookstore_api.model.Author;
import com.lohithpuvvala.restful_bookstore_api.model.Book;
import com.lohithpuvvala.restful_bookstore_api.repository.AuthorRepository;
import com.lohithpuvvala.restful_bookstore_api.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository){
        return args -> {
            Author author1 = new Author();
            author1.setName("Robert C. Martin");
            author1.setEmail("unclebob@gmail.com");
            authorRepository.save(author1);

            Book book1 = new Book();
            book1.setTitle("Clean Code");
            book1.setGenre("Programming");
            book1.setPublicationYear(2008);
            book1.setAuthor(author1);

            Book book2 = new Book();
            book2.setTitle("Clean Architecture");
            book2.setGenre("Programming");
            book2.setPublicationYear(2017);
            book2.setAuthor(author1);

            bookRepository.save(book1);
            bookRepository.save(book2);

            Author author2 = new Author();
            author2.setName("Joshua Bloch");
            author2.setEmail("joshua.bloch@gmail.com");
            authorRepository.save(author2);

            Book book3 = new Book();
            book3.setTitle("Effective Java");
            book3.setGenre("Programming");
            book3.setPublicationYear(2001);
            book3.setAuthor(author2);

            bookRepository.save(book3);

            Author author3 = new Author();
            author3.setName("Martin Fowler");
            author3.setEmail("martin.fowler@gmail.com");
            authorRepository.save(author3);

            Book book4 = new Book();
            book4.setTitle("Refactoring");
            book4.setGenre("Software Engineering");
            book4.setPublicationYear(1999);
            book4.setAuthor(author3);

            bookRepository.save(book4);

            Author author4 = new Author();
            author4.setName("Eric Evans");
            author4.setEmail("eric.evans@gmail.com");
            authorRepository.save(author4);

            Book book5 = new Book();
            book5.setTitle("Domain-Driven Design");
            book5.setGenre("Software Design");
            book5.setPublicationYear(2003);
            book5.setAuthor(author4);

            bookRepository.save(book5);

            Author author5 = new Author();
            author5.setName("Kent Beck");
            author5.setEmail("kent.beck@gmail.com");
            authorRepository.save(author5);

            Book book6 = new Book();
            book6.setTitle("Test-Driven Development");
            book6.setGenre("Programming");
            book6.setPublicationYear(2002);
            book6.setAuthor(author5);

            bookRepository.save(book6);
        };
    }
}
