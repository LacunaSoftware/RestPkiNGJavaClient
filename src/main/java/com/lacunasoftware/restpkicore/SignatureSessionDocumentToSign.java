package com.lacunasoftware.restpkicore;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SignatureSessionDocumentToSign {

    private UUID id;
    private FileReference file;
    private Map<String, List<String>> metadata;
    private String documentKey;
    private SignatureTypes signatureType;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public FileReference getFile() { return file; }
    public void setFile(FileReference file) { this.file = file; }

    public Map<String, List<String>> getMetadata() { return metadata; }
    public void setMetadata(Map<String, List<String>> metadata) { this.metadata = metadata; }

    public String getDocumentKey() { return documentKey; }
    public void setDocumentKey(String documentKey) { this.documentKey = documentKey; }

    public SignatureTypes getSignatureType() { return signatureType; }
    public void setSignatureType(SignatureTypes signatureType) { this.signatureType = signatureType; }
}
