package com;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Books> books = new ArrayList<>();

    LibraryService(){
    }

    public void addBook(Books book) {
        books.add(book);
    }

    public Books findBook(String title) {
        for (Books book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title,User user) {
        Books book = findBook(title);
        if(book==null){
            System.out.println(title+" is not found in the library.");
        } else if (!book.isAvailable()) {
            System.out.println(title+" is not available.");
        }else{
            System.out.println(title+" is available in the library.");
//            book.borrowBook(user);
        }

    }

    public void returnBook(String title) {
        Books book = findBook(title);
        if (book != null) {
//            book.returnBook();
            System.out.println(title+" is  found in the library.");
        } else {
            System.out.println(title+" is not found in the library.");
        }
    }
}
