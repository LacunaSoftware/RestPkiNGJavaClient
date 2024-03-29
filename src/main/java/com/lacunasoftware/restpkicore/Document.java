package com.lacunasoftware.restpkicore;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.lang.*;

/**
 * Document
 */
public class Document {

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

    public Date getAvailableUntil(){
        return model.getAvailableUntil();
    }

    public Document(RestPkiService service, DocumentModel model) {
        this.model = model;
        originalFile = new DocumentFile(service, model.getOriginalFile());
        signedFile = model.getSignedFile() != null ? new DocumentFile(service, model.getSignedFile()) : null;
        markedFile = model.getMarkedFile() != null ? new DocumentFile(service, model.getMarkedFile()) : null;
    }


    public List<SignerSummary> GetSignerSummariesAsync() {
        return model.getSigners();
    }
}
