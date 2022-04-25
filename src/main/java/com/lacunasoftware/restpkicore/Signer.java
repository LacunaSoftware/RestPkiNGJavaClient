package com.lacunasoftware.restpkicore;

import java.util.Date;

public class Signer {

    private SignerModel model;
    private PKCertificate certificate;

    public DigestAlgorithmAndValueModel MessageDigest() {
        return model.getMessageDigest();
    }

    public SignatureAlgorithmAndValueModel Signature() {
        return model.getSignature();
    }

    public Date SigningTime() {
        return model.getSigningTime();
    }

    public Date CertifiedDateReference() {
        return model.getCertifiedDateReference();
    }

    public Boolean IsDocumentTimestamp() {
        return model.isIsDocumentTimestamp();
    }

    public String SignatureFieldName() {
        return model.getSignatureFieldName();
    }

    public ValidationResultsModel getValidationResults() {
        return model.getValidationResults();
    }

    public PKCertificate getCertificate() {
        return this.certificate;
    }

    Signer(SignerModel model) {
        this.model = model;
        this.certificate = new PKCertificate(model.getCertificate());
    }
}
