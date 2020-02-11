package com.twu.biblioteca;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
            do {
                System.out.println("Main menu");
                System.out.println("1. List of books");
                System.out.println("2. Checkout a book");
                System.out.println("3. Return a book");
                System.out.println("4. List of movies");
                System.out.println("5. Checkout a movie");
                System.out.println("6. Quit the application");
                System.out.print("Please select an option: ");
                String response = scanner.nextLine();

                switch (response) {
                    case "1":   listBooks(); break;
                    case "2":   if(checkOutBook()) {
                                    System.out.println("Thank you! Enjoy the book.");
                                } else {
                                    try {
                                        unsuccessfulBookCheckOut();
                                    } catch (RuntimeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                    case "3":   if(returnBook()) {
                                    System.out.println("Thank you for returning the book!");
                                } else {
                                    try {
                                        unsuccessfulBookReturn();
                                    } catch (RuntimeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                    case "4":   listMovies();
                                break;
                    case "5":   if(checkOutMovie()) {
                                    System.out.println("Thank you! Enjoy the movie.");
                                } else {
                                    try {
                                        unsuccessfulMovieCheckOut();
                                    } catch (RuntimeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                    case "6": System.exit(0);
                    default:    try {
                                 invalidOption();
                                } catch (RuntimeException e) {
                                  System.out.println(e.getMessage());
                                }
                }

            } while (true);
    }

    private static void listBooks() {
        List<Book> books = library.getBooks();
        library.list(books);
    }

    static void invalidOption() {
        throw new RuntimeException("Please select a valid option!");
    }

    private static boolean checkOutBook() {
        System.out.print("Please enter the book isbn you want to check out: ");
        String isbn = scanner.nextLine();
        return library.checkOutBook(isbn);
    }

    static void unsuccessfulBookCheckOut() {
        throw new RuntimeException("Sorry, that book is not available.");
    }

    private static boolean returnBook() {
        System.out.print("Please enter the isbn of the book you want to return: ");
        String bookIsbn = scanner.nextLine();
        return library.returnBook(bookIsbn);
    }

    static void unsuccessfulBookReturn() {
        throw new RuntimeException("That is not a valid book to return.");
    }

    private static void listMovies() {
        List<Movie> movies = library.getMovies();
        library.list(movies);
    }

    private static boolean checkOutMovie() {
        System.out.print("Please enter the name of the movie you want to check out: ");
        String movieName = scanner.nextLine();
        return library.checkOutMovie(movieName);
    }

    static void unsuccessfulMovieCheckOut() {
        throw new RuntimeException("Sorry, that movie is not available.");
    }

}
