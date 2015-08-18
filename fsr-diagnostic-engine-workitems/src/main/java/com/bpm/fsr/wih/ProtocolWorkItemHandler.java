package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.ProtocolVO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.process.WorkflowProcessInstance;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ProtocolWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("PROTOCOL");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ProtocolWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        final String methodName = "ProtocolWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        String legacyMarket = (String) processInstance.getVariable("legacyMarket");

        //function call;
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        System.out.println(methodName + " Code - " + processMock);
        System.out.println("Remaining Mock Data - " + processInstance.getVariable("processMock"));
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        LOG.info(methodName + "processMock: " + processMock);
        System.out.println(methodName + " --processMock - " + processMock);
        mockProtocol(processMock, legacyMarket);

        ProtocolVO protocolVO = mockService.getProtocolVO(processMock);
        if (protocolVO == null) {
            protocolVO = MockVOHelper.getProtocolVO(false, "test", false);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", protocolVO.isErrored());
        outputParams.put("protocol", protocolVO.getProtocol());
        outputParams.put("bbcosPresent", protocolVO.isBbcosPresent());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);

    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockProtocol(String processMock, String legacyMarket) {
        when(mockService.getProtocolVO(Matchers.contains("PROTOCOL"))).thenReturn(MockVOHelper.getProtocolVO(false, "StickySIP", false));

        when(mockService.getProtocolVO(Matchers.contains("PRTSIP"))).thenReturn(MockVOHelper.getProtocolVO(false, "StickySIP", true));
        when(mockService.getProtocolVO(Matchers.contains("DHCP"))).thenReturn(MockVOHelper.getProtocolVO(false, "DHCP", true));
        when(mockService.getProtocolVO(Matchers.contains("IPOE"))).thenReturn(MockVOHelper.getProtocolVO(false, "IPoE", true));

        ProtocolVO protocolVOPRTSIP = null;
        if ("CRIS".equalsIgnoreCase(legacyMarket)) {
            protocolVOPRTSIP = MockVOHelper.getProtocolVO(false, "IPoE", false);
        } else {
            protocolVOPRTSIP = MockVOHelper.getProtocolVO(false, "DHCP", true);
        }

        when(mockService.getProtocolVO(Matchers.contains("PRIPOE"))).thenReturn(protocolVOPRTSIP);

        ProtocolVO protocolVOPRPPPOE = null;
        if ("CRIS".equalsIgnoreCase(legacyMarket)) {
            protocolVOPRPPPOE = MockVOHelper.getProtocolVO(false, "PPPoE", false);
        } else {
            protocolVOPRPPPOE = MockVOHelper.getProtocolVO(false, "PPPoE", true);
        }

        when(mockService.getProtocolVO(Matchers.contains("PRPPPOE"))).thenReturn(protocolVOPRPPPOE);

        when(mockService.getProtocolVO(Matchers.contains("ERROR"))).thenReturn(MockVOHelper.getProtocolVO(true, null, false));
    }

}
