package com.lacunasoftware.restpkicore;

import java.util.Date;

public class Signer {


    private RestPkiService service;
    private SignerModel model;

    public PKCertificate Certificate;

    public DigestAlgorithmAndValueModel MessageDigest(){
        return model.getMessageDigest();
    }

    public SignatureAlgorithmAndValueModel Signature(){
        return model.getSignature();
    }

    public Date SigningTime(){
        return model.getSigningTime();
    }

    public Date CertifiedDateReference(){
        return model.getCertifiedDateReference();
    }

    public Boolean IsDocumentTimestamp(){
        return model.isIsDocumentTimestamp();
    }

    public String  SignatureFieldName(){
        return model.getSignatureFieldName();
    }

    public ValidationResultsModel getValidationResults(){
        return model.getValidationResults();
    }

//    public PKCertificate getPKCertificate(){
//        return this.Certificate;
//    }

    public Signer(RestPkiService service, SignerModel model) {
        this.service = service;
        this.model = model;
        //this.Certificate = new PKCertificate(model.getCertificate());
    }
    public Signer( SignerModel model) {
        this.model = model;
        this.Certificate = new PKCertificate(model.getCertificate());
    }
}
