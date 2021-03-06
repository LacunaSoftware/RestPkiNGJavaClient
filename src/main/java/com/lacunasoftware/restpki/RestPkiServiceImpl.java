package com.lacunasoftware.restpki;

import com.fasterxml.jackson.core.type.TypeReference;


import java.beans.Customizer;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
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
		return client.post("api/signature-sessions", request, CreateSignatureSessionResponse.class);
	}

	public SignatureSession getSignatureSession(UUID id) throws RestException {
		SignatureSessionModel model = client.getRestClient().get("api/signature-sessions/" + id.toString(), SignatureSessionModel.class);
		return new SignatureSession(this, model);
	}

	public Document getDocument(UUID id) throws RestException {
		DocumentModel model = client.getRestClient().get("api/documents/" + id.toString(), DocumentModel.class);
		return new Document(this, model);
	}

	public Document getDocument(DocumentModel model){
		return new Document(this, model);
	}


	public List<Signer> getDocumentSigners(UUID id) throws RestException {

		StringBuilder idUri = new StringBuilder("api/documents/").append(id.toString()).append("/signers");
		List<SignerModel> listSignerModel = client.getRestClient().get(idUri.toString(), new TypeReference<List<SignerModel>>(){});

		List<Signer> listSigner = (listSignerModel).stream()
				.map(s -> new Signer(this,s))
				.collect(Collectors.toList());

		return listSigner;
	}

	public  Document findDocumentByKey(String key) throws RestException, IOException{
		if (key != null && !key.isEmpty()) {
			StringBuilder keyUri = new StringBuilder("api/documents/keys/").append(URLEncoder.encode(key.trim(), StandardCharsets.UTF_8.toString()));
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

	public   DocumentModel GetDocumentModel(UUID id) throws RestException {
		StringBuilder idUri = new StringBuilder("api/documents/").append(id.toString());
		DocumentModel documentModel = client.getRestClient().get(idUri.toString(), new TypeReference<DocumentModel>(){});

		return documentModel;
	}

}