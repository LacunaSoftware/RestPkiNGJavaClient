package com.lacunasoftware.restpki;

import java.util.Map;

/**
 * RestPkiCoreClient
 */
public class RestPkiCoreClient {

	private RestPkiOptions options;

	public RestPkiCoreClient(RestPkiOptions options) {
		this.options = options;
	}

	//region Attributes Getters/Setters

	public RestPkiOptions getOptions() {
		return options;
	}

	public void setOptions(RestPkiOptions options) {
		this.options = options;
	}

	//endregion
	
	RestClientPortable getRestClient(Map<String, String> customHeaders) {
		RestClientPortable client = new RestClientPortable(
			options.getEndpoint(), 
			options.getApiKey(), 
			options.getProxy(), 
			options.getCulture());

		if(customHeaders != null){
			client.setCustomHeaders(customHeaders);
		}

		return client;
	}
	
	RestClientPortable getRestClient() {
		return getRestClient(null);
	}
}