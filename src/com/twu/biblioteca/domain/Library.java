package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {

    private static final String newLine = System.getProperty("line.separator");

    private List<Book> books = new ArrayList<>();

    public Library() {
        books.add(new Book(1,"0679732187","ABSALOM, ABSALOM!", "ERNEST HEMINGWAY", 1926, false));
        books.add(new Book(2,"0440245915","A TIME TO KILL", "EVELYN WAUGH",1930, false));
        books.add(new Book(3,"0140187294","THE HOUSE OF MIRTH", "PHILIP K. DICK", 1977, false));
        books.add(new Book(4,"9780140186390","EAST OF EDEN", "STEPHEN FRY", 1997, false));
        books.add(new Book(5,"0195145739","THE SUN ALSO RISES", "LOIS LOWRY",1989, false));
        books.add(new Book(6,"0195145739","THE SUN ALSO RISES", "LOIS LOWRY",1989, false));
        books.add(new Book(7,"11", "Mock", "Anonymus", 2005, true));
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        String result = books.stream()
                .filter(book -> !book.isCheckedOut())
                .map(Book::toString)
                .collect(Collectors.joining("; " + newLine));
        return "Library{" + newLine + result + newLine + "}";
    }

    public void checkOutBook(String isbn) {
        Collection<Book> listOfBooksWithSameIsbn = books.stream()
                                            .filter(book -> book.getIsbn().equals(isbn))
                                            .collect(Collectors.toList());
        if(listOfBooksWithSameIsbn.size() != 0) {
            Optional<Book> optionalBook = listOfBooksWithSameIsbn.stream()
                                                                    .filter(book -> !book.isCheckedOut())
                                                                    .findAny();
            if(optionalBook.isPresent()){
                Book bookToCheckOut = optionalBook.get();
               bookToCheckOut.setCheckedOut(true);
            }
        }
    }
}
