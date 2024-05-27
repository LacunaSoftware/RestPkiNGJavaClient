package com.lacunasoftware.restpkicore;

 import java.util.Objects;
 import java.util.Arrays;
 import com.fasterxml.jackson.annotation.JsonInclude;
 import com.fasterxml.jackson.annotation.JsonProperty;
 import com.fasterxml.jackson.annotation.JsonCreator;
 import com.fasterxml.jackson.annotation.JsonTypeName;
 import com.fasterxml.jackson.annotation.JsonValue;
 import com.lacunasoftware.restpkicore.XmlElementLocationModel;
 import com.lacunasoftware.restpkicore.XmlSignatureTypes;
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import java.util.NoSuchElementException;
 import com.fasterxml.jackson.annotation.JsonPropertyOrder;
 import com.fasterxml.jackson.annotation.JsonTypeName;
 
 /**
  * XmlSignatureOptions
  */
 @JsonPropertyOrder({
   XmlSignatureOptions.JSON_PROPERTY_TYPE,
   XmlSignatureOptions.JSON_PROPERTY_ELEMENT_TO_SIGN_ID,
   XmlSignatureOptions.JSON_PROPERTY_SIGNATURE_ELEMENT_LOCATION
 })

 public class XmlSignatureOptions {
   public static final String JSON_PROPERTY_TYPE = "type";
   private XmlSignatureTypes type;
 
   public static final String JSON_PROPERTY_ELEMENT_TO_SIGN_ID = "elementToSignId";
   private String elementToSignId = null;
 
   public static final String JSON_PROPERTY_SIGNATURE_ELEMENT_LOCATION = "signatureElementLocation";
   private XmlElementLocationModel signatureElementLocation;
 
   public XmlSignatureOptions() {
   }
 
   public XmlSignatureOptions type(XmlSignatureTypes type) {
     
     this.type = type;
     return this;
   }
 
    /**
    * Get type
    * @return type
   **/

   @JsonProperty(JSON_PROPERTY_TYPE)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
 
   public XmlSignatureTypes getType() {
     return type;
   }
 
 
   @JsonProperty(JSON_PROPERTY_TYPE)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
   public void setType(XmlSignatureTypes type) {
     this.type = type;
   }
 
   public XmlSignatureOptions elementToSignId(String elementToSignId) {
     this.elementToSignId = null;
     
     return this;
   }
 
    /**
    * Get elementToSignId
    * @return elementToSignId
   **/

 
   public String getElementToSignId() {
         return elementToSignId;
   } 
 
   public void setElementToSignId(String elementToSignId) {
     this.elementToSignId = (elementToSignId);
   }
 
   public XmlSignatureOptions signatureElementLocation(XmlElementLocationModel signatureElementLocation) {
     
     this.signatureElementLocation = signatureElementLocation;
     return this;
   }
 
    /**
    * Get signatureElementLocation
    * @return signatureElementLocation
   **/
   @JsonProperty(JSON_PROPERTY_SIGNATURE_ELEMENT_LOCATION)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
 
   public XmlElementLocationModel getSignatureElementLocation() {
     return signatureElementLocation;
   }
 
 
   @JsonProperty(JSON_PROPERTY_SIGNATURE_ELEMENT_LOCATION)
   @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
   public void setSignatureElementLocation(XmlElementLocationModel signatureElementLocation) {
     this.signatureElementLocation = signatureElementLocation;
   }
 
   @Override
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     XmlSignatureOptions xmlSignatureOptions = (XmlSignatureOptions) o;
     return Objects.equals(this.type, xmlSignatureOptions.type) &&       
         Objects.equals(this.signatureElementLocation, xmlSignatureOptions.signatureElementLocation);
   }
   @Override
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class XmlSignatureOptions {\n");
     sb.append("    type: ").append(toIndentedString(type)).append("\n");
     sb.append("    elementToSignId: ").append(toIndentedString(elementToSignId)).append("\n");
     sb.append("    signatureElementLocation: ").append(toIndentedString(signatureElementLocation)).append("\n");
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
 
     private XmlSignatureOptions instance;
 
     public Builder() {
       this(new XmlSignatureOptions());
     }
 
     protected Builder(XmlSignatureOptions instance) {
       this.instance = instance;
     }
 
     public XmlSignatureOptions.Builder type(XmlSignatureTypes type) {
       this.instance.type = type;
       return this;
     }
     public XmlSignatureOptions.Builder elementToSignId(String elementToSignId) {
       this.instance.elementToSignId = elementToSignId;
       return this;
     }

     public XmlSignatureOptions.Builder signatureElementLocation(XmlElementLocationModel signatureElementLocation) {
       this.instance.signatureElementLocation = signatureElementLocation;
       return this;
     }
 
 
     /**
     * returns a built XmlSignatureOptions instance.
     *
     * The builder is not reusable.
     */
     public XmlSignatureOptions build() {
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
   public static XmlSignatureOptions.Builder builder() {
     return new XmlSignatureOptions.Builder();
   }
 
   /**
   * Create a builder with a shallow copy of this instance.
   */
   public XmlSignatureOptions.Builder toBuilder() {
     return new XmlSignatureOptions.Builder()
       .type(getType())
       .elementToSignId(getElementToSignId())
       .signatureElementLocation(getSignatureElementLocation());
   }
 
 
 }
 
 