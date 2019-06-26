package com.sample.application.interceptor;

import java.net.UnknownHostException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sample.application.enums.GDCType;
import com.sample.application.util.MDCUtils;

/**
 * Interceptor used to create a CorrelationId for each request and maintain it
 * through whole proccess. Using this each request and related tasks can be
 * monitored and logged easily.
 * 
 */
@Component
public class CorrelationIdInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CorrelationIdInterceptor.class);

	/**
	 * Checks for a valid correlation ID. If no valid Id is found a new correlation
	 * id is generated.
	 * 
	 * @throws UnknownHostException
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws UnknownHostException {

		String correlationId = UUID.randomUUID().toString();
		LOGGER.info("Correlation ID generated for request: {}", correlationId);

		MDCUtils.put(GDCType.CRID.toString(), correlationId);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		// Do nothing.
	}

	/**
	 * Resets the Correlation Id container.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		MDCUtils.removeDiagnosticContext();
	}

}
