package com.bpm.fsr.mock;

public class ServiceOrderVO implements java.io.Serializable{

	private boolean serviceOrderPresent;
	private String serviceOrderStatus;
	private boolean isPastDueOrder;
	private boolean isFutureOrder;
	private boolean isDueTodayOrder;
	private int currentHourInCustomerTZ;
	private String wfadoStatus;
	public String getWfadoStatus() {
		return wfadoStatus;
	}
	public void setWfadoStatus(String wfadoStatus) {
		this.wfadoStatus = wfadoStatus;
	}
	public boolean isServiceOrderPresent() {
		return serviceOrderPresent;
	}
	public void setServiceOrderPresent(boolean serviceOrderPresent) {
		this.serviceOrderPresent = serviceOrderPresent;
	}
	public String getServiceOrderStatus() {
		return serviceOrderStatus;
	}
	public void setServiceOrderStatus(String serviceOrderStatus) {
		this.serviceOrderStatus = serviceOrderStatus;
	}
	public boolean isPastDueOrder() {
		return isPastDueOrder;
	}
	public void setPastDueOrder(boolean isPastDueOrder) {
		this.isPastDueOrder = isPastDueOrder;
	}
	public boolean isFutureOrder() {
		return isFutureOrder;
	}
	public void setFutureOrder(boolean isFutureOrder) {
		this.isFutureOrder = isFutureOrder;
	}
	public boolean isDueTodayOrder() {
		return isDueTodayOrder;
	}
	public void setDueTodayOrder(boolean isDueTodayOrder) {
		this.isDueTodayOrder = isDueTodayOrder;
	}
	public int getCurrentHourInCustomerTZ() {
		return currentHourInCustomerTZ;
	}
	public void setCurrentHourInCustomerTZ(int currentHourInCustomerTZ) {
		this.currentHourInCustomerTZ = currentHourInCustomerTZ;
	}
	
	@Override
	public String toString() {
		return "ServiceOrderVO [serviceOrderPresent=" + serviceOrderPresent + ", serviceOrderStatus="
				+ serviceOrderStatus + ", isPastDueOrder=" + isPastDueOrder + ", isFutureOrder=" + isFutureOrder
				+ ", isDueTodayOrder=" + isDueTodayOrder + ", currentHourInCustomerTZ=" + currentHourInCustomerTZ + "]";
	}
}
