package com.lacunasoftware.restpkicore;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

        public Document findDocumentByKey(String key) throws Exception;

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

        ApplicationAndKey createApplicationAndKey(
                        String name,
                        List<Roles> roles,
                        Map<String, List<String>> defaultDocumentMetadata,
                        UUID subscriptionId) throws Exception;

        ApplicationAndKey createApplicationAndKey(
                        String name,
                        List<Roles> roles,
                        Map<String, List<String>> defaultDocumentMetadata) throws Exception;

        ApplicationAndKey createApplicationAndKey(
                        String name,
                        List<Roles> roles) throws Exception;

        Map<String, List<String>> getApplicationDefaultDocumentMetadata(UUID applicationId) throws Exception;

        Map<String, List<String>> updateApplicationDefaultDocumentMetadata(
                        UUID applicationId,
                        Map<String, List<String>> defaultDocumentMetadata) throws Exception;

        PrepareAuthenticationResult prepareAuthentication(PrepareAuthenticationOptions options) throws Exception;

        AuthenticationResult completeAuthentication(CompleteAuthenticationOptions options) throws Exception;

        // endregion

        // region signature management
        public PrepareSignatureResponse startSignature(PrepareSignatureRequest request) throws Exception;

        public DocumentModel completeSignature(CompleteSignatureRequestV2 req) throws RestException;
        // endregion signature management

        // region CAdES signatures
        CadesSignaturePostResponse startCadesSignature(CadesSignaturePostRequestV2 request) throws Exception;

        CadesSignaturePostResponse startCadesSignature(
                        CadesSignaturePostRequestV2 request,
                        UUID subscriptionId) throws Exception;

        CadesSignaturePostSignedBytesResponse completeCadesSignature(
                        String token,
                        CadesSignaturePostSignedBytesRequest request) throws Exception;

        CadesSignaturePostSignedBytesResponse completeCadesSignature(
                        String token,
                        CadesSignaturePostSignedBytesRequest request,
                        UUID subscriptionId) throws Exception;

        CadesSignatureModel openCadesSignature(OpenCadesSignatureRequestModel request) throws Exception;

        CadesSignatureModel openCadesSignature(
                        OpenCadesSignatureRequestModel request,
                        UUID subscriptionId) throws Exception;
        // endregion CAdES signatures

        // region PAdES signatures
        PadesSignaturePostResponse startPadesSignature(PadesSignaturePostRequestV2 request) throws Exception;

        PadesSignaturePostResponse startPadesSignature(
                        PadesSignaturePostRequestV2 request,
                        UUID subscriptionId) throws Exception;

        PadesSignaturePostSignedBytesResponse completePadesSignature(
                        String token,
                        PadesSignaturePostSignedBytesRequest request) throws Exception;

        PadesSignaturePostSignedBytesResponse completePadesSignature(
                        String token,
                        PadesSignaturePostSignedBytesRequest request,
                        UUID subscriptionId) throws Exception;

        PadesSignatureModel openPadesSignature(OpenSignatureRequestModel request) throws Exception;

        PadesSignatureModel openPadesSignature(
                        OpenSignatureRequestModel request,
                        UUID subscriptionId) throws Exception;

        // Note: PAdES merge endpoints require model classes to be generated from swagger spec
        // PadesMergePostResponse mergePades(PadesMergePostRequest request) throws Exception;

        // PadesMergePostResponse mergePades(
        //                 PadesMergePostRequest request,
        //                 UUID subscriptionId) throws Exception;
        // endregion PAdES signatures

        // region XAdES/XML signatures
        XmlSignaturePostResponse startXmlElementSignature(XmlElementSignaturePostRequest request) throws Exception;

        XmlSignaturePostResponse startXmlElementSignature(
                        XmlElementSignaturePostRequest request,
                        UUID subscriptionId) throws Exception;

        XmlSignaturePostSignedBytesResponse completeXmlElementSignature(
                        String token,
                        XmlSignaturePostSignedBytesRequest request) throws Exception;

        XmlSignaturePostSignedBytesResponse completeXmlElementSignature(
                        String token,
                        XmlSignaturePostSignedBytesRequest request,
                        UUID subscriptionId) throws Exception;

        XmlSignaturePostResponse startFullXmlSignature(FullXmlSignaturePostRequest request) throws Exception;

        XmlSignaturePostResponse startFullXmlSignature(
                        FullXmlSignaturePostRequest request,
                        UUID subscriptionId) throws Exception;

        XmlSignaturePostSignedBytesResponse completeFullXmlSignature(
                        String token,
                        XmlSignaturePostSignedBytesRequest request) throws Exception;

        XmlSignaturePostSignedBytesResponse completeFullXmlSignature(
                        String token,
                        XmlSignaturePostSignedBytesRequest request,
                        UUID subscriptionId) throws Exception;

        XmlSignatureResponseModel openXmlSignature(OpenSignatureRequestModel request) throws Exception;

        XmlSignatureResponseModel openXmlSignature(
                        OpenSignatureRequestModel request,
                        UUID subscriptionId) throws Exception;
        // endregion XAdES/XML signatures

        // region PDF operations
        PdfAddMarksResponse addPdfMarks(PdfAddMarksRequest request) throws Exception;

        PdfAddMarksResponse addPdfMarks(
                        PdfAddMarksRequest request,
                        UUID subscriptionId) throws Exception;

        StampPdfResponse stampPdf(StampPdfRequest request) throws Exception;

        StampPdfResponse stampPdf(
                        StampPdfRequest request,
                        UUID subscriptionId) throws Exception;
        // endregion PDF operations

        // region Timestamp operations
        // Note: PDF timestamp endpoints require additional model classes to be generated from swagger spec
        // TimestampResponse addPdfTimestamp(AddPdfTimestampRequest request) throws Exception;

        // TimestampResponse addPdfTimestamp(
        //                 AddPdfTimestampRequest request,
        //                 UUID subscriptionId) throws Exception;

        // Note: IssueTimestampRequest model class needs to be generated from swagger spec
        // TimestampIssueResponse issueTimestamp(IssueTimestampRequest request) throws Exception;

        // TimestampIssueResponse issueTimestamp(
        //                 IssueTimestampRequest request,
        //                 UUID subscriptionId) throws Exception;
        // endregion Timestamp operations

        // region Certificate operations
        // Note: Certificate decode/validate endpoints require model classes to be generated from swagger spec
        // DecodeCertificateResponse decodeCertificate(byte[] certificateContent) throws Exception;

        // DecodeCertificateResponse decodeCertificate(
        //                 byte[] certificateContent,
        //                 UUID subscriptionId) throws Exception;

        // ValidateCertificateResponse validateCertificate(ValidateCertificateRequest request) throws Exception;

        // ValidateCertificateResponse validateCertificate(
        //                 ValidateCertificateRequest request,
        //                 UUID subscriptionId) throws Exception;
        // endregion Certificate operations

        // region File validation
        ValidateFileResponse validateSignedFile(ValidateFileRequest request) throws Exception;

        ValidateFileResponse validateSignedFile(
                        ValidateFileRequest request,
                        UUID subscriptionId) throws Exception;
        // endregion File validation

        // region Document operations (additional)
        // Note: CreateDocumentRequest model class needs to be generated from swagger spec
        // DocumentModel createDocument(CreateDocumentRequest request) throws Exception;

        // DocumentModel createDocument(
        //                 CreateDocumentRequest request,
        //                 UUID subscriptionId) throws Exception;

        // DocumentModel createDocument(
        //                 CreateDocumentRequest request,
        //                 UUID subscriptionId,
        //                 Map<String, List<String>> metadata) throws Exception;

        DocumentModel updateDocumentMetadata(
                        UUID documentId,
                        Map<String, List<String>> metadata) throws Exception;

        void deleteDocument(UUID documentId) throws Exception;

        SignerModel getDocumentSignature(UUID documentId, UUID signatureId) throws Exception;

        List<SignerModel> getDocumentSignatures(UUID documentId) throws Exception;

        byte[] getDocumentAuditPackage(UUID documentId) throws Exception;

        byte[] getDocumentAuditPackage(
                        UUID documentId,
                        UUID subscriptionId) throws Exception;
        // endregion Document operations

        // region Signature session operations (additional)
        void deleteSignatureSession(UUID sessionId) throws Exception;

        // Note: UpdateSignatureSessionRequest, ProcessActionRequest, and SignatureSessionActionResponse 
        // model classes need to be generated from swagger spec
        // SignatureSessionModel updateSignatureSession(
        //                 UUID sessionId,
        //                 UpdateSignatureSessionRequest request) throws Exception;

        // SignatureSessionActionResponse processAction(
        //                 UUID sessionId,
        //                 ProcessActionRequest request) throws Exception;

        // SignatureSessionActionResponse processAction(
        //                 UUID sessionId,
        //                 ProcessActionRequest request,
        //                 UUID subscriptionId) throws Exception;
        // endregion Signature session operations
}