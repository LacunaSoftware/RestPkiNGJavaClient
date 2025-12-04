package com.lacunasoftware.restpkicore;

import java.util.UUID;

/**
 * RestBioService
 */
public interface RestBioService {

	public default StartBioSessionResponse StartLivenessSessionAsync(StartLivenessSessionRequest request) throws Exception {
		return StartLivenessSessionAsync(request, null);
	}

	public StartBioSessionResponse StartLivenessSessionAsync(StartLivenessSessionRequest request, UUID subscriptionId) throws Exception;

	public LivenessSessionStatusModel GetLivenessSessionStatusAsync(UUID sessionId) throws RestException;

	public LivenessSessionStatusModel CompleteLivenessSessionAsync(String ticket) throws RestException;

}