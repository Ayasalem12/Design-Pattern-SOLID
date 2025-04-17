package com;

public class StandardBorrowingStrategy implements BorrowingStrategy {
    @Override
    public boolean canBorrow(User user, BookInterface book) {
        return book.isAvailable();
    }
}