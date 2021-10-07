package com.lacunasoftware.restpkicore;

/**
 * Class containing the PKI-Italy policy specific certificate fields.
 */
public class PkiItalyCertificateFields {

	private PkiItalyCertificateTypes certificateType;
	private String codiceFiscale;
	private String idCarta;

	PkiItalyCertificateFields(PkiItalyCertificateModel model) {
		this.certificateType = PkiItalyCertificateTypes.valueOf(model.getCertificateType().toString());
		this.codiceFiscale = model.getCodiceFiscale();
		this.idCarta = model.getIdCarta();
	}

	public PkiItalyCertificateTypes getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(PkiItalyCertificateTypes certificateType) {
		this.certificateType = certificateType;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(String idCarta) {
		this.idCarta = idCarta;
	}
}
