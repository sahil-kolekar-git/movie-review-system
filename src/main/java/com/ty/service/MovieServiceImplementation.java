package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Movie;
import com.ty.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public boolean addMovie(Movie movie) {

		return movieRepository.save(movie) != null;

	}

	@Override
	public List<Movie> getMovies() {

		return movieRepository.findAll();
	}

}
