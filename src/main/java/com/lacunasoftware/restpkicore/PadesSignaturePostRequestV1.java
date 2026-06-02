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
import com.lacunasoftware.restpkicore.PadesCertificationLevel;
import com.lacunasoftware.restpkicore.PadesMeasurementUnits;
import com.lacunasoftware.restpkicore.PadesPageOptimizationModel;
import com.lacunasoftware.restpkicore.PadesVisualRepresentationModel;
import com.lacunasoftware.restpkicore.PdfMarkModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * PadesSignaturePostRequestV1
 */




@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class PadesSignaturePostRequestV1 {
  @JsonProperty("pdfToSign")
  private byte[] pdfToSign = null;

  @JsonProperty("visualRepresentation")
  private PadesVisualRepresentationModel visualRepresentation = null;

  @JsonProperty("pdfMarks")
  private List<PdfMarkModel> pdfMarks = null;

  @JsonProperty("bypassMarksIfSigned")
  private Boolean bypassMarksIfSigned = null;

  @JsonProperty("measurementUnits")
  private PadesMeasurementUnits measurementUnits = null;

  @JsonProperty("pageOptimization")
  private PadesPageOptimizationModel pageOptimization = null;

  @JsonProperty("customSignatureFieldName")
  private String customSignatureFieldName = null;

  @JsonProperty("certificationLevel")
  private PadesCertificationLevel certificationLevel = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("certificate")
  private byte[] certificate = null;

  @JsonProperty("signaturePolicyId")
  private UUID signaturePolicyId = null;

  @JsonProperty("securityContextId")
  private UUID securityContextId = null;

  @JsonProperty("callbackArgument")
  private String callbackArgument = null;

  @JsonProperty("ignoreRevocationStatusUnknown")
  private Boolean ignoreRevocationStatusUnknown = null;

  public PadesSignaturePostRequestV1 pdfToSign(byte[] pdfToSign) {
    this.pdfToSign = pdfToSign;
    return this;
  }

   /**
   * Get pdfToSign
   * @return pdfToSign
  **/
  @Schema(required = true, description = "")
  public byte[] getPdfToSign() {
    return pdfToSign;
  }

  public void setPdfToSign(byte[] pdfToSign) {
    this.pdfToSign = pdfToSign;
  }

  public PadesSignaturePostRequestV1 visualRepresentation(PadesVisualRepresentationModel visualRepresentation) {
    this.visualRepresentation = visualRepresentation;
    return this;
  }

   /**
   * Get visualRepresentation
   * @return visualRepresentation
  **/
  @Schema(description = "")
  public PadesVisualRepresentationModel getVisualRepresentation() {
    return visualRepresentation;
  }

  public void setVisualRepresentation(PadesVisualRepresentationModel visualRepresentation) {
    this.visualRepresentation = visualRepresentation;
  }

  public PadesSignaturePostRequestV1 pdfMarks(List<PdfMarkModel> pdfMarks) {
    this.pdfMarks = pdfMarks;
    return this;
  }

  public PadesSignaturePostRequestV1 addPdfMarksItem(PdfMarkModel pdfMarksItem) {
    if (this.pdfMarks == null) {
      this.pdfMarks = new ArrayList<>();
    }
    this.pdfMarks.add(pdfMarksItem);
    return this;
  }

   /**
   * Get pdfMarks
   * @return pdfMarks
  **/
  @Schema(description = "")
  public List<PdfMarkModel> getPdfMarks() {
    return pdfMarks;
  }

  public void setPdfMarks(List<PdfMarkModel> pdfMarks) {
    this.pdfMarks = pdfMarks;
  }

  public PadesSignaturePostRequestV1 bypassMarksIfSigned(Boolean bypassMarksIfSigned) {
    this.bypassMarksIfSigned = bypassMarksIfSigned;
    return this;
  }

   /**
   * Get bypassMarksIfSigned
   * @return bypassMarksIfSigned
  **/
  @Schema(description = "")
  public Boolean isBypassMarksIfSigned() {
    return bypassMarksIfSigned;
  }

  public void setBypassMarksIfSigned(Boolean bypassMarksIfSigned) {
    this.bypassMarksIfSigned = bypassMarksIfSigned;
  }

  public PadesSignaturePostRequestV1 measurementUnits(PadesMeasurementUnits measurementUnits) {
    this.measurementUnits = measurementUnits;
    return this;
  }

   /**
   * Get measurementUnits
   * @return measurementUnits
  **/
  @Schema(description = "")
  public PadesMeasurementUnits getMeasurementUnits() {
    return measurementUnits;
  }

  public void setMeasurementUnits(PadesMeasurementUnits measurementUnits) {
    this.measurementUnits = measurementUnits;
  }

  public PadesSignaturePostRequestV1 pageOptimization(PadesPageOptimizationModel pageOptimization) {
    this.pageOptimization = pageOptimization;
    return this;
  }

   /**
   * Get pageOptimization
   * @return pageOptimization
  **/
  @Schema(description = "")
  public PadesPageOptimizationModel getPageOptimization() {
    return pageOptimization;
  }

  public void setPageOptimization(PadesPageOptimizationModel pageOptimization) {
    this.pageOptimization = pageOptimization;
  }

  public PadesSignaturePostRequestV1 customSignatureFieldName(String customSignatureFieldName) {
    this.customSignatureFieldName = customSignatureFieldName;
    return this;
  }

   /**
   * Get customSignatureFieldName
   * @return customSignatureFieldName
  **/
  @Schema(description = "")
  public String getCustomSignatureFieldName() {
    return customSignatureFieldName;
  }

  public void setCustomSignatureFieldName(String customSignatureFieldName) {
    this.customSignatureFieldName = customSignatureFieldName;
  }

  public PadesSignaturePostRequestV1 certificationLevel(PadesCertificationLevel certificationLevel) {
    this.certificationLevel = certificationLevel;
    return this;
  }

   /**
   * Get certificationLevel
   * @return certificationLevel
  **/
  @Schema(description = "")
  public PadesCertificationLevel getCertificationLevel() {
    return certificationLevel;
  }

  public void setCertificationLevel(PadesCertificationLevel certificationLevel) {
    this.certificationLevel = certificationLevel;
  }

  public PadesSignaturePostRequestV1 reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Get reason
   * @return reason
  **/
  @Schema(description = "")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public PadesSignaturePostRequestV1 certificate(byte[] certificate) {
    this.certificate = certificate;
    return this;
  }

   /**
   * Get certificate
   * @return certificate
  **/
  @Schema(description = "")
  public byte[] getCertificate() {
    return certificate;
  }

  public void setCertificate(byte[] certificate) {
    this.certificate = certificate;
  }

  public PadesSignaturePostRequestV1 signaturePolicyId(UUID signaturePolicyId) {
    this.signaturePolicyId = signaturePolicyId;
    return this;
  }

   /**
   * Get signaturePolicyId
   * @return signaturePolicyId
  **/
  @Schema(description = "")
  public UUID getSignaturePolicyId() {
    return signaturePolicyId;
  }

  public void setSignaturePolicyId(UUID signaturePolicyId) {
    this.signaturePolicyId = signaturePolicyId;
  }

  public PadesSignaturePostRequestV1 securityContextId(UUID securityContextId) {
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

  public PadesSignaturePostRequestV1 callbackArgument(String callbackArgument) {
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

  public PadesSignaturePostRequestV1 ignoreRevocationStatusUnknown(Boolean ignoreRevocationStatusUnknown) {
    this.ignoreRevocationStatusUnknown = ignoreRevocationStatusUnknown;
    return this;
  }

   /**
   * Get ignoreRevocationStatusUnknown
   * @return ignoreRevocationStatusUnknown
  **/
  @Schema(description = "")
  public Boolean isIgnoreRevocationStatusUnknown() {
    return ignoreRevocationStatusUnknown;
  }

  public void setIgnoreRevocationStatusUnknown(Boolean ignoreRevocationStatusUnknown) {
    this.ignoreRevocationStatusUnknown = ignoreRevocationStatusUnknown;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PadesSignaturePostRequestV1 padesSignaturePostRequestV1 = (PadesSignaturePostRequestV1) o;
    return Arrays.equals(this.pdfToSign, padesSignaturePostRequestV1.pdfToSign) &&
        Objects.equals(this.visualRepresentation, padesSignaturePostRequestV1.visualRepresentation) &&
        Objects.equals(this.pdfMarks, padesSignaturePostRequestV1.pdfMarks) &&
        Objects.equals(this.bypassMarksIfSigned, padesSignaturePostRequestV1.bypassMarksIfSigned) &&
        Objects.equals(this.measurementUnits, padesSignaturePostRequestV1.measurementUnits) &&
        Objects.equals(this.pageOptimization, padesSignaturePostRequestV1.pageOptimization) &&
        Objects.equals(this.customSignatureFieldName, padesSignaturePostRequestV1.customSignatureFieldName) &&
        Objects.equals(this.certificationLevel, padesSignaturePostRequestV1.certificationLevel) &&
        Objects.equals(this.reason, padesSignaturePostRequestV1.reason) &&
        Arrays.equals(this.certificate, padesSignaturePostRequestV1.certificate) &&
        Objects.equals(this.signaturePolicyId, padesSignaturePostRequestV1.signaturePolicyId) &&
        Objects.equals(this.securityContextId, padesSignaturePostRequestV1.securityContextId) &&
        Objects.equals(this.callbackArgument, padesSignaturePostRequestV1.callbackArgument) &&
        Objects.equals(this.ignoreRevocationStatusUnknown, padesSignaturePostRequestV1.ignoreRevocationStatusUnknown);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.hashCode(pdfToSign), visualRepresentation, pdfMarks, bypassMarksIfSigned, measurementUnits, pageOptimization, customSignatureFieldName, certificationLevel, reason, Arrays.hashCode(certificate), signaturePolicyId, securityContextId, callbackArgument, ignoreRevocationStatusUnknown);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PadesSignaturePostRequestV1 {\n");
    
    sb.append("    pdfToSign: ").append(toIndentedString(pdfToSign)).append("\n");
    sb.append("    visualRepresentation: ").append(toIndentedString(visualRepresentation)).append("\n");
    sb.append("    pdfMarks: ").append(toIndentedString(pdfMarks)).append("\n");
    sb.append("    bypassMarksIfSigned: ").append(toIndentedString(bypassMarksIfSigned)).append("\n");
    sb.append("    measurementUnits: ").append(toIndentedString(measurementUnits)).append("\n");
    sb.append("    pageOptimization: ").append(toIndentedString(pageOptimization)).append("\n");
    sb.append("    customSignatureFieldName: ").append(toIndentedString(customSignatureFieldName)).append("\n");
    sb.append("    certificationLevel: ").append(toIndentedString(certificationLevel)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("    signaturePolicyId: ").append(toIndentedString(signaturePolicyId)).append("\n");
    sb.append("    securityContextId: ").append(toIndentedString(securityContextId)).append("\n");
    sb.append("    callbackArgument: ").append(toIndentedString(callbackArgument)).append("\n");
    sb.append("    ignoreRevocationStatusUnknown: ").append(toIndentedString(ignoreRevocationStatusUnknown)).append("\n");
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
