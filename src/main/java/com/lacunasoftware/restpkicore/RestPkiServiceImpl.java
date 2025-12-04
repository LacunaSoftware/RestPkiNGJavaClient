package com.lacunasoftware.restpkicore;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * RestPkiServiceImpl
 */
public class RestPkiServiceImpl implements RestPkiService, RestBioService {

	private RestPkiCoreClient client;

	public RestPkiServiceImpl(RestPkiOptions options) {
		client = new RestPkiCoreClient(options);
	}

	public CreateSignatureSessionResponse createSignatureSession(CreateSignatureSessionRequest request)
			throws Exception {
		return createSignatureSession(request, null, null, null);
	}

	public CreateSignatureSessionResponse createSignatureSession(
			CreateSignatureSessionRequest request,
			UUID subscriptionId) throws Exception {
		return createSignatureSession(request, subscriptionId, null, null);
	}

	public CreateSignatureSessionResponse createSignatureSession(
			CreateSignatureSessionRequest request,
			UUID subscriptionId,
			Map<String, List<String>> metadata) throws Exception {
		return createSignatureSession(request, subscriptionId, metadata, null);
	}

	public CreateSignatureSessionResponse createSignatureSession(
			CreateSignatureSessionRequest request,
			UUID subscriptionId,
			Map<String, List<String>> metadata,
			List<SignatureSessionDocumentToSign> documents) throws Exception {

		RestClientPortable client;
		if (subscriptionId != null) {
			Map<String, String> customHeaders = new HashMap<>();
			customHeaders.put("X-Subscription", subscriptionId.toString());
			client = this.client.getRestClient(customHeaders);
		} else {
			client = this.client.getRestClient();
		}
		if (metadata != null) {
			request.setDocumentMetadata(metadata);
		}
		if (documents != null && documents.size() > 0) {
			for (SignatureSessionDocumentToSign document : documents) {
				SignatureSessionDocumentData documentData = new SignatureSessionDocumentData();
				documentData.setId(document.getId());
				documentData.setDocumentKey(document.getDocumentKey());
				documentData.setMetadata(document.getMetadata());
				documentData.setSignatureType(document.getSignatureType());
				if (document.getFile() != null) {
					documentData.setFile(this.uploadOrReference(document.getFile()));
				}
				request.addDocumentsItem(documentData);
			}
		}

		return client.post(ApiRoutes.SIGNATURE_SESSION.getValue() + "/", request, CreateSignatureSessionResponse.class);
	}

	public SignatureSession getSignatureSession(UUID id) throws Exception {
		SignatureSessionModel model = client.getRestClient()
				.get(ApiRoutes.SIGNATURE_SESSION.getValue() + "/" + id.toString(), SignatureSessionModel.class);
		return new SignatureSession(this, model);
	}

	public Document getDocument(UUID id) throws Exception {
		DocumentModel model = client.getRestClient().get(ApiRoutes.DOCUMENTS.getValue() + "/" + id.toString(),
				DocumentModel.class);
		return new Document(this, model);
	}

	public Document getDocument(DocumentModel model) {
		return new Document(this, model);
	}

	public List<Signer> getDocumentSigners(UUID id) throws Exception {

		StringBuilder idUri = new StringBuilder(ApiRoutes.DOCUMENTS.getValue()).append('/').append(id.toString())
				.append("/signers");
		List<SignerModel> listSignerModel = client.getRestClient().get(idUri.toString(),
				new TypeReference<List<SignerModel>>() {
				});

		List<Signer> listSigner = (listSignerModel).stream()
				.map(s -> new Signer(s))
				.collect(Collectors.toList());

		return listSigner;
	}

	public Document findDocumentByKey(String key) throws Exception {
		if (key != null && !key.isEmpty()) {
			StringBuilder keyUri = new StringBuilder(ApiRoutes.DOCUMENTS.getValue()).append("/keys/")
					.append(URLEncoder.encode(key.trim(), StandardCharsets.UTF_8.toString()));
			// string format
			DocumentQueryResponse model = client.getRestClient().get(keyUri.toString(), DocumentQueryResponse.class);
			return getDocument(model.getDocument());
		} else {
			throw new RuntimeException("The key cannot be empty");
		}

	}

	public InputStream openRead(String location) throws Exception {
		return client.getRestClient().openStream(location);
	}

	public byte[] getContent(String location) throws Exception {
		InputStream stream = openRead(location);
		return Util.readStream(stream);
	}

	public DocumentModel getDocumentModel(UUID id) throws Exception {
		StringBuilder idUri = new StringBuilder(ApiRoutes.DOCUMENTS.getValue()).append('/').append(id.toString());
		DocumentModel documentModel = client.getRestClient().get(idUri.toString(), new TypeReference<DocumentModel>() {
		});

		return documentModel;
	}

