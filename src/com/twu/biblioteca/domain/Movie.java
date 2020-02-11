package com.twu.biblioteca.domain;

public class Movie extends Item {

    public static enum Rating {
        UNRATED, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
    }

    private String name;
    private int year;
    private String director;
    private Rating movieRating;

    public Movie(String name, int year, String director, Rating movieRating, boolean checkedOut) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.checkedOut = checkedOut;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name = '" + name + '\'' +
                ", year = " + year +
                ", director = '" + director + '\'' +
                ", movie rating = " + movieRating +
                '}';
    }
}
