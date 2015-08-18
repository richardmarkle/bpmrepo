package com.bpm.fsr.wih;

import static org.mockito.Mockito.when;

import java.util.HashMap;
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

public class SynacorEmailWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SynacorEmailWorkItemHandler.class);

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public SynacorEmailWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = " SynacorEmailWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        LOG.info(methodName + "processMock: " + processMock);
        System.out.println(" SynacorEmailWorkItemHandler processMock - " + processMock);
        mockData();
        System.out.println(" SynacorEmailWorkItemHandler emailSuspended");
        boolean emailSuspended = mockService.isModemProtocolPresent(processMock);

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("emailSuspended", emailSuspended);

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData() {
    	System.out.println("In MOCKDATA METHOD");
        //when(mockService.emailSuspended(Matchers.contains("SYNA"))).thenReturn(true);
    	when(mockService.isModemProtocolPresent(Matchers.contains("SYNA"))).thenReturn(true);

    }

}
