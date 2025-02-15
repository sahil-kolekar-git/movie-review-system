package com.ty.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Movie;
import com.ty.entity.Review;
import com.ty.exception.MovieNotFoundException;
import com.ty.repository.MovieRepository;
import com.ty.repository.ReviewRepository;

@Service
public class ReviewServiceImplementation implements ReviewService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ReviewRepository repository;

	@Override
	public boolean addReview(Integer id, Review review) {

		Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

		review.setMovie(movie);

		return repository.save(review) != null;

	}

}
