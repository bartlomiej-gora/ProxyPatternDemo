package com.github.bgora.movie.adapters;

import com.github.bgora.movie.domain.MovieRepository;

public class AdaptersConfiguration {

    public MovieRepository filmRepository(){
        return new InMemoryMovieRepository();
    }
}
