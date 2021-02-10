package com.lacunasoftware.restpki;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ValidateFileResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-02-01T20:41:18.158913-02:00[America/Sao_Paulo]")@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class ValidateFileResponse {

  @JsonProperty("accept")
  private boolean accept = true;

  @JsonProperty("rejectReason")
  private String rejectReason = null;

  public ValidateFileResponse accept(boolean accept) {
    this.accept = accept;
    return this;
  }

  /**
  * Get accept
  * @return accept
  **/
  @Schema(description = "true")
  public boolean getAccept() {
    return accept;
  }
  public void setAccept(boolean accept) {
    this.accept = accept;
  }

  public ValidateFileResponse rejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
    return this;
  }

  /**
  * Get rejectReason
  * @return rejectReason
  **/
  @Schema(description = "")
  public String getRejectReason() {
    return rejectReason;
  }
  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateFileResponse ValidateFileResponse = (ValidateFileResponse) o;
    return Objects.equals(this.accept, ValidateFileResponse.accept) &&
        Objects.equals(this.rejectReason, ValidateFileResponse.rejectReason);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(accept, rejectReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateFileResponse {\n");
    
    sb.append("    accept: ").append(toIndentedString(accept)).append("\n");
    sb.append("    rejectReason: ").append(toIndentedString(rejectReason)).append("\n");
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
