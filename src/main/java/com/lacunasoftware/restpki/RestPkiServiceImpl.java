package com.lacunasoftware.restpki;

import java.beans.Customizer;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

/**
 * RestPkiServiceImpl
 */
public class RestPkiServiceImpl implements RestPkiService {

	private RestPkiCoreClient client;

	public RestPkiServiceImpl(RestPkiOptions options) {
		client = new RestPkiCoreClient(options);
	}

	public CreateSignatureSessionResponse CreateSignatureSession(CreateSignatureSessionRequest request) throws RestException {
		return CreateSignatureSession(request, null);
	}

	public CreateSignatureSessionResponse CreateSignatureSession(CreateSignatureSessionRequest request, UUID subscriptionId) throws RestException {
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

	public SignatureSession GetSignatureSession(UUID id) throws RestException {
		SignatureSessionModel model = client.getRestClient().get("api/signature-sessions/" + id.toString(), SignatureSessionModel.class);
		return new SignatureSession(this, model);
	}

	public Document GetDocument(UUID id) throws RestException {
		DocumentModel model = client.getRestClient().get("api/documents/" + id.toString(), DocumentModel.class);
		return new Document(this, model);
	}

	public Document GetDocument(DocumentModel model){
		return new Document(this, model);
	}

	public InputStream OpenRead(String location) throws RestException {
		return client.getRestClient().openStream(location);
	}

	public byte[] GetContent(String location) throws RestException, IOException {
		return OpenRead(location).readAllBytes();
	}
}