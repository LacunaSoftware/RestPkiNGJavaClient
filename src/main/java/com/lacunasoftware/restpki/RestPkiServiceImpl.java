package com.lacunasoftware.restpki;

import com.fasterxml.jackson.core.type.TypeReference;


import java.beans.Customizer;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javafx.util.Pair;
import java.util.stream.Collectors;

/**
 * RestPkiServiceImpl
 */
public class RestPkiServiceImpl implements RestPkiService {

	private RestPkiCoreClient client;

	public RestPkiServiceImpl(RestPkiOptions options) {
		client = new RestPkiCoreClient(options);
	}

	public CreateSignatureSessionResponse createSignatureSession(CreateSignatureSessionRequest request) throws RestException {
		return createSignatureSession(request, null);
	}

	public CreateSignatureSessionResponse createSignatureSession(CreateSignatureSessionRequest request, UUID subscriptionId) throws RestException {
		RestClientPortable client;
		if(subscriptionId != null){

			Map<String, String> customHeaders = new HashMap<String, String>();
			customHeaders.put("X-Subscription", subscriptionId.toString());
			client = this.client.getRestClient(customHeaders);

		} else {
			client = this.client.getRestClient();
		}
		return client.post(ApiRoutes.SIGNATURE_SESSION.getValue() + "/", request, CreateSignatureSessionResponse.class);
	}

	public SignatureSession getSignatureSession(UUID id) throws RestException {
		SignatureSessionModel model = client.getRestClient().get(ApiRoutes.SIGNATURE_SESSION.getValue() + "/" + id.toString(), SignatureSessionModel.class);
		return new SignatureSession(this, model);
	}

	public Document getDocument(UUID id) throws RestException {
		DocumentModel model = client.getRestClient().get(ApiRoutes.DOCUMENTS.getValue() + "/" + id.toString(), DocumentModel.class);
		return new Document(this, model);
	}

	public Document getDocument(DocumentModel model){
		return new Document(this, model);
	}

	public List<Signer> getDocumentSigners(UUID id) throws RestException {

		StringBuilder idUri = new StringBuilder(ApiRoutes.DOCUMENTS.getValue()).append('/').append(id.toString()).append("/signers");
		List<SignerModel> listSignerModel = client.getRestClient().get(idUri.toString(), new TypeReference<List<SignerModel>>(){});

		List<Signer> listSigner = (listSignerModel).stream()
				.map(s -> new Signer(this,s))
				.collect(Collectors.toList());

		return listSigner;
	}

	public  Document findDocumentByKey(String key) throws RestException, IOException{
		if (key != null && !key.isEmpty()) {
			StringBuilder keyUri = new StringBuilder(ApiRoutes.DOCUMENTS.getValue()).append("/keys/").append(URLEncoder.encode(key.trim(), StandardCharsets.UTF_8.toString()));
			//string format
			DocumentQueryResponse model = client.getRestClient().get(keyUri.toString(), DocumentQueryResponse.class);
			return getDocument(model.getDocument());
		}else {
			throw new RuntimeException("The key cannot be empty");
		}

	}

	public InputStream openRead(String location) throws RestException {
		return client.getRestClient().openStream(location);
	}

	public byte[] getContent(String location) throws RestException, IOException {
		InputStream stream = openRead(location);
		return Util.readStream(stream);
	}

	public DocumentModel GetDocumentModel(UUID id) throws RestException {
		StringBuilder idUri = new StringBuilder(ApiRoutes.DOCUMENTS.getValue()).append(id.toString());
		DocumentModel documentModel = client.getRestClient().get(idUri.toString(), new TypeReference<DocumentModel>(){});

		return documentModel;
	}

