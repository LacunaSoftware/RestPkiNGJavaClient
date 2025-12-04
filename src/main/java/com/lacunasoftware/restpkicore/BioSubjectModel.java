/*
 * Rest PKI Core API
 * <b><i>Para Português, <a href=\"https://docs.lacunasoftware.com/pt-br/articles/rest-pki/core/integration/get-started\">clique aqui</a></i></b>  <p>   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/\">Rest PKI Core</a> is an upcoming version of   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/\">Rest PKI</a> that will have extended compatibility with environments and databases.  </p>  <p>   In addition to Windows Server (which is already supported by Rest PKI), Rest PKI Core will also run on <b>Linux</b> (Debian- and RedHat-based distributions)   and on <b>Docker</b>. As for database servers, in addition to SQL Server, <b>PostgreSQL</b> will also be supported.  </p>  <p>   <b>Before getting started, see the integration overview on the <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/integration/\">Integration Guide</a></b>  </p>  <p>   For questions regarding the usage of this API, please reach us at <a href=\"https://lacuna.help/\">lacuna.help</a>  </p>    <h2>Parameters</h2>  <p>   You will need the following parameters:  </p>  <ul>   <li><b>Endpoint</b>: address of the Rest PKI Core instance that will be used</li>   <li><b>API Key</b>: authorization key for using the API</li>  </ul>  <p>   The <span class=\"model\">endpoint</span> must be prefixed to all relative URLs mentioned here. As for the <span class=\"model\">API Key</span>, see how to use it below.  </p>    <h2>Authentication</h2>  <p>   The API key must be sent on the <span class=\"model\">X-Api-Key</span> header on each request:  </p>    <!-- unfortunately, class \"example microlight\" doesn't seem to work here -->  <pre style=\"font-size: 12px; padding: 10px; border-radius: 4px; background: #41444e; font-weight: 600; color: #fff;\">  X-Api-Key: yourapp|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  </pre>    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response body is an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>    </tr>    <tr>     <td><strong class=\"model-title\">500 (Internal Server Error)</strong></td>     <td>An unexpected error occurred. The <span class=\"model\">exceptionCode</span> contained on the response body may be of help for our support team during diagnostic.</td>    </tr>   </tbody>  </table>    <h3>Error Codes</h3>    <p>   Some of the error codes returned in the <span class=\"model\">code</span> field of an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>   (body of responses with HTTP status code 422) are provided below*:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td class=\"model\">DocumentNotFound</td>     <td>A referenced document was not found (check the document ID)</td>    </tr>    <tr>     <td class=\"model\">SecurityContextNotFound</td>     <td>A referenced security context was not found (check the security context ID)</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionNotFound</td>     <td>A referenced signature session was not found (check the signature session ID)</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionOperation</td>     <td>The operation is invalid for the current signature session or document status. For instance, trying to await the session's completion if it is still <span class=\"model\">Pending</span> results in this error</td>    </tr>    <tr>     <td class=\"model\">BackgroundProcessing</td>     <td>The operation cannot be completed at this time because the resource is being processed in background</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionTokenRequired</td>     <td>The signature session token was not passed on the <span class=\"model\">X-Signature-Session-Token</span> request header</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionToken</td>     <td>An invalid signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Check your application for possible corruption of the session token, which may contain characters <span class=\"code\">-</span> (hyphen) and <span class=\"code\">_</span> (underscore)</td>    </tr>    <tr>     <td class=\"model\">ExpiredSignatureSessionToken</td>     <td>An expired signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Signature session tokens are normally valid for 4 hours.</td>    </tr>   </tbody>  </table>    <p style=\"font-size: 0.9em\">   *The codes shown above are the most common error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <h2>Culture / Internationalization (i18n)</h2>  <p>The <span class=\"model\">Accept-Language</span> request header is observed by this API. The following cultures are supported:</p>  <ul>   <li><span class=\"code\">en-US</span> (or simply <span class=\"code\">en</span>)</li>   <li><span class=\"code\">pt-BR</span> (or simply <span class=\"code\">pt</span>)</li>   <li><span class=\"code\">es-ES</span> (or simply <span class=\"code\">es</span>)</li>  </ul>  <p><i>Notice: error messages are not affected by this header and therefore should not be displayed to users, being better suited for logging.</i></p>  
 *
 * OpenAPI spec version: 3.8.0
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
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.UUID;
/**
 * BioSubjectModel
 */




