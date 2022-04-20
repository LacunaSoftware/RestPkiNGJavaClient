package com.lacunasoftware.restpkicore;

public class CompleteAuthenticationOptions {

    private String state;
    private byte[] certificate;
    private byte[] signature;

    public CompleteAuthenticationOptions() {
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        state = value;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] value) {
        certificate = value;
    }

    public void setCertificateFromBase64(String base64) {
        certificate = Util.decodeBase64(base64);
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] value) {
        signature = value;
    }

    public void setSignatureFromBase64(String base64) {
        signature = Util.decodeBase64(base64);
    } 

    CompleteAuthenticationRequest getRequest() {
        CompleteAuthenticationRequest request = new CompleteAuthenticationRequest();
        request.setState(state);
        request.setCertificate(certificate);
        request.setSignature(signature);
        return request;
    }
}
