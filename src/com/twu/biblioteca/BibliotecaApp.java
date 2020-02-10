package com.twu.biblioteca;
import com.twu.biblioteca.domain.Book;
import java.util.List;
import java.util.ArrayList;

public class BibliotecaApp {

    private static List<Book> library = new ArrayList<Book>();

    static {
        library.add(new Book("ABSALOM, ABSALOM!"));
        library.add(new Book("A TIME TO KILL"));
        library.add(new Book("THE HOUSE OF MIRTH"));
        library.add(new Book("EAST OF EDEN"));
        library.add(new Book("THE SUN ALSO RISES"));
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        System.out.println(library);
    }
}
