package com.lacunasoftware.restpki;

import com.lacunasoftware.restpki.DocumentModel;
import com.lacunasoftware.restpki.SignatureTypes;
import com.lacunasoftware.restpki.SignerSummary;
import org.threeten.bp.OffsetDateTime;

import java.util.List;
import java.util.UUID;
import java.lang.*;

/**
 * Document
 */
public class Document {

    private final RestPkiService service;
    private DocumentModel model;

    private DocumentFile originalFile;
    private DocumentFile signedFile;
    private DocumentFile markedFile;

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

    public DocumentFile getMarkedFile() {
        return markedFile;
    }


    public SignatureTypes getSignatureType() {
        return model.getSignatureType();
    }

    public OffsetDateTime getAvailableUntil(){
        return model.getAvailableUntil();
    }

    public Document(RestPkiService service, DocumentModel model) {
        this.service = service;
        this.model = model;
        originalFile = new DocumentFile(service, model.getOriginalFile());
        signedFile = model.getSignedFile() != null ? new DocumentFile(service, model.getSignedFile()) : null;
        markedFile = model.getMarkedFile() != null ? new DocumentFile(service, model.getMarkedFile()) : null;
    }


    public List<SignerSummary> GetSignerSummariesAsync() {
        return model.getSigners();
    }

}


