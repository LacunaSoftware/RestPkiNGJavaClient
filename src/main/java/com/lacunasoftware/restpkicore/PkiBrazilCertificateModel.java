/*
 * Rest PKI Core API
 * <b><i>Para Português, <a href=\"https://docs.lacunasoftware.com/pt-br/articles/rest-pki/core/integration/get-started\">clique aqui</a></i></b>  <p>   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/\">Rest PKI Core</a> is an upcoming version of   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/\">Rest PKI</a> that will have extended compatibility with environments and databases.  </p>  <p>   In addition to Windows Server (which is already supported by Rest PKI), Rest PKI Core will also run on <b>Linux</b> (Debian- and RedHat-based distributions)   and on <b>Docker</b>. As for database servers, in addition to SQL Server, <b>PostgreSQL</b> will also be supported.  </p>  <p>   <b>Before getting started, see the integration overview on the <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/integration/\">Integration Guide</a></b>  </p>  <p>   For questions regarding the usage of this API, please reach us at <a href=\"https://lacuna.help/\">lacuna.help</a>  </p>    <h2>Parameters</h2>  <p>   You will need the following parameters:  </p>  <ul>   <li><b>Endpoint</b>: address of the Rest PKI Core instance that will be used</li>   <li><b>API Key</b>: authorization key for using the API</li>  </ul>  <p>   The <span class=\"model\">endpoint</span> must be prefixed to all relative URLs mentioned here. As for the <span class=\"model\">API Key</span>, see how to use it below.  </p>    <h2>Authentication</h2>  <p>   The API key must be sent on the <span class=\"model\">X-Api-Key</span> header on each request:  </p>    <!-- unfortunately, class \"example microlight\" doesn't seem to work here -->  <pre style=\"font-size: 12px; padding: 10px; border-radius: 4px; background: #41444e; font-weight: 600; color: #fff;\">  X-Api-Key: yourapp|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  </pre>    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response body is an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>    </tr>    <tr>     <td><strong class=\"model-title\">500 (Internal Server Error)</strong></td>     <td>An unexpected error occurred. The <span class=\"model\">exceptionCode</span> contained on the response body may be of help for our support team during diagnostic.</td>    </tr>   </tbody>  </table>    <h3>Error Codes</h3>    <p>   Some of the error codes returned in the <span class=\"model\">code</span> field of an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>   (body of responses with HTTP status code 422) are provided below*:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td class=\"model\">DocumentNotFound</td>     <td>A referenced document was not found (check the document ID)</td>    </tr>    <tr>     <td class=\"model\">SecurityContextNotFound</td>     <td>A referenced security context was not found (check the security context ID)</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionNotFound</td>     <td>A referenced signature session was not found (check the signature session ID)</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionOperation</td>     <td>The operation is invalid for the current signature session or document status. For instance, trying to await the session's completion if it is still <span class=\"model\">Pending</span> results in this error</td>    </tr>    <tr>     <td class=\"model\">BackgroundProcessing</td>     <td>The operation cannot be completed at this time because the resource is being processed in background</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionTokenRequired</td>     <td>The signature session token was not passed on the <span class=\"model\">X-Signature-Session-Token</span> request header</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionToken</td>     <td>An invalid signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Check your application for possible corruption of the session token, which may contain characters <span class=\"code\">-</span> (hyphen) and <span class=\"code\">_</span> (underscore)</td>    </tr>    <tr>     <td class=\"model\">ExpiredSignatureSessionToken</td>     <td>An expired signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Signature session tokens are normally valid for 4 hours.</td>    </tr>   </tbody>  </table>    <p style=\"font-size: 0.9em\">   *The codes shown above are the most common error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <h2>Culture / Internationalization (i18n)</h2>  <p>The <span class=\"model\">Accept-Language</span> request header is observed by this API. The following cultures are supported:</p>  <ul>   <li><span class=\"code\">en-US</span> (or simply <span class=\"code\">en</span>)</li>   <li><span class=\"code\">pt-BR</span> (or simply <span class=\"code\">pt</span>)</li>  </ul>  <p><i>Notice: error messages are not affected by this header and therefore should not be displayed to users, being better suited for logging.</i></p>  
 *
 * OpenAPI spec version: 1.10.0 RC 1
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
import com.lacunasoftware.restpkicore.PkiBrazilCertificateTypes;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * PkiBrazilCertificateModel
 */



