package com.lacunasoftware.restpkicore;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ValidateFileRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-02-01T20:41:18.158913-02:00[America/Sao_Paulo]")@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class ValidateFileRequest {

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("length")
  private Integer length = null;

  public ValidateFileRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
  * Get name
  * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public ValidateFileRequest contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
  * Get contentType
  * @return contentType
  **/
  @Schema(description = "")
  public String getContentType() {
    return contentType;
  }
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ValidateFileRequest length(Integer length) {
    this.length = length;
    return this;
  }

  /**
  * Get length
  * @return length
  **/
  @Schema(description = "")
  public Integer getLength() {
    return length;
  }
  public void setLength(Integer length) {
    this.length = length;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateFileRequest ValidateFileRequest = (ValidateFileRequest) o;
    return Objects.equals(this.name, ValidateFileRequest.name) &&
        Objects.equals(this.contentType, ValidateFileRequest.contentType) &&
        Objects.equals(this.length, ValidateFileRequest.length);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, contentType, length);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateFileRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
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
