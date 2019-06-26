package com.sample.application.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;

/**
 * PhoneNumber validator that can be used as an annotation
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberFormatConstraint, String> {

	@Value("${valid.number.pattern}")
	String regex;

	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
		return contactField.matches(regex);
	}

}
