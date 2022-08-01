package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.repository.PostersManagerRepository;

import static org.mockito.Mockito.*;

public class PostersManagerTest {
    //    PostersManagerRepository repo = new PostersManagerRepository();
    PostersManagerRepository repo = Mockito.mock(PostersManagerRepository.class);
//    PostersManager manager = new PostersManager(repo);

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
    public void shouldAddNewMovieStandartLimit() {
        PostersManager manager = new PostersManager(repo);
        MovieData[] movies = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12};
        doReturn(movies).when(repo).findAll();

        MovieData[] expected = {movie12, movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3};
        MovieData[] actual = manager.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewMovieLessUserLimit() {
        PostersManager manager = new PostersManager(repo, 10);
        MovieData[] movies = {movie1, movie2, movie3};
        doReturn(movies).when(repo).findAll();

        MovieData[] expected = {movie3, movie2, movie1};
        MovieData[] actual = manager.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        PostersManager manager = new PostersManager(repo, 4);

        MovieData[] movies = {movie1, movie3, movie4};
        doReturn(movies).when(repo).findAll();

        MovieData[] expected = {movie4, movie3, movie1};
        MovieData[] actual = manager.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }
}

//    @BeforeEach
//    public void setup() {
//        manager.addNewMovie(movie1);
//        manager.addNewMovie(movie2);
//        manager.addNewMovie(movie3);
//        manager.addNewMovie(movie4);
//        manager.addNewMovie(movie5);
//        manager.addNewMovie(movie6);
//        manager.addNewMovie(movie7);
//        manager.addNewMovie(movie8);
//        manager.addNewMovie(movie9);
//        manager.addNewMovie(movie10);
//        manager.addNewMovie(movie11);
//        manager.addNewMovie(movie12);
//    }

//    @Test
//    public void shouldAddNewMovieUserLimit() {
//        PostersManager manager = new PostersManager(repo, 4);
//        MovieData[] expected = {movie12, movie11, movie10, movie9};
//        MovieData[] actual = manager.getMovies();
//
//        Assertions.assertArrayEquals(expected, actual);
//    }

//    @Test
//    public void shouldAddTenNewMovie() {
//        PostersManager manager = new PostersManager(repo);
//
//        MovieData[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12};
//        MovieData[] actual = repo.findAll();
//
//        Assertions.assertArrayEquals(expected, actual);
//    }

//        @Test
//    public void shouldAddNullNewMovie() {
//        PostersManager manager = new PostersManager(repo);
//// должен быть пустой массив
//        MovieData[] expected = {};
//        MovieData[] actual = repo.findAll();
//
//        Assertions.assertArrayEquals(expected, actual);
//    }


//    @Test
//    public void shouldFindById() {
//        PostersManager manager = new PostersManager(repo);
//        repo.findById(2);
//
//        MovieData expected = movie2;
//        MovieData actual = repo.findById(2);
//
//        Assertions.assertEquals(expected, actual);
//    }

//    @Test
//    public void shouldRemoveAll() {
//        PostersManager manager = new PostersManager(repo);
//        repo.removeAll();
//
//        MovieData[] expected = repo.findAll();
//        MovieData[] actual = {};
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
//}
