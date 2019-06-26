package com.sample.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Swagger Contoller is the place where swagger API documantation exposed to out
 * side.
 * 
 */
@ApiIgnore
@RestController("swaggerController")
public class SwaggerController {

	@Value("#{'${APISELF_URL}'.split(',')}")
	private Object[] apiSelfUrl;

	private static final String SWAGGER_UI = "/swagger-ui.html";

	private static final String API_DOCS = "/v2/api-docs";

	private static final int API_LENGTH = 2;

	/**
	 * Return Swagger Documentation.
	 * 
	 * @return {@link ModelAndView}
	 * 
	 * @throws Exception
	 */
	@GetMapping(value = { "/swagger.json", "/" })
	public View getSwaggerUi() {
		return getView(SWAGGER_UI);
	}

	/**
	 * Return Swagger Documentation.
	 * 
	 * @return {@link ModelAndView}
	 * 
	 * @throws Exception
	 */
	@GetMapping(value = "/api-docs")
	public View getSwaggerApiDoc() {
		return getView(API_DOCS);
	}

	/**
	 * Generate the swagger route.
	 * 
	 * @param url: Swagger route.
	 * 
	 * @return {@link View}
	 */
	private View getView(String url) {

		String protocol;
		String domain;
		String port;

		if (apiSelfUrl.length == API_LENGTH) {
			protocol = apiSelfUrl[0].toString();
			domain = apiSelfUrl[1].toString();

			return new RedirectView(protocol + "://" + domain + url, true);
		}
		protocol = apiSelfUrl[0].toString();
		domain = apiSelfUrl[1].toString();
		port = apiSelfUrl[API_LENGTH].toString();

		return new RedirectView(protocol + "://" + domain + ":" + port + url, true);
	}

}
