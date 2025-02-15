package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entity.Movie;
import com.ty.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie) {

		boolean isAdded = movieService.addMovie(movie);

		return isAdded ? new ResponseEntity<String>("Movie added", HttpStatus.OK)
				: new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_GATEWAY);
	}

	@GetMapping("/")
	public ResponseEntity<List<Movie>> getMovies() {

		List<Movie> movies = movieService.getMovies();

		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

}
