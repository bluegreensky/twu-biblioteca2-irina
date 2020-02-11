package com.twu.biblioteca.domain;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

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

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
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
