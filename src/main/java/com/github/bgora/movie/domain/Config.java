package com.github.bgora.movie.domain;

import com.github.bgora.movie.adapters.AdaptersConfiguration;

public class Config {

    public MovieFacade movieFacade() {
        var adapterConfig = new AdaptersConfiguration();
        return new MovieFacadeImpl(adapterConfig.movieRepository());
    }
}
