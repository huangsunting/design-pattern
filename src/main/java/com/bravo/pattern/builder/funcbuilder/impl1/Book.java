package com.bravo.pattern.builder.funcbuilder.impl1;

import com.bravo.pattern.builder.funcbuilder.Genre;
import lombok.ToString;

import java.time.LocalDate;
import java.util.function.Function;

@ToString
public class Book {
    private final Genre genre;
    private final String author;
    private final String title;
    private final LocalDate publicationDate;

    private Book(Genre genre, String author, String title, LocalDate publicationDate) {
        this.genre = genre;
        this.author = author;
        this.title = title;
        this.publicationDate = publicationDate;
    }

    private final static Function<Genre, Function<String, Function<String, Function<LocalDate, Book>>>> book_creator
            = genre
            -> author
            -> title
            -> publicationDate
            -> new Book(genre, author, title, publicationDate);

    public static Function<Genre, Function<String, Function<String, Function<LocalDate, Book>>>> builder() {
        return book_creator;
    }
}