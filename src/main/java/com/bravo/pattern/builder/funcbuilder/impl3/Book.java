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
        // GenreAdder：接收genre，返回AuthorAdder
        return genre -> {
            // AuthorAdder：接收author，返回TitleAdder
            return author -> {
                // TitleAdder：接收title发，返回LocalDateAdder
                return title -> {
                    // LocalDateAdder：接收localDate，返回Book
                    return publicationDate -> new Book(genre, author, title, publicationDate);
                };
            };
        };
    }

    public interface GenreAdder {
        AuthorAdder addGenre(Genre genre);
    }

    public interface AuthorAdder {
        TitleAdder addAuthor(String author);
    }

    public interface TitleAdder {
        LocalDateAdder addTitle(String title);
    }

    public interface LocalDateAdder {
        Book addLocalDate(LocalDate localDate);
    }
}