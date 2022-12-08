package com.github.bgora.movie.adapters;

import com.github.bgora.movie.domain.Movie;
import com.github.bgora.movie.domain.MovieRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class InMemoryMovieRepository implements MovieRepository {
    private final Map<String, Movie> movies;

    InMemoryMovieRepository() {
        movies = new HashMap<>();
    }

    @Override
    public void saveFMovie(final Movie movie) {
        movies.putIfAbsent(movie.getTitle(), movie);
    }

    @Override
    public List<Movie> listMovies() {
        return movies.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
