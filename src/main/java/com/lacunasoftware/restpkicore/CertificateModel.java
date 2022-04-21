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
import com.lacunasoftware.restpkicore.CertificateModel;
import com.lacunasoftware.restpkicore.NameModel;
import com.lacunasoftware.restpkicore.PkiBrazilCertificateModel;
import com.lacunasoftware.restpkicore.PkiItalyCertificateModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
/**
 * CertificateModel
 */



@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class CertificateModel {
  @JsonProperty("subjectName")
  private NameModel subjectName = null;

  @JsonProperty("issuerName")
  private NameModel issuerName = null;

  @JsonProperty("issuerDisplayName")
  private String issuerDisplayName = null;

  @JsonProperty("serialNumber")
  private String serialNumber = null;

  @JsonProperty("validityStart")
  private Date validityStart = null;

  @JsonProperty("validityEnd")
  private Date validityEnd = null;

  @JsonProperty("issuer")
  private CertificateModel issuer = null;

  @JsonProperty("pkiBrazil")
  private PkiBrazilCertificateModel pkiBrazil = null;

  @JsonProperty("pkiItaly")
  private PkiItalyCertificateModel pkiItaly = null;

  @JsonProperty("binaryThumbprintSHA256")
  private byte[] binaryThumbprintSHA256 = null;

  @JsonProperty("thumbprint")
  private String thumbprint = null;

  @JsonProperty("thumbprintSHA256")
  private String thumbprintSHA256 = null;

  @JsonProperty("subjectCommonName")
  private String subjectCommonName = null;

  @JsonProperty("subjectDisplayName")
  private String subjectDisplayName = null;

  @JsonProperty("subjectIdentifier")
  private String subjectIdentifier = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("organization")
  private String organization = null;

  @JsonProperty("organizationIdentifier")
  private String organizationIdentifier = null;

  public CertificateModel subjectName(NameModel subjectName) {
    this.subjectName = subjectName;
    return this;
  }

   /**
   * Get subjectName
   * @return subjectName
  **/
  @Schema(description = "")
  public NameModel getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(NameModel subjectName) {
    this.subjectName = subjectName;
  }

  public CertificateModel issuerName(NameModel issuerName) {
    this.issuerName = issuerName;
    return this;
  }

   /**
   * Get issuerName
   * @return issuerName
  **/
  @Schema(description = "")
  public NameModel getIssuerName() {
    return issuerName;
  }

  public void setIssuerName(NameModel issuerName) {
    this.issuerName = issuerName;
  }

  public CertificateModel issuerDisplayName(String issuerDisplayName) {
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

  public CertificateModel serialNumber(String serialNumber) {
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

  public CertificateModel validityStart(Date validityStart) {
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

  public CertificateModel validityEnd(Date validityEnd) {
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

  public CertificateModel issuer(CertificateModel issuer) {
    this.issuer = issuer;
    return this;
  }

   /**
   * Get issuer
   * @return issuer
  **/
  @Schema(description = "")
  public CertificateModel getIssuer() {
    return issuer;
  }

  public void setIssuer(CertificateModel issuer) {
    this.issuer = issuer;
  }

  public CertificateModel pkiBrazil(PkiBrazilCertificateModel pkiBrazil) {
    this.pkiBrazil = pkiBrazil;
    return this;
  }

   /**
   * Get pkiBrazil
   * @return pkiBrazil
  **/
  @Schema(description = "")
  public PkiBrazilCertificateModel getPkiBrazil() {
    return pkiBrazil;
  }

  public void setPkiBrazil(PkiBrazilCertificateModel pkiBrazil) {
    this.pkiBrazil = pkiBrazil;
  }

  public CertificateModel pkiItaly(PkiItalyCertificateModel pkiItaly) {
    this.pkiItaly = pkiItaly;
    return this;
  }

   /**
   * Get pkiItaly
   * @return pkiItaly
  **/
  @Schema(description = "")
  public PkiItalyCertificateModel getPkiItaly() {
    return pkiItaly;
  }

  public void setPkiItaly(PkiItalyCertificateModel pkiItaly) {
    this.pkiItaly = pkiItaly;
  }

  public CertificateModel binaryThumbprintSHA256(byte[] binaryThumbprintSHA256) {
    this.binaryThumbprintSHA256 = binaryThumbprintSHA256;
    return this;
  }

   /**
   * Get binaryThumbprintSHA256
   * @return binaryThumbprintSHA256
  **/
  @Schema(description = "")
  public byte[] getBinaryThumbprintSHA256() {
    return binaryThumbprintSHA256;
  }

  public void setBinaryThumbprintSHA256(byte[] binaryThumbprintSHA256) {
    this.binaryThumbprintSHA256 = binaryThumbprintSHA256;
  }

  public CertificateModel thumbprint(String thumbprint) {
    this.thumbprint = thumbprint;
    return this;
  }

   /**
   * Get thumbprint
   * @return thumbprint
  **/
  @Schema(description = "")
  public String getThumbprint() {
    return thumbprint;
  }

  public void setThumbprint(String thumbprint) {
    this.thumbprint = thumbprint;
  }

  public CertificateModel thumbprintSHA256(String thumbprintSHA256) {
    this.thumbprintSHA256 = thumbprintSHA256;
    return this;
  }

   /**
   * Get thumbprintSHA256
   * @return thumbprintSHA256
  **/
  @Schema(description = "")
  public String getThumbprintSHA256() {
    return thumbprintSHA256;
  }

  public void setThumbprintSHA256(String thumbprintSHA256) {
    this.thumbprintSHA256 = thumbprintSHA256;
  }

  public CertificateModel subjectCommonName(String subjectCommonName) {
    this.subjectCommonName = subjectCommonName;
    return this;
  }

   /**
   * Get subjectCommonName
   * @return subjectCommonName
  **/
  @Schema(description = "")
  public String getSubjectCommonName() {
    return subjectCommonName;
  }

  public void setSubjectCommonName(String subjectCommonName) {
    this.subjectCommonName = subjectCommonName;
  }

  public CertificateModel subjectDisplayName(String subjectDisplayName) {
    this.subjectDisplayName = subjectDisplayName;
    return this;
  }

   /**
   * Get subjectDisplayName
   * @return subjectDisplayName
  **/
  @Schema(description = "")
  public String getSubjectDisplayName() {
    return subjectDisplayName;
  }

  public void setSubjectDisplayName(String subjectDisplayName) {
    this.subjectDisplayName = subjectDisplayName;
  }

  public CertificateModel subjectIdentifier(String subjectIdentifier) {
    this.subjectIdentifier = subjectIdentifier;
    return this;
  }

   /**
   * Get subjectIdentifier
   * @return subjectIdentifier
  **/
  @Schema(description = "")
  public String getSubjectIdentifier() {
    return subjectIdentifier;
  }

  public void setSubjectIdentifier(String subjectIdentifier) {
    this.subjectIdentifier = subjectIdentifier;
  }

  public CertificateModel emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

   /**
   * Get emailAddress
   * @return emailAddress
  **/
  @Schema(description = "")
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public CertificateModel organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * Get organization
   * @return organization
  **/
  @Schema(description = "")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public CertificateModel organizationIdentifier(String organizationIdentifier) {
    this.organizationIdentifier = organizationIdentifier;
    return this;
  }

   /**
   * Get organizationIdentifier
   * @return organizationIdentifier
  **/
  @Schema(description = "")
  public String getOrganizationIdentifier() {
    return organizationIdentifier;
  }

  public void setOrganizationIdentifier(String organizationIdentifier) {
    this.organizationIdentifier = organizationIdentifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificateModel certificateModel = (CertificateModel) o;
    return Objects.equals(this.subjectName, certificateModel.subjectName) &&
        Objects.equals(this.issuerName, certificateModel.issuerName) &&
        Objects.equals(this.issuerDisplayName, certificateModel.issuerDisplayName) &&
        Objects.equals(this.serialNumber, certificateModel.serialNumber) &&
        Objects.equals(this.validityStart, certificateModel.validityStart) &&
        Objects.equals(this.validityEnd, certificateModel.validityEnd) &&
        Objects.equals(this.issuer, certificateModel.issuer) &&
        Objects.equals(this.pkiBrazil, certificateModel.pkiBrazil) &&
        Objects.equals(this.pkiItaly, certificateModel.pkiItaly) &&
        Arrays.equals(this.binaryThumbprintSHA256, certificateModel.binaryThumbprintSHA256) &&
        Objects.equals(this.thumbprint, certificateModel.thumbprint) &&
        Objects.equals(this.thumbprintSHA256, certificateModel.thumbprintSHA256) &&
        Objects.equals(this.subjectCommonName, certificateModel.subjectCommonName) &&
        Objects.equals(this.subjectDisplayName, certificateModel.subjectDisplayName) &&
        Objects.equals(this.subjectIdentifier, certificateModel.subjectIdentifier) &&
        Objects.equals(this.emailAddress, certificateModel.emailAddress) &&
        Objects.equals(this.organization, certificateModel.organization) &&
        Objects.equals(this.organizationIdentifier, certificateModel.organizationIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subjectName, issuerName, issuerDisplayName, serialNumber, validityStart, validityEnd, issuer, pkiBrazil, pkiItaly, Arrays.hashCode(binaryThumbprintSHA256), thumbprint, thumbprintSHA256, subjectCommonName, subjectDisplayName, subjectIdentifier, emailAddress, organization, organizationIdentifier);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificateModel {\n");
    
    sb.append("    subjectName: ").append(toIndentedString(subjectName)).append("\n");
    sb.append("    issuerName: ").append(toIndentedString(issuerName)).append("\n");
    sb.append("    issuerDisplayName: ").append(toIndentedString(issuerDisplayName)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    validityStart: ").append(toIndentedString(validityStart)).append("\n");
    sb.append("    validityEnd: ").append(toIndentedString(validityEnd)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    pkiBrazil: ").append(toIndentedString(pkiBrazil)).append("\n");
    sb.append("    pkiItaly: ").append(toIndentedString(pkiItaly)).append("\n");
    sb.append("    binaryThumbprintSHA256: ").append(toIndentedString(binaryThumbprintSHA256)).append("\n");
    sb.append("    thumbprint: ").append(toIndentedString(thumbprint)).append("\n");
    sb.append("    thumbprintSHA256: ").append(toIndentedString(thumbprintSHA256)).append("\n");
    sb.append("    subjectCommonName: ").append(toIndentedString(subjectCommonName)).append("\n");
    sb.append("    subjectDisplayName: ").append(toIndentedString(subjectDisplayName)).append("\n");
    sb.append("    subjectIdentifier: ").append(toIndentedString(subjectIdentifier)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    organizationIdentifier: ").append(toIndentedString(organizationIdentifier)).append("\n");
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
