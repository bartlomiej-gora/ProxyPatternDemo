package com.github.bgora.movie.domain;

import java.util.List;
import java.util.Optional;

public interface MovieFacade {

    void save(Movie movie);

    Optional<Movie> findByTitle(String title);

    List<Movie> findWithTitleStarting(String title);

}
