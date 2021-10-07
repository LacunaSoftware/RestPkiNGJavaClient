/*
 * Rest PKI Core API
 * <b><i>Para Português, <a href=\"https://docs.lacunasoftware.com/pt-br/articles/rest-pki/core/integration/get-started\">clique aqui</a></i></b>  <p>   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/\">Rest PKI Core</a> is an upcoming version of   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/\">Rest PKI</a> that will have extended compatibility with environments and databases.  </p>  <p>   In addition to Windows Server (which is already supported by Rest PKI), Rest PKI Core will also run on <b>Linux</b> (Debian- and RedHat-based distributions)   and on <b>Docker</b>. As for database servers, in addition to SQL Server, <b>PostgreSQL</b> will also be supported.  </p>  <p>   <b>Before getting started, see the integration overview on the <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/integration/\">Integration Guide</a></b>  </p>  <p>   For questions regarding the usage of this API, please reach us at <a href=\"https://lacuna.help/\">lacuna.help</a>  </p>    <h2>Parameters</h2>  <p>   You will need the following parameters:  </p>  <ul>   <li><b>Endpoint</b>: address of the Rest PKI Core instance that will be used</li>   <li><b>API Key</b>: authorization key for using the API</li>  </ul>  <p>   The <span class=\"model\">endpoint</span> must be prefixed to all relative URLs mentioned here. As for the <span class=\"model\">API Key</span>, see how to use it below.  </p>    <h2>Authentication</h2>  <p>   The API key must be sent on the <span class=\"model\">X-Api-Key</span> header on each request:  </p>    <!-- unfortunately, class \"example microlight\" doesn't seem to work here -->  <pre style=\"font-size: 12px; padding: 10px; border-radius: 4px; background: #41444e; font-weight: 600; color: #fff;\">  X-Api-Key: yourapp|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  </pre>    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response body is an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>    </tr>    <tr>     <td><strong class=\"model-title\">500 (Internal Server Error)</strong></td>     <td>An unexpected error occurred. The <span class=\"model\">exceptionCode</span> contained on the response body may be of help for our support team during diagnostic.</td>    </tr>   </tbody>  </table>    <h3>Error Codes</h3>    <p>   Some of the error codes returned in the <span class=\"model\">code</span> field of an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>   (body of responses with HTTP status code 422) are provided below*:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td class=\"model\">DocumentNotFound</td>     <td>A referenced document was not found (check the document ID)</td>    </tr>    <tr>     <td class=\"model\">SecurityContextNotFound</td>     <td>A referenced security context was not found (check the security context ID)</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionNotFound</td>     <td>A referenced signature session was not found (check the signature session ID)</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionOperation</td>     <td>The operation is invalid for the current signature session or document status. For instance, trying to await the session's completion if it is still <span class=\"model\">Pending</span> results in this error</td>    </tr>    <tr>     <td class=\"model\">BackgroundProcessing</td>     <td>The operation cannot be completed at this time because the resource is being processed in background</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionTokenRequired</td>     <td>The signature session token was not passed on the <span class=\"model\">X-Signature-Session-Token</span> request header</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionToken</td>     <td>An invalid signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Check your application for possible corruption of the session token, which may contain characters <span class=\"code\">-</span> (hyphen) and <span class=\"code\">_</span> (underscore)</td>    </tr>    <tr>     <td class=\"model\">ExpiredSignatureSessionToken</td>     <td>An expired signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Signature session tokens are normally valid for 4 hours.</td>    </tr>   </tbody>  </table>    <p style=\"font-size: 0.9em\">   *The codes shown above are the most common error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <h2>Culture / Internationalization (i18n)</h2>  <p>The <span class=\"model\">Accept-Language</span> request header is observed by this API. The following cultures are supported:</p>  <ul>   <li><span class=\"code\">en-US</span> (or simply <span class=\"code\">en</span>)</li>   <li><span class=\"code\">pt-BR</span> (or simply <span class=\"code\">pt</span>)</li>  </ul>  <p><i>Notice: error messages are not affected by this header and therefore should not be displayed to users, being better suited for logging.</i></p>  
 *
 * OpenAPI spec version: 1.5.0 RTM
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.lacunasoftware.restpkicore;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
/**
 * SignerModel
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-10-06T21:56:19.611140200-03:00[America/Sao_Paulo]")
public class SignerModel {
  @JsonProperty("messageDigest")
  private DigestAlgorithmAndValueModel messageDigest = null;

  @JsonProperty("signature")
  private SignatureAlgorithmAndValueModel signature = null;

  @JsonProperty("signingTime")
  private Date signingTime = null;

  @JsonProperty("certifiedDateReference")
  private Date certifiedDateReference = null;

  @JsonProperty("isDocumentTimestamp")
  private Boolean isDocumentTimestamp = null;

  @JsonProperty("signatureFieldName")
  private String signatureFieldName = null;

  @JsonProperty("validationResults")
  private ValidationResultsModel validationResults = null;

  @JsonProperty("certificate")
  private CertificateModel certificate = null;

  @JsonProperty("date")
  private Date date = null;

  public SignerModel messageDigest(DigestAlgorithmAndValueModel messageDigest) {
    this.messageDigest = messageDigest;
    return this;
  }

   /**
   * Get messageDigest
   * @return messageDigest
  **/
  @Schema(description = "")
  public DigestAlgorithmAndValueModel getMessageDigest() {
    return messageDigest;
  }

  public void setMessageDigest(DigestAlgorithmAndValueModel messageDigest) {
    this.messageDigest = messageDigest;
  }

  public SignerModel signature(SignatureAlgorithmAndValueModel signature) {
    this.signature = signature;
    return this;
  }

   /**
   * Get signature
   * @return signature
  **/
  @Schema(description = "")
  public SignatureAlgorithmAndValueModel getSignature() {
    return signature;
  }

  public void setSignature(SignatureAlgorithmAndValueModel signature) {
    this.signature = signature;
  }

  public SignerModel signingTime(Date signingTime) {
    this.signingTime = signingTime;
    return this;
  }

   /**
   * Get signingTime
   * @return signingTime
  **/
  @Schema(description = "")
  public Date getSigningTime() {
    return signingTime;
  }

  public void setSigningTime(Date signingTime) {
    this.signingTime = signingTime;
  }

  public SignerModel certifiedDateReference(Date certifiedDateReference) {
    this.certifiedDateReference = certifiedDateReference;
    return this;
  }

   /**
   * Get certifiedDateReference
   * @return certifiedDateReference
  **/
  @Schema(description = "")
  public Date getCertifiedDateReference() {
    return certifiedDateReference;
  }

  public void setCertifiedDateReference(Date certifiedDateReference) {
    this.certifiedDateReference = certifiedDateReference;
  }

  public SignerModel isDocumentTimestamp(Boolean isDocumentTimestamp) {
    this.isDocumentTimestamp = isDocumentTimestamp;
    return this;
  }

   /**
   * Get isDocumentTimestamp
   * @return isDocumentTimestamp
  **/
  @Schema(description = "")
  public Boolean isIsDocumentTimestamp() {
    return isDocumentTimestamp;
  }

  public void setIsDocumentTimestamp(Boolean isDocumentTimestamp) {
    this.isDocumentTimestamp = isDocumentTimestamp;
  }

  public SignerModel signatureFieldName(String signatureFieldName) {
    this.signatureFieldName = signatureFieldName;
    return this;
  }

   /**
   * Get signatureFieldName
   * @return signatureFieldName
  **/
  @Schema(description = "")
  public String getSignatureFieldName() {
    return signatureFieldName;
  }

  public void setSignatureFieldName(String signatureFieldName) {
    this.signatureFieldName = signatureFieldName;
  }

  public SignerModel validationResults(ValidationResultsModel validationResults) {
    this.validationResults = validationResults;
    return this;
  }

   /**
   * Get validationResults
   * @return validationResults
  **/
  @Schema(description = "")
  public ValidationResultsModel getValidationResults() {
    return validationResults;
  }

  public void setValidationResults(ValidationResultsModel validationResults) {
    this.validationResults = validationResults;
  }

  public SignerModel certificate(CertificateModel certificate) {
    this.certificate = certificate;
    return this;
  }

   /**
   * Get certificate
   * @return certificate
  **/
  @Schema(description = "")
  public CertificateModel getCertificate() {
    return certificate;
  }

  public void setCertificate(CertificateModel certificate) {
    this.certificate = certificate;
  }

  public SignerModel date(Date date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @Schema(description = "")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignerModel signerModel = (SignerModel) o;
    return Objects.equals(this.messageDigest, signerModel.messageDigest) &&
        Objects.equals(this.signature, signerModel.signature) &&
        Objects.equals(this.signingTime, signerModel.signingTime) &&
        Objects.equals(this.certifiedDateReference, signerModel.certifiedDateReference) &&
        Objects.equals(this.isDocumentTimestamp, signerModel.isDocumentTimestamp) &&
        Objects.equals(this.signatureFieldName, signerModel.signatureFieldName) &&
        Objects.equals(this.validationResults, signerModel.validationResults) &&
        Objects.equals(this.certificate, signerModel.certificate) &&
        Objects.equals(this.date, signerModel.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageDigest, signature, signingTime, certifiedDateReference, isDocumentTimestamp, signatureFieldName, validationResults, certificate, date);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignerModel {\n");
    
    sb.append("    messageDigest: ").append(toIndentedString(messageDigest)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    signingTime: ").append(toIndentedString(signingTime)).append("\n");
    sb.append("    certifiedDateReference: ").append(toIndentedString(certifiedDateReference)).append("\n");
    sb.append("    isDocumentTimestamp: ").append(toIndentedString(isDocumentTimestamp)).append("\n");
    sb.append("    signatureFieldName: ").append(toIndentedString(signatureFieldName)).append("\n");
    sb.append("    validationResults: ").append(toIndentedString(validationResults)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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