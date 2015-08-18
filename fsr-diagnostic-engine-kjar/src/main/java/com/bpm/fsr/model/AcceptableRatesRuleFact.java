package com.bpm.fsr.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

@org.kie.api.definition.type.Label("AcceptableRatesRuleFact")
public class AcceptableRatesRuleFact implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label("PurchasedRatesPresent")
	@org.kie.api.definition.type.Position(0)
	private boolean isPurchasedRatesPresent;

    @org.kie.api.definition.type.Label("PurchasedRateDown")
	@org.kie.api.definition.type.Position(1)
	private java.lang.Integer purchasedRateDown;

	@org.kie.api.definition.type.Label("PurchasedRateUP")
	@org.kie.api.definition.type.Position(2)
	private java.lang.Integer purchasedRateUP;

	@org.kie.api.definition.type.Label("isProvisionedRateDown")
	@org.kie.api.definition.type.Position(3)
	private java.lang.Boolean isProvisionedRateDown;

	@org.kie.api.definition.type.Label("isProvisionedRatesPresent")
	@org.kie.api.definition.type.Position(4)
	private java.lang.Boolean isProvisionedRatesPresent;

	@org.kie.api.definition.type.Label("ProvisionedRateDown")
	@org.kie.api.definition.type.Position(5)
	private java.lang.Integer provisionedRateDown;

	@org.kie.api.definition.type.Label("isProvisionedRateUP")
	@org.kie.api.definition.type.Position(6)
	private java.lang.Boolean isProvisionedRateUP;

	@org.kie.api.definition.type.Label("ProvisionedRateUP")
	@org.kie.api.definition.type.Position(7)
	private java.lang.Integer provisionedRateUP;

	@org.kie.api.definition.type.Label("ActualRatesPresent")
	@org.kie.api.definition.type.Position(8)
	private java.lang.Boolean isActualRatesPresent;

	@org.kie.api.definition.type.Label("IsActualRateUP")
	@org.kie.api.definition.type.Position(9)
	private java.lang.Boolean isActualRateUP;

	@org.kie.api.definition.type.Label("actualRateUP")
	@org.kie.api.definition.type.Position(10)
	private java.lang.Integer actualRateUP;

	@org.kie.api.definition.type.Label("IsActualRateDown")
	@org.kie.api.definition.type.Position(11)
	private java.lang.Boolean isActualRateDown;

	@org.kie.api.definition.type.Label("ActualRateDown")
	@org.kie.api.definition.type.Position(12)
	private java.lang.Integer actualRateDown;

	@org.kie.api.definition.type.Label(value = "Path")
	@org.kie.api.definition.type.Position(value = 13)
	private java.lang.String path;

	public boolean isIsPurchasedRatesPresent() {
        return this.isPurchasedRatesPresent;
    }
    
    public void setIsPurchasedRatesPresent(boolean isPurchasedRatesPresent) {
        this.isPurchasedRatesPresent = isPurchasedRatesPresent;
    }

	public java.lang.Integer getPurchasedRateDown() {
		return this.purchasedRateDown;
	}

	public void setPurchasedRateDown(java.lang.Integer purchasedRateDown) {
		this.purchasedRateDown = purchasedRateDown;
	}

	public java.lang.Integer getPurchasedRateUP() {
		return this.purchasedRateUP;
	}

	public void setPurchasedRateUP(java.lang.Integer purchasedRateUP) {
		this.purchasedRateUP = purchasedRateUP;
	}

	public java.lang.Boolean getIsProvisionedRateDown() {
		return this.isProvisionedRateDown;
	}

	public void setIsProvisionedRateDown(java.lang.Boolean isProvisionedRateDown) {
		this.isProvisionedRateDown = isProvisionedRateDown;
	}

	public java.lang.Boolean getIsProvisionedRatesPresent() {
		return this.isProvisionedRatesPresent;
	}

	public void setIsProvisionedRatesPresent(
			java.lang.Boolean isProvisionedRatesPresent) {
		this.isProvisionedRatesPresent = isProvisionedRatesPresent;
	}

	public java.lang.Integer getProvisionedRateDown() {
		return this.provisionedRateDown;
	}

	public void setProvisionedRateDown(java.lang.Integer provisionedRateDown) {
		this.provisionedRateDown = provisionedRateDown;
	}

	public java.lang.Boolean getIsProvisionedRateUP() {
		return this.isProvisionedRateUP;
	}

	public void setIsProvisionedRateUP(java.lang.Boolean isProvisionedRateUP) {
		this.isProvisionedRateUP = isProvisionedRateUP;
	}

	public java.lang.Integer getProvisionedRateUP() {
		return this.provisionedRateUP;
	}

	public void setProvisionedRateUP(java.lang.Integer provisionedRateUP) {
		this.provisionedRateUP = provisionedRateUP;
	}

	public java.lang.Boolean getIsActualRatesPresent() {
		return this.isActualRatesPresent;
	}

	public void setIsActualRatesPresent(java.lang.Boolean isActualRatesPresent) {
		this.isActualRatesPresent = isActualRatesPresent;
	}

	public java.lang.Boolean getIsActualRateUP() {
		return this.isActualRateUP;
	}

	public void setIsActualRateUP(java.lang.Boolean isActualRateUP) {
		this.isActualRateUP = isActualRateUP;
	}

	public java.lang.Integer getActualRateUP() {
		return this.actualRateUP;
	}

	public void setActualRateUP(java.lang.Integer actualRateUP) {
		this.actualRateUP = actualRateUP;
	}

	public java.lang.Boolean getIsActualRateDown() {
		return this.isActualRateDown;
	}

	public void setIsActualRateDown(java.lang.Boolean isActualRateDown) {
		this.isActualRateDown = isActualRateDown;
	}

	public java.lang.Integer getActualRateDown() {
		return this.actualRateDown;
	}

	public void setActualRateDown(java.lang.Integer actualRateDown) {
		this.actualRateDown = actualRateDown;
	}

	public java.lang.String getPath() {
		return this.path;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public AcceptableRatesRuleFact() {
	}

	public AcceptableRatesRuleFact(boolean isPurchasedRatesPresent,
			java.lang.Integer purchasedRateDown,
			java.lang.Integer purchasedRateUP,
			java.lang.Boolean isProvisionedRateDown,
			java.lang.Boolean isProvisionedRatesPresent,
			java.lang.Integer provisionedRateDown,
			java.lang.Boolean isProvisionedRateUP,
			java.lang.Integer provisionedRateUP,
			java.lang.Boolean isActualRatesPresent,
			java.lang.Boolean isActualRateUP, java.lang.Integer actualRateUP,
			java.lang.Boolean isActualRateDown,
			java.lang.Integer actualRateDown, java.lang.String path) {
		this.isPurchasedRatesPresent = isPurchasedRatesPresent;
		this.purchasedRateDown = purchasedRateDown;
		this.purchasedRateUP = purchasedRateUP;
		this.isProvisionedRateDown = isProvisionedRateDown;
		this.isProvisionedRatesPresent = isProvisionedRatesPresent;
		this.provisionedRateDown = provisionedRateDown;
		this.isProvisionedRateUP = isProvisionedRateUP;
		this.provisionedRateUP = provisionedRateUP;
		this.isActualRatesPresent = isActualRatesPresent;
		this.isActualRateUP = isActualRateUP;
		this.actualRateUP = actualRateUP;
		this.isActualRateDown = isActualRateDown;
		this.actualRateDown = actualRateDown;
		this.path = path;
	}
	@Override
	public String toString() {
		return "VerifyProtocol [isPurchasedRatesPresent=" + isPurchasedRatesPresent +"purchasedRateDown=" +purchasedRateDown +
		"purchasedRateUP="+purchasedRateUP+	"provisionedRateDown="	+ provisionedRateDown +"provisionedRateUP=" +provisionedRateUP+
		"isActualRatesPresent="+isActualRatesPresent + "actualRateUP="+actualRateUP + "actualRateDown=" + actualRateDown+"Path="+path+"]";
	}
}