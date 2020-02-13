package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.domain.User;
import org.junit.*;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

public class LibraryTest {

    public static Library library = new Library();

    @Test(expected = RuntimeException.class)
    public void testCheckOutBook() {
        User user = new User("100-0002", "abc", false, "Sam", "sam@yahoo.com", "222-222-2222");
        library.checkOutBook("00", user); // Throws an exception (not in the library)
        library.checkOutBook("11", user); // Throws an exception (in the library, but not available)
        Book book = library.getBooks().get(0);
        library.checkOutBook("0679732187", user); // Successful check out
        assertTrue(book.isCheckedOut());
    }

    @Test(expected = RuntimeException.class)
    public void testReturnBook() {
        User user = new User("100-0002", "abc", false, "Sam", "sam@yahoo.com", "222-222-2222");
        library.returnBook("1234", user); // Throws an exception (not in the library)
        library.returnBook("0679732187", user); // Throws an exception (it is already in the library)
        Book book = library.getBooks().get(6);
        library.returnBook("11", user); // Successful return
        assertFalse(book.isCheckedOut());
    }

    @Test(expected = RuntimeException.class)
    public void testCheckOutMovie(){
        library.checkOutMovie("Doesn't exist in the library"); // Throws an exception (not in the library)
        library.checkOutMovie("Wall-E"); // Throws an exception (in the library, but not available)
        Movie movie = library.getMovies().get(0);
        library.checkOutMovie("The Seven Samurai"); // Successful check out
        assertTrue(movie.isCheckedOut());
    }

}
