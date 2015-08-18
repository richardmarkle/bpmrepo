package com.bpm.fsr.mock;

import java.util.List;

public class StaticIPVO extends ErrorVO implements java.io.Serializable {

    private static final long serialVersionUID = -8023093718324609124L;

    private boolean hasStaticIP;
    private int IPQuantity;
    private String startIP;
    private String endIP;
    private List ipAddressList;

    public boolean isHasStaticIP() {
        return hasStaticIP;
    }

    public void setHasStaticIP(boolean hasStaticIP) {
        this.hasStaticIP = hasStaticIP;
    }

    public int getIPQuantity() {
        return IPQuantity;
    }

    public void setIPQuantity(int iPQuantity) {
        IPQuantity = iPQuantity;
    }

    public String getStartIP() {
        return startIP;
    }

    public void setStartIP(String startIP) {
        this.startIP = startIP;
    }

    public String getEndIP() {
        return endIP;
    }

    public void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    public List getIpAddressList() {
        return ipAddressList;
    }

    public void setIpAddressList(List ipAddressList) {
        this.ipAddressList = ipAddressList;
    }

    @Override
    public String toString() {
        return "StaticIPVO [hasStaticIP=" + hasStaticIP + ", IPQuantity="
                + IPQuantity + ", startIP=" + startIP + ", endIP=" + endIP
                + ", ipAddressList=" + ipAddressList + "]";
    }

}
