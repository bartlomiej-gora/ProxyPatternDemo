package com.github.bgora.movie.domain;

import com.github.bgora.movie.domain.Movie;

import java.util.List;

public interface MovieRepository {

    void saveFMovie(Movie movie);

    List<Movie> listMovies();
}
