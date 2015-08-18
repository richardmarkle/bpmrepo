package com.bpm.fsr.mock;

public class PollDSLAMActualsVO implements java.io.Serializable {
	
	private boolean isErrored;
	private boolean isPollDSLAMSupported;
	private boolean isModemTrained;
	private boolean isNoiseMarginAvailable;
	private int noiseMarginUp;
	private int noiseMarginDown;
	private boolean provisionedSpeedAvailable;
	private boolean actualSpeedAvailable;
	private int provisionedSpeedUp;
	private int provisionedSpeedDown;
	private int actualSpeedUp;
	private int actualSpeedDown;
	private String portAdminStatus;
	private String portOpStatus;
	private String crossConnectStatus;
	private int provisionedSpeedUp_2;
	private int provisionedSpeedDown_2;
	private String portAdminStatus_2;
	private String portOpStatus_2;
	private String actualsSubscriberVPI;
	private String actualsSubscriberVCI;
	private String actualsSubscriberVLAN;
	private String actualsNetworkVPI;
	private String actualsNetworkVCI;
	private String actualsNetworkVLAN;
	
	
	
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
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
	public String getCrossConnectStatus() {
		return crossConnectStatus;
	}
	public void setCrossConnectStatus(String crossConnectStatus) {
		this.crossConnectStatus = crossConnectStatus;
	}
	public int getProvisionedSpeedUp_2() {
		return provisionedSpeedUp_2;
	}
	public void setProvisionedSpeedUp_2(int provisionedSpeedUp_2) {
		this.provisionedSpeedUp_2 = provisionedSpeedUp_2;
	}
	public int getProvisionedSpeedDown_2() {
		return provisionedSpeedDown_2;
	}
	public void setProvisionedSpeedDown_2(int provisionedSpeedDown_2) {
		this.provisionedSpeedDown_2 = provisionedSpeedDown_2;
	}
	public String getPortAdminStatus_2() {
		return portAdminStatus_2;
	}
	public void setPortAdminStatus_2(String portAdminStatus_2) {
		this.portAdminStatus_2 = portAdminStatus_2;
	}
	public String getPortOpStatus_2() {
		return portOpStatus_2;
	}
	public void setPortOpStatus_2(String portOpStatus_2) {
		this.portOpStatus_2 = portOpStatus_2;
	}
	public String getActualsSubscriberVPI() {
		return actualsSubscriberVPI;
	}
	public void setActualsSubscriberVPI(String actualsSubscriberVPI) {
		this.actualsSubscriberVPI = actualsSubscriberVPI;
	}
	public String getActualsSubscriberVCI() {
		return actualsSubscriberVCI;
	}
	public void setActualsSubscriberVCI(String actualsSubscriberVCI) {
		this.actualsSubscriberVCI = actualsSubscriberVCI;
	}
	public String getActualsSubscriberVLAN() {
		return actualsSubscriberVLAN;
	}
	public void setActualsSubscriberVLAN(String actualsSubscriberVLAN) {
		this.actualsSubscriberVLAN = actualsSubscriberVLAN;
	}
	public String getActualsNetworkVPI() {
		return actualsNetworkVPI;
	}
	public void setActualsNetworkVPI(String actualsNetworkVPI) {
		this.actualsNetworkVPI = actualsNetworkVPI;
	}
	public String getActualsNetworkVCI() {
		return actualsNetworkVCI;
	}
	public void setActualsNetworkVCI(String actualsNetworkVCI) {
		this.actualsNetworkVCI = actualsNetworkVCI;
	}
	public String getActualsNetworkVLAN() {
		return actualsNetworkVLAN;
	}
	public void setActualsNetworkVLAN(String actualsNetworkVLAN) {
		this.actualsNetworkVLAN = actualsNetworkVLAN;
	}
	public boolean isPollDSLAMSupported() {
		return isPollDSLAMSupported;
	}
	public void setPollDSLAMSupported(boolean isPollDSLAMSupported) {
		this.isPollDSLAMSupported = isPollDSLAMSupported;
	}
	public boolean isModemTrained() {
		return isModemTrained;
	}
	public void setModemTrained(boolean isModemTrained) {
		this.isModemTrained = isModemTrained;
	}
	public boolean isNoiseMarginAvailable() {
		return isNoiseMarginAvailable;
	}
	public void setNoiseMarginAvailable(boolean isNoiseMarginAvailable) {
		this.isNoiseMarginAvailable = isNoiseMarginAvailable;
	}
	public int getNoiseMarginUp() {
		return noiseMarginUp;
	}
	public void setNoiseMarginUp(int noiseMarginUp) {
		this.noiseMarginUp = noiseMarginUp;
	}
	public int getNoiseMarginDown() {
		return noiseMarginDown;
	}
	public void setNoiseMarginDown(int noiseMarginDown) {
		this.noiseMarginDown = noiseMarginDown;
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
	public String getPortAdminStatus() {
		return portAdminStatus;
	}
	
	public void setPortAdminStatus(String portAdminStatus) {
		this.portAdminStatus = portAdminStatus;
	}
	public String getPortOpStatus() {
		return portOpStatus;
	}
	public void setPortOpStatus(String portOpStatus) {
		this.portOpStatus = portOpStatus;
	}
	@Override
	public String toString() {
		return "PollDSLAMActualsVO [isErrored=" + isErrored
				+ ", isPollDSLAMSupported=" + isPollDSLAMSupported
				+ ", isModemTrained=" + isModemTrained
				+ ", isNoiseMarginAvailable=" + isNoiseMarginAvailable
				+ ", noiseMarginUp=" + noiseMarginUp + ", noiseMarginDown="
				+ noiseMarginDown + ", provisionedSpeedAvailable="
				+ provisionedSpeedAvailable + ", actualSpeedAvailable="
				+ actualSpeedAvailable + ", provisionedSpeedUp="
				+ provisionedSpeedUp + ", provisionedSpeedDown="
				+ provisionedSpeedDown + ", actualSpeedUp=" + actualSpeedUp
				+ ", actualSpeedDown=" + actualSpeedDown + ", portAdminStatus="
				+ portAdminStatus + ", portOpStatus=" + portOpStatus
				+ ", crossConnectStatus=" + crossConnectStatus
				+ ", provisionedSpeedUp_2=" + provisionedSpeedUp_2
				+ ", provisionedSpeedDown_2=" + provisionedSpeedDown_2
				+ ", portAdminStatus_2=" + portAdminStatus_2
				+ ", portOpStatus_2=" + portOpStatus_2
				+ ", actualsSubscriberVPI=" + actualsSubscriberVPI
				+ ", actualsSubscriberVCI=" + actualsSubscriberVCI
				+ ", actualsSubscriberVLAN=" + actualsSubscriberVLAN
				+ ", actualsNetworkVPI=" + actualsNetworkVPI
				+ ", actualsNetworkVCI=" + actualsNetworkVCI
				+ ", actualsNetworkVLAN=" + actualsNetworkVLAN + "]";
	}
	
	
}
