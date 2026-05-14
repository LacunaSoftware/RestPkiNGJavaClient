/*
 * Rest PKI Core API
 * <b><i>Para Português, <a href=\"https://docs.lacunasoftware.com/pt-br/articles/rest-pki/core/integration/get-started\">clique aqui</a></i></b>  <p>   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/\">Rest PKI Core</a> is an upcoming version of   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/\">Rest PKI</a> that will have extended compatibility with environments and databases.  </p>  <p>   In addition to Windows Server (which is already supported by Rest PKI), Rest PKI Core will also run on <b>Linux</b> (Debian- and RedHat-based distributions)   and on <b>Docker</b>. As for database servers, in addition to SQL Server, <b>PostgreSQL</b> will also be supported.  </p>  <p>   <b>Before getting started, see the integration overview on the <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/integration/\">Integration Guide</a></b>  </p>  <p>   For questions regarding the usage of this API, please reach us at <a href=\"https://lacuna.help/\">lacuna.help</a>  </p>    <h2>Parameters</h2>  <p>   You will need the following parameters:  </p>  <ul>   <li><b>Endpoint</b>: address of the Rest PKI Core instance that will be used</li>   <li><b>API Key</b>: authorization key for using the API</li>  </ul>  <p>   The <span class=\"model\">endpoint</span> must be prefixed to all relative URLs mentioned here. As for the <span class=\"model\">API Key</span>, see how to use it below.  </p>    <h2>Authentication</h2>  <p>   The API key must be sent on the <span class=\"model\">X-Api-Key</span> header on each request:  </p>    <!-- unfortunately, class \"example microlight\" doesn't seem to work here -->  <pre style=\"font-size: 12px; padding: 10px; border-radius: 4px; background: #41444e; font-weight: 600; color: #fff;\">  X-Api-Key: yourapp|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  </pre>    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response body is an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>    </tr>    <tr>     <td><strong class=\"model-title\">500 (Internal Server Error)</strong></td>     <td>An unexpected error occurred. The <span class=\"model\">exceptionCode</span> contained on the response body may be of help for our support team during diagnostic.</td>    </tr>   </tbody>  </table>    <h3>Error Codes</h3>    <p>   Some of the error codes returned in the <span class=\"model\">code</span> field of an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>   (body of responses with HTTP status code 422) are provided below*:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td class=\"model\">DocumentNotFound</td>     <td>A referenced document was not found (check the document ID)</td>    </tr>    <tr>     <td class=\"model\">SecurityContextNotFound</td>     <td>A referenced security context was not found (check the security context ID)</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionNotFound</td>     <td>A referenced signature session was not found (check the signature session ID)</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionOperation</td>     <td>The operation is invalid for the current signature session or document status. For instance, trying to await the session's completion if it is still <span class=\"model\">Pending</span> results in this error</td>    </tr>    <tr>     <td class=\"model\">BackgroundProcessing</td>     <td>The operation cannot be completed at this time because the resource is being processed in background</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionTokenRequired</td>     <td>The signature session token was not passed on the <span class=\"model\">X-Signature-Session-Token</span> request header</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionToken</td>     <td>An invalid signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Check your application for possible corruption of the session token, which may contain characters <span class=\"code\">-</span> (hyphen) and <span class=\"code\">_</span> (underscore)</td>    </tr>    <tr>     <td class=\"model\">ExpiredSignatureSessionToken</td>     <td>An expired signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Signature session tokens are normally valid for 4 hours.</td>    </tr>   </tbody>  </table>    <p style=\"font-size: 0.9em\">   *The codes shown above are the most common error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <h2>Culture / Internationalization (i18n)</h2>  <p>The <span class=\"model\">Accept-Language</span> request header is observed by this API. The following cultures are supported:</p>  <ul>   <li><span class=\"code\">en-US</span> (or simply <span class=\"code\">en</span>)</li>   <li><span class=\"code\">pt-BR</span> (or simply <span class=\"code\">pt</span>)</li>   <li><span class=\"code\">es-ES</span> (or simply <span class=\"code\">es</span>)</li>  </ul>  <p><i>Notice: error messages are not affected by this header and therefore should not be displayed to users, being better suited for logging.</i></p>  
 *
 * OpenAPI spec version: 4.2.1
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
import com.lacunasoftware.restpkicore.CertificateModel;
import com.lacunasoftware.restpkicore.SignatureSessionDocumentSummary;
import com.lacunasoftware.restpkicore.SignatureSessionStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
/**
 * SignatureSessionModel
 */




