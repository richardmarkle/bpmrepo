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
import com.bpm.fsr.mock.ModemPushCredentialsVO;

public class ModemPushCredentialsWorkItemHandler implements WorkItemHandler  {
	private static final Logger LOG = LoggerFactory.getLogger(ModemPushCredentialsWorkItemHandler.class);
	 private final static List<String> mockValues = new ArrayList();

	    static {
	        mockValues.add("PUSH");
	    }

	    @Mock
	    MockService mockService;

	    private final KieSession kieSession;

	    public ModemPushCredentialsWorkItemHandler(KieSession kieSession) {
	        this.kieSession = kieSession;
	        MockitoAnnotations.initMocks(this);
	    }

	    @Override
	    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

	        final String methodName = "ModemPushCredentialsWorkItemHandler.executeWorkItem() ";
	        LOG.info(methodName);
	        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
	                .getProcessInstance((workItem.getProcessInstanceId()));
	        String processMock = (String) processInstance.getVariable("processMock");

	        //function call;
	        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
	        processMock = MockVOHelper.getMockCode(processMock, processInstance);
	        System.out.println(methodName + " Code - " + processMock);
	        System.out.println("Remaining Mock Data - " + processInstance.getVariable("processMock"));
	        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

	        LOG.info(methodName + "processMock: " + processMock);
	        System.out.println(methodName + " --processMock - " + processMock);
	        mockPushCredentials(processMock);

	        ModemPushCredentialsVO modemPushCredentialsVO = mockService.getModemPushCredentialsVO(processMock);
	        if (modemPushCredentialsVO == null) {
	        	modemPushCredentialsVO = MockVOHelper.getModemPushCredentialsVO(false,false);
	        }

	        Map<String, Object> outputParams = new HashMap<String, Object>();
	        outputParams.put("isErrored", modemPushCredentialsVO.isErrored());
	        outputParams.put("isCredentialPushInitiated", modemPushCredentialsVO.isCredentialPushInitiated());
	       

	        workItemManager.completeWorkItem(workItem.getId(), outputParams);

	    }

	    @Override
	    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

	    }

	    private void mockPushCredentials(String processMock) {
	        when(mockService.getModemPushCredentialsVO(Matchers.contains("PUSH"))).thenReturn(MockVOHelper.getModemPushCredentialsVO(true,true));
	    }

}
