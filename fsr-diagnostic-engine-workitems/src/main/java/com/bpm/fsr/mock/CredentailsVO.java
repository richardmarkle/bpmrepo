package com.bpm.fsr.mock;

public class CredentailsVO implements java.io.Serializable {
	boolean isErrored;
	String sourceSystem;
	boolean credentailsPresent;
	String userName;
	String initialPassword;
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public boolean isCredentailsPresent() {
		return credentailsPresent;
	}
	public void setCredentailsPresent(boolean credentailsPresent) {
		this.credentailsPresent = credentailsPresent;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInitialPassword() {
		return initialPassword;
	}
	public void setInitialPassword(String initialPassword) {
		this.initialPassword = initialPassword;
	}

}
