package com.lacunasoftware.restpkicore;

import java.util.UUID;

/**
 * RestBioService
 */
public interface RestBioService {

	public default StartBioSessionResponse StartLivenessSession(StartLivenessSessionRequest request)
			throws Exception {
		return StartLivenessSession(request, null);
	}

	public StartBioSessionResponse StartLivenessSession(StartLivenessSessionRequest request, UUID subscriptionId)
			throws Exception;

	public LivenessSessionStatusModel GetLivenessSessionStatus(UUID sessionId) throws RestException;

	public LivenessSessionStatusModel CompleteLivenessSession(String ticket) throws RestException;

	public default StartBioSessionResponse StartEnrollmentSession(StartBioEnrollmentSessionRequest request)
			throws Exception {
		return StartEnrollmentSession(request, null);
	}

	public StartBioSessionResponse StartEnrollmentSession(StartBioEnrollmentSessionRequest request,
			UUID subscriptionId) throws Exception;

	public BioEnrollmentSessionStatusModel GetEnrollmentSessionStatus(UUID sessionId) throws RestException;

	public BioEnrollmentSessionStatusModel CompleteEnrollmentSession(String ticket) throws RestException;

	public default StartBioSessionResponse StartAuthenticationSession(StartBioAuthenticationSessionRequest request)
			throws Exception {
		return StartAuthenticationSession(request, null);
	}

	public StartBioSessionResponse StartAuthenticationSession(StartBioAuthenticationSessionRequest request,
			UUID subscriptionId) throws Exception;

	public BioAuthenticationSessionStatusModel GetAuthenticationSessionStatus(UUID sessionId) throws RestException;

	public BioAuthenticationSessionStatusModel CompleteAuthenticationSession(String ticket) throws RestException;

	public BioSessionResultDataModel GetSessionResultData(UUID sessionId) throws RestException;

	public BioSubjectModel GetSubjectById(UUID subjectId) throws RestException;

	public default BioSubjectModel GetSubjectByIdentifier(String subjectIdentifier) throws RestException {
		return GetSubjectByIdentifier(subjectIdentifier, null);
	}

	public BioSubjectModel GetSubjectByIdentifier(String subjectIdentifier, UUID subscriptionId)
			throws RestException;

	public BioSubjectFaceModel GetFaceBySubjectId(UUID subjectId) throws RestException;

}