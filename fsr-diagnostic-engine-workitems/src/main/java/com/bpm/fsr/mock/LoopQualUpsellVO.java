package com.bpm.fsr.mock;

public class LoopQualUpsellVO implements java.io.Serializable {

	boolean isErrored;
	int maximumSpeedUp;
	int maximumSpeedDown;
	
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
	}
	public int getMaximumSpeedUp() {
		return maximumSpeedUp;
	}
	public void setMaximumSpeedUp(int maximumSpeedUp) {
		this.maximumSpeedUp = maximumSpeedUp;
	}
	public int getMaximumSpeedDown() {
		return maximumSpeedDown;
	}
	public void setMaximumSpeedDown(int maximumSpeedDown) {
		this.maximumSpeedDown = maximumSpeedDown;
	}
	
	

}