@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class BioSubjectModel {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("subscriptionId")
  private UUID subscriptionId = null;

  @JsonProperty("identifier")
  private String identifier = null;

  @JsonProperty("hasIdentificationDocument")
  private Boolean hasIdentificationDocument = null;

  @JsonProperty("dateCreated")
  private Date dateCreated = null;

  @JsonProperty("currentFaceId")
  private UUID currentFaceId = null;

  @JsonProperty("currentIdentificationDocumentId")
  private UUID currentIdentificationDocumentId = null;

  @JsonProperty("identificationDocumentMatchedFace")
  private Boolean identificationDocumentMatchedFace = null;

  @JsonProperty("currentFaceTecSubjectId")
  private UUID currentFaceTecSubjectId = null;

  public BioSubjectModel id(UUID id) {
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

  public BioSubjectModel subscriptionId(UUID subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   * Get subscriptionId
   * @return subscriptionId
  **/
  @Schema(description = "")
  public UUID getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(UUID subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public BioSubjectModel identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

   /**
   * Get identifier
   * @return identifier
  **/
  @Schema(description = "")
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public BioSubjectModel hasIdentificationDocument(Boolean hasIdentificationDocument) {
    this.hasIdentificationDocument = hasIdentificationDocument;
    return this;
  }

   /**
   * Get hasIdentificationDocument
   * @return hasIdentificationDocument
  **/
  @Schema(description = "")
  public Boolean isHasIdentificationDocument() {
    return hasIdentificationDocument;
  }

  public void setHasIdentificationDocument(Boolean hasIdentificationDocument) {
    this.hasIdentificationDocument = hasIdentificationDocument;
  }

  public BioSubjectModel dateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

   /**
   * Get dateCreated
   * @return dateCreated
  **/
  @Schema(description = "")
  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public BioSubjectModel currentFaceId(UUID currentFaceId) {
    this.currentFaceId = currentFaceId;
    return this;
  }

   /**
   * Get currentFaceId
   * @return currentFaceId
  **/
  @Schema(description = "")
  public UUID getCurrentFaceId() {
    return currentFaceId;
  }

  public void setCurrentFaceId(UUID currentFaceId) {
    this.currentFaceId = currentFaceId;
  }

  public BioSubjectModel currentIdentificationDocumentId(UUID currentIdentificationDocumentId) {
    this.currentIdentificationDocumentId = currentIdentificationDocumentId;
    return this;
  }

   /**
   * Get currentIdentificationDocumentId
   * @return currentIdentificationDocumentId
  **/
  @Schema(description = "")
  public UUID getCurrentIdentificationDocumentId() {
    return currentIdentificationDocumentId;
  }

  public void setCurrentIdentificationDocumentId(UUID currentIdentificationDocumentId) {
    this.currentIdentificationDocumentId = currentIdentificationDocumentId;
  }

  public BioSubjectModel identificationDocumentMatchedFace(Boolean identificationDocumentMatchedFace) {
    this.identificationDocumentMatchedFace = identificationDocumentMatchedFace;
    return this;
  }

   /**
   * Get identificationDocumentMatchedFace
   * @return identificationDocumentMatchedFace
  **/
  @Schema(description = "")
  public Boolean isIdentificationDocumentMatchedFace() {
    return identificationDocumentMatchedFace;
  }

  public void setIdentificationDocumentMatchedFace(Boolean identificationDocumentMatchedFace) {
    this.identificationDocumentMatchedFace = identificationDocumentMatchedFace;
  }

  public BioSubjectModel currentFaceTecSubjectId(UUID currentFaceTecSubjectId) {
    this.currentFaceTecSubjectId = currentFaceTecSubjectId;
    return this;
  }

   /**
   * Get currentFaceTecSubjectId
   * @return currentFaceTecSubjectId
  **/
  @Schema(description = "")
  public UUID getCurrentFaceTecSubjectId() {
    return currentFaceTecSubjectId;
  }

  public void setCurrentFaceTecSubjectId(UUID currentFaceTecSubjectId) {
    this.currentFaceTecSubjectId = currentFaceTecSubjectId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BioSubjectModel bioSubjectModel = (BioSubjectModel) o;
    return Objects.equals(this.id, bioSubjectModel.id) &&
        Objects.equals(this.subscriptionId, bioSubjectModel.subscriptionId) &&
        Objects.equals(this.identifier, bioSubjectModel.identifier) &&
        Objects.equals(this.hasIdentificationDocument, bioSubjectModel.hasIdentificationDocument) &&
        Objects.equals(this.dateCreated, bioSubjectModel.dateCreated) &&
        Objects.equals(this.currentFaceId, bioSubjectModel.currentFaceId) &&
        Objects.equals(this.currentIdentificationDocumentId, bioSubjectModel.currentIdentificationDocumentId) &&
        Objects.equals(this.identificationDocumentMatchedFace, bioSubjectModel.identificationDocumentMatchedFace) &&
        Objects.equals(this.currentFaceTecSubjectId, bioSubjectModel.currentFaceTecSubjectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subscriptionId, identifier, hasIdentificationDocument, dateCreated, currentFaceId, currentIdentificationDocumentId, identificationDocumentMatchedFace, currentFaceTecSubjectId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BioSubjectModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    hasIdentificationDocument: ").append(toIndentedString(hasIdentificationDocument)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    currentFaceId: ").append(toIndentedString(currentFaceId)).append("\n");
    sb.append("    currentIdentificationDocumentId: ").append(toIndentedString(currentIdentificationDocumentId)).append("\n");
    sb.append("    identificationDocumentMatchedFace: ").append(toIndentedString(identificationDocumentMatchedFace)).append("\n");
    sb.append("    currentFaceTecSubjectId: ").append(toIndentedString(currentFaceTecSubjectId)).append("\n");
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
