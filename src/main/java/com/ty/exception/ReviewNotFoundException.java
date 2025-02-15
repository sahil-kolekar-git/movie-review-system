package com.ty.exception;

public class ReviewNotFoundException extends RuntimeException {

	private String message;

	public ReviewNotFoundException() {
	}

	public ReviewNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
