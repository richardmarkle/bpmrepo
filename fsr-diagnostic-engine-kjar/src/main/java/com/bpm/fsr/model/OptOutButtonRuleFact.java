package com.bpm.fsr.model;

public class OptOutButtonRuleFact implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label(value = "inWalledGarden")
	@org.kie.api.definition.type.Position(value = 1)
	private boolean inWalledGarden;

	@org.kie.api.definition.type.Label(value = "optOutButtonText")
	@org.kie.api.definition.type.Position(value = 2)
	private java.lang.String optOutButtonText;

	@org.kie.api.definition.type.Label(value = "outageExists")
	@org.kie.api.definition.type.Position(value = 0)
	private boolean outageExists;

	public OptOutButtonRuleFact() {
	}

	public OptOutButtonRuleFact(boolean outageExists, boolean inWalledGarden,
			java.lang.String optOutButtonText) {
		this.outageExists = outageExists;
		this.inWalledGarden = inWalledGarden;
		this.optOutButtonText = optOutButtonText;
	}

	public boolean isInWalledGarden() {
		return this.inWalledGarden;
	}

	public void setInWalledGarden(boolean inWalledGarden) {
		this.inWalledGarden = inWalledGarden;
	}

	public java.lang.String getOptOutButtonText() {
		return this.optOutButtonText;
	}

	public void setOptOutButtonText(java.lang.String optOutButtonText) {
		this.optOutButtonText = optOutButtonText;
	}

	public boolean isOutageExists() {
		return this.outageExists;
	}

	public void setOutageExists(boolean outageExists) {
		this.outageExists = outageExists;
	}

	@Override
	public String toString() {
		return "OptOutButtonRuleFact [inWalledGarden=" + inWalledGarden
				+ ", optOutButtonText=" + optOutButtonText + ", outageExists="
				+ outageExists + "]";
	}

}