package com.sample.application.repository;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sample.application.exceptions.InternalErrorException;
	
@Aspect
@Component
public class RepositoryAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryAspect.class);

	private static final String EXCEPTION_TRACE = "Exception Trace:";

	/**
	 * Wraps the exception thrown from the Repository with a Internal Server Error.
	 * 
	 * @param ex: Exception thrown from the Repository.
	 */
	@AfterThrowing(pointcut = "execution(* com.sample.application..*Repository.*(..))", throwing = "ex")
	public void repositoryException(Exception ex) {

		LOGGER.error("Error Occured, Couldn't Complete Database Call Successfully");

		LOGGER.error(EXCEPTION_TRACE, ex);
		throw new InternalErrorException();
	}

	/**
	 * Runs before every database call
	 */
	@Before("execution(* com.sample.application..*Repository.*(..))")
	public void repositiryBeforeLogging() {

		LOGGER.info("Database Call Inprogress");
	}

	/**
	 * Runs after successfully completing every database call
	 */
	@AfterReturning("execution(* com.sample.application..*Repository.*(..))")
	public void repositiryAfterLogging() {

		LOGGER.info("Database Call Completed Successfully");
	}
}
