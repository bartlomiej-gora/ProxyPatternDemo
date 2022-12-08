package com.github.bgora.movie.domain;

import com.github.bgora.movie.adapters.MovieRepository;

import java.util.List;
import java.util.Optional;

class MovieFacadeImpl implements MovieFacade {

    private final MovieRepository movieRepository;

    MovieFacadeImpl(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void save(final Movie movie) {
        movieRepository.saveFMovie(movie);
    }

    @Override
    public Optional<Movie> findByTitle(final String title) {
        return movieRepository.listMovies().stream().filter(film -> film.title().equals(title)).findFirst();
    }

    @Override
    public List<Movie> findWithTitleStarting(final String title) {
        return movieRepository.listMovies().stream().filter(movie -> movie.title().startsWith(title)).toList();
    }
}
