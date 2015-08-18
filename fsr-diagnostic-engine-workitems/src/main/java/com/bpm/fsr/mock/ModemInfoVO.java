package com.bpm.fsr.mock;

public class ModemInfoVO extends ErrorVO implements java.io.Serializable {

    private String modemSerialNumber;
    private boolean modemWanIpPresent;
    private String modemWanIP;
    private String modemFirmwareLatest;
    private boolean modemConnectedDevicesPresent;
    private boolean modemActiveConnectedDevicePresent;
    private boolean modemEthernetConnectedDevicePresent;
    private String modemMake;
    private String modemModel;
    private String modemFirmware;
    private String modemAuthenticatedPPPusername;

    public String getModemSerialNumber() {
        return modemSerialNumber;
    }

    public void setModemSerialNumber(String modemSerialNumber) {
        this.modemSerialNumber = modemSerialNumber;
    }

    public boolean isModemWanIpPresent() {
        return modemWanIpPresent;
    }

    public void setModemWanIpPresent(boolean modemWanIpPresent) {
        this.modemWanIpPresent = modemWanIpPresent;
    }

    public String getModemWanIP() {
        return modemWanIP;
    }

    public void setModemWanIP(String modemWanIP) {
        this.modemWanIP = modemWanIP;
    }

    public String getModemFirmwareLatest() {
        return modemFirmwareLatest;
    }

    public void setModemFirmwareLatest(String modemFirmwareLatest) {
        this.modemFirmwareLatest = modemFirmwareLatest;
    }

    public boolean isModemConnectedDevicesPresent() {
        return modemConnectedDevicesPresent;
    }

    public void setModemConnectedDevicesPresent(boolean modemConnectedDevicesPresent) {
        this.modemConnectedDevicesPresent = modemConnectedDevicesPresent;
    }

    public boolean isModemActiveConnectedDevicePresent() {
        return modemActiveConnectedDevicePresent;
    }

    public void setModemActiveConnectedDevicePresent(
            boolean modemActiveConnectedDevicePresent) {
        this.modemActiveConnectedDevicePresent = modemActiveConnectedDevicePresent;
    }

    public boolean isModemEthernetConnectedDevicePresent() {
        return modemEthernetConnectedDevicePresent;
    }

    public void setModemEthernetConnectedDevicePresent(
            boolean modemEthernetConnectedDevicePresent) {
        this.modemEthernetConnectedDevicePresent = modemEthernetConnectedDevicePresent;
    }

    public String getModemMake() {
        return modemMake;
    }

    public void setModemMake(String modemMake) {
        this.modemMake = modemMake;
    }

    public String getModemModel() {
        return modemModel;
    }

    public void setModemModel(String modemModel) {
        this.modemModel = modemModel;
    }

    public String getModemFirmware() {
        return modemFirmware;
    }

    public void setModemFirmware(String modemFirmware) {
        this.modemFirmware = modemFirmware;
    }

    public String getModemAuthenticatedPPPusername() {
        return modemAuthenticatedPPPusername;
    }

    public void setModemAuthenticatedPPPusername(
            String modemAuthenticatedPPPusername) {
        this.modemAuthenticatedPPPusername = modemAuthenticatedPPPusername;
    }

}
