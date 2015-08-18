package com.bpm.fsr.mock;

public class SpeedsVO implements java.io.Serializable {
	boolean purchasedSpeedAvailable;
	boolean provisionedSpeedAvailable;
	boolean actualSpeedAvailable;
	
	int purchasedSpeedUp;
	int purchasedSpeedDown;
	int provisionedSpeedUp;
	int provisionedSpeedDown;
    int actualSpeedUp;
    int actualSpeedDown;
	public boolean isPurchasedSpeedAvailable() {
		return purchasedSpeedAvailable;
	}
	public void setPurchasedSpeedAvailable(boolean purchasedSpeedAvailable) {
		this.purchasedSpeedAvailable = purchasedSpeedAvailable;
	}
	public boolean isProvisionedSpeedAvailable() {
		return provisionedSpeedAvailable;
	}
	public void setProvisionedSpeedAvailable(boolean provisionedSpeedAvailable) {
		this.provisionedSpeedAvailable = provisionedSpeedAvailable;
	}
	public boolean isActualSpeedAvailable() {
		return actualSpeedAvailable;
	}
	public void setActualSpeedAvailable(boolean actualSpeedAvailable) {
		this.actualSpeedAvailable = actualSpeedAvailable;
	}
	public int getPurchasedSpeedUp() {
		return purchasedSpeedUp;
	}
	public void setPurchasedSpeedUp(int purchasedSpeedUp) {
		this.purchasedSpeedUp = purchasedSpeedUp;
	}
	public int getPurchasedSpeedDown() {
		return purchasedSpeedDown;
	}
	public void setPurchasedSpeedDown(int purchasedSpeedDown) {
		this.purchasedSpeedDown = purchasedSpeedDown;
	}
	public int getProvisionedSpeedUp() {
		return provisionedSpeedUp;
	}
	public void setProvisionedSpeedUp(int provisionedSpeedUp) {
		this.provisionedSpeedUp = provisionedSpeedUp;
	}
	public int getProvisionedSpeedDown() {
		return provisionedSpeedDown;
	}
	public void setProvisionedSpeedDown(int provisionedSpeedDown) {
		this.provisionedSpeedDown = provisionedSpeedDown;
	}
	public int getActualSpeedUp() {
		return actualSpeedUp;
	}
	public void setActualSpeedUp(int actualSpeedUp) {
		this.actualSpeedUp = actualSpeedUp;
	}
	public int getActualSpeedDown() {
		return actualSpeedDown;
	}
	public void setActualSpeedDown(int actualSpeedDown) {
		this.actualSpeedDown = actualSpeedDown;
	}
}
