package com.lacunasoftware.restpkicore;

/**
 * ApiRoutes
 */
public enum ApiRoutes {
  APPLICATIONS("api/applications"),
  AUTHENTICATION("api/v2/authentication"),
  APPLICATION_KEYS("api/app-keys"),
  CADES_SIGNATURES("Api/CadesSignatures"),
  CADES_SIGNATURES_V2("Api/v2/CadesSignatures"),
  CERTIFICATES("api/certificates"),
  DOCUMENTS("api/documents"),
  DOCUMENT_KEYS("api/document-keys"),
  FILE_VALIDATION("api/file-validation"),
  PADES_SIGNATURES("Api/PadesSignatures"),
  PADES_SIGNATURES_V2("Api/v2/PadesSignatures"),
  PADES_MERGE("api/pades-merge"),
  PDF_TIMESTAMP("api/pdf-timestamp"),
  SETTINGS("api/settings"),
  SIGNATURE_SESSION("api/signature-sessions"),
  SIGNATURE("api/signature"),
  TIMESTAMPS("api/timestamps"),
  XML_SIGNATURES("Api/XmlSignatures"),
  XML_SIGNATURES_V2("Api/v2/XmlSignatures"),
  @Deprecated
  FULL_XML_SIGNATURES("Api/XmlSignatures"),
  @Deprecated
  XML_ELEMENT_SIGNATURES("Api/XmlSignatures"),
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
