package com.lohithpuvvala.restful_bookstore_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private String genre;
    private int year;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER) // Need to change this to LAZY once completed the project
    @JoinColumn(name = "author_id")
    private Author author;
}
