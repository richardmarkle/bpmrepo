/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpm.fsr.mock;

/**
 *
 * @author ab19041
 */
public class KnownOutageVO implements java.io.Serializable {
    private boolean outageExists;
    private String outageId;
    private String outageType;
    private String outageStatus;
    private boolean isCongestionOutagePresent;

    public boolean isCongestionOutagePresent() {
		return isCongestionOutagePresent;
	}

	public void setCongestionOutagePresent(boolean isCongestionOutagePresent) {
		this.isCongestionOutagePresent = isCongestionOutagePresent;
	}

	public String getOutageStatus() {
        return outageStatus;
    }

    public void setOutageStatus(String outageStatus) {
        this.outageStatus = outageStatus;
    }

    public String getProductAffected() {
        return productAffected;
    }

    public void setProductAffected(String productAffected) {
        this.productAffected = productAffected;
    }
    private String productAffected;

    public String getOutageType() {
        return outageType;
    }

    public void setOutageType(String outageType) {
        this.outageType = outageType;
    }

    public boolean isOutageExists() {
        return outageExists;
    }

    public void setOutageExists(boolean outageExists) {
        this.outageExists = outageExists;
    }

    public String getOutageId() {
        return outageId;
    }

    public void setOutageId(String outageId) {
        this.outageId = outageId;
    }

    @Override
    public String toString() {
        return "KnownOutageVO{" + "outageExists=" + outageExists + ", outageId=" + outageId + ", outageType=" + outageType + ", outageStatus=" + outageStatus + ", productAffected=" + productAffected + '}';
    }
}