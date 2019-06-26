package com.sample.application.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.application.exceptions.BaseException;

public class BaseExceptionResponse {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseExceptionResponse.class);

	@JsonProperty("ResponseCode")
	private int responseCode;

	@JsonProperty("ResponseData")
	private String responseData;

	/**
	 * Constructor Method.
	 * 
	 * @param e : Base exception.
	 */
	public BaseExceptionResponse(BaseException e) {
		this.responseCode = e.getHttpStatus().value();
		this.responseData = e.getMessage();
	}

	/**
	 * Constructor Method.
	 * 
	 * @param responseCode : The responseCode of the error.
	 * 
	 * @param responseData : The responseData of the error.
	 */
	public BaseExceptionResponse(int code, String description) {
		this.responseCode = code;
		this.responseData = description;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public String getResponseData() {
		return responseData;
	}

	/**
	 * Generate JSON string to set to Response.
	 */
	@Override
	public String toString() {

		try {

			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);

		} catch (JsonProcessingException e) {
			LOGGER.error("Exception Occured: ", e);
			return "{\"error\":\"internal_server_error\"}";
		}

	}
}
