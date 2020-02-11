package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import org.junit.*;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

public class LibraryTest {

    public static Library library = new Library();

    @Test
    public void testCheckOutBookWhenInLibrary() {
        Book book = library.getBooks().get(0);
        library.checkOutBook("0679732187");
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void testReturnBook() {
        Book book = library.getBooks().get(6);
        library.returnBook("11");
        assertFalse(book.isCheckedOut());
    }

}
