package com.lacunasoftware.restpki;

class ModelConverters {

      static DocumentModel toDocumentModel(SignatureSessionDocumentSummary model){
        DocumentModel documentModel = new DocumentModel();
        documentModel.setId(model.getId());
        documentModel.setKey(model.getKey());
        documentModel.setFormattedKey(model.getFormattedKey());
        documentModel.setOriginalFile(model.getOriginalFile());
        documentModel.setSignedFile(model.getSignedFile());
        documentModel.setMarkedFile(model.getMarkedFile());
        documentModel.setSignatureType(model.getSignatureType());
        documentModel.setAvailableUntil(model.getAvailableUntil());

        return documentModel;
    }

    static Signer toSigner(SignerModel signerModel){
          Signer signer = new Signer(signerModel);
          return signer;
    }
}
