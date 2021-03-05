package com.lacunasoftware.restpki;

import java.util.UUID;
import java.io.IOException;
import java.io.InputStream;

/**
 * RestPkiService
 */
public interface RestPkiService {

    CreateSignatureSessionResponse createSignatureSession(CreateSignatureSessionRequest request) throws RestException;

    CreateSignatureSessionResponse createSignatureSession(CreateSignatureSessionRequest request, UUID subscriptionId) throws RestException;

    SignatureSession getSignatureSession(UUID id) throws RestException;

    Document getDocument(UUID id) throws RestException;

    Document getDocument(DocumentModel model);

    InputStream openRead(String location) throws RestException;

    byte[] getContent(String location) throws RestException, IOException;

    DocumentModel GetDocumentModel(UUID id) throws RestException;
}