	// region allocateDocumentKey
	public DocumentKeyModel allocateDocumentKey(Map<String, List<String>> provisionalMetadata, UUID subscriptionId)
			throws Exception {
		Map<String, String> customHeaders = null;
		if (subscriptionId != null) {
			customHeaders = new HashMap<String, String>();
			customHeaders.put("X-Subscription", subscriptionId.toString());
		}

		AllocateDocumentKeyRequest request = new AllocateDocumentKeyRequest();
		request.setProvisionalMetadata(provisionalMetadata);

		return this.client.getRestClient(customHeaders).post(
				ApiRoutes.DOCUMENT_KEYS + "/",
				provisionalMetadata != null ? request : null,
				DocumentKeyModel.class);
	}

	public DocumentKeyModel allocateDocumentKey(Map<String, List<String>> provisionalMetadata) throws Exception {
		return allocateDocumentKey(provisionalMetadata, null);
	}

	public DocumentKeyModel allocateDocumentKey() throws Exception {
		return allocateDocumentKey(null, null);
	}
	// endregion allocateDocumentKey

	// region allocateDocumentKeys
	@SuppressWarnings({ "unchecked" })
	public List<DocumentKeyModel> allocateDocumentKeys(int count, Map<String, List<String>> provisionalMetadata,
			UUID subscriptionId) throws Exception {
		Map<String, String> customHeaders = null;
		if (subscriptionId != null) {
			customHeaders = new HashMap<String, String>();
			customHeaders.put("X-Subscription", subscriptionId.toString());
		}

		AllocateDocumentKeyBatchRequest request = new AllocateDocumentKeyBatchRequest();
		request.setCount(count);
		request.setProvisionalMetadata(provisionalMetadata);

		return this.client.getRestClient(customHeaders).post(
				ApiRoutes.DOCUMENT_KEYS + "/batch/",
				request,
				List.class);
	}

	public List<DocumentKeyModel> allocateDocumentKeys(int count, Map<String, List<String>> provisionalMetadata)
			throws Exception {
		return allocateDocumentKeys(count, provisionalMetadata, null);
	}

	public List<DocumentKeyModel> allocateDocumentKeys(int count) throws Exception {
		return allocateDocumentKeys(count, null, null);
	}
	// endregion allocateDocumentKeys

	// region createApplication
	public ApplicationModel createApplication(String name, List<Roles> roles,
			Map<String, List<String>> defaultDocumentMetadata, UUID subscriptionId) throws Exception {
		Map<String, String> customHeaders = null;
		if (subscriptionId != null) {
			customHeaders = new HashMap<String, String>();
			customHeaders.put("X-Subscription", subscriptionId.toString());
		}

		AuthorizationData authData = new AuthorizationData();
		authData.setRoles(roles);
		RootAuthorizationData rootAuthData = new RootAuthorizationData();
		AuthorizationDataRootAuthorizationDataRolesRootRolesApplicationData request = new AuthorizationDataRootAuthorizationDataRolesRootRolesApplicationData();
		request.setName(name);
		request.setAuthorizationData(authData);
		request.setRootAuthorizationData(rootAuthData);

		ApplicationModel response = this.client.getRestClient()
				.post(ApiRoutes.APPLICATIONS + "/", request, ApplicationModel.class);
		if (defaultDocumentMetadata != null && !defaultDocumentMetadata.isEmpty()) {
			updateApplicationDefaultDocumentMetadata(response.getId(), defaultDocumentMetadata);
		}
		return response;
	}

	public ApplicationModel createApplication(String name, List<Roles> roles,
			Map<String, List<String>> defaultDocumentMetadata) throws Exception {
		return createApplication(name, roles, defaultDocumentMetadata, null);
	}

	public ApplicationModel createApplication(String name, List<Roles> roles) throws Exception {
		return createApplication(name, roles, null, null);
	}
	// endregion createApplication

	// region createApplicationKey
	public CreateApplicationApiKeyResponse createApplicationKey(UUID id, Date expiresOn, String description)
			throws Exception {
		if (description == null || description.isEmpty()) {
			description = "Generated on "
					+ OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"));
		}

		CreateApplicationApiKeyRequest request = new CreateApplicationApiKeyRequest();
		request.setDescription(description);
		request.setExpiresOn(expiresOn);

		return this.client.getRestClient().post(
				ApiRoutes.APPLICATIONS.getValue() + "/" + id.toString() + "/api-keys/",
				request,
				CreateApplicationApiKeyResponse.class);
	}

