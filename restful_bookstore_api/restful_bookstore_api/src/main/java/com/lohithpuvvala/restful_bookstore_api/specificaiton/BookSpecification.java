package com.lohithpuvvala.restful_bookstore_api.specificaiton;

import com.lohithpuvvala.restful_bookstore_api.model.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book> hasGenre(String genre) {
        return (root, query, cb) -> cb.equal(root.get("genre"), genre);
    }

    public static Specification<Book> hasPulicationYear(int year) {
        return (root, query, cb) -> cb.equal(root.get("publicationYear"), year);
    }
}
