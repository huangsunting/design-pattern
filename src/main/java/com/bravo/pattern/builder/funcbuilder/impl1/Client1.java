package com.bravo.pattern.builder.funcbuilder.impl1;


import com.bravo.pattern.builder.funcbuilder.Genre;

import java.time.LocalDate;

public class Client1 {

    public static void main(String[] args) {
        Book book = Book.builder()
                .apply(Genre.FANTASY)
                .apply("JK.Rowling")
                .apply("哈利波特与火焰山")
                .apply(LocalDate.of(2000, 7, 8));
        System.out.println(book);
    }
}
