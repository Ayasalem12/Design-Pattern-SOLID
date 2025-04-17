package com;

public class Main {
    public static void main(String[] args) {
        OutputHandler outputHandler = new OutputHandler();
        LibraryService library = new LibraryService(outputHandler);

        // Create books using factory
        BookInterface book = BookFactory.createBook("Harry Potter", BookType.STANDARD);
        BookInterface physicalBook = BookFactory.createBook("Lord of the Rings", BookType.PHYSICAL);
        BookInterface historicalBook = BookFactory.createBook("Outlander", BookType.HISTORICAL);
        BookInterface externalBook = BookFactory.createExternalBook("Pride and Prejudice", "Jane Austen", 1813, true);

        // Add books to library
        library.addBook(book);
        library.addBook(physicalBook);
        library.addBook(historicalBook);
        library.addBook(externalBook);

        // Create users
        User john = new User("John", false);
        User alice = new User("Alice", true);

        // Test borrowing and returning
        System.out.println("=== Borrowing Tests ===");
        library.borrowBook("Harry Potter", john);
        library.returnBook("Harry Potter");
        System.out.println("======================");
        library.borrowBook("Lord of the Rings", john);
        library.borrowBook("Lord of the Rings", alice); // Premium user
        System.out.println("======================");
        library.borrowBook("Outlander", alice);
        System.out.println("======================");
        library.borrowBook("Pride and Prejudice", john);
        library.returnBook("Pride and Prejudice");
        System.out.println("======================");
        library.borrowBook("math", john); // Non-existent book
    }
}