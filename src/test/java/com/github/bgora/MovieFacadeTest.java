package com.github.bgora;

import com.github.bgora.movie.domain.Config;
import com.github.bgora.movie.domain.Movie;
import com.github.bgora.movie.domain.MovieFacade;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class MovieFacadeTest {

    private MovieFacade movieFacade = new Config().movieFacade();

    @Test
    void testSaveOneFilm() {

        //given
        final String givenTitle = "Alien";
        final String givenReleaseDate = "1979";
        var movie = new Movie(givenTitle, givenReleaseDate);

        //when
        movieFacade.save(movie);

        //then
        var existingOpt = movieFacade.findByTitle(givenTitle);
        assertThat(existingOpt).isNotEmpty();
        var existing = existingOpt.get();
        assertThat(existing.getTitle()).isEqualTo(givenTitle);
        assertThat(existing.getReleaseDate()).isEqualTo(givenReleaseDate);
    }

    @Test
    void testShouldReturnAliens() {

        //given
        final String givenTitle1 = "Alien";
        final String givenReleaseDate1 = "1979";
        var movie1 = new Movie(givenTitle1, givenReleaseDate1);
        final String givenTitle2 = "Aliens";
        final String givenReleaseDate2 = "1986";
        var movie2 = new Movie(givenTitle2, givenReleaseDate2);
        final String givenTitle3 = "Alien 3";
        final String givenReleaseDate3 = "1993";
        var movie3 = new Movie(givenTitle3, givenReleaseDate3);

        //when
        movieFacade.save(movie1);
        movieFacade.save(movie2);
        movieFacade.save(movie3);

        //then
        var list = movieFacade.findWithTitleStarting("Aliens");
        assertThat(list).size().isEqualTo(1);
        assertThat(list).extracting("title", "releaseDate").contains(tuple(givenTitle2, givenReleaseDate2));
    }

    @Test
    void testShouldReturnAllMovies() {

        //given
        final String givenTitle1 = "Alien";
        final String givenReleaseDate1 = "1979";
        var movie1 = new Movie(givenTitle1, givenReleaseDate1);
        final String givenTitle2 = "Aliens";
        final String givenReleaseDate2 = "1986";
        var movie2 = new Movie(givenTitle2, givenReleaseDate2);
        final String givenTitle3 = "Alien 3";
        final String givenReleaseDate3 = "1993";
        var movie3 = new Movie(givenTitle3, givenReleaseDate3);

        //when
        movieFacade.save(movie1);
        movieFacade.save(movie2);
        movieFacade.save(movie3);

        //then
        var list = movieFacade.findWithTitleStarting("Alien");
        assertThat(list).size().isEqualTo(3);
        assertThat(list).extracting("title", "releaseDate").contains(tuple(givenTitle1, givenReleaseDate1));
        assertThat(list).extracting("title", "releaseDate").contains(tuple(givenTitle2, givenReleaseDate2));
        assertThat(list).extracting("title", "releaseDate").contains(tuple(givenTitle3, givenReleaseDate3));
    }
}
