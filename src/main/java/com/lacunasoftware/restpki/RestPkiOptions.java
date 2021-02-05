package com.lacunasoftware.restpki;

import java.time.Duration;

/**
 * RestPkiOptions
 */
public class RestPkiOptions {


  private String Endpoint;
  private String ApiKey;
  private Duration Timeout;
  private String Culture;

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

  public long getTimeoutSeconds() {
    return Timeout != null ? Timeout.getSeconds() : null;
  }
  public void setTimeoutSeconds(long timeoutSeconds) {
    Timeout = Duration.ofSeconds(timeoutSeconds);
  }

  public String getCulture() {
    return Culture;
  }
  public void setCulture(String culture) {
    Culture = culture;
  }
}