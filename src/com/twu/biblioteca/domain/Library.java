package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private static final String newLine = System.getProperty("line.separator");

    private List<Book> books = new ArrayList<Book>();

    public Library() {
        books.add(new Book("ABSALOM, ABSALOM!", "ERNEST HEMINGWAY", 1926));
        books.add(new Book("A TIME TO KILL", "EVELYN WAUGH",1930));
        books.add(new Book("THE HOUSE OF MIRTH", "PHILIP K. DICK", 1977));
        books.add(new Book("EAST OF EDEN", "STEPHEN FRY", 1997));
        books.add(new Book("THE SUN ALSO RISES", "LOIS LOWRY",1989));
    }

    @Override
    public String toString() {
        String result = books.stream()
                .map(book -> book.toString())
                .collect(Collectors.joining("; " + newLine));
        return "Library{" + newLine + result + newLine + "}";
    }
}
