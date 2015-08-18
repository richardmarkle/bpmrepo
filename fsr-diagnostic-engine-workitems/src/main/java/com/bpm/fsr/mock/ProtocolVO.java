package com.bpm.fsr.mock;

public class ProtocolVO extends ErrorVO {

    private String protocol;
    private boolean bbcosPresent;

    public boolean isBbcosPresent() {
        return bbcosPresent;
    }

    public void setBbcosPresent(boolean bbcosPresent) {
        this.bbcosPresent = bbcosPresent;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
