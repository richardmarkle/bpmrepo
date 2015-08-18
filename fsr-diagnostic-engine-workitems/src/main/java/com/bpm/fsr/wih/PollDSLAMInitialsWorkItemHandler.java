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
import com.bpm.fsr.mock.PollDSLAMInitialsVO;

public class PollDSLAMInitialsWorkItemHandler implements WorkItemHandler {

	
	private static final Logger LOG = LoggerFactory.getLogger(PollDSLAMInitialsWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public PollDSLAMInitialsWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = "PollDSLAMInitialsWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);
        
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        mockData(processMock);

        PollDSLAMInitialsVO pollDSLAMInitialsVO = mockService.getPollDSLAMInitialsVO(processMock);
        if (pollDSLAMInitialsVO == null) {
        	pollDSLAMInitialsVO = MockVOHelper.getPollDSLAMInitialsVO(false, false, 0, null, false);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", pollDSLAMInitialsVO.isErrored());
        outputParams.put("isPollDSLAMSupported", pollDSLAMInitialsVO.isPollDSLAMSupported());
        outputParams.put("customerExpScore", pollDSLAMInitialsVO.getCustomerExpScore());
        outputParams.put("deviceTID", pollDSLAMInitialsVO.getDeviceTID());
        outputParams.put("isNetworkCongested", pollDSLAMInitialsVO.isNetworkCongested());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData(String product) {
    	
        when(mockService.getPollDSLAMInitialsVO(Matchers.contains("POLLCONG"))).thenReturn(MockVOHelper.getPollDSLAMInitialsVO(true, true,1, "1", true));
        
    }

}
