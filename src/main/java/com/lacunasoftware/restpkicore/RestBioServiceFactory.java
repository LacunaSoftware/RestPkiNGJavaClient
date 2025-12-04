package com.lacunasoftware.restpkicore;

/**
 * RestBioServiceFactory
 */
public class RestBioServiceFactory {

	public static RestBioService getService(String endpoint, String apiKey) {
		RestPkiOptions options = new RestPkiOptions();
		options.setEndpoint(endpoint);
		options.setApiKey(apiKey);
		return getService(options);
	}

	public static RestBioService getService(RestPkiOptions options) {
		return new RestPkiServiceImpl(options);
	}
}