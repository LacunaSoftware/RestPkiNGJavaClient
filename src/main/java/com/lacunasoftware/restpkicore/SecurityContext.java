package com.lacunasoftware.restpkicore;

import java.util.UUID;

/**
 * Reference to a security context in the REST PKI service, which is used to
 * determine if a given
 * certificate can be trusted.
 */
public class SecurityContext {

	/**
	 * Returns a reference to the built-in PkiBrazil security context (ICP-Brasil).
	 * This context is
	 * guaranteed to be available.
	 */
	public static final SecurityContext pkiBrazil = new SecurityContext("201856ce-273c-4058-a872-8937bd547d36");

	/**
	 * Returns a reference to the built-in PkiItaly security context. This context
	 * is guaranteed to
	 * be available.
	 */
	public static final SecurityContext pkiItaly = new SecurityContext("c438b17e-4862-446b-86ad-6f85734f0bfe");

	/**
	 * Returns a reference to the built-in WindowsServer security context, which
	 * consists of the
	 * roots trusted by default by Windows Server. This context is guaranteed to be
	 * available.
	 */
	public static final SecurityContext windowsServer = new SecurityContext("3881384c-a54d-45c5-bbe9-976b674f5ec7");

	/**
	 * Lacuna Test PKI (use for development purposes only!) If you are using an
	 * on-premises instance
	 * of Rest PKI (instead of https://pki.rest/), this security context might have
	 * to be created
	 * first.
	 */
	public static final SecurityContext lacunaTest = new SecurityContext("803517ad-3bbc-4169-b085-60053a8f6dbf");

	private String id;

	/**
	 * Creates a reference to a custom security context created on the REST PKI
	 * website.
	 *
	 * @param id The id of the security context, as given by the REST PKI website.
	 */
	public SecurityContext(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UUID getUUID() {
		return UUID.fromString(id);
	}
}
