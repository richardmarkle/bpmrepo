package com.bpm.fsr.mock;

public class ModemPushCredentialsVO implements java.io.Serializable {

	boolean isErrored;
	boolean isCredentialPushInitiated;
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
	}
	public boolean isCredentialPushInitiated() {
		return isCredentialPushInitiated;
	}
	public void setCredentialPushInitiated(boolean isCredentialPushInitiated) {
		this.isCredentialPushInitiated = isCredentialPushInitiated;
	}
}
