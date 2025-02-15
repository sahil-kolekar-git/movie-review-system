package com.ty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Movie;
import com.ty.entity.Review;
import com.ty.exception.MovieNotFoundException;
import com.ty.exception.ReviewNotFoundException;
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

	@Override
	public Review updateReview(Integer id, Review review) {

		Review db_review = repository.findById(id).orElseThrow(() -> new ReviewNotFoundException("Review not found"));

		if (review.getReviewer_name() != null)
			db_review.setReviewer_name(review.getReviewer_name());
		if (review.getComment() != null)
			db_review.setComment(review.getComment());
		if (review.getRating() != null)
			db_review.setRating(review.getRating());

		Review updated = repository.save(db_review);
		return updated;
	}

}
