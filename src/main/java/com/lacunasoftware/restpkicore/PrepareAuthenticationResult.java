package com.lacunasoftware.restpkicore;

public class PrepareAuthenticationResult extends ToSignHashAndState {

    PrepareAuthenticationResult(DigestAlgorithmAndValueModel toSignHashModel, String state) {
        super(toSignHashModel, state);
    }

    PrepareAuthenticationResult(SignatureParametersModel signatureParametersModel, String state){
        super(signatureParametersModel, state);
    }
}
