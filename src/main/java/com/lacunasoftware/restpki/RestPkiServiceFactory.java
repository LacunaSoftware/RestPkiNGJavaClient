package com.lacunasoftware.restpki;

/**
 * RestPkiServiceFactory
 */
public class RestPkiServiceFactory {

  public static RestPkiService getService(String endpoint, String apiKey) {
    RestPkiOptions options = new RestPkiOptions();
    options.setEndpoint(endpoint);
    options.setApiKey(apiKey);
    return getService(options);
  }

  public static RestPkiService getService(RestPkiOptions options){
    return new RestPkiServiceImpl(options);
  }
}