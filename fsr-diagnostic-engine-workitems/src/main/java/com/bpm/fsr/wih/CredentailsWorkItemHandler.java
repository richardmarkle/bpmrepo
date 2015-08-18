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

import com.bpm.fsr.mock.CredentailsVO;
import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;

public class CredentailsWorkItemHandler implements WorkItemHandler {
	private static final Logger LOG = LoggerFactory
            .getLogger(CredentailsWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("CREDENTAILS");
       
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public CredentailsWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {

        final String methodName = " CredentailsWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        mockCredentials();

        CredentailsVO credentailsVO = mockService.getCredentailsVO(processMock);
        if (credentailsVO == null) {
        	credentailsVO = MockVOHelper.getCredentailsVO(false,"",false, "TEST","TEST");
        }

        
        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", credentailsVO.isErrored());
        outputParams.put("sourceSystem", credentailsVO.getSourceSystem());
        outputParams.put("credentailsPresent", credentailsVO.isCredentailsPresent());
        outputParams.put("userName", credentailsVO.getUserName());
        outputParams.put("initialPassword",credentailsVO.getInitialPassword());
        

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockCredentials() {

        when(mockService.getCredentailsVO(Matchers.contains("CREDENTAILS"))).thenReturn(
                MockVOHelper.getCredentailsVO(false,"",true, "username","CTLPWD" ));
       
    }


}
