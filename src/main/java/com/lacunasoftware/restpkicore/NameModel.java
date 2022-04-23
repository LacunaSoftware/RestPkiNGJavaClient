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
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * NameModel
 */



@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class NameModel {
  @JsonProperty("country")
  private String country = null;

  @JsonProperty("organization")
  private String organization = null;

  @JsonProperty("organizationUnit")
  private String organizationUnit = null;

  @JsonProperty("dnQualifier")
  private String dnQualifier = null;

  @JsonProperty("stateName")
  private String stateName = null;

  @JsonProperty("commonName")
  private String commonName = null;

  @JsonProperty("serialNumber")
  private String serialNumber = null;

  @JsonProperty("locality")
  private String locality = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("givenName")
  private String givenName = null;

  @JsonProperty("initials")
  private String initials = null;

  @JsonProperty("pseudonym")
  private String pseudonym = null;

  @JsonProperty("generationQualifier")
  private String generationQualifier = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("allValues")
  private Map<String, List<String>> allValues = null;

  public NameModel country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @Schema(description = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public NameModel organization(String organization) {
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

  public NameModel organizationUnit(String organizationUnit) {
    this.organizationUnit = organizationUnit;
    return this;
  }

   /**
   * Get organizationUnit
   * @return organizationUnit
  **/
  @Schema(description = "")
  public String getOrganizationUnit() {
    return organizationUnit;
  }

  public void setOrganizationUnit(String organizationUnit) {
    this.organizationUnit = organizationUnit;
  }

  public NameModel dnQualifier(String dnQualifier) {
    this.dnQualifier = dnQualifier;
    return this;
  }

   /**
   * Get dnQualifier
   * @return dnQualifier
  **/
  @Schema(description = "")
  public String getDnQualifier() {
    return dnQualifier;
  }

  public void setDnQualifier(String dnQualifier) {
    this.dnQualifier = dnQualifier;
  }

  public NameModel stateName(String stateName) {
    this.stateName = stateName;
    return this;
  }

   /**
   * Get stateName
   * @return stateName
  **/
  @Schema(description = "")
  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public NameModel commonName(String commonName) {
    this.commonName = commonName;
    return this;
  }

   /**
   * Get commonName
   * @return commonName
  **/
  @Schema(description = "")
  public String getCommonName() {
    return commonName;
  }

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }

  public NameModel serialNumber(String serialNumber) {
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

  public NameModel locality(String locality) {
    this.locality = locality;
    return this;
  }

   /**
   * Get locality
   * @return locality
  **/
  @Schema(description = "")
  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public NameModel title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @Schema(description = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public NameModel surname(String surname) {
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @Schema(description = "")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public NameModel givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

   /**
   * Get givenName
   * @return givenName
  **/
  @Schema(description = "")
  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public NameModel initials(String initials) {
    this.initials = initials;
    return this;
  }

   /**
   * Get initials
   * @return initials
  **/
  @Schema(description = "")
  public String getInitials() {
    return initials;
  }

  public void setInitials(String initials) {
    this.initials = initials;
  }

  public NameModel pseudonym(String pseudonym) {
    this.pseudonym = pseudonym;
    return this;
  }

   /**
   * Get pseudonym
   * @return pseudonym
  **/
  @Schema(description = "")
  public String getPseudonym() {
    return pseudonym;
  }

  public void setPseudonym(String pseudonym) {
    this.pseudonym = pseudonym;
  }

  public NameModel generationQualifier(String generationQualifier) {
    this.generationQualifier = generationQualifier;
    return this;
  }

   /**
   * Get generationQualifier
   * @return generationQualifier
  **/
  @Schema(description = "")
  public String getGenerationQualifier() {
    return generationQualifier;
  }

  public void setGenerationQualifier(String generationQualifier) {
    this.generationQualifier = generationQualifier;
  }

  public NameModel emailAddress(String emailAddress) {
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

  public NameModel allValues(Map<String, List<String>> allValues) {
    this.allValues = allValues;
    return this;
  }

  public NameModel putAllValuesItem(String key, List<String> allValuesItem) {
    if (this.allValues == null) {
      this.allValues = new HashMap<>();
    }
    this.allValues.put(key, allValuesItem);
    return this;
  }

   /**
   * Get allValues
   * @return allValues
  **/
  @Schema(description = "")
  public Map<String, List<String>> getAllValues() {
    return allValues;
  }

  public void setAllValues(Map<String, List<String>> allValues) {
    this.allValues = allValues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NameModel nameModel = (NameModel) o;
    return Objects.equals(this.country, nameModel.country) &&
        Objects.equals(this.organization, nameModel.organization) &&
        Objects.equals(this.organizationUnit, nameModel.organizationUnit) &&
        Objects.equals(this.dnQualifier, nameModel.dnQualifier) &&
        Objects.equals(this.stateName, nameModel.stateName) &&
        Objects.equals(this.commonName, nameModel.commonName) &&
        Objects.equals(this.serialNumber, nameModel.serialNumber) &&
        Objects.equals(this.locality, nameModel.locality) &&
        Objects.equals(this.title, nameModel.title) &&
        Objects.equals(this.surname, nameModel.surname) &&
        Objects.equals(this.givenName, nameModel.givenName) &&
        Objects.equals(this.initials, nameModel.initials) &&
        Objects.equals(this.pseudonym, nameModel.pseudonym) &&
        Objects.equals(this.generationQualifier, nameModel.generationQualifier) &&
        Objects.equals(this.emailAddress, nameModel.emailAddress) &&
        Objects.equals(this.allValues, nameModel.allValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, organization, organizationUnit, dnQualifier, stateName, commonName, serialNumber, locality, title, surname, givenName, initials, pseudonym, generationQualifier, emailAddress, allValues);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NameModel {\n");
    
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    organizationUnit: ").append(toIndentedString(organizationUnit)).append("\n");
    sb.append("    dnQualifier: ").append(toIndentedString(dnQualifier)).append("\n");
    sb.append("    stateName: ").append(toIndentedString(stateName)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    initials: ").append(toIndentedString(initials)).append("\n");
    sb.append("    pseudonym: ").append(toIndentedString(pseudonym)).append("\n");
    sb.append("    generationQualifier: ").append(toIndentedString(generationQualifier)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    allValues: ").append(toIndentedString(allValues)).append("\n");
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
