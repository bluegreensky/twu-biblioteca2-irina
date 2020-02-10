package com.twu.biblioteca;


import org.junit.Test;

public class BibliotecaAppTest {

    @Test(expected = RuntimeException.class)
    public void test() {
        BibliotecaApp.notifyInvalidOption();
    }
}
