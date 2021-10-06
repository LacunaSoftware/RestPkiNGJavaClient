package com.lacunasoftware.restpki;


/**
 * Thrown to indicate that the REST PKI API returned a specific error defined in the API.
 */
public class RestPkiException extends RestException {

	private ErrorCodes errorCode;
	private String errorCodeStr;
	private String detail;

	RestPkiException(String verb, String url, ErrorCodes errorCode, String detail) {
		super(formatExceptionMessage(verb, url, errorCode, detail), verb, url);
		this.errorCode = errorCode;
		this.errorCodeStr = errorCode.name();
		this.detail = detail;
	}

	RestPkiException(String verb, String url, String errorCode, String detail) {
		super(formatExceptionMessage(verb, url, errorCode, detail), verb, url);
		this.errorCodeStr = errorCode;
		this.detail = detail;
	}

	private static String formatExceptionMessage(String verb, String url, ErrorCodes errorCode, String detail) {
		if (Util.isNullOrEmpty(detail)) {
			return String.format("REST PKI action %s %s error: %s", verb, url, errorCode);
		} else {
			return String.format("REST PKI action %s %s error: %s (%s)", verb, url, errorCode, detail);
		}
	}

	private static String formatExceptionMessage(String verb, String url, String errorCode, String detail) {
		if (Util.isNullOrEmpty(detail)) {
			return String.format("REST PKI action %s %s error: %s", verb, url, errorCode);
		} else {
			return String.format("REST PKI action %s %s error: %s (%s)", verb, url, errorCode, detail);
		}
	}

	/**
	 * Returns the error code.
	 *
	 * @return The error code.
	 */
	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	/**
	 * Return the error code in string.
	 * @return The erro code string.
	 */
	public String getErrorCodeStr() {
		return errorCodeStr;
	}

	/**
	 * Returns details for the error, if any.
	 *
	 * @return Details for the error, if any.
	 */
	public String getDetail() {
		return detail;
	}
}
