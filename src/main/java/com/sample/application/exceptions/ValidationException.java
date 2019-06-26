package com.sample.application.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.sample.application.constants.ExceptionMessages;

public class ValidationException extends BaseException {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -1333498040655851329L;

	/**
	 * Constructor Method. (Default Message).
	 *
	 */
	public ValidationException() {
		super(HttpStatus.BAD_REQUEST, ExceptionMessages.VALIDATION_DEFAULT);
	}

	/**
	 * Constructor Method.
	 * 
	 * @param message : The message for the exception
	 */
	public ValidationException(String message) {
		super(HttpStatus.BAD_REQUEST, message);
	}

	/**
	 * Constructor Method.
	 * 
	 * @param message : The message for the exception
	 * 
	 * @param e       : The cause.
	 */
	public ValidationException(String message, Exception e) {
		super(HttpStatus.BAD_REQUEST, message, e);
	}

	/**
	 * Constructor Method..
	 * 
	 * @param e : Method Argument Not Valid Exception;
	 */
	public ValidationException(MethodArgumentNotValidException e) {
		super(HttpStatus.BAD_REQUEST, generateValidationMessage(e), e);
	}

	/**
	 * Generate the error String from inout validation exceptions.
	 * 
	 * @param e : Method Argument Not Valid Exception.
	 * 
	 * @return Error String.
	 */
	private static String generateValidationMessage(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		StringBuilder errorString = new StringBuilder();
		int count = 1;
		for (FieldError field : fieldErrors) {

			if (fieldErrors.size() == 1 || fieldErrors.size() == count) {
				errorString.append(field.getField()).append(": ").append(field.getDefaultMessage());
			} else {
				errorString.append(field.getField()).append(": ").append(field.getDefaultMessage()).append(",");
				count++;
			}

		}

		return errorString.toString();

	}
}
