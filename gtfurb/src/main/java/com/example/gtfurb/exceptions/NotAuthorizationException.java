package com.example.gtfurb.exceptions;

public class NotAuthorizationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotAuthorizationException(String message) {
		super(message);
	}

}
