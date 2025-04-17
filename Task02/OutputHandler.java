package com;

public class OutputHandler {
    public void printBorrowSuccess(User user, BookInterface book) {
        System.out.printf("%s successfully borrowed %s (%s)%n", user.getName(), book.getTitle(), getBookType(book));
    }

    public void printBorrowFailure(String title, String reason) {
        System.out.printf("%s: %s%n", title, reason);
    }

    public void printReturnSuccess(String title) {
        System.out.printf("%s has been returned.%n", title);
    }

    private String getBookType(BookInterface book) {
        if (book instanceof Book) {
            return ((Book) book).getType().name().toLowerCase();
        } else if (book instanceof ExternalBookAdapter) {
            return "external";
        }
        return "unknown";
    }
}