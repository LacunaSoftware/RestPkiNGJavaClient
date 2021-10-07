package com.lacunasoftware.restpkicore;


import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Error codes for the REST PKI API
 */
public enum ErrorCodes {
	EntityNotFound,
	EntityAlreadyExists,
	EntityUnusable,
	EntityIsReadOnly,
	SecurityContextRequired,
	PKCertificateMalformed,
	ValidationError,
	ClientSignatureNotSet,
	ClientSignatureAlreadySet,
	ToSignHashNotAvailable,
	CertificateMismatch,
	InvalidRequest,
	TimestampingUnavailable,
	EndUserCertificate,
	CACertificate,
	SelfSignedCertificate,
	TimestampPlanRequired,
	StorageUnavailable,
	InvalidPdf,
	InvalidVisualRepresentation,
	SignaturePolicyRequired,
	MissingDataHash,
	CannotApplyPdfMarks,
	BadDigest,
	InvalidXml,
	TransactionLimitAlreadyExists,
	InvalidSortField,
	FontSizeZero,
	InvalidPage,
	FileDownloadFailed,
	InvalidElementType,
	UnsupportedCMSContentType,
	UnsupportedDigestAlgorithm,
	UnsupportedSignatureAlgorithm,
	PadesPositionNotFilled,
	SignatureHashNotFound,
	InvoiceNotCreated,
	InvalidCades,
	InvalidToken,
	ProtectedPdfError;

	private static final Map<String, ErrorCodes> ENUM_MAP;

	static {
		Map<String, ErrorCodes> map = new ConcurrentHashMap<>();
		for (ErrorCodes instance : ErrorCodes.values()) {
			map.put(instance.name().toLowerCase(), instance);
		}
		ENUM_MAP = Collections.unmodifiableMap(map);
	}

	public static ErrorCodes get(String name) {
		return ENUM_MAP.get(name.toLowerCase());
	}

	public static boolean exists(String name) {
		return ENUM_MAP.containsKey(name.toLowerCase());
	}
}
