package com.bravo.pattern.builder.funcbuilder.impl2;


import com.bravo.pattern.builder.funcbuilder.Genre;

import java.time.LocalDate;

public class Client2 {

    public static void main(String[] args) {
        Book book = Book.builder()
                .addGenre(Genre.FANTASY)
                .addAuthor("JK.Rowling")
                .addTitle("哈利波特与死亡摇滚")
                .addLocalDate(LocalDate.of(2006, 12, 21));
        System.out.println(book);
    }
}
