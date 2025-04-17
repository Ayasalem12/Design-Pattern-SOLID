package com;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<BookInterface> books = new ArrayList<>();
    private final OutputHandler outputHandler;
    private final BorrowingStrategy standardStrategy;
    private final BorrowingStrategy premiumStrategy;

    public LibraryService(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
        this.standardStrategy = new StandardBorrowingStrategy();
        this.premiumStrategy = new PremiumBorrowingStrategy();
    }

    public void addBook(BookInterface book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
    }

    public BookInterface findBook(String title) {
        if (title == null) {
            return null;
        }
        for (BookInterface book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title, User user) {
        BookInterface book = findBook(title);
        if (book == null) {
            outputHandler.printBorrowFailure(title, "not found in the library");
            return;
        }
        BorrowingStrategy strategy = user.isPremium() ? premiumStrategy : standardStrategy;
        if (strategy.canBorrow(user, book)) {
            book.borrowBook(user);
            outputHandler.printBorrowSuccess(user, book);
        } else {
            outputHandler.printBorrowFailure(title, "not available");
        }
    }

    public void returnBook(String title) {
        BookInterface book = findBook(title);
        if (book != null) {
            book.returnBook();
            outputHandler.printReturnSuccess(title);
        } else {
            outputHandler.printBorrowFailure(title, "not found in the library");
        }
    }
}