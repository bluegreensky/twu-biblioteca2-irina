package com.twu.biblioteca.domain;

import java.util.Objects;

public class User {
    private String libraryNumber;
    private String password;
    private boolean isLibrarian;

    public User(String libraryNumber, String password, boolean isLibrarian) {
        setLibraryNumber(libraryNumber); // Verify correct format
        this.password = password;
        this.isLibrarian = isLibrarian;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    // Verification of format will be implemented later
    // If wrong format throw IllegalArgumentException
    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(libraryNumber, user.libraryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "libraryNumber = '" + libraryNumber + '\'' +
                '}';
    }
}
