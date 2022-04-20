package com.lacunasoftware.restpkicore;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Represents a digest algorithm
 */
public enum DigestAlgorithm {

	MD5("MD5"),
	SHA1("SHA-1"),
	SHA256("SHA-256"),
	SHA384("SHA-384"),
	SHA512("SHA-512");

	private String name;

	private DigestAlgorithm(String name) {
		this.name = name;
	}

	static DigestAlgorithm getInstanceByApiModel(DigestAlgorithms model) {
		switch (model) {
			case MD5:
				return MD5;
			case SHA1:
				return SHA1;
			case SHA256:
				return SHA256;
			case SHA384:
				return SHA384;
			case SHA512:
				return SHA512;
			default:
				throw new RuntimeException("Unsupported digest algorithm: " + model); // should not happen
		}
	}

	/**
	 * Returns the name of the digest algorithm.
	 *
	 * @return Name of the digest algorithm.
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns a Service Provider Interface (SPI) corresponding to the digest algorithm.
	 *
	 * @return An instance of the MessageDigest class (the SPI) corresponding to the digest
	 * algorithm.
	 */
	public MessageDigest getSpi() {
		try {
			return MessageDigest.getInstance(name);
		} catch (NoSuchAlgorithmException e) {
			// should not happen
			throw new RuntimeException("Could not get MessageDigest instance for algorithm " + name, e);
		}
	}

	DigestAlgorithms getModel() {
		switch (this) {
			case MD5:
				return DigestAlgorithms.MD5;
			case SHA1:
				return DigestAlgorithms.SHA1;
			case SHA256:
				return DigestAlgorithms.SHA256;
			case SHA384:
				return DigestAlgorithms.SHA384;
			case SHA512:
				return DigestAlgorithms.SHA512;
			default:
				throw new RuntimeException(); // should not happen
		}
	}
}
