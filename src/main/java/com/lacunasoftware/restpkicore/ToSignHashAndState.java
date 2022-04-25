package com.lacunasoftware.restpkicore;

public class ToSignHashAndState {

    private DigestAlgorithmAndValue toSignHash;
    private String state;

    ToSignHashAndState(DigestAlgorithmAndValueModel toSignHashModel, String state) {
        this.toSignHash = new DigestAlgorithmAndValue(toSignHashModel);
        this.state = state;
    }

    public DigestAlgorithmAndValue getToSignHash() {
        return toSignHash;
    }

    public String getState() {
        return state;
    }
}
