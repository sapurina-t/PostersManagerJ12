package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieData;

public class PostersManagerRepositoryTest {

    MovieData movie1 = new MovieData(1, "movie1", "genre1");
    MovieData movie2 = new MovieData(2, "movie2", "genre2");
    MovieData movie3 = new MovieData(3, "movie3", "genre3");

    @Test
    public void shouldAddObjectToArray() {
        PostersManagerRepository repo = new PostersManagerRepository();
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);

        MovieData[] expected = {movie1, movie2, movie3};
        MovieData[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddObjectById() {
        PostersManagerRepository repo = new PostersManagerRepository();

        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);
//        repo.findById(2);

        MovieData expected = movie2;
        MovieData actual = repo.findById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddNullObjectById() {
        PostersManagerRepository repo = new PostersManagerRepository();

        repo.save(movie1);
        repo.save(movie3);

        MovieData expected = null;
        MovieData actual = repo.findById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveObjectById() {
        PostersManagerRepository repo = new PostersManagerRepository();
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);
        repo.removeById(movie2.getId());

        MovieData[] expected = {movie1, movie3};
        MovieData[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        PostersManagerRepository repo = new PostersManagerRepository();
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);

        repo.removeAll();

        MovieData[] expected = {};
        MovieData[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
