package com.bpm.fsr.mock;

public class ProductsFeaturesVO extends ErrorVO implements java.io.Serializable {

    private boolean hasPRISMonAccount;
    private boolean hasGPON;
    private boolean isMadisonRiverCustomer;
    private boolean hasAtEaseFeature;
    private String atEaseLevel;
    private boolean hasTechInstallUSOC;
    private String marketUnit;
    private String accessTech;

    public boolean isHasTechInstallUSOC() {
        return hasTechInstallUSOC;
    }

    public void setHasTechInstallUSOC(boolean hasTechInstallUSOC) {
        this.hasTechInstallUSOC = hasTechInstallUSOC;
    }

    public String getMarketUnit() {
        return marketUnit;
    }

    public void setMarketUnit(String marketUnit) {
        this.marketUnit = marketUnit;
    }

    public String getAccessTech() {
        return accessTech;
    }

    public void setAccessTech(String accessTech) {
        this.accessTech = accessTech;
    }

    public boolean isHasPRISMonAccount() {
        return hasPRISMonAccount;
    }

    public void setHasPRISMonAccount(boolean hasPRISMonAccount) {
        this.hasPRISMonAccount = hasPRISMonAccount;
    }

    public boolean isHasGPON() {
        return hasGPON;
    }

    public void setHasGPON(boolean hasGPON) {
        this.hasGPON = hasGPON;
    }

    public boolean isMadisonRiverCustomer() {
        return isMadisonRiverCustomer;
    }

    public void setMadisonRiverCustomer(boolean isMadisonRiverCustomer) {
        this.isMadisonRiverCustomer = isMadisonRiverCustomer;
    }

    public boolean isHasAtEaseFeature() {
        return hasAtEaseFeature;
    }

    public void setHasAtEaseFeature(boolean hasAtEaseFeature) {
        this.hasAtEaseFeature = hasAtEaseFeature;
    }

    public String getAtEaseLevel() {
        return atEaseLevel;
    }

    public void setAtEaseLevel(String atEaseLevel) {
        this.atEaseLevel = atEaseLevel;
    }
}
