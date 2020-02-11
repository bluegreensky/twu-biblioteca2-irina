package com.twu.biblioteca.domain;

import java.util.Objects;

public class User {
    private String libraryNumber;
    private String password;
    private boolean isLibrarian;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String libraryNumber, String password, boolean isLibrarian, String name, String email, String phoneNumber) {
        setLibraryNumber(libraryNumber); // Verify correct format
        this.password = password;
        this.isLibrarian = isLibrarian;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber);
    }
}
