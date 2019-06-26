package com.sample.application.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Return a {@link Docket}
	 * 
	 * @return {@link Docket}
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("(?!/error.*).*")).build().apiInfo(metadata());
	}

	/**
	 * API Information for Swagger.
	 * 
	 * @return {@link ApiInfo}
	 */
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Sample Spring Boot API")
				.description("Sample Spring Boot API - udara.dhammika@gmail.com").version("1.0").license("Apache 2.0")
				.build();
	}
}
