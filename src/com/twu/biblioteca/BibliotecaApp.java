package com.twu.biblioteca;
import com.twu.biblioteca.domain.Library;
import java.util.Scanner;

public class BibliotecaApp {

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
            do {
                System.out.println("Main menu");
                System.out.println("1. List of books");
                System.out.println("2. Check out a book");
                System.out.println("3. Return a book");
                System.out.println("4. Quit the application");
                System.out.print("Please select an option: ");
                String response = scanner.nextLine();

                switch (response) {
                    case "1":   listBooks(); break;
                    case "2":   if(checkOutBook()) {
                                    System.out.println("Thank you! Enjoy the book.");
                                } else {
                                    try{
                                        unsuccessfulBookCheckOut();
                                    } catch (RuntimeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                    case "3":   if(returnBook()) {
                                    System.out.println("Thank you for returning the book!");
                                }
                                break;
                    case "4": System.exit(0);
                    default:    try{
                                 invalidOption();
                                } catch (RuntimeException e) {
                                  System.out.println(e.getMessage());
                                }
                }

            } while (true);
    }

    private static void listBooks() {
        System.out.println(library);
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
        System.out.print("Please enter the book isbn you want to return: ");
        String isbn = scanner.nextLine();
        return library.returnBook(isbn);
    }
}
