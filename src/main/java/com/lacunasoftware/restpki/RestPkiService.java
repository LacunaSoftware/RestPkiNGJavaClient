package com.lacunasoftware.restpki;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import java.util.UUID;
import java.io.IOException;
import java.io.InputStream;
import java.time.OffsetDateTime;

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

    DocumentKeyModel AllocateDocumentKey(Map<String, List<String>> provisionalMetadata, UUID subscriptionId) throws RestException;

    List<DocumentKeyModel> AllocateDocumentKeys(int count, Map<String, List<String>> provisionalMetadata, UUID subscriptionId) throws RestException;

    // region Application management

    ApplicationModel CreateApplication(String name, List<Roles> roles,  Map<String, List<String>> defaultDocumentMetadata, UUID subscriptionId) throws RestException;

    CreateApplicationApiKeyResponse CreateApplicationKey(UUID applicationId, OffsetDateTime expiresOn, String description) throws RestException;

    Pair<ApplicationModel, String> CreateApplicationAndKey(String name, List<Roles> roles,  Map<String, List<String>> defaultDocumentMetadata, UUID subscriptionId) throws RestException;

    Map<String, List<String>> GetApplicationDefaultDocumentMetadata(UUID applicationId) throws RestException;

    Map<String, List<String>> UpdateApplicationDefaultDocumentMetadata(UUID applicationId,  Map<String, List<String>> defaultDocumentMetadata) throws RestException;

    // endregion
}