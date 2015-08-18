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

import com.bpm.fsr.mock.CustomerExperienceVO;
import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;

public class CustomerExperienceWorkItemHandler implements WorkItemHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(KnownOutageWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public CustomerExperienceWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = "CustomerExperienceWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);
        
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        mockData(processMock);

        CustomerExperienceVO customerExperienceVO = mockService.getCustomerExperienceVO(processMock);
        if (customerExperienceVO == null) {
        	customerExperienceVO = MockVOHelper.getCustomerExperienceVO(false, 0, false, 0, 0);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", customerExperienceVO.isErrored());
        outputParams.put("actualLineError", customerExperienceVO.getActualLineError());
        outputParams.put("congestionIncidentReported", customerExperienceVO.isCongestionIncidentReported());
        outputParams.put("cesPortTrainUp", customerExperienceVO.getCesPortTrainUp());
        outputParams.put("cesPortTrainDown", customerExperienceVO.getCesPortTrainDown());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData(String product) {
    	
        when(mockService.getCustomerExperienceVO(Matchers.contains("CONG"))).thenReturn(MockVOHelper.getCustomerExperienceVO(false, 1, true, 1, 1));
        
    }

}
