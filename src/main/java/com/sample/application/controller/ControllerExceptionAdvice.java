package com.sample.application.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.InvalidMimeTypeException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sample.application.constants.ExceptionMessages;
import com.sample.application.exceptions.BaseException;
import com.sample.application.exceptions.ValidationException;
import com.sample.application.model.BaseExceptionResponse;
	
/**
 * Advisor Class used in all Controllers to handle exceptions.
 * 
 */
@ControllerAdvice
public class ControllerExceptionAdvice {

	private static final String EXCEPTION_TRACE = "Exception Trace:";

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

	/**
	 * constructor
	 */
	public ControllerExceptionAdvice() {
		super();
	}

	/**
	 * Method to handle Resource Exceptions thrown by Controllers
	 * 
	 * @param e        : The base exception object.
	 * 
	 * @param request  : The Http request object.
	 * 
	 * @param response : The Http response object.
	 * 
	 * @return {@link ResponseEntity}
	 * 
	 * @throws IOException : Input/output exception.
	 */
	@ExceptionHandler({ BaseException.class })
	public ResponseEntity<String> handleResourceException(BaseException e, HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.error(EXCEPTION_TRACE, e);

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		BaseExceptionResponse exceptionDto = new BaseExceptionResponse(e);

		return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, e.getHttpStatus());
	}

	/**
	 * Method to handle Exceptions thrown by Controllers
	 * 
	 * @param e        : The exception thrown from the controller.
	 * 
	 * @param request  : The request object.
	 * 
	 * @param response : The response object.
	 * 
	 * @return {@link ResponseEntity}
	 * 
	 * @throws IOException : Input/output exception.
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleException(Exception e, HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.error(EXCEPTION_TRACE, e);

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		BaseExceptionResponse exceptionDto = new BaseExceptionResponse(httpStatus.value(),
				ExceptionMessages.INTERNAL_DEFAULT);

		return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, httpStatus);
	}

	/**
	 * Method to handle Method Argument Not Valid Exception thrown by Controllers.
	 * 
	 * @param e        : The base exception object.
	 * 
	 * @param request  : The Http request object.
	 * 
	 * @param response : The Http response object.
	 * 
	 * @return {@link ResponseEntity}
	 * 
	 * @throws IOException : Input/output exception.
	 */
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e,
			HttpServletRequest request, HttpServletResponse response) {

		LOGGER.error(EXCEPTION_TRACE, e);

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		ValidationException validationEx = new ValidationException(e);
		BaseExceptionResponse exceptionDto = new BaseExceptionResponse(validationEx);

		return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, validationEx.getHttpStatus());
	}

	/**
	 * Method to handle MediaTypeNotSupported Exceptions thrown by Controllers
	 * 
	 * @param e        : The exception thrown from the controller.
	 * 
	 * @param request  : The request object.
	 * 
	 * @param response : The response object.
	 * 
	 * @return {@link ResponseEntity}
	 * 
	 * @throws IOException : Input/output exception.
	 */
	@ExceptionHandler({ HttpMediaTypeNotSupportedException.class, InvalidMimeTypeException.class,
			InvalidMediaTypeException.class, HttpMessageNotReadableException.class })
	public ResponseEntity<String> handleMediaTypeNotSupportException(Exception e, HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.error(EXCEPTION_TRACE, e);

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		BaseExceptionResponse exceptionDto = new BaseExceptionResponse(httpStatus.value(),
				ExceptionMessages.BAD_REQUEST_DEFAULT);

		return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, httpStatus);
	}

	/**
	 * Method to handle HttpRequestMethodNotSupport Exceptions thrown by Controllers
	 * 
	 * @param e        : The exception thrown from the controller.
	 * 
	 * @param request  : The request object.
	 * 
	 * @param response : The response object.
	 * 
	 * @return {@link ResponseEntity}
	 * 
	 * @throws IOException : Input/output exception.
	 */
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<String> handleMethodNotSupportException(Exception e, HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.error(EXCEPTION_TRACE, e);

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpStatus httpStatus = HttpStatus.METHOD_NOT_ALLOWED;

		BaseExceptionResponse exceptionDto = new BaseExceptionResponse(httpStatus.value(),
				ExceptionMessages.METHOD_NOT_ALLOWED);

		return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, httpStatus);
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class })
	public ResponseEntity<String> handleMissingServletRequestParameterException(Exception e, HttpServletRequest request,
			HttpServletResponse response) {

		LOGGER.error(EXCEPTION_TRACE, e);

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		BaseExceptionResponse exceptionDto = new BaseExceptionResponse(httpStatus.value(),
				ExceptionMessages.BAD_REQUEST_DEFAULT);

		return new ResponseEntity<>(exceptionDto.toString(), responseHeaders, httpStatus);
	}
}
