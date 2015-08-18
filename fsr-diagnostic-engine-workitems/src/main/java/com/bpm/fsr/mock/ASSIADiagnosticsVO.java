/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.mock;

import java.util.List;

/**
 *
 * @author ab19041
 */
public class ASSIADiagnosticsVO implements java.io.Serializable {

    private static final long serialVersionUID = -5690208200655836884L;

    private boolean messagesPresent;
    private List messages;

    public List getMessages() {
        return messages;
    }

    public void setMessages(List messages) {
        this.messages = messages;
    }

    public boolean isMessagesPresent() {
        return messagesPresent;
    }

    public void setMessagesPresent(boolean messagesPresent) {
        this.messagesPresent = messagesPresent;
    }

    @Override
    public String toString() {
        return "ASSIADiagnosticsVO{" + "messagesPresent=" + messagesPresent + ", messages=" + messages + '}';
    }

}
