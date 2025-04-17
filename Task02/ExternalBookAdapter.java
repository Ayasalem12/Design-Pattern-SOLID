package com;

public class ExternalBookAdapter implements BookInterface {
    private final ExternalBook externalBook;

    public ExternalBookAdapter(ExternalBook externalBook) {
        if (externalBook == null) {
            throw new IllegalArgumentException("ExternalBook cannot be null");
        }
        this.externalBook = externalBook;
    }

    @Override
    public void borrowBook(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        externalBook.setBorrowable(false);
    }

    @Override
    public void returnBook() {
        externalBook.setBorrowable(true);
    }

    @Override
    public String getTitle() {
        return externalBook.getBookTitle();
    }

    @Override
    public boolean isAvailable() {
        return externalBook.isBorrowable();
    }
}