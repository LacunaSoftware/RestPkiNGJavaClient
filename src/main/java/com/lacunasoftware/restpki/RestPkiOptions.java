package com.lacunasoftware.restpki;

import java.net.Proxy;

/**
 * RestPkiOptions
 */
public class RestPkiOptions {


  private String Endpoint;
  private String ApiKey;
  private String Culture;
  private Proxy proxy;

  public String getEndpoint() {
    return Endpoint;
  }
  public void setEndpoint(String endpoint) {
    Endpoint = endpoint;
  }

  public String getApiKey() {
    return ApiKey;
  }
  public void setApiKey(String apiKey) {
    ApiKey = apiKey;
  }

  public String getCulture() {
    return Culture;
  }
  public void setCulture(String culture) {
    Culture = culture;
  }

  public Proxy getProxy(){
    return proxy;
  }
  public void setProxy(Proxy proxy){
    this.proxy = proxy;
  }
}