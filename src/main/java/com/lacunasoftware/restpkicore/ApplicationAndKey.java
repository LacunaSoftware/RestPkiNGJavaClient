package com.lacunasoftware.restpkicore;

public class ApplicationAndKey {

	private ApplicationModel application;
	private String key;

	public ApplicationAndKey(ApplicationModel application, String key) {
		this.application = application;
		this.key = key;
	}

	public ApplicationModel getApplication() {
		return application;
	}

	public String getKey() {
		return key;
	}
}
