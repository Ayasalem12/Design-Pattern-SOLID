package com;

public class PremiumBorrowingStrategy implements BorrowingStrategy {
    @Override
    public boolean canBorrow(User user, BookInterface book) {
        return true; // Premium users can borrow even unavailable books (for simplicity)
    }
}