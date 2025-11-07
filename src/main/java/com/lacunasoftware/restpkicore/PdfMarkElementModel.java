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
import com.lacunasoftware.restpkicore.PadesHorizontalAlign;
import com.lacunasoftware.restpkicore.PadesVerticalAlign;
import com.lacunasoftware.restpkicore.PadesVisualRectangleModel;
import com.lacunasoftware.restpkicore.PdfMarkElementType;
import com.lacunasoftware.restpkicore.PdfMarkImageModel;
import com.lacunasoftware.restpkicore.PdfTextSectionModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * PdfMarkElementModel
 */




@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class PdfMarkElementModel {
  @JsonProperty("elementType")
  private PdfMarkElementType elementType = null;

  @JsonProperty("relativeContainer")
  private PadesVisualRectangleModel relativeContainer = null;

  @JsonProperty("rotation")
  private Integer rotation = null;

  @JsonProperty("textSections")
  private List<PdfTextSectionModel> textSections = null;

  @JsonProperty("image")
  private PdfMarkImageModel image = null;

  @JsonProperty("qrCodeData")
  private String qrCodeData = null;

  @JsonProperty("qrCodeDrawQuietZones")
  private Boolean qrCodeDrawQuietZones = null;

  @JsonProperty("align")
  private PadesHorizontalAlign align = null;

  @JsonProperty("verticalAlign")
  private PadesVerticalAlign verticalAlign = null;

  @JsonProperty("opacity")
  private Double opacity = null;

  public PdfMarkElementModel elementType(PdfMarkElementType elementType) {
    this.elementType = elementType;
    return this;
  }

   /**
   * Get elementType
   * @return elementType
  **/
  @Schema(description = "")
  public PdfMarkElementType getElementType() {
    return elementType;
  }

  public void setElementType(PdfMarkElementType elementType) {
    this.elementType = elementType;
  }

  public PdfMarkElementModel relativeContainer(PadesVisualRectangleModel relativeContainer) {
    this.relativeContainer = relativeContainer;
    return this;
  }

   /**
   * Get relativeContainer
   * @return relativeContainer
  **/
  @Schema(description = "")
  public PadesVisualRectangleModel getRelativeContainer() {
    return relativeContainer;
  }

  public void setRelativeContainer(PadesVisualRectangleModel relativeContainer) {
    this.relativeContainer = relativeContainer;
  }

  public PdfMarkElementModel rotation(Integer rotation) {
    this.rotation = rotation;
    return this;
  }

   /**
   * Get rotation
   * @return rotation
  **/
  @Schema(description = "")
  public Integer getRotation() {
    return rotation;
  }

  public void setRotation(Integer rotation) {
    this.rotation = rotation;
  }

  public PdfMarkElementModel textSections(List<PdfTextSectionModel> textSections) {
    this.textSections = textSections;
    return this;
  }

  public PdfMarkElementModel addTextSectionsItem(PdfTextSectionModel textSectionsItem) {
    if (this.textSections == null) {
      this.textSections = new ArrayList<>();
    }
    this.textSections.add(textSectionsItem);
    return this;
  }

   /**
   * Get textSections
   * @return textSections
  **/
  @Schema(description = "")
  public List<PdfTextSectionModel> getTextSections() {
    return textSections;
  }

  public void setTextSections(List<PdfTextSectionModel> textSections) {
    this.textSections = textSections;
  }

  public PdfMarkElementModel image(PdfMarkImageModel image) {
    this.image = image;
    return this;
  }

   /**
   * Get image
   * @return image
  **/
  @Schema(description = "")
  public PdfMarkImageModel getImage() {
    return image;
  }

  public void setImage(PdfMarkImageModel image) {
    this.image = image;
  }

  public PdfMarkElementModel qrCodeData(String qrCodeData) {
    this.qrCodeData = qrCodeData;
    return this;
  }

   /**
   * Get qrCodeData
   * @return qrCodeData
  **/
  @Schema(description = "")
  public String getQrCodeData() {
    return qrCodeData;
  }

  public void setQrCodeData(String qrCodeData) {
    this.qrCodeData = qrCodeData;
  }

  public PdfMarkElementModel qrCodeDrawQuietZones(Boolean qrCodeDrawQuietZones) {
    this.qrCodeDrawQuietZones = qrCodeDrawQuietZones;
    return this;
  }

   /**
   * Get qrCodeDrawQuietZones
   * @return qrCodeDrawQuietZones
  **/
  @Schema(description = "")
  public Boolean isQrCodeDrawQuietZones() {
    return qrCodeDrawQuietZones;
  }

  public void setQrCodeDrawQuietZones(Boolean qrCodeDrawQuietZones) {
    this.qrCodeDrawQuietZones = qrCodeDrawQuietZones;
  }

  public PdfMarkElementModel align(PadesHorizontalAlign align) {
    this.align = align;
    return this;
  }

   /**
   * Get align
   * @return align
  **/
  @Schema(description = "")
  public PadesHorizontalAlign getAlign() {
    return align;
  }

  public void setAlign(PadesHorizontalAlign align) {
    this.align = align;
  }

  public PdfMarkElementModel verticalAlign(PadesVerticalAlign verticalAlign) {
    this.verticalAlign = verticalAlign;
    return this;
  }

   /**
   * Get verticalAlign
   * @return verticalAlign
  **/
  @Schema(description = "")
  public PadesVerticalAlign getVerticalAlign() {
    return verticalAlign;
  }

  public void setVerticalAlign(PadesVerticalAlign verticalAlign) {
    this.verticalAlign = verticalAlign;
  }

  public PdfMarkElementModel opacity(Double opacity) {
    this.opacity = opacity;
    return this;
  }

   /**
   * Get opacity
   * @return opacity
  **/
  @Schema(description = "")
  public Double getOpacity() {
    return opacity;
  }

  public void setOpacity(Double opacity) {
    this.opacity = opacity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PdfMarkElementModel pdfMarkElementModel = (PdfMarkElementModel) o;
    return Objects.equals(this.elementType, pdfMarkElementModel.elementType) &&
        Objects.equals(this.relativeContainer, pdfMarkElementModel.relativeContainer) &&
        Objects.equals(this.rotation, pdfMarkElementModel.rotation) &&
        Objects.equals(this.textSections, pdfMarkElementModel.textSections) &&
        Objects.equals(this.image, pdfMarkElementModel.image) &&
        Objects.equals(this.qrCodeData, pdfMarkElementModel.qrCodeData) &&
        Objects.equals(this.qrCodeDrawQuietZones, pdfMarkElementModel.qrCodeDrawQuietZones) &&
        Objects.equals(this.align, pdfMarkElementModel.align) &&
        Objects.equals(this.verticalAlign, pdfMarkElementModel.verticalAlign) &&
        Objects.equals(this.opacity, pdfMarkElementModel.opacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementType, relativeContainer, rotation, textSections, image, qrCodeData, qrCodeDrawQuietZones, align, verticalAlign, opacity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PdfMarkElementModel {\n");
    
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    relativeContainer: ").append(toIndentedString(relativeContainer)).append("\n");
    sb.append("    rotation: ").append(toIndentedString(rotation)).append("\n");
    sb.append("    textSections: ").append(toIndentedString(textSections)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    qrCodeData: ").append(toIndentedString(qrCodeData)).append("\n");
    sb.append("    qrCodeDrawQuietZones: ").append(toIndentedString(qrCodeDrawQuietZones)).append("\n");
    sb.append("    align: ").append(toIndentedString(align)).append("\n");
    sb.append("    verticalAlign: ").append(toIndentedString(verticalAlign)).append("\n");
    sb.append("    opacity: ").append(toIndentedString(opacity)).append("\n");
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
