package com.github.bgora.movie.domain;

public class Movie {
    public Movie(final String title, final String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    private String title;
    private String releaseDate;

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