@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class SignatureSessionModel {
  @JsonProperty("processingErrorCode")
  private String processingErrorCode = null;

  @JsonProperty("callbackArgument")
  private String callbackArgument = null;

  @JsonProperty("signerCertificate")
  private CertificateModel signerCertificate = null;

  @JsonProperty("documents")
  private List<SignatureSessionDocumentSummary> documents = null;

  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("status")
  private SignatureSessionStatus status = null;

  @JsonProperty("subscriptionId")
  private UUID subscriptionId = null;

  @JsonProperty("dateCreated")
  private Date dateCreated = null;

  @JsonProperty("duration")
  private String duration = null;

  public SignatureSessionModel processingErrorCode(String processingErrorCode) {
    this.processingErrorCode = processingErrorCode;
    return this;
  }

   /**
   * If &#x60;Status&#x60; is &#x60;ProcessingError&#x60;, this contains a 6-character code suitable for logging that can be useful to correlate the issue when  asking for tech support
   * @return processingErrorCode
  **/
  @Schema(description = "If `Status` is `ProcessingError`, this contains a 6-character code suitable for logging that can be useful to correlate the issue when  asking for tech support")
  public String getProcessingErrorCode() {
    return processingErrorCode;
  }

  public void setProcessingErrorCode(String processingErrorCode) {
    this.processingErrorCode = processingErrorCode;
  }

  public SignatureSessionModel callbackArgument(String callbackArgument) {
    this.callbackArgument = callbackArgument;
    return this;
  }

   /**
   * The callback argument initially passed during creation of the session, containing any app-specific state of your choosing
   * @return callbackArgument
  **/
  @Schema(description = "The callback argument initially passed during creation of the session, containing any app-specific state of your choosing")
  public String getCallbackArgument() {
    return callbackArgument;
  }

  public void setCallbackArgument(String callbackArgument) {
    this.callbackArgument = callbackArgument;
  }

  public SignatureSessionModel signerCertificate(CertificateModel signerCertificate) {
    this.signerCertificate = signerCertificate;
    return this;
  }

   /**
   * Get signerCertificate
   * @return signerCertificate
  **/
  @Schema(description = "")
  public CertificateModel getSignerCertificate() {
    return signerCertificate;
  }

  public void setSignerCertificate(CertificateModel signerCertificate) {
    this.signerCertificate = signerCertificate;
  }

  public SignatureSessionModel documents(List<SignatureSessionDocumentSummary> documents) {
    this.documents = documents;
    return this;
  }

  public SignatureSessionModel addDocumentsItem(SignatureSessionDocumentSummary documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<>();
    }
    this.documents.add(documentsItem);
    return this;
  }

   /**
   * List of documents
   * @return documents
  **/
  @Schema(description = "List of documents")
  public List<SignatureSessionDocumentSummary> getDocuments() {
    return documents;
  }

  public void setDocuments(List<SignatureSessionDocumentSummary> documents) {
    this.documents = documents;
  }

  public SignatureSessionModel id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the signature session
   * @return id
  **/
  @Schema(description = "ID of the signature session")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SignatureSessionModel status(SignatureSessionStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(description = "")
  public SignatureSessionStatus getStatus() {
    return status;
  }

  public void setStatus(SignatureSessionStatus status) {
    this.status = status;
  }

  public SignatureSessionModel subscriptionId(UUID subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   * Subscription used to create the signature session
   * @return subscriptionId
  **/
  @Schema(description = "Subscription used to create the signature session")
  public UUID getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(UUID subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public SignatureSessionModel dateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

   /**
   * Date and time when the signature session was created
   * @return dateCreated
  **/
  @Schema(description = "Date and time when the signature session was created")
  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public SignatureSessionModel duration(String duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Time in milliseconds that the session took from the moment of creation until completion. If the session is still in progress, this  property is null
   * @return duration
  **/
  @Schema(description = "Time in milliseconds that the session took from the moment of creation until completion. If the session is still in progress, this  property is null")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureSessionModel signatureSessionModel = (SignatureSessionModel) o;
    return Objects.equals(this.processingErrorCode, signatureSessionModel.processingErrorCode) &&
        Objects.equals(this.callbackArgument, signatureSessionModel.callbackArgument) &&
        Objects.equals(this.signerCertificate, signatureSessionModel.signerCertificate) &&
        Objects.equals(this.documents, signatureSessionModel.documents) &&
        Objects.equals(this.id, signatureSessionModel.id) &&
        Objects.equals(this.status, signatureSessionModel.status) &&
        Objects.equals(this.subscriptionId, signatureSessionModel.subscriptionId) &&
        Objects.equals(this.dateCreated, signatureSessionModel.dateCreated) &&
        Objects.equals(this.duration, signatureSessionModel.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processingErrorCode, callbackArgument, signerCertificate, documents, id, status, subscriptionId, dateCreated, duration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureSessionModel {\n");
    
    sb.append("    processingErrorCode: ").append(toIndentedString(processingErrorCode)).append("\n");
    sb.append("    callbackArgument: ").append(toIndentedString(callbackArgument)).append("\n");
    sb.append("    signerCertificate: ").append(toIndentedString(signerCertificate)).append("\n");
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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
