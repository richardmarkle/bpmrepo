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

public class RebootONTWorkItemHandler implements WorkItemHandler{
	
	private static final Logger LOG = LoggerFactory
			.getLogger(RebootONTWorkItemHandler.class);
	
	@Mock
    MockService mockService;
    
    private KieSession kieSession;  
    
    private final static List<String> mockValues = new ArrayList();
    static {
        mockValues.add("REBT");
    }

    public RebootONTWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;        
        MockitoAnnotations.initMocks(this);        
    }
    
    public void executeWorkItem(WorkItem workItem,
			WorkItemManager workItemManager) {
		final String methodName = " RebootONTWorkItemHandler.executeWorkItem() ";
		LOG.info(methodName);
		
		/*WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
		String processMock = (String) processInstance.getVariable("processMock");   
		
		//function call;
		processMock = MockVOHelper.getMockCode(processMock,processInstance);
		System.out.println(methodName + " Code - " + processMock);
		LOG.info(methodName + "processMock: " + processMock);
		
		mockRebootONT(processMock);
				
		String rebootStatus = mockService.rebootOnt(processMock);
		if(rebootStatus == null){
			rebootStatus = "Error";
		}
		
        System.out.println("rebootStatus - " + rebootStatus);*/
        
        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("rebootStatus", "OK");
        
        //System.out.println( "Remaining Mock Data - "+processInstance.getVariable("processMock"));
        
        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }
    
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

	}
    
    /*private void mockRebootONT(String processMock) {
    	when(mockService.rebootOnt(Matchers.contains("REBT"))).thenReturn("OK");
    	//when(mockService.rebootOnt(Matchers.contains("NREBT"))).thenReturn(false);
    }*/

}
