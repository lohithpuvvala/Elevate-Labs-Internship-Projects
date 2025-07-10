package com.lohithpuvvala.restful_bookstore_api.config;

import com.lohithpuvvala.restful_bookstore_api.model.Author;
import com.lohithpuvvala.restful_bookstore_api.model.Book;
import com.lohithpuvvala.restful_bookstore_api.repository.AuthorRepository;
import com.lohithpuvvala.restful_bookstore_api.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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

            Author author6 = new Author();
            author6.setName("Ava Winters");
            author6.setEmail("ava.winters@fictionalmail.com");
            authorRepository.save(author6);

            Book book7 = new Book();
            book7.setTitle("The Midnight Algorithm");
            book7.setGenre("Tech Thriller");
            book7.setPublicationYear(2021);
            book7.setAuthor(author6);

            Book book8 = new Book();
            book8.setTitle("Neural Shadows");
            book8.setGenre("Sci-Fi");
            book8.setPublicationYear(2023);
            book8.setAuthor(author6);
            bookRepository.saveAll(List.of(book7, book8));

            Author author7 = new Author();
            author7.setName("Leo Ashford");
            author7.setEmail("leo.ashford@fictionverse.com");
            authorRepository.save(author7);

            Book book9 = new Book();
            book9.setTitle("Echoes of the Stack");
            book9.setGenre("Tech Mystery");
            book9.setPublicationYear(2020);
            book9.setAuthor(author7);
            bookRepository.save(book9);

            Author author8 = new Author();
            author8.setName("Mira Langdon");
            author8.setEmail("mira.langdon@paperworld.org");
            authorRepository.save(author8);

            Book book10 = new Book();
            book10.setTitle("Framework of Illusions");
            book10.setGenre("Fantasy");
            book10.setPublicationYear(2019);
            book10.setAuthor(author8);

            Book book11 = new Book();
            book11.setTitle("The Code of Fire");
            book11.setGenre("Fantasy");
            book11.setPublicationYear(2022);
            book11.setAuthor(author8);
            bookRepository.saveAll(List.of(book10, book11));

            Author author9 = new Author();
            author9.setName("Elias Thorne");
            author9.setEmail("elias.thorne@imaginelab.net");
            authorRepository.save(author9);

            Book book12 = new Book();
            book12.setTitle("The Compiler's Curse");
            book12.setGenre("Magical Realism");
            book12.setPublicationYear(2020);
            book12.setAuthor(author9);
            bookRepository.save(book12);

            Author author10 = new Author();
            author10.setName("Nova Quinn");
            author10.setEmail("nova.quinn@futurepages.com");
            authorRepository.save(author10);

            Book book13 = new Book();
            book13.setTitle("Quantum Syntax");
            book13.setGenre("Cyberpunk");
            book13.setPublicationYear(2025);
            book13.setAuthor(author10);

            Book book14 = new Book();
            book14.setTitle("Threads of Tomorrow");
            book14.setGenre("Cyberpunk");
            book14.setPublicationYear(2024);
            book14.setAuthor(author10);
            bookRepository.saveAll(List.of(book13, book14));

        };
    }
}
