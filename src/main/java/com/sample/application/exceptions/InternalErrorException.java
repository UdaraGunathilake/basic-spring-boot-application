package com.sample.application.exceptions;

import org.springframework.http.HttpStatus;

import com.sample.application.constants.ExceptionMessages;

public class InternalErrorException extends BaseException {

	/**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = -9017137809045377930L;

	/**
	 * Constructor Method. (Default Message).
	 *
	 */
	public InternalErrorException() {
		super();
	}

	/**
	 * Constructor Method. (Default Message).
	 *
	 * @param e
	 */
	public InternalErrorException(Exception e) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, ExceptionMessages.INTERNAL_DEFAULT, e);
	}

	/**
	 * Constructor Method. (Customized Message)
	 * 
	 * @param message
	 */
	public InternalErrorException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}

	/**
	 * Constructor Method. (Customized message and exception details).
	 * 
	 * @param message : Customized Exception.
	 * 
	 * @param e       : Exception thrown.
	 */
	public InternalErrorException(String message, Exception e) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message, e);
	}

}
