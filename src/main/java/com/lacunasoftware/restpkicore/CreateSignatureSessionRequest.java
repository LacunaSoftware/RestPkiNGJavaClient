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
import com.lacunasoftware.restpkicore.CertificateRequirement;
import com.lacunasoftware.restpkicore.SignatureSessionDocumentData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * CreateSignatureSessionRequest
 */



@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSignatureSessionRequest {
  @JsonProperty("returnUrl")
  private String returnUrl = null;

  @JsonProperty("securityContextId")
  private UUID securityContextId = null;

  @JsonProperty("callbackArgument")
  private String callbackArgument = null;

  @JsonProperty("enableBackgroundProcessing")
  private Boolean enableBackgroundProcessing = null;

  @JsonProperty("disableDownloads")
  private Boolean disableDownloads = null;

  @JsonProperty("documentMetadata")
  private Map<String, List<String>> documentMetadata = null;

  @JsonProperty("documents")
  private List<SignatureSessionDocumentData> documents = null;

  @JsonProperty("certificateRequirements")
  private List<CertificateRequirement> certificateRequirements = null;

  public CreateSignatureSessionRequest returnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
    return this;
  }

   /**
   * Get returnUrl
   * @return returnUrl
  **/
  @Schema(description = "")
  public String getReturnUrl() {
    return returnUrl;
  }

  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public CreateSignatureSessionRequest securityContextId(UUID securityContextId) {
    this.securityContextId = securityContextId;
    return this;
  }

   /**
   * Get securityContextId
   * @return securityContextId
  **/
  @Schema(description = "")
  public UUID getSecurityContextId() {
    return securityContextId;
  }

  public void setSecurityContextId(UUID securityContextId) {
    this.securityContextId = securityContextId;
  }

  public CreateSignatureSessionRequest callbackArgument(String callbackArgument) {
    this.callbackArgument = callbackArgument;
    return this;
  }

   /**
   * Get callbackArgument
   * @return callbackArgument
  **/
  @Schema(description = "")
  public String getCallbackArgument() {
    return callbackArgument;
  }

  public void setCallbackArgument(String callbackArgument) {
    this.callbackArgument = callbackArgument;
  }

  public CreateSignatureSessionRequest enableBackgroundProcessing(Boolean enableBackgroundProcessing) {
    this.enableBackgroundProcessing = enableBackgroundProcessing;
    return this;
  }

   /**
   * Get enableBackgroundProcessing
   * @return enableBackgroundProcessing
  **/
  @Schema(description = "")
  public Boolean isEnableBackgroundProcessing() {
    return enableBackgroundProcessing;
  }

  public void setEnableBackgroundProcessing(Boolean enableBackgroundProcessing) {
    this.enableBackgroundProcessing = enableBackgroundProcessing;
  }

  public CreateSignatureSessionRequest disableDownloads(Boolean disableDownloads) {
    this.disableDownloads = disableDownloads;
    return this;
  }

   /**
   * Get disableDownloads
   * @return disableDownloads
  **/
  @Schema(description = "")
  public Boolean isDisableDownloads() {
    return disableDownloads;
  }

  public void setDisableDownloads(Boolean disableDownloads) {
    this.disableDownloads = disableDownloads;
  }

  public CreateSignatureSessionRequest documentMetadata(Map<String, List<String>> documentMetadata) {
    this.documentMetadata = documentMetadata;
    return this;
  }

  public CreateSignatureSessionRequest putDocumentMetadataItem(String key, List<String> documentMetadataItem) {
    if (this.documentMetadata == null) {
      this.documentMetadata = new HashMap<>();
    }
    this.documentMetadata.put(key, documentMetadataItem);
    return this;
  }

   /**
   * Get documentMetadata
   * @return documentMetadata
  **/
  @Schema(description = "")
  public Map<String, List<String>> getDocumentMetadata() {
    return documentMetadata;
  }

  public void setDocumentMetadata(Map<String, List<String>> documentMetadata) {
    this.documentMetadata = documentMetadata;
  }

  public CreateSignatureSessionRequest documents(List<SignatureSessionDocumentData> documents) {
    this.documents = documents;
    return this;
  }

  public CreateSignatureSessionRequest addDocumentsItem(SignatureSessionDocumentData documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<>();
    }
    this.documents.add(documentsItem);
    return this;
  }

   /**
   * Get documents
   * @return documents
  **/
  @Schema(description = "")
  public List<SignatureSessionDocumentData> getDocuments() {
    return documents;
  }

  public void setDocuments(List<SignatureSessionDocumentData> documents) {
    this.documents = documents;
  }

  public CreateSignatureSessionRequest certificateRequirements(List<CertificateRequirement> certificateRequirements) {
    this.certificateRequirements = certificateRequirements;
    return this;
  }

  public CreateSignatureSessionRequest addCertificateRequirementsItem(CertificateRequirement certificateRequirementsItem) {
    if (this.certificateRequirements == null) {
      this.certificateRequirements = new ArrayList<>();
    }
    this.certificateRequirements.add(certificateRequirementsItem);
    return this;
  }

   /**
   * Get certificateRequirements
   * @return certificateRequirements
  **/
  @Schema(description = "")
  public List<CertificateRequirement> getCertificateRequirements() {
    return certificateRequirements;
  }

  public void setCertificateRequirements(List<CertificateRequirement> certificateRequirements) {
    this.certificateRequirements = certificateRequirements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSignatureSessionRequest createSignatureSessionRequest = (CreateSignatureSessionRequest) o;
    return Objects.equals(this.returnUrl, createSignatureSessionRequest.returnUrl) &&
        Objects.equals(this.securityContextId, createSignatureSessionRequest.securityContextId) &&
        Objects.equals(this.callbackArgument, createSignatureSessionRequest.callbackArgument) &&
        Objects.equals(this.enableBackgroundProcessing, createSignatureSessionRequest.enableBackgroundProcessing) &&
        Objects.equals(this.disableDownloads, createSignatureSessionRequest.disableDownloads) &&
        Objects.equals(this.documentMetadata, createSignatureSessionRequest.documentMetadata) &&
        Objects.equals(this.documents, createSignatureSessionRequest.documents) &&
        Objects.equals(this.certificateRequirements, createSignatureSessionRequest.certificateRequirements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(returnUrl, securityContextId, callbackArgument, enableBackgroundProcessing, disableDownloads, documentMetadata, documents, certificateRequirements);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSignatureSessionRequest {\n");
    
    sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
    sb.append("    securityContextId: ").append(toIndentedString(securityContextId)).append("\n");
    sb.append("    callbackArgument: ").append(toIndentedString(callbackArgument)).append("\n");
    sb.append("    enableBackgroundProcessing: ").append(toIndentedString(enableBackgroundProcessing)).append("\n");
    sb.append("    disableDownloads: ").append(toIndentedString(disableDownloads)).append("\n");
    sb.append("    documentMetadata: ").append(toIndentedString(documentMetadata)).append("\n");
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("    certificateRequirements: ").append(toIndentedString(certificateRequirements)).append("\n");
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
