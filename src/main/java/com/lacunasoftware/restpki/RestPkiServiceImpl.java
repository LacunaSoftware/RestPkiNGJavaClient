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

	public InputStream openRead(String location) throws RestException {
		return client.getRestClient().openStream(location);
	}

	public byte[] getContent(String location) throws RestException, IOException {
		InputStream stream = openRead(location);
		return Util.readStream(stream);
	}
}