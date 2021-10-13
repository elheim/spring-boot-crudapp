package com.elheim.movies.controllers;

import com.elheim.movies.entities.Movie;
import com.elheim.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Movie movie) {
        return "add-movie";
    }

    @GetMapping("/index")
    public String showMovieList(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }

    @PostMapping("/addmovie")
    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "add-movie";
        }
        movieRepository.save(movie);
        return "redirect:/index";
    }

    @GetMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") Long id, Model model) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") Long id, @Valid Movie movie,
    BindingResult result, Model model){
        if (result.hasErrors()){
            movie.setId(id);
            return "update-movie";
        }
        movieRepository.save(movie);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id, Model model) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie id:" + id));
        movieRepository.delete(movie);
        return "redirect:/index";
    }

}
