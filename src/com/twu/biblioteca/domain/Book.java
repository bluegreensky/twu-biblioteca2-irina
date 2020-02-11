package com.twu.biblioteca.domain;

public class Book extends Item {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private int yearPublished;

    public Book(int id, String isbn, String title, String author, int yearPublished, boolean checkedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = checkedOut;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn = '" + isbn + '\'' +
                ", title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", year published = " + yearPublished +
                '}';
    }
}
