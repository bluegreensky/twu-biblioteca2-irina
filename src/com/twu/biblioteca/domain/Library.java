package com.twu.biblioteca.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private static final String newLine = System.getProperty("line.separator");

    private List<Book> books = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Map<User, List<Book>> userBooksMap = new HashMap<>();

    public Library() {
        books.add(new Book(1,"0679732187","ABSALOM, ABSALOM!", "ERNEST HEMINGWAY", 1926, false));
        books.add(new Book(2,"0440245915","A TIME TO KILL", "EVELYN WAUGH",1930, false));
        books.add(new Book(3,"0140187294","THE HOUSE OF MIRTH", "PHILIP K. DICK", 1977, false));
        books.add(new Book(4,"9780140186390","EAST OF EDEN", "STEPHEN FRY", 1997, false));
        books.add(new Book(5,"0195145739","THE SUN ALSO RISES", "LOIS LOWRY",1989, false));
        books.add(new Book(6,"0195145739","THE SUN ALSO RISES", "LOIS LOWRY",1989, false));
        books.add(new Book(7,"11", "Mock", "Anonymus", 2005, true));

        movies.add(new Movie("The Seven Samurai", 1954, "Akira Kurosawa", Movie.Rating.EIGHT, false));
        movies.add(new Movie("Bonnie and Clyde", 1967, "Arthur Penn", Movie.Rating.SEVEN, false));
        movies.add(new Movie("Reservoir Dogs", 1992, "Quentin Tarantino", Movie.Rating.UNRATED, false));
        movies.add(new Movie("Wall-E", 2008, "Andrew Stanton", Movie.Rating.TEN, true));
        movies.add(new Movie("Wall-E", 2008, "Andrew Stanton", Movie.Rating.TEN, true));

        users.add(new User("100-0001", "123", true, "Dan", "dan@gmail.com", "111-111-1111"));
        users.add(new User("100-0002", "abc", false, "Sam", "sam@yahoo.com", "222-222-2222"));
        users.add(new User("100-0003", "xyz", false, "Lucy", "lucy@gmail.com", "333-333-3333"));
        users.add(new User("100-0004", "pass", false, "Mike", "mike@yahoo.com", "444-444-4444"));

        // Populate userBooksMap
        for (User user : users) {
            userBooksMap.put(user, new ArrayList<>());
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public String list(List<? extends Item> items) {
        String result = items.stream()
                .filter(item -> !item.isCheckedOut())
                .map(Item::toString)
                .collect(Collectors.joining("; " + newLine));
        return result;
    }

    public void checkOutBook(String isbn, User currentUser) {
        Collection<Book> listOfBooksWithThisIsbn = getListOfBooksWithThisIsbn(isbn);
        if(listOfBooksWithThisIsbn.size() != 0) {
            Optional<Book> optionalBook = listOfBooksWithThisIsbn.stream() // Find any unchecked book
                                                                    .filter(book -> !book.isCheckedOut())
                                                                    .findAny();
            if(optionalBook.isPresent()){
                Book bookToCheckOut = optionalBook.get();
                bookToCheckOut.setCheckedOut(true);
                List<Book> currentUserCheckedOutBooks = userBooksMap.get(currentUser);
                currentUserCheckedOutBooks.add(bookToCheckOut);
                System.out.println("Thank you! Enjoy the book."); // We checked out the book!
                return;
            }
        }
        throw new RuntimeException("Sorry, that book is not available.");
    }

    public void returnBook(String isbn, User currentUser) {
        Collection<Book> listOfBooksWithThisIsbn = getListOfBooksWithThisIsbn(isbn);
        if(listOfBooksWithThisIsbn.size() != 0) {
            Optional<Book> optionalBook = listOfBooksWithThisIsbn.stream() // Find any checked out book
                                                                    .filter(book -> book.isCheckedOut())
                                                                    .findAny();
            if(optionalBook.isPresent()){
                Book bookToReturn = optionalBook.get();
                bookToReturn.setCheckedOut(false);
                List<Book> currentUserCheckedOutBooks = userBooksMap.get(currentUser);
                currentUserCheckedOutBooks.remove(bookToReturn);
                System.out.println("Thank you for returning the book!"); // We returned the book!
                return;
            }
        }
        throw new RuntimeException("That is not a valid book to return.");
    }

    private List<Book> getListOfBooksWithThisIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .collect(Collectors.toList());
    }

    public void checkOutMovie(String name) {
        Collection<Movie> listOfMoviesWithThisName = getListOfMoviesWithThisName(name);
        if(listOfMoviesWithThisName.size() != 0) {
            Optional<Movie> optionalMovie = listOfMoviesWithThisName.stream() // Find any unchecked movie
                    .filter(movie -> !movie.isCheckedOut())
                    .findAny();
            if(optionalMovie.isPresent()){
                Movie movieToCheckOut = optionalMovie.get();
                movieToCheckOut.setCheckedOut(true);
                System.out.println("Thank you! Enjoy the movie."); // We checked out the movie!
                return;
            }
        }
        throw new RuntimeException("Sorry, that movie is not available.");
    }

    private List<Movie> getListOfMoviesWithThisName(String name) {
        return movies.stream()
                .filter(movie -> movie.getName().equals(name))
                .collect(Collectors.toList());
    }

    public Optional<User> findUser(String libraryNumber, String password) {
        return users.stream()
                .filter(user -> user.getLibraryNumber().equals(libraryNumber))
                .filter(user -> user.getPassword().equals(password))
                .findAny();
    }

    public void viewBooksCheckedOut() {
        userBooksMap.forEach((user, userCheckedOutBooks) ->
                System.out.println("User library number: " + user.getLibraryNumber()
                        + newLine
                        + "Checked out books: " + userCheckedOutBooks
                        + newLine));
    }
}