	public CreateApplicationApiKeyResponse createApplicationKey(UUID applicationId, Date expiresOn) throws Exception {
		return createApplicationKey(applicationId, expiresOn, null);
	}

	public CreateApplicationApiKeyResponse createApplicationKey(UUID applicationId) throws Exception {
		return createApplicationKey(applicationId, null, null);
	}
	// endregion createApplicationKey

	// region createApplicationAndKey
	public ApplicationAndKey createApplicationAndKey(String name, List<Roles> roles,
			Map<String, List<String>> defaultDocumentMetadata, UUID subscriptionId) throws Exception {
		ApplicationModel app = createApplication(name, roles, defaultDocumentMetadata, subscriptionId);
		CreateApplicationApiKeyResponse key = createApplicationKey(app.getId());
		return new ApplicationAndKey(app, key.getKey());
	}

	public ApplicationAndKey createApplicationAndKey(String name, List<Roles> roles,
			Map<String, List<String>> defaultDocumentMetadata) throws Exception {
		return createApplicationAndKey(name, roles, defaultDocumentMetadata, null);
	}

	public ApplicationAndKey createApplicationAndKey(String name, List<Roles> roles) throws Exception {
		return createApplicationAndKey(name, roles, null, null);
	}
	// endregion createApplicationAndKey

	// region signature
	public PrepareSignatureResponse startSignature(PrepareSignatureRequest request) throws Exception {
		return this.client.getRestClient().post(
				ApiRoutes.SIGNATURE.getValue(), request,
				PrepareSignatureResponse.class);
	}

	public DocumentModel completeSignature(CompleteSignatureRequestV2 req) throws RestException {
		return this.client.getRestClient().post(
				ApiRoutes.SIGNATURE.getValue() + "/" + "completion", req,
				DocumentModel.class);
	}

	// endregion signature

	@SuppressWarnings({ "unchecked" })
	public Map<String, List<String>> getApplicationDefaultDocumentMetadata(UUID applicationId) throws Exception {
		return this.client.getRestClient().get(
				ApiRoutes.APPLICATIONS.getValue() + "/" + applicationId.toString() + "/default-document-metadata/",
				Map.class);
	}

	@SuppressWarnings({ "unchecked" })
	public Map<String, List<String>> updateApplicationDefaultDocumentMetadata(UUID applicationId,
			Map<String, List<String>> defaultDocumentMetadata) throws Exception {
		return this.client.getRestClient().put(
				ApiRoutes.APPLICATIONS.getValue() + "/" + applicationId.toString() + "/default-document-metadata/",
				defaultDocumentMetadata,
				Map.class);
	}

	protected FileReferenceModel uploadOrReference(FileReference file) throws Exception {

		FileReferenceModel model = new FileReferenceModel();

		if (file.getBlobToken() != null && !file.getBlobToken().isEmpty()) {

			model.setBlobToken(file.getBlobToken());

		} else if (file.getUrl() != null && !file.getUrl().isEmpty()) {

			model.setUrl(file.getUrl());

		} else {

			// TODO: upload depending on file size
			model.setContent(file.getContent());
		}

		model.setName(file.getName());
		model.setMimeType(file.getMimeType());
		model.setLength(file.getLength());
		return model;
	}

	public PrepareAuthenticationResult prepareAuthentication(PrepareAuthenticationOptions options) throws Exception {
		PrepareAuthenticationResponse response = getRestClient(options).post(ApiRoutes.AUTHENTICATION.getValue() + "/",
				options.getRequest(), PrepareAuthenticationResponse.class);
		return new PrepareAuthenticationResult(response.getToSignHash(), response.getState());
	}

	public PrepareAuthenticationResult prepareAuthenticationV2(PrepareAuthenticationOptions options) throws Exception {
		PrepareAuthenticationResponse response = getRestClient(options).post(ApiRoutes.AUTHENTICATION.getValue() + "/",
				options.getRequest(), PrepareAuthenticationResponse.class);
		return new PrepareAuthenticationResult(response.getToSign(), response.getState());
	}

	public AuthenticationResult completeAuthentication(CompleteAuthenticationOptions options) throws Exception {
		CompleteAuthenticationResponse response = getRestClient(options).post(
				ApiRoutes.AUTHENTICATION.getValue() + "/completion/", options.getRequest(),
				CompleteAuthenticationResponse.class);
		return new AuthenticationResult(response);
	}

	private RestClientPortable getRestClient(RequestOptions options) {
		if (options.getSubscriptionId() == null) {
			return this.client.getRestClient();
		} else {
			Map<String, String> customHeaders = new HashMap<>();
			customHeaders.put("X-Subscription", options.getSubscriptionId().toString());
			return this.client.getRestClient(customHeaders);
		}
	}

