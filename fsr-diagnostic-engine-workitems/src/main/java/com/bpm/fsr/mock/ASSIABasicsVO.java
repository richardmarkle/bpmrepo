package com.bpm.fsr.mock;

public class ASSIABasicsVO implements java.io.Serializable {
	private boolean isErrored;
	private boolean supported;
	private boolean optimized;
	
	public boolean isErrored() {
		return isErrored;
	}
	public void setErrored(boolean isErrored) {
		this.isErrored = isErrored;
	}
	public boolean isSupported() {
		return supported;
	}
	public void setSupported(boolean supported) {
		this.supported = supported;
	}
	public boolean isOptimized() {
		return optimized;
	}
	public void setOptimized(boolean optimized) {
		this.optimized = optimized;
	}
	public String getOptimizerStartTime() {
		return optimizerStartTime;
	}
	public void setOptimizerStartTime(String optimizerStartTime) {
		this.optimizerStartTime = optimizerStartTime;
	}
	public String getOptimizerEndTime() {
		return optimizerEndTime;
	}
	public void setOptimizerEndTime(String optimizerEndTime) {
		this.optimizerEndTime = optimizerEndTime;
	}

	private boolean monitored;
	private String lineStability;
	private String optimizerStartTime;
	private String optimizerEndTime;
	
	public boolean isMonitored() {
		return monitored;
	}
	public void setMonitored(boolean monitored) {
		this.monitored = monitored;
	}
	public String getLineStability() {
		return lineStability;
	}
	public void setLineStability(String lineStability) {
		this.lineStability = lineStability;
	}
	
	@Override
    public String toString() {
        return "ASSIABasicsVO{" + "monitored=" + monitored + ", lineStability=" + lineStability+"}";
    }

}
