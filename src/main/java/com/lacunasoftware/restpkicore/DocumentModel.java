/*
 * Rest PKI Core API
 * <b><i>Para Português, <a href=\"https://docs.lacunasoftware.com/pt-br/articles/rest-pki/core/integration/get-started\">clique aqui</a></i></b>  <p>   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/\">Rest PKI Core</a> is an upcoming version of   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/\">Rest PKI</a> that will have extended compatibility with environments and databases.  </p>  <p>   In addition to Windows Server (which is already supported by Rest PKI), Rest PKI Core will also run on <b>Linux</b> (Debian- and RedHat-based distributions)   and on <b>Docker</b>. As for database servers, in addition to SQL Server, <b>PostgreSQL</b> will also be supported.  </p>  <p>   <b>Before getting started, see the integration overview on the <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/integration/\">Integration Guide</a></b>  </p>  <p>   For questions regarding the usage of this API, please reach us at <a href=\"https://lacuna.help/\">lacuna.help</a>  </p>    <h2>Parameters</h2>  <p>   You will need the following parameters:  </p>  <ul>   <li><b>Endpoint</b>: address of the Rest PKI Core instance that will be used</li>   <li><b>API Key</b>: authorization key for using the API</li>  </ul>  <p>   The <span class=\"model\">endpoint</span> must be prefixed to all relative URLs mentioned here. As for the <span class=\"model\">API Key</span>, see how to use it below.  </p>    <h2>Authentication</h2>  <p>   The API key must be sent on the <span class=\"model\">X-Api-Key</span> header on each request:  </p>    <!-- unfortunately, class \"example microlight\" doesn't seem to work here -->  <pre style=\"font-size: 12px; padding: 10px; border-radius: 4px; background: #41444e; font-weight: 600; color: #fff;\">  X-Api-Key: yourapp|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  </pre>    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response body is an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>    </tr>    <tr>     <td><strong class=\"model-title\">500 (Internal Server Error)</strong></td>     <td>An unexpected error occurred. The <span class=\"model\">exceptionCode</span> contained on the response body may be of help for our support team during diagnostic.</td>    </tr>   </tbody>  </table>    <h3>Error Codes</h3>    <p>   Some of the error codes returned in the <span class=\"model\">code</span> field of an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>   (body of responses with HTTP status code 422) are provided below*:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td class=\"model\">DocumentNotFound</td>     <td>A referenced document was not found (check the document ID)</td>    </tr>    <tr>     <td class=\"model\">SecurityContextNotFound</td>     <td>A referenced security context was not found (check the security context ID)</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionNotFound</td>     <td>A referenced signature session was not found (check the signature session ID)</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionOperation</td>     <td>The operation is invalid for the current signature session or document status. For instance, trying to await the session's completion if it is still <span class=\"model\">Pending</span> results in this error</td>    </tr>    <tr>     <td class=\"model\">BackgroundProcessing</td>     <td>The operation cannot be completed at this time because the resource is being processed in background</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionTokenRequired</td>     <td>The signature session token was not passed on the <span class=\"model\">X-Signature-Session-Token</span> request header</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionToken</td>     <td>An invalid signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Check your application for possible corruption of the session token, which may contain characters <span class=\"code\">-</span> (hyphen) and <span class=\"code\">_</span> (underscore)</td>    </tr>    <tr>     <td class=\"model\">ExpiredSignatureSessionToken</td>     <td>An expired signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Signature session tokens are normally valid for 4 hours.</td>    </tr>   </tbody>  </table>    <p style=\"font-size: 0.9em\">   *The codes shown above are the most common error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <h2>Culture / Internationalization (i18n)</h2>  <p>The <span class=\"model\">Accept-Language</span> request header is observed by this API. The following cultures are supported:</p>  <ul>   <li><span class=\"code\">en-US</span> (or simply <span class=\"code\">en</span>)</li>   <li><span class=\"code\">pt-BR</span> (or simply <span class=\"code\">pt</span>)</li>  </ul>  <p><i>Notice: error messages are not affected by this header and therefore should not be displayed to users, being better suited for logging.</i></p>  
 *
 * OpenAPI spec version: 1.10.0 Beta 1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.lacunasoftware.restpkicore;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lacunasoftware.restpkicore.DocumentFileModel;
import com.lacunasoftware.restpkicore.SignatureTypes;
import com.lacunasoftware.restpkicore.SignerSummary;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * DocumentModel
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-04-13T10:50:43.275-03:00[America/Sao_Paulo]")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
class DocumentModel {
  @JsonProperty("signers")
  private List<SignerSummary> signers = null;

  @JsonProperty("metadata")
  private Map<String, List<String>> metadata = null;

  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("key")
  private String key = null;

  @JsonProperty("formattedKey")
  private String formattedKey = null;

  @JsonProperty("originalFile")
  private DocumentFileModel originalFile = null;

  @JsonProperty("markedFile")
  private DocumentFileModel markedFile = null;

  @JsonProperty("signedFile")
  private DocumentFileModel signedFile = null;

  @JsonProperty("signatureType")
  private SignatureTypes signatureType = null;

  @JsonProperty("availableUntil")
  private Date availableUntil = null;

  public DocumentModel signers(List<SignerSummary> signers) {
    this.signers = signers;
    return this;
  }

  public DocumentModel addSignersItem(SignerSummary signersItem) {
    if (this.signers == null) {
      this.signers = new ArrayList<>();
    }
    this.signers.add(signersItem);
    return this;
  }

   /**
   * Get signers
   * @return signers
  **/
  @Schema(description = "")
  public List<SignerSummary> getSigners() {
    return signers;
  }

  public void setSigners(List<SignerSummary> signers) {
    this.signers = signers;
  }

  public DocumentModel metadata(Map<String, List<String>> metadata) {
    this.metadata = metadata;
    return this;
  }

  public DocumentModel putMetadataItem(String key, List<String> metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @Schema(description = "")
  public Map<String, List<String>> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, List<String>> metadata) {
    this.metadata = metadata;
  }

  public DocumentModel id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DocumentModel key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @Schema(description = "")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public DocumentModel formattedKey(String formattedKey) {
    this.formattedKey = formattedKey;
    return this;
  }

   /**
   * Get formattedKey
   * @return formattedKey
  **/
  @Schema(description = "")
  public String getFormattedKey() {
    return formattedKey;
  }

  public void setFormattedKey(String formattedKey) {
    this.formattedKey = formattedKey;
  }

  public DocumentModel originalFile(DocumentFileModel originalFile) {
    this.originalFile = originalFile;
    return this;
  }

   /**
   * Get originalFile
   * @return originalFile
  **/
  @Schema(description = "")
  public DocumentFileModel getOriginalFile() {
    return originalFile;
  }

  public void setOriginalFile(DocumentFileModel originalFile) {
    this.originalFile = originalFile;
  }

  public DocumentModel markedFile(DocumentFileModel markedFile) {
    this.markedFile = markedFile;
    return this;
  }

   /**
   * Get markedFile
   * @return markedFile
  **/
  @Schema(description = "")
  public DocumentFileModel getMarkedFile() {
    return markedFile;
  }

  public void setMarkedFile(DocumentFileModel markedFile) {
    this.markedFile = markedFile;
  }

  public DocumentModel signedFile(DocumentFileModel signedFile) {
    this.signedFile = signedFile;
    return this;
  }

   /**
   * Get signedFile
   * @return signedFile
  **/
  @Schema(description = "")
  public DocumentFileModel getSignedFile() {
    return signedFile;
  }

  public void setSignedFile(DocumentFileModel signedFile) {
    this.signedFile = signedFile;
  }

  public DocumentModel signatureType(SignatureTypes signatureType) {
    this.signatureType = signatureType;
    return this;
  }

   /**
   * Get signatureType
   * @return signatureType
  **/
  @Schema(description = "")
  public SignatureTypes getSignatureType() {
    return signatureType;
  }

  public void setSignatureType(SignatureTypes signatureType) {
    this.signatureType = signatureType;
  }

  public DocumentModel availableUntil(Date availableUntil) {
    this.availableUntil = availableUntil;
    return this;
  }

   /**
   * Get availableUntil
   * @return availableUntil
  **/
  @Schema(description = "")
  public Date getAvailableUntil() {
    return availableUntil;
  }

  public void setAvailableUntil(Date availableUntil) {
    this.availableUntil = availableUntil;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentModel documentModel = (DocumentModel) o;
    return Objects.equals(this.signers, documentModel.signers) &&
        Objects.equals(this.metadata, documentModel.metadata) &&
        Objects.equals(this.id, documentModel.id) &&
        Objects.equals(this.key, documentModel.key) &&
        Objects.equals(this.formattedKey, documentModel.formattedKey) &&
        Objects.equals(this.originalFile, documentModel.originalFile) &&
        Objects.equals(this.markedFile, documentModel.markedFile) &&
        Objects.equals(this.signedFile, documentModel.signedFile) &&
        Objects.equals(this.signatureType, documentModel.signatureType) &&
        Objects.equals(this.availableUntil, documentModel.availableUntil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signers, metadata, id, key, formattedKey, originalFile, markedFile, signedFile, signatureType, availableUntil);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentModel {\n");
    
    sb.append("    signers: ").append(toIndentedString(signers)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    formattedKey: ").append(toIndentedString(formattedKey)).append("\n");
    sb.append("    originalFile: ").append(toIndentedString(originalFile)).append("\n");
    sb.append("    markedFile: ").append(toIndentedString(markedFile)).append("\n");
    sb.append("    signedFile: ").append(toIndentedString(signedFile)).append("\n");
    sb.append("    signatureType: ").append(toIndentedString(signatureType)).append("\n");
    sb.append("    availableUntil: ").append(toIndentedString(availableUntil)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
