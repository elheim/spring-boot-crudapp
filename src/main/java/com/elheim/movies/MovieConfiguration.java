package com.elheim.movies;

import com.elheim.movies.entities.Movie;
import com.elheim.movies.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> {
            Movie godfather = new Movie(
                    "Godfather",
                    "1971",
                    "good acting skills");


            movieRepository.saveAll(
                    List.of(godfather)
            );
        };
    }
}
