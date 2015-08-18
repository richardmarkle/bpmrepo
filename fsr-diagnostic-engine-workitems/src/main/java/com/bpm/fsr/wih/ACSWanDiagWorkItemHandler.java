package com.bpm.fsr.wih;

import static org.mockito.Mockito.when;

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
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;

public class ACSWanDiagWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ACSWanDiagWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ACSWanDiagWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = " ACSWanDiagWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        mockData();
        boolean isErrored = mockService.isErrored(processMock);
        boolean isModemProtocolPresent = mockService.isModemProtocolPresent(processMock);
        String modemProtocol = mockService.modemProtocol(processMock);
        if(modemProtocol == null){
        	modemProtocol = "";
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", isErrored);
        outputParams.put("isModemProtocolPresent", isModemProtocolPresent);
        outputParams.put("modemProtocol", modemProtocol);

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData() {
        // Connected/Not Connected/Not Associated
    	when(mockService.isErrored(Matchers.contains("ACSWAN"))).thenReturn(false);
        when(mockService.isModemProtocolPresent(Matchers.contains("ACSWAN"))).thenReturn(true);
        when(mockService.modemProtocol(Matchers.contains("ACSWAN"))).thenReturn("IPoE");
        when(mockService.isModemProtocolPresent(Matchers.contains("PPPoE"))).thenReturn(true);
        when(mockService.modemProtocol(Matchers.contains("PPPoE"))).thenReturn("PPPoE");
    }

}
