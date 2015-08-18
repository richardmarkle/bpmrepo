package com.bpm.fsr.mock;

public class RadLogVO implements java.io.Serializable {

	boolean isErrored;
	boolean logWasFound;
	String lastEvent;
	String lastEventTimeStamp;
	int stopUserError;
	int stopUserRequest;
	int stopLostCarrier;
	int stopPortError;
	int stopAdminRequest;
	int startOk;
	int aliveOk;
	int stopNasRequest;
	boolean ipAddressFound;
	String lastLoggedIP;
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
	}
	public boolean isLogWasFound() {
		return logWasFound;
	}
	public void setLogWasFound(boolean logWasFound) {
		this.logWasFound = logWasFound;
	}
	public String getLastEvent() {
		return lastEvent;
	}
	public void setLastEvent(String lastEvent) {
		this.lastEvent = lastEvent;
	}
	public String getLastEventTimeStamp() {
		return lastEventTimeStamp;
	}
	public void setLastEventTimeStamp(String lastEventTimeStamp) {
		this.lastEventTimeStamp = lastEventTimeStamp;
	}
	public int getStopUserError() {
		return stopUserError;
	}
	public void setStopUserError(int stopUserError) {
		this.stopUserError = stopUserError;
	}
	public int getStopUserRequest() {
		return stopUserRequest;
	}
	public void setStopUserRequest(int stopUserRequest) {
		this.stopUserRequest = stopUserRequest;
	}
	public int getStopLostCarrier() {
		return stopLostCarrier;
	}
	public void setStopLostCarrier(int stopLostCarrier) {
		this.stopLostCarrier = stopLostCarrier;
	}
	public int getStopPortError() {
		return stopPortError;
	}
	public void setStopPortError(int stopPortError) {
		this.stopPortError = stopPortError;
	}
	public int getStopAdminRequest() {
		return stopAdminRequest;
	}
	public void setStopAdminRequest(int stopAdminRequest) {
		this.stopAdminRequest = stopAdminRequest;
	}
	public int getStartOk() {
		return startOk;
	}
	public void setStartOk(int startOk) {
		this.startOk = startOk;
	}
	public int getAliveOk() {
		return aliveOk;
	}
	public void setAliveOk(int aliveOk) {
		this.aliveOk = aliveOk;
	}
	public int getStopNasRequest() {
		return stopNasRequest;
	}
	public void setStopNasRequest(int stopNasRequest) {
		this.stopNasRequest = stopNasRequest;
	}
	public boolean isIpAddressFound() {
		return ipAddressFound;
	}
	public void setIpAddressFound(boolean ipAddressFound) {
		this.ipAddressFound = ipAddressFound;
	}
	public String getLastLoggedIP() {
		return lastLoggedIP;
	}
	public void setLastLoggedIP(String lastLoggedIP) {
		this.lastLoggedIP = lastLoggedIP;
	}
}
