package com.ticketpedia.usermanagement.exception;

public class CustomerAlreadyExistException extends RuntimeException {

	public CustomerAlreadyExistException(String message) {
		super(message);
	}
}
