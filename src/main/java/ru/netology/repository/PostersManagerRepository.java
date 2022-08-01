package ru.netology.repository;

import ru.netology.domain.MovieData;

public class PostersManagerRepository {
    private MovieData[] movies = new MovieData[0];

    public MovieData[] findAll() {
        return movies;
    }

//        public MovieData[] getMovies() {
//        return movies;
//    }
    public void save(MovieData movie) {
        MovieData[] tmp = new MovieData[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieData findById(int id) {
        for (MovieData movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        MovieData[] tmp = new MovieData[movies.length - 1];
        int dellToIndex = 0;
        for (MovieData movie : movies) {
            if (movie.getId() != id) {
                tmp[dellToIndex] = movie;
                dellToIndex++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        MovieData[] clear = new MovieData[0];
        movies = clear;
    }
}
