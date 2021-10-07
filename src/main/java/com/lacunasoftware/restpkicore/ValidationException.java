package com.lacunasoftware.restpkicore;

/**
 * Thrown to indicate that a validation failed while fulfilling an API call.
 */
public class ValidationException extends RestException {

	private ValidationResults validationResults;

	ValidationException(String verb, String url, ValidationResults vr) {
		super(vr.toString(), verb, url);
		this.validationResults = vr;
	}

	public ValidationResults getValidationResults() {
		return validationResults;
	}
}
