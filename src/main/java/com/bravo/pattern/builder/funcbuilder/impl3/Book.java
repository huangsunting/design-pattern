package com.bravo.pattern.builder.funcbuilder.impl3;

import com.bravo.pattern.builder.funcbuilder.Genre;
import lombok.ToString;

import java.time.LocalDate;

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

    public static GenreAdder builder() {
        // fn1：接收genre，返回fn1
        return genre -> {
            // fn2：接收author，返回fn2
            return author -> {
                // fn3：接收title发，返回fn3
                return title -> {
                    // fn4：接收localDate，返回Book
                    return publicationDate -> new Book(genre, author, title, publicationDate);
                };
            };
        };
    }

    public interface GenreAdder {
        AuthorAdder addGenre(Genre genre);
    }

    public interface AuthorAdder {
        titleAdder addAuthor(String author);
    }

    public interface titleAdder {
        LocalDateAdder addTitle(String title);
    }

    public interface LocalDateAdder {
        Book addLocalDate(LocalDate localDate);
    }
}