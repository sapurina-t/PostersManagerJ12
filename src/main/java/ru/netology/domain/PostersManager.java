package ru.netology.domain;

public class PostersManager {

    private MovieData[] movies = new MovieData[0];
    private int numberOfMoviesDisplayed;

    public PostersManager(int numberOfMoviesDisplayed) {
        this.numberOfMoviesDisplayed = numberOfMoviesDisplayed;
    }

    public PostersManager() {
        this.numberOfMoviesDisplayed = 10;
    }

    public void addNewMovie(MovieData movieData) {
        MovieData[] tmp = new MovieData[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movieData;
        movies = tmp;
    }


    public MovieData[] findAll() {
        return movies;
    }

    public MovieData[] findLast() {
        int resultLength;
        if (movies.length >= numberOfMoviesDisplayed) {
            resultLength = numberOfMoviesDisplayed;
        } else {
            resultLength = movies.length;
        }
        MovieData[] result = new MovieData[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}
