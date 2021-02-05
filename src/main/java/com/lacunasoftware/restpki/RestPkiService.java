package com.lacunasoftware.restpki;

import java.util.UUID;
import java.io.InputStream;

/**
 * RestPkiService
 */
public interface RestPkiService {

    public CreateSignatureSessionResponse CreateSignatureSessionAsync(CreateSignatureSessionRequest request, UUID subscriptionId);

    public SignatureSession GetSignatureSessionAsync(UUID id);

    public Document GetDocumentAsync(UUID id);

    public Document GetDocumentAsync(DocumentModel model);

    public InputStream OpenReadAsync(String location);

    public byte[] GetContentAsync(String location);
}