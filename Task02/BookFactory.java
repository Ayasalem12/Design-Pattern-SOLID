package com;

public class BookFactory {
    public static BookInterface createBook(String title, BookType type) {
        return new Book(title, type);
    }

    public static BookInterface createExternalBook(String title, String author, int year, boolean isBorrowable) {
        return new ExternalBookAdapter(new ExternalBook(title, author, year, isBorrowable));
    }
}