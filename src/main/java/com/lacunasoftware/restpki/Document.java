package com.lacunasoftware.restpki;

import java.util.UUID;

/**
 * Document
 */
public class Document {

    private DocumentModel model;
    private DocumentFile originalFile;
    private DocumentFile signedFile;

    public UUID getId() {
        return model.getId();
    }

    public String getKey() {
        return model.getKey();
    }

    public String getFormattedKey() {
        return model.getFormattedKey();
    }

    public DocumentFile getOriginalFile() {
        return originalFile;
    }

    public DocumentFile getSignedFile() {
        return signedFile;
    }

    public DocumentStatus getStatus() {
        return model.getStatus();
    }

    public SignatureTypes getSignatureType() {
        return model.getSignatureType();
    }

    public Document(RestPkiService service, DocumentModel model) {
        this.model = model;
        originalFile = new DocumentFile(service, model.getOriginalFile());
        signedFile = model.getSignedFile() != null ? new DocumentFile(service, model.getSignedFile()) : null;
    }
}