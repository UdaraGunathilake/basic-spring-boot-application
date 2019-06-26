package com.sample.application.exceptions;

import org.springframework.http.HttpStatus;

import com.sample.application.constants.ExceptionMessages;

public class BadRequestException extends BaseException {

	/**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = -3926855032933143474L;

	/**
	 * Constructor Method.(Default Message).
	 *
	 */
	public BadRequestException() {
		super(HttpStatus.BAD_REQUEST, ExceptionMessages.BAD_REQUEST_DEFAULT);
	}

	/**
	 * Constructor Method. (Customized Exception)
	 * 
	 * @param message
	 */
	public BadRequestException(String message) {
		super(HttpStatus.BAD_REQUEST, message);
	}

	/**
	 * Constructor Method. (Exception and Customized Message).
	 * 
	 * @param message : Customization message.
	 * 
	 * @param e       : Exception.
	 */
	public BadRequestException(String message, Exception e) {
		super(HttpStatus.BAD_REQUEST, message, e);
	}

}
