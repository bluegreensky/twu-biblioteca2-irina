package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.User;
import org.junit.*;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

public class LibraryTest {

    public static Library library = new Library();

    @Test
    public void testCheckOutBookWhenInLibrary() {
        Book book = library.getBooks().get(0);
        User user = new User("100-0002", "abc", false, "Sam", "sam@yahoo.com", "222-222-2222");
        library.checkOutBook("0679732187", user);
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void testReturnBook() {
        Book book = library.getBooks().get(6);
        library.returnBook("11");
        assertFalse(book.isCheckedOut());
    }

}
