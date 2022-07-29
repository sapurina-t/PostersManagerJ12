package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostersManagerTest {
    MovieData movie1 = new MovieData(1, "movie1", "genre1");
    MovieData movie2 = new MovieData(2, "movie2", "genre2");
    MovieData movie3 = new MovieData(3, "movie3", "genre3");
    MovieData movie4 = new MovieData(4, "movie4", "genre4");
    MovieData movie5 = new MovieData(5, "movie5", "genre5");
    MovieData movie6 = new MovieData(6, "movie6", "genre6");
    MovieData movie7 = new MovieData(7, "movie7", "genre7");
    MovieData movie8 = new MovieData(8, "movie8", "genre8");
    MovieData movie9 = new MovieData(9, "movie9", "genre9");
    MovieData movie10 = new MovieData(10, "movie10", "genre10");
    MovieData movie11 = new MovieData(11, "movie11", "genre11");
    MovieData movie12 = new MovieData(12, "movie12", "genre12");

    @Test
    public void shouldAddNewMovieUserLimit() {
        PostersManager manager = new PostersManager(4);
        manager.addNewMovie(movie1);
        manager.addNewMovie(movie2);
        manager.addNewMovie(movie3);
        manager.addNewMovie(movie4);
        manager.addNewMovie(movie5);
        manager.addNewMovie(movie6);
        manager.addNewMovie(movie7);
        manager.addNewMovie(movie8);
        manager.addNewMovie(movie9);
        manager.addNewMovie(movie10);
        manager.addNewMovie(movie11);
        manager.addNewMovie(movie12);
        MovieData[] expected = {movie12, movie11, movie10, movie9};
        MovieData[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewMovieStandartLimit() {
        PostersManager manager = new PostersManager();
        manager.addNewMovie(movie1);
        manager.addNewMovie(movie2);
        manager.addNewMovie(movie3);
        manager.addNewMovie(movie4);
        manager.addNewMovie(movie5);
        manager.addNewMovie(movie6);
        manager.addNewMovie(movie7);
        manager.addNewMovie(movie8);
        manager.addNewMovie(movie9);
        manager.addNewMovie(movie10);
        manager.addNewMovie(movie11);
        manager.addNewMovie(movie12);
        MovieData[] expected = {movie12, movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3};
        MovieData[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewMovieLessUserLimit() {
        PostersManager manager = new PostersManager(10);
        manager.addNewMovie(movie1);
        manager.addNewMovie(movie2);
        manager.addNewMovie(movie3);

        MovieData[] expected = {movie3, movie2, movie1};
        MovieData[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewMovie() {
        PostersManager manager = new PostersManager();
        manager.addNewMovie(movie1);
        manager.addNewMovie(movie2);
        manager.addNewMovie(movie3);

        MovieData[] expected = {movie1, movie2, movie3};
        MovieData[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTenNewMovie() {
        PostersManager manager = new PostersManager();
        manager.addNewMovie(movie1);
        manager.addNewMovie(movie2);
        manager.addNewMovie(movie3);
        manager.addNewMovie(movie4);
        manager.addNewMovie(movie5);
        manager.addNewMovie(movie6);
        manager.addNewMovie(movie7);
        manager.addNewMovie(movie8);
        manager.addNewMovie(movie9);
        manager.addNewMovie(movie10);

        MovieData[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10};
        MovieData[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNullNewMovie() {
        PostersManager manager = new PostersManager();

        MovieData[] expected = {};
        MovieData[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
