package ru.netology.domain;


import ru.netology.repository.PostersManagerRepository;

public class PostersManager {
    private PostersManagerRepository repo;

    private MovieData[] movies = new MovieData[0];
    private int numberOfMoviesDisplayed;

    public PostersManager(PostersManagerRepository repo) {
        this.repo = repo;
        this.numberOfMoviesDisplayed = 10;
    }

    public PostersManager(PostersManagerRepository repo, int numberOfMoviesDisplayed) {
        this.repo = repo;
        this.numberOfMoviesDisplayed = numberOfMoviesDisplayed;
    }

    public void addNewMovie(MovieData movie) {
        repo.save(movie);
    }


        public MovieData[] getMovies() {
        MovieData[] movies = repo.findAll();
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


    public void removeById(int id) {
        repo.removeById(id);
    }

    public MovieData[] findById(int id) {
        repo.findById(id);
        return movies;
    }

    public void removeAll() {
        repo.removeAll();
    }
}



