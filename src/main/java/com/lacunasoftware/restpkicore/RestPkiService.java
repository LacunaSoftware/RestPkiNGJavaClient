package com.lacunasoftware.restpkicore;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;
import java.util.UUID;
import java.io.InputStream;

/**
 * RestPkiService
 */
public interface RestPkiService {

    CreateSignatureSessionResponse createSignatureSession(CreateSignatureSessionRequest request) throws Exception;
    CreateSignatureSessionResponse createSignatureSession(
            CreateSignatureSessionRequest request,
            UUID subscriptionId) throws Exception;
    CreateSignatureSessionResponse createSignatureSession(
            CreateSignatureSessionRequest request,
            UUID subscriptionId,
            Map<String, List<String>> metadata) throws Exception;
    CreateSignatureSessionResponse createSignatureSession(
            CreateSignatureSessionRequest request,
            UUID subscriptionId,
            Map<String, List<String>> metadata,
            List<SignatureSessionDocumentToSign> documents) throws Exception;

    SignatureSession getSignatureSession(UUID id) throws Exception;

    Document getDocument(UUID id) throws Exception;
    Document getDocument(DocumentModel model);

    public List<Signer> getDocumentSigners(UUID id) throws Exception;

    public  Document findDocumentByKey(String key) throws Exception;

    InputStream openRead(String location) throws Exception;

    byte[] getContent(String location) throws Exception;

    DocumentModel getDocumentModel(UUID id) throws Exception;

    DocumentKeyModel allocateDocumentKey(
            Map<String, List<String>> provisionalMetadata,
            UUID subscriptionId) throws Exception;
    DocumentKeyModel allocateDocumentKey(Map<String, List<String>> provisionalMetadata) throws Exception;
    DocumentKeyModel allocateDocumentKey() throws Exception;

    List<DocumentKeyModel> allocateDocumentKeys(
            int count,
            Map<String, List<String>> provisionalMetadata,
            UUID subscriptionId) throws Exception;
    List<DocumentKeyModel> allocateDocumentKeys(
            int count,
            Map<String, List<String>> provisionalMetadata) throws Exception;
    List<DocumentKeyModel> allocateDocumentKeys(int count) throws Exception;

    // region Application management

    ApplicationModel createApplication(
            String name,
            List<Roles> roles,
            Map<String, List<String>> defaultDocumentMetadata,
            UUID subscriptionId) throws Exception;
    ApplicationModel createApplication(
            String name,
            List<Roles> roles,
            Map<String, List<String>> defaultDocumentMetadata) throws Exception;
    ApplicationModel createApplication(
            String name,
            List<Roles> roles) throws Exception;

    CreateApplicationApiKeyResponse createApplicationKey(
            UUID applicationId,
            Date expiresOn,
            String description) throws Exception;
    CreateApplicationApiKeyResponse createApplicationKey(
            UUID applicationId,
            Date expiresOn) throws Exception;
    CreateApplicationApiKeyResponse createApplicationKey(UUID applicationId) throws Exception;

    Pair<ApplicationModel, String> createApplicationAndKey(
            String name,
            List<Roles> roles,
            Map<String, List<String>> defaultDocumentMetadata,
            UUID subscriptionId) throws Exception;
    Pair<ApplicationModel, String> createApplicationAndKey(
            String name,
            List<Roles> roles,
            Map<String, List<String>> defaultDocumentMetadata) throws Exception;
    Pair<ApplicationModel, String> createApplicationAndKey(
            String name,
            List<Roles> roles) throws Exception;

    Map<String, List<String>> getApplicationDefaultDocumentMetadata(UUID applicationId) throws Exception;
    Map<String, List<String>> updateApplicationDefaultDocumentMetadata(
            UUID applicationId,
            Map<String, List<String>> defaultDocumentMetadata) throws Exception;

    // endregion
}