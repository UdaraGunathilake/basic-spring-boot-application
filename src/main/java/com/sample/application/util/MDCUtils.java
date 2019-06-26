package com.sample.application.util;

import org.slf4j.MDC;

import com.sample.application.enums.GDCType;

public final class MDCUtils {

	private MDCUtils() {
		// private constructor.
	}

	/**
	 * Remove all keys from the MDC context.
	 */
	public static void removeDiagnosticContext() {
		for (GDCType t : GDCType.values()) {
			MDC.remove(t.name());
		}
	}

	/**
	 * Clear the MDC context.
	 */
	public static void clearDiagnosticContext() {
		MDC.clear();
	}

	/**
	 * Add value to MDC context.
	 * 
	 * @param key   : Key to refer the value.
	 * 
	 * @param value : The value to be added.
	 */
	public static void put(String key, String value) {
		MDC.put(key, value);
	}
}
