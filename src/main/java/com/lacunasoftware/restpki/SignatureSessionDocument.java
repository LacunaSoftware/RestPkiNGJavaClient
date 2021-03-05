package com.lacunasoftware.restpki;

import org.threeten.bp.OffsetDateTime;

public class SignatureSessionDocument extends Document {

    private SignatureSessionDocumentSummary model;

    public SignatureSessionDocument(RestPkiService service, SignatureSessionDocumentSummary model) {
        super(service, ModelConverters.toDocumentModel(model));
        this.model = model;
    }


    public DocumentStatus getStatus() {
        return model.getStatus();
    }

    public OffsetDateTime getDateSigned() {
        return model.getDateSigned();
    }

}
