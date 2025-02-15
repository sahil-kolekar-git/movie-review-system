package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entity.Review;
import com.ty.service.ReviewService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("/{movieid}/")
	public ResponseEntity<String> addReview(@PathVariable Integer movieid, @RequestBody Review review) {

		boolean isAdded = reviewService.addReview(movieid, review);

		return isAdded ? new ResponseEntity<String>("Review Added", HttpStatus.OK)
				: new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_GATEWAY);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable Integer id, @RequestBody Review review) {

		Review updatedReview = reviewService.updateReview(id, review);

		return new ResponseEntity<Review>(updatedReview, HttpStatus.OK);
	}

}
