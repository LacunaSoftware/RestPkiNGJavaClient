package com.lacunasoftware.restpki;

import com.lacunasoftware.restpki.DocumentStatus;
import com.lacunasoftware.restpki.SignatureSessionDocumentSummary;
import org.threeten.bp.OffsetDateTime;

import java.util.Date;

public class SignatureSessionDocument extends Document {

    private SignatureSessionDocumentSummary model;

    public SignatureSessionDocument(RestPkiService service, SignatureSessionDocumentSummary model) {
        super(service, ModelConverters.toDocumentModel(model));
        this.model = model;
    }


    public DocumentStatus getStatus() {
        return model.getStatus();
    }

    public Date getDateSigned() {
        return model.getDateSigned();
    }

}
