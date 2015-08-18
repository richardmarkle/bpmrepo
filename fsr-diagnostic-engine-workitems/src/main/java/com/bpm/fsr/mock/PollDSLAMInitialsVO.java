package com.bpm.fsr.mock;

public class PollDSLAMInitialsVO implements java.io.Serializable {
	private boolean isErrored;
	private boolean isPollDSLAMSupported;
	private float customerExpScore;
	private String deviceTID;
	private boolean isNetworkCongested;
	
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
	}
	public boolean isPollDSLAMSupported() {
		return isPollDSLAMSupported;
	}
	public void setPollDSLAMSupported(boolean isPollDSLAMSupported) {
		this.isPollDSLAMSupported = isPollDSLAMSupported;
	}
	public float getCustomerExpScore() {
		return customerExpScore;
	}
	public void setCustomerExpScore(float customerExpScore) {
		this.customerExpScore = customerExpScore;
	}
	public String getDeviceTID() {
		return deviceTID;
	}
	public void setDeviceTID(String deviceTID) {
		this.deviceTID = deviceTID;
	}
	public boolean isNetworkCongested() {
		return isNetworkCongested;
	}
	public void setNetworkCongested(boolean isNetworkCongested) {
		this.isNetworkCongested = isNetworkCongested;
	}
	
	
	@Override
	public String toString() {
		return "PollDSLAMInitialsVO [isErrored=" + isErrored +", isPollDSLAMSupported="+isPollDSLAMSupported +
				",customerExpScore="+customerExpScore +",deviceTID=" +deviceTID + ",isNetworkCongested=" + isNetworkCongested +"]";
	}

}
