package com.bpm.fsr.mock;

public class CustomerExperienceVO implements java.io.Serializable {
	
	boolean isErrored;
    int actualLineError;
    boolean congestionIncidentReported;
    int cesPortTrainUp;
    int cesPortTrainDown;
    
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
	}
	public int getActualLineError() {
		return actualLineError;
	}
	public void setActualLineError(int actualLineError) {
		this.actualLineError = actualLineError;
	}
	public boolean isCongestionIncidentReported() {
		return congestionIncidentReported;
	}
	public void setCongestionIncidentReported(boolean congestionIncidentReported) {
		this.congestionIncidentReported = congestionIncidentReported;
	}
	public int getCesPortTrainUp() {
		return cesPortTrainUp;
	}
	public void setCesPortTrainUp(int cesPortTrainUp) {
		this.cesPortTrainUp = cesPortTrainUp;
	}
	public int getCesPortTrainDown() {
		return cesPortTrainDown;
	}
	public void setCesPortTrainDown(int cesPortTrainDown) {
		this.cesPortTrainDown = cesPortTrainDown;
	}
    
    

}
