package com.lacunasoftware.restpkicore;

public class ToSignHashAndState {

    private DigestAlgorithmAndValue toSignHash;
    private String state;
    private SignatureParametersModel toSign;

    ToSignHashAndState(DigestAlgorithmAndValueModel toSignHashModel, String state) {
        this.toSignHash = new DigestAlgorithmAndValue(toSignHashModel);
        this.state = state;
    }
    

    public ToSignHashAndState(SignatureParametersModel signatureParams, String state) {
        this.toSign = new SignatureParametersModel()
            .signatureAlgorithm(signatureParams.getSignatureAlgorithm())
            .data(signatureParams.getData())
            .hash(signatureParams.getHash())
            .digestInfo(signatureParams.getDigestInfo());
        this.state = state;
    }


    public DigestAlgorithmAndValue getToSignHash() {
        return toSignHash;
    }

    public String getState() {
        return state;
    }

    public void setToSignHash(DigestAlgorithmAndValue toSignHash) {
        this.toSignHash = toSignHash;
    }

    public void setState(String state) {
        this.state = state;
    }

    public SignatureParametersModel getToSign() {
        return toSign;
    }

    public void setToSign(SignatureParametersModel toSign) {
        this.toSign = toSign;
    }

    
}
