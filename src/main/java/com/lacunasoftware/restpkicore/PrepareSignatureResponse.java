/*
 * Rest PKI Core API
 * <b><i>Para Português, <a href=\"https://docs.lacunasoftware.com/pt-br/articles/rest-pki/core/integration/get-started\">clique aqui</a></i></b>  <p>   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/\">Rest PKI Core</a> is an upcoming version of   <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/\">Rest PKI</a> that will have extended compatibility with environments and databases.  </p>  <p>   In addition to Windows Server (which is already supported by Rest PKI), Rest PKI Core will also run on <b>Linux</b> (Debian- and RedHat-based distributions)   and on <b>Docker</b>. As for database servers, in addition to SQL Server, <b>PostgreSQL</b> will also be supported.  </p>  <p>   <b>Before getting started, see the integration overview on the <a href=\"https://docs.lacunasoftware.com/en-us/articles/rest-pki/core/integration/\">Integration Guide</a></b>  </p>  <p>   For questions regarding the usage of this API, please reach us at <a href=\"https://lacuna.help/\">lacuna.help</a>  </p>    <h2>Parameters</h2>  <p>   You will need the following parameters:  </p>  <ul>   <li><b>Endpoint</b>: address of the Rest PKI Core instance that will be used</li>   <li><b>API Key</b>: authorization key for using the API</li>  </ul>  <p>   The <span class=\"model\">endpoint</span> must be prefixed to all relative URLs mentioned here. As for the <span class=\"model\">API Key</span>, see how to use it below.  </p>    <h2>Authentication</h2>  <p>   The API key must be sent on the <span class=\"model\">X-Api-Key</span> header on each request:  </p>    <!-- unfortunately, class \"example microlight\" doesn't seem to work here -->  <pre style=\"font-size: 12px; padding: 10px; border-radius: 4px; background: #41444e; font-weight: 600; color: #fff;\">  X-Api-Key: yourapp|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  </pre>    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response body is an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>    </tr>    <tr>     <td><strong class=\"model-title\">500 (Internal Server Error)</strong></td>     <td>An unexpected error occurred. The <span class=\"model\">exceptionCode</span> contained on the response body may be of help for our support team during diagnostic.</td>    </tr>   </tbody>  </table>    <h3>Error Codes</h3>    <p>   Some of the error codes returned in the <span class=\"model\">code</span> field of an <a href=\"#model-ErrorModelV2\" class=\"model\">ErrorModelV2</a>   (body of responses with HTTP status code 422) are provided below*:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td class=\"model\">DocumentNotFound</td>     <td>A referenced document was not found (check the document ID)</td>    </tr>    <tr>     <td class=\"model\">SecurityContextNotFound</td>     <td>A referenced security context was not found (check the security context ID)</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionNotFound</td>     <td>A referenced signature session was not found (check the signature session ID)</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionOperation</td>     <td>The operation is invalid for the current signature session or document status. For instance, trying to await the session's completion if it is still <span class=\"model\">Pending</span> results in this error</td>    </tr>    <tr>     <td class=\"model\">BackgroundProcessing</td>     <td>The operation cannot be completed at this time because the resource is being processed in background</td>    </tr>    <tr>     <td class=\"model\">SignatureSessionTokenRequired</td>     <td>The signature session token was not passed on the <span class=\"model\">X-Signature-Session-Token</span> request header</td>    </tr>    <tr>     <td class=\"model\">BadSignatureSessionToken</td>     <td>An invalid signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Check your application for possible corruption of the session token, which may contain characters <span class=\"code\">-</span> (hyphen) and <span class=\"code\">_</span> (underscore)</td>    </tr>    <tr>     <td class=\"model\">ExpiredSignatureSessionToken</td>     <td>An expired signature session token was passed on the <span class=\"model\">X-Signature-Session-Token</span> request header. Signature session tokens are normally valid for 4 hours.</td>    </tr>   </tbody>  </table>    <p style=\"font-size: 0.9em\">   *The codes shown above are the most common error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <h2>Culture / Internationalization (i18n)</h2>  <p>The <span class=\"model\">Accept-Language</span> request header is observed by this API. The following cultures are supported:</p>  <ul>   <li><span class=\"code\">en-US</span> (or simply <span class=\"code\">en</span>)</li>   <li><span class=\"code\">pt-BR</span> (or simply <span class=\"code\">pt</span>)</li>  </ul>  <p><i>Notice: error messages are not affected by this header and therefore should not be displayed to users, being better suited for logging.</i></p>  
 *
 * The version of the OpenAPI document: 2.2.2
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.lacunasoftware.restpkicore;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lacunasoftware.restpkicore.CertificateModel;
import com.lacunasoftware.restpkicore.DigestAlgorithmAndValueModel;
import com.lacunasoftware.restpkicore.PrepareSignatureFailures;
import com.lacunasoftware.restpkicore.ValidationResultsModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PrepareSignatureResponse
 */
@JsonPropertyOrder({
  PrepareSignatureResponse.JSON_PROPERTY_SUCCESS,
  PrepareSignatureResponse.JSON_PROPERTY_FAILURE,
  PrepareSignatureResponse.JSON_PROPERTY_STATE,
  PrepareSignatureResponse.JSON_PROPERTY_TO_SIGN_HASH,
  PrepareSignatureResponse.JSON_PROPERTY_VALIDATION_RESULTS,
  PrepareSignatureResponse.JSON_PROPERTY_CERTIFICATE
})

public class PrepareSignatureResponse {
  public static final String JSON_PROPERTY_SUCCESS = "success";
  private Boolean success;

