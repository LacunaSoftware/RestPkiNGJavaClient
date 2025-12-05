package com.lacunasoftware.restpkicore;

import java.util.UUID;

/**
 * RestBioService
 */
public interface RestBioService {

	public default StartBioSessionResponse StartLivenessSessionAsync(StartLivenessSessionRequest request)
			throws Exception {
		return StartLivenessSessionAsync(request, null);
	}

	public StartBioSessionResponse StartLivenessSessionAsync(StartLivenessSessionRequest request, UUID subscriptionId)
			throws Exception;

	public LivenessSessionStatusModel GetLivenessSessionStatusAsync(UUID sessionId) throws RestException;

	public LivenessSessionStatusModel CompleteLivenessSessionAsync(String ticket) throws RestException;

	public default StartBioSessionResponse StartEnrollmentSessionAsync(StartBioEnrollmentSessionRequest request)
			throws Exception {
		return StartEnrollmentSessionAsync(request, null);
	}

	public StartBioSessionResponse StartEnrollmentSessionAsync(StartBioEnrollmentSessionRequest request,
			UUID subscriptionId) throws Exception;

	public BioEnrollmentSessionStatusModel GetEnrollmentSessionStatusAsync(UUID sessionId) throws RestException;

	public BioEnrollmentSessionStatusModel CompleteEnrollmentSessionAsync(String ticket) throws RestException;

	public default StartBioSessionResponse StartAuthenticationSessionAsync(StartBioAuthenticationSessionRequest request)
			throws Exception {
		return StartAuthenticationSessionAsync(request, null);
	}

	public StartBioSessionResponse StartAuthenticationSessionAsync(StartBioAuthenticationSessionRequest request,
			UUID subscriptionId) throws Exception;

	public BioAuthenticationSessionStatusModel GetAuthenticationSessionStatusAsync(UUID sessionId) throws RestException;

	public BioAuthenticationSessionStatusModel CompleteAuthenticationSessionAsync(String ticket) throws RestException;

	public BioSessionResultDataModel GetSessionResultData(UUID sessionId) throws RestException;

	public BioSubjectModel GetSubjectByIdAsync(UUID subjectId) throws RestException;

	public default BioSubjectModel GetSubjectByIdentifierAsync(String subjectIdentifier) throws RestException {
		return GetSubjectByIdentifierAsync(subjectIdentifier, null);
	}

	public BioSubjectModel GetSubjectByIdentifierAsync(String subjectIdentifier, UUID subscriptionId)
			throws RestException;

	public BioSubjectFaceModel GetFaceBySubjectIdAsync(UUID subjectId) throws RestException;

}