package com.lacunasoftware.restpkicore;

public class AuthenticationResult {

    private boolean success;
    private AuthenticationFailures failure;
    private PKCertificate certificate;
    private ValidationResults validationResults;

    AuthenticationResult(CompleteAuthenticationResponse response) {
        this.success = response.isSuccess();
        this.failure = response.getFailure();
        if (response.getCertificate() != null) {
            this.certificate = new PKCertificate(response.getCertificate());
        }
        if (response.getValidationResults() != null) {
            this.validationResults = new ValidationResults(response.getValidationResults());
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public AuthenticationFailures getFailure() {
        return failure;
    }

    public PKCertificate getCertificate() {
        return certificate;
    }

    public ValidationResults getValidationResults() {
        return validationResults;
    }
}
