package com.lacunasoftware.restpkicore;

/**
 * ApiRoutes
 */
public enum ApiRoutes {
  APPLICATIONS("api/applications"),
  AUTHENTICATION("api/v2/authentication"),
  APPLICATION_KEYS("api/app-keys"),
  CADES_SIGNATURES("api/cades-signatures"),
  CERTIFICATES("api/certificates"),
  DOCUMENTS("api/documents"),
  DOCUMENT_KEYS("api/document-keys"),
  FILE_VALIDATION("api/file-validation"),
  FULL_XML_SIGNATURES("api/full-xml-signatures"),
  PADES_SIGNATURES("api/pades-signatures"),
  PADES_MERGE("api/pades-merge"),
  PDF_TIMESTAMP("api/pdf-timestamp"),
  SETTINGS("api/settings"),
  SIGNATURE_SESSION("api/signature-sessions"),
  SIGNATURE("api/signature"),
  TIMESTAMPS("api/timestamps"),
  XML_ELEMENT_SIGNATURES("api/xml-element-signatures"),
  BIO_SESSIONS("api/bio/sessions"),
  BIO_SUBJECTS("api/bio/subjects"),
;

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
