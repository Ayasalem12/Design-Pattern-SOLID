package com;

public interface BorrowingStrategy {
    boolean canBorrow(User user, BookInterface book);
}