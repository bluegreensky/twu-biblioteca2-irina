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
                System.out.println("3. Quit the application");
                System.out.print("Please select an option: ");
                String response = scanner.nextLine();

                switch (response) {
                    case "1":   listBooks(); break;
                    case "2":   if(checkOutBook()) {
                                    System.out.println("Thank you! Enjoy the book.");
                                }
                                break;
                    case "3": System.exit(0);
                    default:    try{
                                 notifyInvalidOption();
                                } catch (RuntimeException e) {
                                  System.out.println(e.getMessage());
                                }
                }

            } while (true);
    }

    private static void listBooks() {
        System.out.println(library);
    }

    static void notifyInvalidOption() {
        throw new RuntimeException("Please select a valid option!");
    }

    private static boolean checkOutBook() {
        System.out.print("Please enter the book isbn you want to check out: ");
        String isbn = scanner.nextLine();
        return library.checkOutBook(isbn);
    }
}
