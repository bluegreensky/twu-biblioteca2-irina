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
}