  public static final String JSON_PROPERTY_FAILURE = "failure";
  private PrepareSignatureFailures failure;

  public static final String JSON_PROPERTY_STATE = "state";
  private String state = null;

  public static final String JSON_PROPERTY_TO_SIGN_HASH = "toSignHash";
  private DigestAlgorithmAndValueModel toSignHash;

  public static final String JSON_PROPERTY_VALIDATION_RESULTS = "validationResults";
  private ValidationResultsModel validationResults;

  public static final String JSON_PROPERTY_CERTIFICATE = "certificate";
  private CertificateModel certificate;

  public PrepareSignatureResponse() {
  }

  public PrepareSignatureResponse success(Boolean success) {
    
    this.success = success;
    return this;
  }

   /**
   * Get success
   * @return success
  **/
  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isSuccess() {
    return success;
  }


  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public PrepareSignatureResponse failure(PrepareSignatureFailures failure) {
    
    this.failure = failure;
    return this;
  }

   /**
   * Get failure
   * @return failure
  **/
  
  @JsonProperty(JSON_PROPERTY_FAILURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PrepareSignatureFailures getFailure() {
    return failure;
  }


  @JsonProperty(JSON_PROPERTY_FAILURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFailure(PrepareSignatureFailures failure) {
    this.failure = failure;
  }

  public PrepareSignatureResponse state(String state) {
    this.state = state;
    
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  
  @JsonIgnore

  public String getState() {
        return state;
  }
  

  public void setState(String state) {
    this.state = state;
  }

  public PrepareSignatureResponse toSignHash(DigestAlgorithmAndValueModel toSignHash) {
    
    this.toSignHash = toSignHash;
    return this;
  }

   /**
   * Get toSignHash
   * @return toSignHash
  **/  
  @JsonProperty(JSON_PROPERTY_TO_SIGN_HASH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DigestAlgorithmAndValueModel getToSignHash() {
    return toSignHash;
  }


  @JsonProperty(JSON_PROPERTY_TO_SIGN_HASH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToSignHash(DigestAlgorithmAndValueModel toSignHash) {
    this.toSignHash = toSignHash;
  }

  public PrepareSignatureResponse validationResults(ValidationResultsModel validationResults) {
    
    this.validationResults = validationResults;
    return this;
  }

   /**
   * Get validationResults
   * @return validationResults
  **/
  @JsonProperty(JSON_PROPERTY_VALIDATION_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ValidationResultsModel getValidationResults() {
    return validationResults;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATION_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidationResults(ValidationResultsModel validationResults) {
    this.validationResults = validationResults;
  }

  public PrepareSignatureResponse certificate(CertificateModel certificate) {
    
    this.certificate = certificate;
    return this;
  }

   /**
   * Get certificate
   * @return certificate
  **/
  @JsonProperty(JSON_PROPERTY_CERTIFICATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CertificateModel getCertificate() {
    return certificate;
  }


  @JsonProperty(JSON_PROPERTY_CERTIFICATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCertificate(CertificateModel certificate) {
    this.certificate = certificate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrepareSignatureResponse prepareSignatureResponse = (PrepareSignatureResponse) o;
    return Objects.equals(this.success, prepareSignatureResponse.success) &&
        Objects.equals(this.failure, prepareSignatureResponse.failure) &&
        Objects.equals(this.state, prepareSignatureResponse.state) &&
        Objects.equals(this.toSignHash, prepareSignatureResponse.toSignHash) &&
        Objects.equals(this.validationResults, prepareSignatureResponse.validationResults) &&
        Objects.equals(this.certificate, prepareSignatureResponse.certificate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrepareSignatureResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    failure: ").append(toIndentedString(failure)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    toSignHash: ").append(toIndentedString(toSignHash)).append("\n");
    sb.append("    validationResults: ").append(toIndentedString(validationResults)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public static class Builder {

    private PrepareSignatureResponse instance;

    public Builder() {
      this(new PrepareSignatureResponse());
    }

    protected Builder(PrepareSignatureResponse instance) {
      this.instance = instance;
    }

    public PrepareSignatureResponse.Builder success(Boolean success) {
      this.instance.success = success;
      return this;
    }
    public PrepareSignatureResponse.Builder failure(PrepareSignatureFailures failure) {
      this.instance.failure = failure;
      return this;
    }
    public PrepareSignatureResponse.Builder state(String state) {
      this.instance.state = state;
      return this;
    }
    
    public PrepareSignatureResponse.Builder toSignHash(DigestAlgorithmAndValueModel toSignHash) {
      this.instance.toSignHash = toSignHash;
      return this;
    }
    public PrepareSignatureResponse.Builder validationResults(ValidationResultsModel validationResults) {
      this.instance.validationResults = validationResults;
      return this;
    }
    public PrepareSignatureResponse.Builder certificate(CertificateModel certificate) {
      this.instance.certificate = certificate;
      return this;
    }


    /**
    * returns a built PrepareSignatureResponse instance.
    *
    * The builder is not reusable.
    */
    public PrepareSignatureResponse build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field.
  */
  public static PrepareSignatureResponse.Builder builder() {
    return new PrepareSignatureResponse.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PrepareSignatureResponse.Builder toBuilder() {
    return new PrepareSignatureResponse.Builder()
      .success(isSuccess())
      .failure(getFailure())
      .state(getState())
      .toSignHash(getToSignHash())
      .validationResults(getValidationResults())
      .certificate(getCertificate());
  }


}

