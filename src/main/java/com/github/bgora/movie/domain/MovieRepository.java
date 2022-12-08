package com.github.bgora.movie.domain;

import java.util.List;

public interface MovieRepository {

    void saveFMovie(Movie movie);

    List<Movie> listMovies();
}
