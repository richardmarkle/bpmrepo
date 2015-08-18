/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.wih;

import com.bpm.fsr.mock.ASSIADiagnosticsVO;
import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
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

/**
 *
 * @author ab19041
 */
public class ASSIADiagnosticsWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ASSIADiagnosticsWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("DIAGD");
        mockValues.add("DIAGN");
        mockValues.add("DIAGF");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ASSIADiagnosticsWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = "ASSIADiagnosticsWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
       // processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);

        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        mockASSIADiagnostics(processMock);
        ASSIADiagnosticsVO assiaDiagnosticsVO = mockService.getASSIADiagnostics(processMock);

        if (assiaDiagnosticsVO == null) {
            assiaDiagnosticsVO = MockVOHelper.getASSIADiagnosticsVO(false, "N/A");
        }
        LOG.info(methodName + " assiaDiagnosticsVO: " + assiaDiagnosticsVO.toString());

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("messagesPresent", assiaDiagnosticsVO.isMessagesPresent());
        outputParams.put("messages", assiaDiagnosticsVO.getMessages());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {
    }

    private void mockASSIADiagnostics(String processMock) {
        when(mockService.getASSIADiagnostics(Matchers.contains("DIAGD"))).thenReturn(MockVOHelper.getASSIADiagnosticsVO(true, "DISPATCH"));
        when(mockService.getASSIADiagnostics(Matchers.contains("DIAGN"))).thenReturn(MockVOHelper.getASSIADiagnosticsVO(true, "NOT DISPATCH"));
        when(mockService.getASSIADiagnostics(Matchers.contains("DIAGF"))).thenReturn(MockVOHelper.getASSIADiagnosticsVO(false, "N/A"));
    }
}
