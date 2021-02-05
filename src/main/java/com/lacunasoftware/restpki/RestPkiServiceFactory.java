package com.lacunasoftware.restpki;

/**
 * RestPkiServiceFactory
 */
public class RestPkiServiceFactory {

  public static RestPkiService GetService(String endpoint, String apiKey) {
    RestPkiOptions options = new RestPkiOptions();
    options.setEndpoint(endpoint);
    options.setApiKey(apiKey);
    return GetService(options);
  }

  public static RestPkiService GetService(RestPkiOptions options){
    return new RestPkiServiceImpl(options);
  }
}