package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entity.Review;
import com.ty.service.ReviewService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("/{movieid}/")
	public String addReview(@PathVariable Integer movieid, @RequestBody Review review) {

		reviewService.addReview(movieid, review);

		return "";
	}

}
