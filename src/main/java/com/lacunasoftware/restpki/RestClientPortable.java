package com.lacunasoftware.restpki;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

class RestClientPortable {

	protected String endpointUri;
	protected String apiKey;
	protected String cultureName;
	protected Proxy proxy;
	protected Map<String, String> customHeaders;

	public RestClientPortable(String endpointUri, String apiKey, Proxy proxy, String cultureName) {
		this.endpointUri = endpointUri;
		this.apiKey = apiKey;
		this.proxy = proxy;
		this.cultureName = cultureName;
	}

	public <TResponse> TResponse get(String requestUri, Class<TResponse> responseType) throws RestException {
		return get(requestUri, new TypeReference<TResponse>() {
			@Override
			public Type getType() {
				return responseType;
			}
		});
	}

	public <TResponse> TResponse get(String requestUri, TypeReference<TResponse> responseType) throws RestException {

		String verb = "GET";
		String url = endpointUri + requestUri;
		HttpURLConnection conn;

		try {

			URL urlObj = new URL(url);
			if (proxy != null) {
				conn = (HttpURLConnection) urlObj.openConnection(proxy);
			} else {
				conn = (HttpURLConnection) urlObj.openConnection();
			}
			conn.setRequestMethod(verb);
			conn.setRequestProperty("Accept", "application/json");
			if (apiKey != null) {
				conn.setRequestProperty("X-Api-Key", apiKey);
			}
			if (cultureName != null) {
				conn.setRequestProperty("Accept-Language", cultureName);
			}
			if (customHeaders != null){
				customHeaders.forEach(
						(key, value) -> conn.setRequestProperty(key, value));
			}

		} catch (Exception e) {
			throw new RestUnreachableException(verb, url, e);
		}

		checkResponse(verb, url, conn);

		TResponse response;

		try {
			response = readResponse(conn, responseType);
		} catch (Exception e) {
			throw new RestDecodeException(verb, url, e);
		}

		conn.disconnect();
		return response;
	}

	public <TRequest, TResponse> TResponse post(String requestUri, TRequest request, Class<TResponse> responseType) throws RestException {

		String verb = "POST";
		String url = endpointUri + requestUri;
		HttpURLConnection conn;

		try {

			URL urlObj = new URL(url);
			if (proxy != null) {
				conn = (HttpURLConnection) urlObj.openConnection(proxy);
			} else {
				conn = (HttpURLConnection) urlObj.openConnection();
			}
			conn.setDoOutput(true);
			conn.setRequestMethod(verb);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			if (apiKey != null) {
				conn.setRequestProperty("X-Api-Key", apiKey);
			}
			if (cultureName != null) {
				conn.setRequestProperty("Accept-Language", cultureName);
			}
			if (customHeaders != null){
				customHeaders.forEach(
					(key, value) -> conn.setRequestProperty(key, value));
			}

			OutputStream outStream = conn.getOutputStream();
			if (request != null) {
				new ObjectMapper().writeValue(outStream, request);
			}
			outStream.close();

		} catch (Exception e) {
			throw new RestUnreachableException(verb, url, e);
		}

		checkResponse(verb, url, conn);

		TResponse response = null;

		try {
			if (responseType != null) {
				response = readResponse(conn, responseType);
			}
		} catch (Exception e) {
			throw new RestDecodeException(verb, url, e);
		}

		conn.disconnect();
		return response;
	}

	public InputStream openStream(String url) throws RestException {

		String verb = "GET";
		HttpURLConnection conn;

		try {

			URL urlObj = new URL(url);
			if (proxy != null) {
				conn = (HttpURLConnection) urlObj.openConnection(proxy);
			} else {
				conn = (HttpURLConnection) urlObj.openConnection();
			}
			conn.setRequestMethod(verb);

			return conn.getInputStream();

		} catch (Exception e) {
			throw new RestUnreachableException(verb, url, e);
		}
	}

	//region Response check/read

	private void checkResponse(String verb, String url, HttpURLConnection conn) throws RestException {

		int statusCode;

		try {
			statusCode = conn.getResponseCode();
		} catch (Exception e) {
			throw new RestUnreachableException(verb, url, e);
		}

		if (statusCode < 200 || statusCode > 299) {

			RestException ex = null;

			try {

				if (statusCode == 404) {

					RestResourceNotFoundModel model = readErrorResponse(conn, RestResourceNotFoundModel.class);
					if (model != null) {
						if (!Util.isNullOrEmpty(model.resourceName) && !Util.isNullOrEmpty(model.resourceId)) {
							ex = new RestResourceNotFoundException(verb, url, model.resourceName, model.resourceId);
						} else {
							ex = new RestErrorException(verb, url, statusCode, model.message);
						}
					}

				} else if (statusCode == 422) {

					ErrorModel errorModel = readErrorResponse(conn, ErrorModel.class);
					ErrorCodes errorCode = ErrorCodes.valueOf(errorModel.code);
					if (errorCode.equals(ErrorCodes.ValidationError)) {
						ex = new ValidationException(verb, url, new ValidationResults(errorModel.validationResults));
					} else {
						ex = new RestPkiException(verb, url, errorCode, errorModel.detail);
					}

				} else {

					RestGeneralErrorModel model = readErrorResponse(conn, RestGeneralErrorModel.class);
					if (model != null && !Util.isNullOrEmpty(model.message)) {
						ex = new RestErrorException(verb, url, statusCode, model.message);
					}

				}

			} catch (Exception e) {
				// do nothing
				//throw new RuntimeException("Error decoding error", e);
			}

			if (ex == null) {
				ex = new RestErrorException(verb, url, statusCode);
			}
			throw ex;
		}
	}

	private <T> T readResponse(HttpURLConnection conn, Class<T> valueType) throws IOException {
		InputStream inStream = conn.getInputStream();
		T response = new ObjectMapper().readValue(inStream, valueType);
		inStream.close();
		return response;
	}

	private <T> T readResponse(HttpURLConnection conn, TypeReference<T> valueType) throws IOException {
		InputStream inStream = conn.getInputStream();
		T response = new ObjectMapper().readValue(inStream, valueType);
		inStream.close();
		return response;
	}

	private <T> T readErrorResponse(HttpURLConnection conn, Class<T> valueType) throws IOException {
		InputStream inStream = conn.getErrorStream();
		T response = new ObjectMapper().readValue(inStream, valueType);
		inStream.close();
		return response;
	}

	//region Attributes Getters/Setters

	public String getEndpointUri() {
		return endpointUri;
	}

	public void setEndpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getCultureName() {
		return cultureName;
	}

	public void setCultureName(String cultureName) {
		this.cultureName = cultureName;
	}

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	public Map<String, String> getCustomHeaders() {
		return customHeaders;
	}

	public void setCustomHeaders(Map<String, String> customHeaders) {
		this.customHeaders = customHeaders;
	}
}
