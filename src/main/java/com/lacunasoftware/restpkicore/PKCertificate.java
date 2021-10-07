package com.lacunasoftware.restpkicore;

import java.math.BigInteger;
import java.util.Date;

/**
 * Contains information about a X.509 public key certificate.
 */
public class PKCertificate {

	private Name subjectName;
	private String emailAddress;
	private Name issuerName;
	private BigInteger serialNumber;
	private Date validityStart;
	private Date validityEnd;
	private PkiBrazilCertificateFields pkiBrazil;
	private PkiItalyCertificateFields pkiItaly;
	private PKCertificate issuer;
	private byte[] binaryThumbprintSHA256;
	private String thumbprint;

	PKCertificate(CertificateModel model) {
		this.subjectName = new Name(model.getSubjectName());
		this.emailAddress = model.getEmailAddress();
		this.issuerName = new Name(model.getIssuerName());
		this.serialNumber = new BigInteger(model.getSerialNumber());
		this.pkiBrazil = new PkiBrazilCertificateFields(model.getPkiBrazil());
		this.pkiItaly = new PkiItalyCertificateFields(model.getPkiItaly());
		if (model.getIssuer() != null) {
			this.issuer = new PKCertificate(model.getIssuer());
		}
		this.binaryThumbprintSHA256 = model.getBinaryThumbprintSHA256();
		this.thumbprint = model.getThumbprint();

		if (model.getValidityStart() != null) {
			this.validityStart = Util.parseApiDate(model.getValidityStart());
		}
		if (model.getValidityEnd() != null) {
			this.validityEnd = Util.parseApiDate(model.getValidityEnd());
		}
	}

	public Name getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(Name subjectName) {
		this.subjectName = subjectName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Name getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(Name issuerName) {
		this.issuerName = issuerName;
	}

	public BigInteger getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(BigInteger serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getValidityStart() {
		return validityStart;
	}

	public void setValidityStart(Date validityStart) {
		this.validityStart = validityStart;
	}

	public Date getValidityEnd() {
		return validityEnd;
	}

	public void setValidityEnd(Date validityEnd) {
		this.validityEnd = validityEnd;
	}

	/**
	 * Gets the ICP-Brasil specific certificate fields.
	 *
	 * @return ICP-Brasil specific certificate fields.
	 */
	public PkiBrazilCertificateFields getPkiBrazil() {
		return pkiBrazil;
	}

	public void setPkiBrazil(PkiBrazilCertificateFields pkiBrazil) {
		this.pkiBrazil = pkiBrazil;
	}

	/**
	 * Gets PKI-Italy specific fields.
	 *
	 * @return PKI-Italy specific fields.
	 */
	public PkiItalyCertificateFields getPkiItaly() {
		return pkiItaly;
	}

	public void setPkiItaly(PkiItalyCertificateFields pkiItaly) {
		this.pkiItaly = pkiItaly;
	}

	public PKCertificate getIssuer() {
		return issuer;
	}

	public void setIssuer(PKCertificate issuer) {
		this.issuer = issuer;
	}

	public byte[] getBinaryThumbprintSHA256() {
		return binaryThumbprintSHA256;
	}

	public void setBinaryThumbprintSHA256(byte[] binaryThumbprintSHA256) {
		this.binaryThumbprintSHA256 = binaryThumbprintSHA256;
	}

	public String getThumbprint() {
		return thumbprint;
	}

	public void setThumbprint(String thumbprint) {
		this.thumbprint = thumbprint;
	}
}
