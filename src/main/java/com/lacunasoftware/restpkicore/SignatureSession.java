package com.lacunasoftware.restpkicore;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * SignatureSession
 */
public class SignatureSession {

    private final RestPkiService service;
    private SignatureSessionModel model;


    private List<SignatureSessionDocument> documents;

    public UUID getId() {
        return model.getId();
    }

    public SignatureSessionStatus getStatus() {
        return model.getStatus();
    }

    public String getProcessingErrorCode(){
        return model.getProcessingErrorCode();
    }

    public String getCallbackArgument() {
        return model.getCallbackArgument();
    }

    public CertificateSummary getSignerCertificate(){
        return model.getSignerCertificate();
    }

    public List<SignatureSessionDocument> getDocuments() {
        return documents;
    }

    public SignatureSession(RestPkiService service, SignatureSessionModel model) {
        this.service = service;
        this.model = model;
        this.documents = (model.getDocuments()).stream()
                .map(s -> new SignatureSessionDocument(service,s))
                .collect(Collectors.toList());
    }
}