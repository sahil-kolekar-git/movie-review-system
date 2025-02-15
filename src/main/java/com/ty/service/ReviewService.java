package com.ty.service;

import com.ty.entity.Review;

public interface ReviewService {

	boolean addReview(Integer id, Review review);

	Review updateReview(Integer id, Review review);

}