	// region CAdES signatures implementation
	@Override
	public CadesSignaturePostResponse startCadesSignature(CadesSignaturePostRequestV2 request) throws Exception {
		return startCadesSignature(request, null);
	}

	@Override
	public CadesSignaturePostResponse startCadesSignature(CadesSignaturePostRequestV2 request, UUID subscriptionId)
			throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.CADES_SIGNATURES.getValue(), request, CadesSignaturePostResponse.class);
	}

	@Override
	public CadesSignaturePostSignedBytesResponse completeCadesSignature(String token,
			CadesSignaturePostSignedBytesRequest request) throws Exception {
		return completeCadesSignature(token, request, null);
	}

	@Override
	public CadesSignaturePostSignedBytesResponse completeCadesSignature(String token,
			CadesSignaturePostSignedBytesRequest request, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.CADES_SIGNATURES.getValue() + "/" + token, request,
				CadesSignaturePostSignedBytesResponse.class);
	}

	@Override
	public CadesSignatureModel openCadesSignature(OpenCadesSignatureRequestModel request) throws Exception {
		return openCadesSignature(request, null);
	}

	@Override
	public CadesSignatureModel openCadesSignature(OpenCadesSignatureRequestModel request, UUID subscriptionId)
			throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.CADES_SIGNATURES.getValue() + "/open", request, CadesSignatureModel.class);
	}
	// endregion CAdES signatures

	// region PAdES signatures implementation
	@Override
	public PadesSignaturePostResponse startPadesSignature(PadesSignaturePostRequestV2 request) throws Exception {
		return startPadesSignature(request, null);
	}

	@Override
	public PadesSignaturePostResponse startPadesSignature(PadesSignaturePostRequestV2 request, UUID subscriptionId)
			throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.PADES_SIGNATURES.getValue(), request, PadesSignaturePostResponse.class);
	}

	@Override
	public PadesSignaturePostSignedBytesResponse completePadesSignature(String token,
			PadesSignaturePostSignedBytesRequest request) throws Exception {
		return completePadesSignature(token, request, null);
	}

	@Override
	public PadesSignaturePostSignedBytesResponse completePadesSignature(String token,
			PadesSignaturePostSignedBytesRequest request, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.PADES_SIGNATURES.getValue() + "/" + token, request,
				PadesSignaturePostSignedBytesResponse.class);
	}

	@Override
	public PadesSignatureModel openPadesSignature(OpenSignatureRequestModel request) throws Exception {
		return openPadesSignature(request, null);
	}

	@Override
	public PadesSignatureModel openPadesSignature(OpenSignatureRequestModel request, UUID subscriptionId)
			throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.PADES_SIGNATURES.getValue() + "/open", request, PadesSignatureModel.class);
	}
	// endregion PAdES signatures

	// region XML signatures implementation
	@Override
	public XmlSignaturePostResponse startXmlElementSignature(XmlElementSignaturePostRequest request) throws Exception {
		return startXmlElementSignature(request, null);
	}

	@Override
	public XmlSignaturePostResponse startXmlElementSignature(XmlElementSignaturePostRequest request,
			UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.XML_ELEMENT_SIGNATURES.getValue(), request, XmlSignaturePostResponse.class);
	}

	@Override
	public XmlSignaturePostSignedBytesResponse completeXmlElementSignature(String token,
			XmlSignaturePostSignedBytesRequest request) throws Exception {
		return completeXmlElementSignature(token, request, null);
	}

	@Override
	public XmlSignaturePostSignedBytesResponse completeXmlElementSignature(String token,
			XmlSignaturePostSignedBytesRequest request, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.XML_ELEMENT_SIGNATURES.getValue() + "/" + token, request,
				XmlSignaturePostSignedBytesResponse.class);
	}

	@Override
	public XmlSignaturePostResponse startFullXmlSignature(FullXmlSignaturePostRequest request) throws Exception {
		return startFullXmlSignature(request, null);
	}

	@Override
	public XmlSignaturePostResponse startFullXmlSignature(FullXmlSignaturePostRequest request, UUID subscriptionId)
			throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.FULL_XML_SIGNATURES.getValue(), request, XmlSignaturePostResponse.class);
	}

	@Override
	public XmlSignaturePostSignedBytesResponse completeFullXmlSignature(String token,
			XmlSignaturePostSignedBytesRequest request) throws Exception {
		return completeFullXmlSignature(token, request, null);
	}

	@Override
	public XmlSignaturePostSignedBytesResponse completeFullXmlSignature(String token,
			XmlSignaturePostSignedBytesRequest request, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.FULL_XML_SIGNATURES.getValue() + "/" + token, request,
				XmlSignaturePostSignedBytesResponse.class);
	}

	@Override
	public XmlSignatureResponseModel openXmlSignature(OpenSignatureRequestModel request) throws Exception {
		return openXmlSignature(request, null);
	}

	@Override
	public XmlSignatureResponseModel openXmlSignature(OpenSignatureRequestModel request, UUID subscriptionId)
			throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.FULL_XML_SIGNATURES.getValue() + "/open", request,
				XmlSignatureResponseModel.class);
	}
	// endregion XML signatures

	// region PDF operations implementation
	@Override
	public PdfAddMarksResponse addPdfMarks(PdfAddMarksRequest request) throws Exception {
		return addPdfMarks(request, null);
	}

	@Override
	public PdfAddMarksResponse addPdfMarks(PdfAddMarksRequest request, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.DOCUMENTS.getValue() + "/pdf-marks", request, PdfAddMarksResponse.class);
	}

	@Override
	public StampPdfResponse stampPdf(StampPdfRequest request) throws Exception {
		return stampPdf(request, null);
	}

	@Override
	public StampPdfResponse stampPdf(StampPdfRequest request, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.DOCUMENTS.getValue() + "/stamp-pdf", request, StampPdfResponse.class);
	}
	// endregion PDF operations

	// region File validation implementation
	@Override
	public ValidateFileResponse validateSignedFile(ValidateFileRequest request) throws Exception {
		return validateSignedFile(request, null);
	}

	@Override
	public ValidateFileResponse validateSignedFile(ValidateFileRequest request, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		return restClient.post(ApiRoutes.FILE_VALIDATION.getValue(), request, ValidateFileResponse.class);
	}
	// endregion File validation

	// region Document operations implementation
	@Override
	public DocumentModel updateDocumentMetadata(UUID documentId, Map<String, List<String>> metadata) throws Exception {
		return client.getRestClient().put(
				ApiRoutes.DOCUMENTS.getValue() + "/" + documentId.toString() + "/metadata",
				metadata,
				DocumentModel.class);
	}

	@Override
	public void deleteDocument(UUID documentId) throws Exception {
		client.getRestClient().delete(ApiRoutes.DOCUMENTS.getValue() + "/" + documentId.toString());
	}

	@Override
	public SignerModel getDocumentSignature(UUID documentId, UUID signatureId) throws Exception {
		return client.getRestClient().get(
				ApiRoutes.DOCUMENTS.getValue() + "/" + documentId.toString() + "/signatures/" + signatureId.toString(),
				SignerModel.class);
	}

	@Override
	public List<SignerModel> getDocumentSignatures(UUID documentId) throws Exception {
		return client.getRestClient().get(
				ApiRoutes.DOCUMENTS.getValue() + "/" + documentId.toString() + "/signatures",
				new TypeReference<List<SignerModel>>() {
				});
	}

	@Override
	public byte[] getDocumentAuditPackage(UUID documentId) throws Exception {
		return getDocumentAuditPackage(documentId, null);
	}

	@Override
	public byte[] getDocumentAuditPackage(UUID documentId, UUID subscriptionId) throws Exception {
		RestClientPortable restClient = getRestClient(subscriptionId);
		String url = ApiRoutes.DOCUMENTS.getValue() + "/" + documentId.toString() + "/audit-package";
		InputStream stream = restClient.openStream(url);
		return Util.readStream(stream);
	}
	// endregion Document operations

	// region Signature session operations implementation
	@Override
	public void deleteSignatureSession(UUID sessionId) throws Exception {
		client.getRestClient().delete(ApiRoutes.SIGNATURE_SESSION.getValue() + "/" + sessionId.toString());
	}
	// endregion Signature session operations
	
	// Helper method for getting rest client with subscription
	private RestClientPortable getRestClient(UUID subscriptionId) {
		if (subscriptionId == null) {
			return this.client.getRestClient();
		} else {
			Map<String, String> customHeaders = new HashMap<>();
			customHeaders.put("X-Subscription", subscriptionId.toString());
			return this.client.getRestClient(customHeaders);
		}
	}

	//region RestBio

	public StartBioSessionResponse StartLivenessSessionAsync(StartLivenessSessionRequest request, UUID subscriptionId) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public LivenessSessionStatusModel GetLivenessSessionStatusAsync(UUID sessionId) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public LivenessSessionStatusModel CompleteLivenessSessionAsync(String ticket) {
		// TODO
		throw new UnsupportedOperationException();
	}

	//endregion
}
