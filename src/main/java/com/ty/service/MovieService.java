package com.ty.service;

import java.util.List;

import com.ty.entity.Movie;

public interface MovieService {

	boolean addMovie(Movie movie);

	List<Movie> getMovies();

}
