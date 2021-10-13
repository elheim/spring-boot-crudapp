package com.elheim.movies.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.*;

@Entity
public class Movie {
    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "movie_sequence")
    private Long id;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String year;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Description is mandatory")
    private String description;

    public Movie() {
    }

    public Movie(String name, String year, String description) {
        this.name = name;
        this.year = year;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}