@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class PkiBrazilCertificateModel {
  @JsonProperty("certificateType")
  private PkiBrazilCertificateTypes certificateType = null;

  @JsonProperty("cpf")
  private String cpf = null;

  @JsonProperty("cnpj")
  private String cnpj = null;

  @JsonProperty("responsavel")
  private String responsavel = null;

  @JsonProperty("dateOfBirth")
  private String dateOfBirth = null;

  @JsonProperty("companyName")
  private String companyName = null;

  @JsonProperty("oabUF")
  private String oabUF = null;

  @JsonProperty("oabNumero")
  private String oabNumero = null;

  @JsonProperty("rgEmissor")
  private String rgEmissor = null;

  @JsonProperty("rgEmissorUF")
  private String rgEmissorUF = null;

  @JsonProperty("rgNumero")
  private String rgNumero = null;

  public PkiBrazilCertificateModel certificateType(PkiBrazilCertificateTypes certificateType) {
    this.certificateType = certificateType;
    return this;
  }

   /**
   * Get certificateType
   * @return certificateType
  **/
  @Schema(description = "")
  public PkiBrazilCertificateTypes getCertificateType() {
    return certificateType;
  }

  public void setCertificateType(PkiBrazilCertificateTypes certificateType) {
    this.certificateType = certificateType;
  }

  public PkiBrazilCertificateModel cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

   /**
   * Get cpf
   * @return cpf
  **/
  @Schema(description = "")
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public PkiBrazilCertificateModel cnpj(String cnpj) {
    this.cnpj = cnpj;
    return this;
  }

   /**
   * Get cnpj
   * @return cnpj
  **/
  @Schema(description = "")
  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public PkiBrazilCertificateModel responsavel(String responsavel) {
    this.responsavel = responsavel;
    return this;
  }

   /**
   * Get responsavel
   * @return responsavel
  **/
  @Schema(description = "")
  public String getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(String responsavel) {
    this.responsavel = responsavel;
  }

  public PkiBrazilCertificateModel dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

   /**
   * Get dateOfBirth
   * @return dateOfBirth
  **/
  @Schema(description = "")
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public PkiBrazilCertificateModel companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

   /**
   * Get companyName
   * @return companyName
  **/
  @Schema(description = "")
  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public PkiBrazilCertificateModel oabUF(String oabUF) {
    this.oabUF = oabUF;
    return this;
  }

   /**
   * Get oabUF
   * @return oabUF
  **/
  @Schema(description = "")
  public String getOabUF() {
    return oabUF;
  }

  public void setOabUF(String oabUF) {
    this.oabUF = oabUF;
  }

  public PkiBrazilCertificateModel oabNumero(String oabNumero) {
    this.oabNumero = oabNumero;
    return this;
  }

   /**
   * Get oabNumero
   * @return oabNumero
  **/
  @Schema(description = "")
  public String getOabNumero() {
    return oabNumero;
  }

  public void setOabNumero(String oabNumero) {
    this.oabNumero = oabNumero;
  }

  public PkiBrazilCertificateModel rgEmissor(String rgEmissor) {
    this.rgEmissor = rgEmissor;
    return this;
  }

   /**
   * Get rgEmissor
   * @return rgEmissor
  **/
  @Schema(description = "")
  public String getRgEmissor() {
    return rgEmissor;
  }

  public void setRgEmissor(String rgEmissor) {
    this.rgEmissor = rgEmissor;
  }

  public PkiBrazilCertificateModel rgEmissorUF(String rgEmissorUF) {
    this.rgEmissorUF = rgEmissorUF;
    return this;
  }

   /**
   * Get rgEmissorUF
   * @return rgEmissorUF
  **/
  @Schema(description = "")
  public String getRgEmissorUF() {
    return rgEmissorUF;
  }

  public void setRgEmissorUF(String rgEmissorUF) {
    this.rgEmissorUF = rgEmissorUF;
  }

  public PkiBrazilCertificateModel rgNumero(String rgNumero) {
    this.rgNumero = rgNumero;
    return this;
  }

   /**
   * Get rgNumero
   * @return rgNumero
  **/
  @Schema(description = "")
  public String getRgNumero() {
    return rgNumero;
  }

  public void setRgNumero(String rgNumero) {
    this.rgNumero = rgNumero;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PkiBrazilCertificateModel pkiBrazilCertificateModel = (PkiBrazilCertificateModel) o;
    return Objects.equals(this.certificateType, pkiBrazilCertificateModel.certificateType) &&
        Objects.equals(this.cpf, pkiBrazilCertificateModel.cpf) &&
        Objects.equals(this.cnpj, pkiBrazilCertificateModel.cnpj) &&
        Objects.equals(this.responsavel, pkiBrazilCertificateModel.responsavel) &&
        Objects.equals(this.dateOfBirth, pkiBrazilCertificateModel.dateOfBirth) &&
        Objects.equals(this.companyName, pkiBrazilCertificateModel.companyName) &&
        Objects.equals(this.oabUF, pkiBrazilCertificateModel.oabUF) &&
        Objects.equals(this.oabNumero, pkiBrazilCertificateModel.oabNumero) &&
        Objects.equals(this.rgEmissor, pkiBrazilCertificateModel.rgEmissor) &&
        Objects.equals(this.rgEmissorUF, pkiBrazilCertificateModel.rgEmissorUF) &&
        Objects.equals(this.rgNumero, pkiBrazilCertificateModel.rgNumero);
  }

  @Override
  public int hashCode() {
    return Objects.hash(certificateType, cpf, cnpj, responsavel, dateOfBirth, companyName, oabUF, oabNumero, rgEmissor, rgEmissorUF, rgNumero);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PkiBrazilCertificateModel {\n");
    
    sb.append("    certificateType: ").append(toIndentedString(certificateType)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    cnpj: ").append(toIndentedString(cnpj)).append("\n");
    sb.append("    responsavel: ").append(toIndentedString(responsavel)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    oabUF: ").append(toIndentedString(oabUF)).append("\n");
    sb.append("    oabNumero: ").append(toIndentedString(oabNumero)).append("\n");
    sb.append("    rgEmissor: ").append(toIndentedString(rgEmissor)).append("\n");
    sb.append("    rgEmissorUF: ").append(toIndentedString(rgEmissorUF)).append("\n");
    sb.append("    rgNumero: ").append(toIndentedString(rgNumero)).append("\n");
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
