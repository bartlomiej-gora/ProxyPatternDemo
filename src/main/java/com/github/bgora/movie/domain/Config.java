package com.github.bgora.movie.domain;

import com.github.bgora.movie.adapters.AdaptersConfiguration;

public class Config {

    public MovieFacade filmFacade() {
        var adapterConfig = new AdaptersConfiguration();
        return new MovieFacadeImpl(adapterConfig.filmRepository());
    }
}
