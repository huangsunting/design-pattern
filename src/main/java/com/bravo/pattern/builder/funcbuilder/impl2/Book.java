package com.bravo.pattern.builder.funcbuilder.impl2;

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

    // 每次调用都构建一个函数，该函数用于构建Book
    public static MyFunction1<Genre, MyFunction2<String, MyFunction3<String, MyFunction4<LocalDate, Book>>>> builder() {
        return genre
                -> author
                -> title
                -> publicationDate
                -> new Book(genre, author, title, publicationDate);
    }

    public interface MyFunction1<T, R> {
        R addGenre(T t);
    }

    public interface MyFunction2<T, R> {
        R addAuthor(T t);
    }

    public interface MyFunction3<T, R> {
        R addTitle(T t);
    }

    public interface MyFunction4<T, R> {
        R addLocalDate(T t);
    }
}