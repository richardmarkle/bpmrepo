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

import com.bpm.fsr.mock.LoopQualUpsellVO;
import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;

public class LoopQualUpsellWorkItemHandler implements WorkItemHandler {
	
    private static final Logger LOG = LoggerFactory
            .getLogger(LoopQualUpsellWorkItemHandler.class);
    
    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public LoopQualUpsellWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {

        final String methodName = " LoopQualUpsellWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        mockSpeed();

        LoopQualUpsellVO loopQualUpsellVO = mockService.getLoopQualUpsellVO(processMock);
        if (loopQualUpsellVO == null) {
        	loopQualUpsellVO = MockVOHelper.getLoopQualUpsellVO(false, 0, 0);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", loopQualUpsellVO.isErrored());
        outputParams.put("maximumSpeedUp", loopQualUpsellVO.getMaximumSpeedUp());
        outputParams.put("maximumSpeedDown", loopQualUpsellVO.getMaximumSpeedDown());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockSpeed() {

        when(mockService.getLoopQualUpsellVO(Matchers.contains("LOOPQ"))).thenReturn(
                MockVOHelper.getLoopQualUpsellVO(false, 900000, 1700000));

    }

}
