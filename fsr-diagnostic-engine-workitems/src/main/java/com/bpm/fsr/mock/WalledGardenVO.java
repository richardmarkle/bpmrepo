package com.bpm.fsr.mock;

public class WalledGardenVO implements java.io.Serializable {

	private boolean inWalledGarden;
	private String walledGardenType;
	
	public boolean isInWalledGarden() {
		return inWalledGarden;
	}
	public void setInWalledGarden(boolean inWalledGarden) {
		this.inWalledGarden = inWalledGarden;
	}
	public String getWalledGardenType() {
		return walledGardenType;
	}
	public void setWalledGardenType(String walledGardenType) {
		this.walledGardenType = walledGardenType;
	}
}
