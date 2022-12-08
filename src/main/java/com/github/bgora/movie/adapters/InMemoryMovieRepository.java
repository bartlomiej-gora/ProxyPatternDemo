package com.github.bgora.movie.adapters;

import com.github.bgora.movie.domain.Movie;
import com.github.bgora.movie.domain.MovieRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class InMemoryMovieRepository implements MovieRepository {
    private final Map<String, Movie> films;

    InMemoryMovieRepository() {
        films = new HashMap<>();
    }

    @Override
    public void saveFMovie(final Movie movie) {
        films.putIfAbsent(movie.getTitle(), movie);
    }

    @Override
    public List<Movie> listMovies() {
        return films.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
