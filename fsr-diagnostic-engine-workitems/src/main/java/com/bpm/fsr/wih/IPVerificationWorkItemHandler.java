/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ab19041
 */
public class IPVerificationWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(IPVerificationWorkItemHandler.class);
    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public IPVerificationWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = " IPVerificationWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        String startIP = (String) workItem.getParameter("startIP");
        String endIP = (String) workItem.getParameter("endIP");
        String ipTocompare = (String) workItem.getParameter("ipTocompare");

        LOG.info(methodName + " startIP: " + startIP + " endIP " + endIP + " ipTocompare " + ipTocompare);
        System.out.println(methodName + " startIP: " + startIP + " endIP " + endIP + " ipTocompare " + ipTocompare);

        boolean ipInRange = isIPInRange(startIP, endIP, ipTocompare);
        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("ipInRange", ipInRange);

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {
    }

    public static boolean isIPInRange(String startIP, String endIP, String ipInRange) {
        try {
            if (startIP != null && endIP != null && ipInRange != null) {
                long ipLo = ipToLong(InetAddress.getByName(startIP));
                long ipHi = ipToLong(InetAddress.getByName(endIP));
                long ipToTest = ipToLong(InetAddress.getByName(ipInRange));

                return ipToTest >= ipLo && ipToTest <= ipHi;

            }

        } catch (UnknownHostException unknownHostException) {
            LOG.error("Error while validating IP's" + unknownHostException);

        }
        return false;

    }

    private static long ipToLong(InetAddress ip) {
        byte[] octets = ip.getAddress();
        long result = 0;
        for (byte octet : octets) {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }
}
