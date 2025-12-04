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
import com.lacunasoftware.restpkicore.CadesSignerModel;
import com.lacunasoftware.restpkicore.CmsContentTypes;
import com.lacunasoftware.restpkicore.DigestAlgorithmAndValueModel;
import com.lacunasoftware.restpkicore.FileModel;
import com.lacunasoftware.restpkicore.SignatureBStampModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * CadesTimestampModel
 */




@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class CadesTimestampModel {
  @JsonProperty("genTime")
  private Date genTime = null;

  @JsonProperty("serialNumber")
  private String serialNumber = null;

  @JsonProperty("messageImprint")
  private DigestAlgorithmAndValueModel messageImprint = null;

  @JsonProperty("encapsulatedContentType")
  private CmsContentTypes encapsulatedContentType = null;

  @JsonProperty("hasEncapsulatedContent")
  private Boolean hasEncapsulatedContent = null;

  @JsonProperty("signers")
  private List<CadesSignerModel> signers = null;

  @JsonProperty("encapsulatedContent")
  private FileModel encapsulatedContent = null;

  @JsonProperty("auditPackage")
  private FileModel auditPackage = null;

  @JsonProperty("bStamp")
  private SignatureBStampModel bStamp = null;

  public CadesTimestampModel genTime(Date genTime) {
    this.genTime = genTime;
    return this;
  }

   /**
   * Get genTime
   * @return genTime
  **/
  @Schema(description = "")
  public Date getGenTime() {
    return genTime;
  }

  public void setGenTime(Date genTime) {
    this.genTime = genTime;
  }

  public CadesTimestampModel serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

   /**
   * Get serialNumber
   * @return serialNumber
  **/
  @Schema(description = "")
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public CadesTimestampModel messageImprint(DigestAlgorithmAndValueModel messageImprint) {
    this.messageImprint = messageImprint;
    return this;
  }

   /**
   * Get messageImprint
   * @return messageImprint
  **/
  @Schema(description = "")
  public DigestAlgorithmAndValueModel getMessageImprint() {
    return messageImprint;
  }

  public void setMessageImprint(DigestAlgorithmAndValueModel messageImprint) {
    this.messageImprint = messageImprint;
  }

  public CadesTimestampModel encapsulatedContentType(CmsContentTypes encapsulatedContentType) {
    this.encapsulatedContentType = encapsulatedContentType;
    return this;
  }

   /**
   * Get encapsulatedContentType
   * @return encapsulatedContentType
  **/
  @Schema(description = "")
  public CmsContentTypes getEncapsulatedContentType() {
    return encapsulatedContentType;
  }

  public void setEncapsulatedContentType(CmsContentTypes encapsulatedContentType) {
    this.encapsulatedContentType = encapsulatedContentType;
  }

  public CadesTimestampModel hasEncapsulatedContent(Boolean hasEncapsulatedContent) {
    this.hasEncapsulatedContent = hasEncapsulatedContent;
    return this;
  }

   /**
   * Get hasEncapsulatedContent
   * @return hasEncapsulatedContent
  **/
  @Schema(description = "")
  public Boolean isHasEncapsulatedContent() {
    return hasEncapsulatedContent;
  }

  public void setHasEncapsulatedContent(Boolean hasEncapsulatedContent) {
    this.hasEncapsulatedContent = hasEncapsulatedContent;
  }

  public CadesTimestampModel signers(List<CadesSignerModel> signers) {
    this.signers = signers;
    return this;
  }

  public CadesTimestampModel addSignersItem(CadesSignerModel signersItem) {
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
  public List<CadesSignerModel> getSigners() {
    return signers;
  }

  public void setSigners(List<CadesSignerModel> signers) {
    this.signers = signers;
  }

  public CadesTimestampModel encapsulatedContent(FileModel encapsulatedContent) {
    this.encapsulatedContent = encapsulatedContent;
    return this;
  }

   /**
   * Get encapsulatedContent
   * @return encapsulatedContent
  **/
  @Schema(description = "")
  public FileModel getEncapsulatedContent() {
    return encapsulatedContent;
  }

  public void setEncapsulatedContent(FileModel encapsulatedContent) {
    this.encapsulatedContent = encapsulatedContent;
  }

  public CadesTimestampModel auditPackage(FileModel auditPackage) {
    this.auditPackage = auditPackage;
    return this;
  }

   /**
   * Get auditPackage
   * @return auditPackage
  **/
  @Schema(description = "")
  public FileModel getAuditPackage() {
    return auditPackage;
  }

  public void setAuditPackage(FileModel auditPackage) {
    this.auditPackage = auditPackage;
  }

  public CadesTimestampModel bStamp(SignatureBStampModel bStamp) {
    this.bStamp = bStamp;
    return this;
  }

   /**
   * Get bStamp
   * @return bStamp
  **/
  @Schema(description = "")
  public SignatureBStampModel getBStamp() {
    return bStamp;
  }

  public void setBStamp(SignatureBStampModel bStamp) {
    this.bStamp = bStamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CadesTimestampModel cadesTimestampModel = (CadesTimestampModel) o;
    return Objects.equals(this.genTime, cadesTimestampModel.genTime) &&
        Objects.equals(this.serialNumber, cadesTimestampModel.serialNumber) &&
        Objects.equals(this.messageImprint, cadesTimestampModel.messageImprint) &&
        Objects.equals(this.encapsulatedContentType, cadesTimestampModel.encapsulatedContentType) &&
        Objects.equals(this.hasEncapsulatedContent, cadesTimestampModel.hasEncapsulatedContent) &&
        Objects.equals(this.signers, cadesTimestampModel.signers) &&
        Objects.equals(this.encapsulatedContent, cadesTimestampModel.encapsulatedContent) &&
        Objects.equals(this.auditPackage, cadesTimestampModel.auditPackage) &&
        Objects.equals(this.bStamp, cadesTimestampModel.bStamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genTime, serialNumber, messageImprint, encapsulatedContentType, hasEncapsulatedContent, signers, encapsulatedContent, auditPackage, bStamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CadesTimestampModel {\n");
    
    sb.append("    genTime: ").append(toIndentedString(genTime)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    messageImprint: ").append(toIndentedString(messageImprint)).append("\n");
    sb.append("    encapsulatedContentType: ").append(toIndentedString(encapsulatedContentType)).append("\n");
    sb.append("    hasEncapsulatedContent: ").append(toIndentedString(hasEncapsulatedContent)).append("\n");
    sb.append("    signers: ").append(toIndentedString(signers)).append("\n");
    sb.append("    encapsulatedContent: ").append(toIndentedString(encapsulatedContent)).append("\n");
    sb.append("    auditPackage: ").append(toIndentedString(auditPackage)).append("\n");
    sb.append("    bStamp: ").append(toIndentedString(bStamp)).append("\n");
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
