package com.lacunasoftware.restpkicore;

import java.util.UUID;

/**
 * RestBioService
 */
public interface RestBioService {

	public default StartBioSessionResponse StartLivenessSessionAsync(StartLivenessSessionRequest request) {
		return StartLivenessSessionAsync(request, null);
	}

	public StartBioSessionResponse StartLivenessSessionAsync(StartLivenessSessionRequest request, UUID subscriptionId);

	public LivenessSessionStatusModel GetLivenessSessionStatusAsync(UUID sessionId);

	public LivenessSessionStatusModel CompleteLivenessSessionAsync(String ticket);

}