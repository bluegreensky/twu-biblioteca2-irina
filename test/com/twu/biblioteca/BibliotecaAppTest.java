package com.twu.biblioteca;


import org.junit.Test;

public class BibliotecaAppTest {

    @Test(expected = RuntimeException.class)
    public void testInvalidOption() {
        BibliotecaApp.invalidOption();
    }

    @Test(expected = RuntimeException.class)
    public void testUnsuccessfulBookCheckOut() {
        BibliotecaApp.unsuccessfulBookCheckOut();
    }

    @Test(expected = RuntimeException.class)
    public void testUnsuccessfulBookReturn() {
        BibliotecaApp.unsuccessfulBookReturn();
    }

    @Test(expected = RuntimeException.class)
    public void testUnsuccessfulMovieCheckOut() {
        BibliotecaApp.unsuccessfulMovieCheckOut();
    }
}
