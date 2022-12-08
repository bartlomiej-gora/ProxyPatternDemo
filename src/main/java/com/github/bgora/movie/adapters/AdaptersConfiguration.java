package com.github.bgora.movie.adapters;

public class AdaptersConfiguration {

    public MovieRepository filmRepository(){
        return new InMemoryMovieRepository();
    }
}
