package com.lacunasoftware.restpkicore;

/**
 * Represents a digest algorithm and value.
 */
public class DigestAlgorithmAndValue {

	private DigestAlgorithm algorithm;
	private byte[] value;

	DigestAlgorithmAndValue(DigestAlgorithmAndValueModel model) {
		this.algorithm = DigestAlgorithm.getInstanceByApiModel(model.getAlgorithm());
		this.value = model.getValue();
	}

	/**
	 * Returns the digest algorithm.
	 */
	public DigestAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(DigestAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Returns the digest value.
	 */
	public byte[] getValue() {
		return value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}

    public String getValueAsBase64() {
        return Util.encodeBase64(value);
    }
}
