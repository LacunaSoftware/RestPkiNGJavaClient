package com.lacunasoftware.restpki;

import java.util.List;
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
    
    public List<Signer> getDocumentSigners(UUID id) throws RestException;

    public  Document findDocumentByKey(String key) throws RestException, IOException;

    InputStream openRead(String location) throws RestException;

    byte[] getContent(String location) throws RestException, IOException;

    DocumentModel GetDocumentModel(UUID id) throws RestException;
}