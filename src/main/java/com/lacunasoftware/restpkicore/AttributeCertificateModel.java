/*
 * Rest PKI Core API
 * <b><i>Para Português, <a href=\"https://docs.lacunasoftware.com/pt-br/articles/rest-pki/core/integration/get-started\">clique aqui</a></i></b>  <p>   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/\">Rest PKI Core</a> is an upcoming version of   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/\">Rest PKI</a> that will have extended compatibility with environments and databases.  </p>  <p>   In addition to Windows Server (which is already supported by Rest PKI), Rest PKI Core will also run on <b>Linux</b> (Debian- and RedHat-based distributions)   and on <b>Docker</b>. As for database servers, in addition to SQL Server, <b>PostgreSQL</b> will also be supported.  </p>  <p>   <b>Before getting started, see the integration overview on the <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/integration/\">Integration Guide</a></b>  </p>  <p>   For questions regarding the usage of this API, please reach us at <a href=\"https://lacuna.help/\">lacuna.help</a>  </p>    <h2>Parameters</h2>  <p>   You will need the following parameters:  </p>  <ul>   <li><b>Endpoint</b>: address of the Rest PKI Core instance that will be used</li>   <li><b>API Key</b>: authorization key for using the API</li>  </ul>  <p>   The <span class=\"model\">endpoint</span> must be prefixed to all relative URLs mentioned here. As for the <span class=\"model\">API Key</span>, see how to use it below.  </p>    <h2>Authentication</h2>  <p>   The API key must be sent on the <span class=\"model\">X-Api-Key</span> header on each request:  </p>    <!-- unfortunately, class \"example microlight\" doesn't seem to work here -->  <pre style=\"font-size: 12px; padding: 10px; border-radius: 4px; background: #41444e; font-weight: 600; color: #fff;\">  X-Api-Key: yourapp|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  </pre>    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response body is an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>    </tr>    <tr>     <td><strong class=\"model-title\">500 (Internal Server Error)</strong></td>     <td>An unexpected error occurred. The <span class=\"model\">exceptionCode</span> contained on the response body may be of help for our support team during diagnostic.</td>    </tr>   </tbody>  </table>    <h3>Error Codes</h3>    <p>   Some of the error codes returned in the <span class=\"model\">code</span> field of an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>   (body of responses with HTTP status code 422) are provided below*:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td class=\"model\">DocumentNotFound</td>     <td>A referenced document was not found (check the document ID)</td>    </tr>    <tr>     <td class=\"model\">SecurityContextNotFound</td>     <td>A referenced security context was not found (check the security context ID)</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionNotFound</td>     <td>A referenced signature session was not found (check the signature session ID)</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionOperation</td>     <td>The operation is invalid for the current signature session or document status. For instance, trying to await the session's completion if it is still <span class=\"model\">Pending</span> results in this error</td>    </tr>    <tr>     <td class=\"model\">BackgroundProcessing</td>     <td>The operation cannot be completed at this time because the resource is being processed in background</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionTokenRequired</td>     <td>The signature session token was not passed on the <span class=\"model\">X-Signature-Session-Token</span> request header</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionToken</td>     <td>An invalid signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Check your application for possible corruption of the session token, which may contain characters <span class=\"code\">-</span> (hyphen) and <span class=\"code\">_</span> (underscore)</td>    </tr>    <tr>     <td class=\"model\">ExpiredSignatureSessionToken</td>     <td>An expired signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Signature session tokens are normally valid for 4 hours.</td>    </tr>   </tbody>  </table>    <p style=\"font-size: 0.9em\">   *The codes shown above are the most common error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <h2>Culture / Internationalization (i18n)</h2>  <p>The <span class=\"model\">Accept-Language</span> request header is observed by this API. The following cultures are supported:</p>  <ul>   <li><span class=\"code\">en-US</span> (or simply <span class=\"code\">en</span>)</li>   <li><span class=\"code\">pt-BR</span> (or simply <span class=\"code\">pt</span>)</li>  </ul>  <p><i>Notice: error messages are not affected by this header and therefore should not be displayed to users, being better suited for logging.</i></p>  
 *
 * OpenAPI spec version: 3.3.0
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
import com.lacunasoftware.restpkicore.CertifiedAttributeModel;
import com.lacunasoftware.restpkicore.GeneralNameModel;
import com.lacunasoftware.restpkicore.HolderTypes;
import com.lacunasoftware.restpkicore.NameModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * AttributeCertificateModel
 */




