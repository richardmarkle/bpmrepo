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

public class ModemFirmwareUpdateNowWorkItemHandler implements WorkItemHandler {
	private static final Logger LOG = LoggerFactory.getLogger(ModemFirmUpdateWorkItemHandler.class);

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ModemFirmwareUpdateNowWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
    	 final String methodName = " ModemFirmwareUpdateNowWorkItemHandler.executeWorkItem() ";
         LOG.info(methodName);
         WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                 .getProcessInstance((workItem.getProcessInstanceId()));
         String processMock = (String) processInstance.getVariable("processMock");
         LOG.info(methodName + " process mock before mock code: " + processMock);
         processMock = MockVOHelper.getMockCode(processMock, processInstance);
         LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

         mockData();
         boolean isErrored = mockService.isErrored(processMock);
         System.out.println(" isErrored - "+ isErrored);
         boolean isFirmwareUpdateNowInitiated = mockService.isFirmwareUpdateNowInitiated(processMock);
         System.out.println(" isFirmwareUpdateInitiated - "+ isFirmwareUpdateNowInitiated);
         
         Map<String, Object> outputParams = new HashMap<String, Object>();
         outputParams.put("isErrored", isErrored);
         outputParams.put("isFirmwareUpdateNowInitiated", isFirmwareUpdateNowInitiated);

         workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }
    
	
	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void mockData() {
        when(mockService.isErrored(Matchers.contains("MFRU"))).thenReturn(false);
        when(mockService.isFirmwareUpdateNowInitiated(Matchers.contains("MFRU"))).thenReturn(true);
        
        when(mockService.isErrored(Matchers.contains("ERR"))).thenReturn(true);
    }

}
