/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.OntVO;
import java.util.HashMap;
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

/**
 *
 * @author ab19041
 */
public class ONTEthernetPortInfoWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(ONTWorkItemHandler.class);

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ONTEthernetPortInfoWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = " ONTWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        //function call;
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        System.out.println(methodName + " Code - " + processMock);
        System.out.println("Remaining Mock Data - " + processInstance.getVariable("processMock"));

        LOG.info(methodName + "processMock: " + processMock);
        mockData(processMock);

        OntVO ontVO = mockService.getOntVO(processMock);
        if (ontVO == null) {
            ontVO = MockVOHelper.getOntVO("Missing", "Unknown", "", "");
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("ethernetPortAdminStatus", ontVO.getEthernetPortAdminStatus());
        outputParams.put("ethernetPortOpStatus", ontVO.getEthernetPortOpStatus());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData(String processMock) {

        //check ONT Ethernet
        when(mockService.getOntVO(Matchers.contains("ETHINS"))).thenReturn(MockVOHelper.getOntVO("", "", "In Service", "Up"));
        //when(mockService.getOntVO(Matchers.contains("ETHOUTS"))).thenReturn(MockVOHelper.getOntVO("", "", "Out of Service UAS", "N/A"));
        when(mockService.getOntVO(Matchers.contains("ETHAOS"))).thenReturn(MockVOHelper.getOntVO("", "", "Missing", "Unknown"));

    }
}
