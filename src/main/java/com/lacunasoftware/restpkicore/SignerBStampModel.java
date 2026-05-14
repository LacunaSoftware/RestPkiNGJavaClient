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
import com.lacunasoftware.restpkicore.Blockchains;
import com.lacunasoftware.restpkicore.DigestAlgorithmAndValueModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * SignerBStampModel
 */




@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class SignerBStampModel {
  @JsonProperty("signatureDigest")
  private DigestAlgorithmAndValueModel signatureDigest = null;

  @JsonProperty("crlsDigests")
  private List<DigestAlgorithmAndValueModel> crlsDigests = null;

  @JsonProperty("certificateDigests")
  private List<DigestAlgorithmAndValueModel> certificateDigests = null;

  @JsonProperty("blockchain")
  private Blockchains blockchain = null;

  @JsonProperty("transactionId")
  private String transactionId = null;

  @JsonProperty("transactionDate")
  private Date transactionDate = null;

  public SignerBStampModel signatureDigest(DigestAlgorithmAndValueModel signatureDigest) {
    this.signatureDigest = signatureDigest;
    return this;
  }

   /**
   * Get signatureDigest
   * @return signatureDigest
  **/
  @Schema(description = "")
  public DigestAlgorithmAndValueModel getSignatureDigest() {
    return signatureDigest;
  }

  public void setSignatureDigest(DigestAlgorithmAndValueModel signatureDigest) {
    this.signatureDigest = signatureDigest;
  }

  public SignerBStampModel crlsDigests(List<DigestAlgorithmAndValueModel> crlsDigests) {
    this.crlsDigests = crlsDigests;
    return this;
  }

  public SignerBStampModel addCrlsDigestsItem(DigestAlgorithmAndValueModel crlsDigestsItem) {
    if (this.crlsDigests == null) {
      this.crlsDigests = new ArrayList<>();
    }
    this.crlsDigests.add(crlsDigestsItem);
    return this;
  }

   /**
   * Get crlsDigests
   * @return crlsDigests
  **/
  @Schema(description = "")
  public List<DigestAlgorithmAndValueModel> getCrlsDigests() {
    return crlsDigests;
  }

  public void setCrlsDigests(List<DigestAlgorithmAndValueModel> crlsDigests) {
    this.crlsDigests = crlsDigests;
  }

  public SignerBStampModel certificateDigests(List<DigestAlgorithmAndValueModel> certificateDigests) {
    this.certificateDigests = certificateDigests;
    return this;
  }

  public SignerBStampModel addCertificateDigestsItem(DigestAlgorithmAndValueModel certificateDigestsItem) {
    if (this.certificateDigests == null) {
      this.certificateDigests = new ArrayList<>();
    }
    this.certificateDigests.add(certificateDigestsItem);
    return this;
  }

   /**
   * Get certificateDigests
   * @return certificateDigests
  **/
  @Schema(description = "")
  public List<DigestAlgorithmAndValueModel> getCertificateDigests() {
    return certificateDigests;
  }

  public void setCertificateDigests(List<DigestAlgorithmAndValueModel> certificateDigests) {
    this.certificateDigests = certificateDigests;
  }

  public SignerBStampModel blockchain(Blockchains blockchain) {
    this.blockchain = blockchain;
    return this;
  }

   /**
   * Get blockchain
   * @return blockchain
  **/
  @Schema(description = "")
  public Blockchains getBlockchain() {
    return blockchain;
  }

  public void setBlockchain(Blockchains blockchain) {
    this.blockchain = blockchain;
  }

  public SignerBStampModel transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

   /**
   * Get transactionId
   * @return transactionId
  **/
  @Schema(description = "")
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public SignerBStampModel transactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
    return this;
  }

   /**
   * Get transactionDate
   * @return transactionDate
  **/
  @Schema(description = "")
  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignerBStampModel signerBStampModel = (SignerBStampModel) o;
    return Objects.equals(this.signatureDigest, signerBStampModel.signatureDigest) &&
        Objects.equals(this.crlsDigests, signerBStampModel.crlsDigests) &&
        Objects.equals(this.certificateDigests, signerBStampModel.certificateDigests) &&
        Objects.equals(this.blockchain, signerBStampModel.blockchain) &&
        Objects.equals(this.transactionId, signerBStampModel.transactionId) &&
        Objects.equals(this.transactionDate, signerBStampModel.transactionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signatureDigest, crlsDigests, certificateDigests, blockchain, transactionId, transactionDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignerBStampModel {\n");
    
    sb.append("    signatureDigest: ").append(toIndentedString(signatureDigest)).append("\n");
    sb.append("    crlsDigests: ").append(toIndentedString(crlsDigests)).append("\n");
    sb.append("    certificateDigests: ").append(toIndentedString(certificateDigests)).append("\n");
    sb.append("    blockchain: ").append(toIndentedString(blockchain)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n");
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
