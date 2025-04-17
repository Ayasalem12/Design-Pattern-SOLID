package com;

public class Book implements BookInterface {
    private final String title;
    private boolean isAvailable;
    private final BookType type;

    public Book(String title, BookType type) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
        this.isAvailable = true;
        this.type = type;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void borrowBook(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        isAvailable = false;
    }

    @Override
    public void returnBook() {
        isAvailable = true;
    }

    public BookType getType() {
        return type;
    }
}