package com.lacunasoftware.restpkicore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrepareSignatureRequest {

    @JsonProperty("file")
    private FileReferenceModel file = null;

    @JsonProperty("certificate")
    private CertificateModel certificate = null;

    @JsonProperty("securityContextId")
    private String securityContextId = null;

    @JsonProperty("signatureTypes")
    private SignatureTypes signatureTypes = null;

    @JsonProperty("cmsSignatureOptions")
    private PdfSignatureOptions pdfSignatureOptions = null;

    @JsonProperty("cmsSignatureOptions")
    private CmsSignatureOptions cmsSignatureOptions = null;

    @JsonProperty("xmlSignatureOptions")
    private XmlSignatureOptions xmlSignatureOptions = null;


    public FileReferenceModel getFile() {
        return file;
    }

    public void setFile(FileReferenceModel file) {
        this.file = file;
    }

    public CertificateModel getCertificate() {
        return certificate;
    }

    public void setCertificate(CertificateModel certificate) {
        this.certificate = certificate;
    }

    public String getSecurityContextId() {
        return securityContextId;
    }

    public void setSecurityContextId(String securityContextId) {
        this.securityContextId = securityContextId;
    }

    public SignatureTypes getSignatureTypes() {
        return signatureTypes;
    }

    public void setSignatureTypes(SignatureTypes signatureTypes) {
        this.signatureTypes = signatureTypes;
    }

    public CmsSignatureOptions getCmsSignatureOptions() {
        return cmsSignatureOptions;
    }

    public void setCmsSignatureOptions(CmsSignatureOptions cmsSignatureOptions) {
        this.cmsSignatureOptions = cmsSignatureOptions;
    }

    public XmlSignatureOptions getXmlSignatureOptions() {
        return xmlSignatureOptions;
    }

    public void setXmlSignatureOptions(XmlSignatureOptions xmlSignatureOptions) {
        this.xmlSignatureOptions = xmlSignatureOptions;
    }


}
