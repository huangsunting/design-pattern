package com.bravo.pattern.iterator.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryIteratorTest {

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Book 1"));
        library.addBook(new Book("Book 2"));
        library.addBook(new Book("Book 3"));

        BookIterator iterator = library.createIterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Book Title: " + book.getTitle());
        }
    }

    // 书籍类
    static class Book {
        private final String title;

        public Book(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    // 图书馆类
    static class Library {
        private final List<Book> books;

        public Library() {
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public BookIterator createIterator() {
            return new BookIterator(books);
        }
    }

    // 自定义迭代器类
    static class BookIterator {
        private final List<Book> books;
        private int index;

        public BookIterator(List<Book> books) {
            this.books = books;
            this.index = 0;
        }

        public boolean hasNext() {
            return index < books.size();
        }

        public Book next() {
            if (hasNext()) {
                Book book = books.get(index);
                index++;
                return book;
            }
            return null;
        }
    }

}