	// region allocateDocumentKey 
	public DocumentKeyModel allocateDocumentKey(Map<String, List<String>> provisionalMetadata, UUID subscriptionId) throws RestException {
		Map<String, String> customHeaders = null;
		if(subscriptionId != null){
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
	public DocumentKeyModel allocateDocumentKey(Map<String, List<String>> provisionalMetadata) throws RestException {
		return allocateDocumentKey(provisionalMetadata, null);
	}
	public DocumentKeyModel allocateDocumentKey(UUID subscriptionId) throws RestException { 
		return allocateDocumentKey(null, subscriptionId);
	}
	public DocumentKeyModel allocateDocumentKey() throws RestException {
		return allocateDocumentKey(null, null);
	}
	// endregion allocateDocumentKey

	// region allocateDocumentKeys
	public List<DocumentKeyModel> allocateDocumentKeys(int count, Map<String, List<String>> provisionalMetadata, UUID subscriptionId) throws RestException {
		Map<String, String> customHeaders = null;
		if(subscriptionId != null){
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
	public List<DocumentKeyModel> allocateDocumentKeys(int count, Map<String, List<String>> provisionalMetadata) throws RestException {
		return allocateDocumentKeys(count, provisionalMetadata, null);
	}
	public List<DocumentKeyModel> allocateDocumentKeys(int count, UUID subscriptionId) throws RestException {
		return allocateDocumentKeys(count, null, subscriptionId);
	}
	public List<DocumentKeyModel> allocateDocumentKeys(int count) throws RestException {
		return allocateDocumentKeys(count, null, null);
	}
	// endregion allocateDocumentKeys

	// region createApplication 
	public ApplicationModel createApplication(String name, List<Roles> roles,  Map<String, List<String>> defaultDocumentMetadata, UUID subscriptionId) throws RestException {
		Map<String, String> customHeaders = null;
		if(subscriptionId != null){
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
		if(defaultDocumentMetadata != null && !defaultDocumentMetadata.isEmpty()) {
			updateApplicationDefaultDocumentMetadata(response.getId(), defaultDocumentMetadata);
		}
		return response;
	}
	public ApplicationModel createApplication(String name, List<Roles> roles,  Map<String, List<String>> defaultDocumentMetadata) throws RestException {
		return createApplication(name, roles, defaultDocumentMetadata, null); 
	}
	public ApplicationModel createApplication(String name, List<Roles> roles, UUID subscriptionId) throws RestException {
		return createApplication(name, roles, null, subscriptionId); 
	}
	public ApplicationModel createApplication(String name, List<Roles> roles) throws RestException {
		return createApplication(name, roles, null, null); 
	}
	// endregion createApplication

	// region createApplicationKey
	public CreateApplicationApiKeyResponse createApplicationKey(UUID id, OffsetDateTime expiresOn, String description) throws RestException {
		if (description == null || description.isEmpty()){
			description = "Generated on " + OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"));
		}

		CreateApplicationApiKeyRequest request = new CreateApplicationApiKeyRequest();
		request.setDescription(description);
		request.setExpiresOn(expiresOn);

		return this.client.getRestClient().post(
			ApiRoutes.APPLICATIONS.getValue() + "/" + id.toString() + "/api-keys/",
			request,
			CreateApplicationApiKeyResponse.class);
	}
	public CreateApplicationApiKeyResponse createApplicationKey(UUID applicationId, OffsetDateTime expiresOn) throws RestException {
		return createApplicationKey(applicationId, expiresOn, null);
	}
	public CreateApplicationApiKeyResponse createApplicationKey(UUID applicationId, String description) throws RestException {
		return createApplicationKey(applicationId, null, description);
	}
	public CreateApplicationApiKeyResponse createApplicationKey(UUID applicationId) throws RestException {
		return createApplicationKey(applicationId, null, null);
	}
	// endregion createApplicationKey

	// region createApplicationAndKey
	public Pair<ApplicationModel, String> createApplicationAndKey(String name, List<Roles> roles,  Map<String, List<String>> defaultDocumentMetadata, UUID subscriptionId) throws RestException {
		ApplicationModel app = createApplication(name, roles, defaultDocumentMetadata, subscriptionId);
		CreateApplicationApiKeyResponse key = createApplicationKey(app.getId());
		return new Pair<ApplicationModel, String>(app, key.getKey());
	}
	public Pair<ApplicationModel, String> createApplicationAndKey(String name, List<Roles> roles,  Map<String, List<String>> defaultDocumentMetadata) throws RestException {
		return createApplicationAndKey(name, roles, defaultDocumentMetadata, null);
	}
	public Pair<ApplicationModel, String> createApplicationAndKey(String name, List<Roles> roles, UUID subscriptionId) throws RestException {
		return createApplicationAndKey(name, roles, null, subscriptionId);
	}
	public Pair<ApplicationModel, String> createApplicationAndKey(String name, List<Roles> roles) throws RestException {
		return createApplicationAndKey(name, roles, null, null);
	}
	// endregion createApplicationAndKey

	public Map<String, List<String>> getApplicationDefaultDocumentMetadata(UUID applicationId) throws RestException {
		return this.client.getRestClient().get(
			ApiRoutes.APPLICATIONS.getValue() + "/" + applicationId.toString() + "/default-document-metadata/",
			Map.class);
	}

	public Map<String, List<String>> updateApplicationDefaultDocumentMetadata(UUID applicationId, Map<String, List<String>> defaultDocumentMetadata) throws RestException {
		return this.client.getRestClient().put(
			ApiRoutes.APPLICATIONS.getValue() + "/" + applicationId.toString() + "/default-document-metadata/",
			defaultDocumentMetadata,
			Map.class);
	}

}