package com.twu.biblioteca;
import com.twu.biblioteca.domain.Library;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Main menu");
                System.out.println("1. List of books");
                System.out.println("2. Quit the application");
                System.out.print("Please select an option: ");
                String response = scanner.nextLine();

                switch (response) {
                    case "1": listBooks(); break;
                    case "2": System.exit(0);
                    default:    try{
                                 notifyInvalidOption();
                                } catch (RuntimeException e) {
                                  System.out.println(e.getMessage());
                                }
                }

            } while (true);
        }
    }

    private static void listBooks() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        System.out.println(new Library());
    }

    static void notifyInvalidOption() {
        throw new RuntimeException("Please select a valid option!");
    }
}
