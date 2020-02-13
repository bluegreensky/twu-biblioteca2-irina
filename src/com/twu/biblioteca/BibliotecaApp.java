package com.twu.biblioteca;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BibliotecaApp {

    private static final String newLine = System.getProperty("line.separator");

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        User currentUser;
        do {
            System.out.println("Login page");
            System.out.print("Please enter your library number: ");
            String libraryNumber = scanner.nextLine();
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();
            try {
                currentUser = login(libraryNumber, password);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        do {
            System.out.println("Main menu");
            System.out.println("1. List of books");
            System.out.println("2. Checkout a book");
            System.out.println("3. Return a book");
            System.out.println("4. List of movies");
            System.out.println("5. Checkout a movie");
            System.out.println("6. View my information");
            System.out.println("7. Quit the application");
            if(currentUser.isLibrarian()) {
                System.out.println("8. View books checked out");
            }
            System.out.print("Please select an option: ");
            String response = scanner.nextLine();

            switch (response) {
                case "1":   listBooks(); break;
                case "2":   try {
                                checkOutBook(currentUser);
                            } catch (RuntimeException e) {
                                 System.out.println(e.getMessage());
                            }
                            break;
                case "3":   try {
                                returnBook(currentUser);
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                case "4":   listMovies();
                            break;
                case "5":   try {
                                checkOutMovie();
                            } catch (RuntimeException e) {
                                 System.out.println(e.getMessage());
                            }
                            break;
                case "6":   viewMyInformation(currentUser);
                            break;
                case "7":   System.exit(0);
                case "8":   if(currentUser.isLibrarian()) {
                                viewBooksCheckedOut();
                                break;
                            }
                default:    try {
                                invalidOption();
                            } catch (RuntimeException e) {
                                 System.out.println(e.getMessage());
                            }
            }

        } while (true);
    }

    private static void viewMyInformation(User currentUser) {
        System.out.println("Name: " + currentUser.getName());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Phone number: " + currentUser.getPhoneNumber());
    }

    private static void viewBooksCheckedOut() {
        System.out.println("Books checked out:");
        library.viewBooksCheckedOut();
    }

    static User login(String libraryNumber, String password) {
        Optional<User> optionalUser = library.findUser(libraryNumber, password);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new RuntimeException("Wrong credentials! Please try again.");
    }

    private static void listBooks() {
        List<Book> books = library.getBooks();
        String result = library.list(books);
        System.out.println("Library{" + newLine + result + newLine + "}");
    }

    static void invalidOption() {
        throw new RuntimeException("Please select a valid option!");
    }

    private static void checkOutBook(User currentUser) {
        System.out.print("Please enter the book isbn you want to check out: ");
        String isbn = scanner.nextLine();
        library.checkOutBook(isbn, currentUser);
    }

    private static void returnBook(User currentUser) {
        System.out.print("Please enter the isbn of the book you want to return: ");
        String bookIsbn = scanner.nextLine();
        library.returnBook(bookIsbn, currentUser);
    }

    private static void listMovies() {
        List<Movie> movies = library.getMovies();
        String result = library.list(movies);
        System.out.println("Library{" + newLine + result + newLine + "}");
    }

    private static void checkOutMovie() {
        System.out.print("Please enter the name of the movie you want to check out: ");
        String movieName = scanner.nextLine();
        library.checkOutMovie(movieName);
    }
}
