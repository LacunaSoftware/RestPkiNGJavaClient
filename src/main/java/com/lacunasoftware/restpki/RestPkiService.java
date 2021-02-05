package com.lacunasoftware.restpki;

import java.util.UUID;
import java.io.IOException;
import java.io.InputStream;

/**
 * RestPkiService
 */
public interface RestPkiService {

    public CreateSignatureSessionResponse CreateSignatureSession(CreateSignatureSessionRequest request, UUID subscriptionId) throws RestException;

    public SignatureSession GetSignatureSession(UUID id) throws RestException;

    public Document GetDocument(UUID id) throws RestException;

    public Document GetDocument(DocumentModel model);

    public InputStream OpenRead(String location) throws RestException;

    public byte[] GetContent(String location) throws RestException, IOException;
}