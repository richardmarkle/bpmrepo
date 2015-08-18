package com.bpm.fsr.mock;

public class AuthenticationVO implements java.io.Serializable {
	
	private String sourceSystem;
	private boolean isAuthenticated;
	private String wanIP;
	private String macAddress;
	private String authenticatedUserName;
    private String sessionStartTime;
    
	public String getSessionStartTime() {
		return sessionStartTime;
	}
	public void setSessionStartTime(String sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	public String getWanIP() {
		return wanIP;
	}
	public void setWanIP(String wanIP) {
		this.wanIP = wanIP;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getAuthenticatedUserName() {
		return authenticatedUserName;
	}
	public void setAuthenticatedUserName(String authenticatedUserName) {
		this.authenticatedUserName = authenticatedUserName;
	}
	@Override
	public String toString() {
		return "AuthenticationVO [sourceSystem=" + sourceSystem
				+ ", isAuthenticated=" + isAuthenticated + ", wanIP=" + wanIP
				+ ", macAddress=" + macAddress + ", authenticatedUserName="
				+ authenticatedUserName + "]";
	}
	
	

}
