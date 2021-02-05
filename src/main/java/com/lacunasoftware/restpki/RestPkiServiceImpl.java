package com.lacunasoftware.restpki;

import com.lacunasoftware.restpki.RestClient;
import java.io.InputStream;
import java.util.UUID;

/**
 * RestPkiServiceImpl
 */
public class RestPkiServiceImpl implements RestPkiService {

  private RestClient client;

  public RestPkiServiceImpl(RestPkiOptions options) {
    client = new RestClient("endpointUri");
  }

  public CreateSignatureSessionResponse CreateSignatureSessionAsync(CreateSignatureSessionRequest request, UUID subscriptionId){
    // TODO: implement
  }

  public SignatureSession GetSignatureSessionAsync(UUID id){
    // TODO: implement
  }

  public Document GetDocumentAsync(UUID id){
    // TODO: implement
    return new Document(this, model);
  }

  public Document GetDocumentAsync(DocumentModel model){
    return new Document(this, model);
  }

  public InputStream OpenReadAsync(String location){
    // TODO: implement
  }

  public byte[] GetContentAsync(String location){
    // TODO: implement
  }
}