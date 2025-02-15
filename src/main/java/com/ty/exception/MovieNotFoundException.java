package com.ty.exception;

public class MovieNotFoundException extends RuntimeException {

	private String message;

	public MovieNotFoundException() {
	}

	public MovieNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