@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeCertificateModel {
  @JsonProperty("holderType")
  private HolderTypes holderType = null;

  @JsonProperty("holderCertificateSerialNumber")
  private String holderCertificateSerialNumber = null;

  @JsonProperty("holderDisplayName")
  private String holderDisplayName = null;

  @JsonProperty("holderName")
  private GeneralNameModel holderName = null;

  @JsonProperty("issuerDisplayName")
  private String issuerDisplayName = null;

  @JsonProperty("issuer")
  private NameModel issuer = null;

  @JsonProperty("validityStart")
  private Date validityStart = null;

  @JsonProperty("validityEnd")
  private Date validityEnd = null;

  @JsonProperty("attributes")
  private List<CertifiedAttributeModel> attributes = null;

  public AttributeCertificateModel holderType(HolderTypes holderType) {
    this.holderType = holderType;
    return this;
  }

   /**
   * Get holderType
   * @return holderType
  **/
  @Schema(description = "")
  public HolderTypes getHolderType() {
    return holderType;
  }

  public void setHolderType(HolderTypes holderType) {
    this.holderType = holderType;
  }

  public AttributeCertificateModel holderCertificateSerialNumber(String holderCertificateSerialNumber) {
    this.holderCertificateSerialNumber = holderCertificateSerialNumber;
    return this;
  }

   /**
   * Get holderCertificateSerialNumber
   * @return holderCertificateSerialNumber
  **/
  @Schema(description = "")
  public String getHolderCertificateSerialNumber() {
    return holderCertificateSerialNumber;
  }

  public void setHolderCertificateSerialNumber(String holderCertificateSerialNumber) {
    this.holderCertificateSerialNumber = holderCertificateSerialNumber;
  }

  public AttributeCertificateModel holderDisplayName(String holderDisplayName) {
    this.holderDisplayName = holderDisplayName;
    return this;
  }

   /**
   * Get holderDisplayName
   * @return holderDisplayName
  **/
  @Schema(description = "")
  public String getHolderDisplayName() {
    return holderDisplayName;
  }

  public void setHolderDisplayName(String holderDisplayName) {
    this.holderDisplayName = holderDisplayName;
  }

  public AttributeCertificateModel holderName(GeneralNameModel holderName) {
    this.holderName = holderName;
    return this;
  }

   /**
   * Get holderName
   * @return holderName
  **/
  @Schema(description = "")
  public GeneralNameModel getHolderName() {
    return holderName;
  }

  public void setHolderName(GeneralNameModel holderName) {
    this.holderName = holderName;
  }

  public AttributeCertificateModel issuerDisplayName(String issuerDisplayName) {
    this.issuerDisplayName = issuerDisplayName;
    return this;
  }

   /**
   * Get issuerDisplayName
   * @return issuerDisplayName
  **/
  @Schema(description = "")
  public String getIssuerDisplayName() {
    return issuerDisplayName;
  }

  public void setIssuerDisplayName(String issuerDisplayName) {
    this.issuerDisplayName = issuerDisplayName;
  }

  public AttributeCertificateModel issuer(NameModel issuer) {
    this.issuer = issuer;
    return this;
  }

   /**
   * Get issuer
   * @return issuer
  **/
  @Schema(description = "")
  public NameModel getIssuer() {
    return issuer;
  }

  public void setIssuer(NameModel issuer) {
    this.issuer = issuer;
  }

  public AttributeCertificateModel validityStart(Date validityStart) {
    this.validityStart = validityStart;
    return this;
  }

   /**
   * Get validityStart
   * @return validityStart
  **/
  @Schema(description = "")
  public Date getValidityStart() {
    return validityStart;
  }

  public void setValidityStart(Date validityStart) {
    this.validityStart = validityStart;
  }

  public AttributeCertificateModel validityEnd(Date validityEnd) {
    this.validityEnd = validityEnd;
    return this;
  }

   /**
   * Get validityEnd
   * @return validityEnd
  **/
  @Schema(description = "")
  public Date getValidityEnd() {
    return validityEnd;
  }

  public void setValidityEnd(Date validityEnd) {
    this.validityEnd = validityEnd;
  }

  public AttributeCertificateModel attributes(List<CertifiedAttributeModel> attributes) {
    this.attributes = attributes;
    return this;
  }

  public AttributeCertificateModel addAttributesItem(CertifiedAttributeModel attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public List<CertifiedAttributeModel> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<CertifiedAttributeModel> attributes) {
    this.attributes = attributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttributeCertificateModel attributeCertificateModel = (AttributeCertificateModel) o;
    return Objects.equals(this.holderType, attributeCertificateModel.holderType) &&
        Objects.equals(this.holderCertificateSerialNumber, attributeCertificateModel.holderCertificateSerialNumber) &&
        Objects.equals(this.holderDisplayName, attributeCertificateModel.holderDisplayName) &&
        Objects.equals(this.holderName, attributeCertificateModel.holderName) &&
        Objects.equals(this.issuerDisplayName, attributeCertificateModel.issuerDisplayName) &&
        Objects.equals(this.issuer, attributeCertificateModel.issuer) &&
        Objects.equals(this.validityStart, attributeCertificateModel.validityStart) &&
        Objects.equals(this.validityEnd, attributeCertificateModel.validityEnd) &&
        Objects.equals(this.attributes, attributeCertificateModel.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(holderType, holderCertificateSerialNumber, holderDisplayName, holderName, issuerDisplayName, issuer, validityStart, validityEnd, attributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributeCertificateModel {\n");
    
    sb.append("    holderType: ").append(toIndentedString(holderType)).append("\n");
    sb.append("    holderCertificateSerialNumber: ").append(toIndentedString(holderCertificateSerialNumber)).append("\n");
    sb.append("    holderDisplayName: ").append(toIndentedString(holderDisplayName)).append("\n");
    sb.append("    holderName: ").append(toIndentedString(holderName)).append("\n");
    sb.append("    issuerDisplayName: ").append(toIndentedString(issuerDisplayName)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    validityStart: ").append(toIndentedString(validityStart)).append("\n");
    sb.append("    validityEnd: ").append(toIndentedString(validityEnd)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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
