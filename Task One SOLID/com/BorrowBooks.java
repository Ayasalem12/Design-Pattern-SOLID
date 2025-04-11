package com;

public class BorrowBooks extends Books implements BorrowBook {


    public BorrowBooks(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        if (isAvailable()) {
            setAvailable(false);
            System.out.printf(user.getName() + " successfully borrowed " + getTitle());
        } else {
            System.out.printf(getTitle()+ " is not available " );
        }
    }

    @Override
    public void returnBook() {
        setAvailable(true);
        System.out.printf(getTitle()+ " is available " );
    }
}
