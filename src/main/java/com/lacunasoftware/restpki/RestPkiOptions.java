package com.lacunasoftware.restpki;

import java.net.Proxy;

/**
 * RestPkiOptions
 */
public class RestPkiOptions {


  private String endpoint;
  private String apiKey;
  private String culture;
  private Proxy proxy;

  public String getEndpoint() {
    return endpoint;
  }
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getApiKey() {
    return apiKey;
  }
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getCulture() {
    return culture;
  }
  public void setCulture(String culture) {
    this.culture = culture;
  }

  public Proxy getProxy(){
    return proxy;
  }
  public void setProxy(Proxy proxy){
    this.proxy = proxy;
  }
}