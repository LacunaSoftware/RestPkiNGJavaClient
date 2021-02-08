package com.lacunasoftware.restpki;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * SignatureSession
 */
public class SignatureSession {

    private SignatureSessionModel model;
    private List<Document> documents;

    public UUID getId() {
        return model.getId();
    }

    public SignatureSessionStatus getStatus() {
        return model.getStatus();
    }

    public String getCallbackArgument() {
        return model.getCallbackArgument();
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public SignatureSession(RestPkiService service, SignatureSessionModel model) {
        this.model = model;
        documents = new ArrayList<Document>();
        for (DocumentModel document : model.getDocuments()) {
            documents.add(new Document(service, document));
        }
    }
}