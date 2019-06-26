package com.sample.application.constants;

public final class ExceptionMessages {

	public static final String BASE_DEFAULT = "An internal server error has occured.";

	public static final String BAD_REQUEST_DEFAULT = "The request is invalid. Please try again";

	public static final String NOT_FOUND_DEFAULT = "Resource Not Found";

	public static final String INTERNAL_DEFAULT = "An internal error has occurred, Please try again later";

	public static final String UNSUPPORTED_OPERATION = "Unsupported Operation";

	public static final String METHOD_NOT_ALLOWED = "Method Not Allowed";

	public static final String VALIDATION_DEFAULT = "Data input is invalid.";

	private ExceptionMessages() {
		// private constructor to prevent creation.
	}
}
