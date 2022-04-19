package com.lacunasoftware.restpkicore;

/**
 * ApiRoutes
 */
public enum ApiRoutes {
  APPLICATIONS("api/applications"),
  AUTHENTICATION("api/v2/authentication"),
  APPLICATION_KEYS("api/app-keys"),
  CERTIFICATES("api/certificates"),
  DOCUMENTS("api/documents"),
  DOCUMENT_KEYS("api/document-keys"),
  FILE_VALIDATION("api/file-validation"),
  SETTINGS("api/settings"),
  SIGNATURE_SESSION("api/signature-sessions"),
  SIGNATURE("api/signature");

  private String value;

  ApiRoutes(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ApiRoutes fromValue(String text) {
    for (ApiRoutes b : ApiRoutes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
