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

public class ModemLANDevicesConnectedWorkItemHandler implements WorkItemHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(ModemLANDevicesConnectedWorkItemHandler.class);

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ModemLANDevicesConnectedWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		final String methodName = " ModemInformationWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        LOG.info(methodName + "processMock: " + processMock);
        System.out.println("processMock - " + processMock);
        mockData();
        System.out.println("MockData Method executed...");
        int modemNumberOfConnectedDevices = mockService.modemNumberOfConnectedDevices(processMock);
        int modemNumberOfActiveWirelessDevices = mockService.modemNumberOfActiveWirelessDevices(processMock);
        int modemNumberOfActiveDevices = mockService.modemNumberOfActiveDevices(processMock);
        
        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("modemNumberOfConnectedDevices", modemNumberOfConnectedDevices);
        outputParams.put("modemNumberOfActiveWirelessDevices", modemNumberOfActiveWirelessDevices);
        outputParams.put("modemNumberOfActiveDevices",modemNumberOfActiveDevices);
        
        workItemManager.completeWorkItem(workItem.getId(), outputParams);
		
	}

	@Override
	public void abortWorkItem(WorkItem wi, WorkItemManager wim) {
		
	}
	
	private void mockData() {

		when(mockService.modemNumberOfConnectedDevices(Matchers.contains("CONACTD"))).thenReturn(2);
		when(mockService.modemNumberOfActiveWirelessDevices(Matchers.contains("CONACTD"))).thenReturn(3);
		
		when(mockService.modemNumberOfConnectedDevices(Matchers.contains("WIRELESS"))).thenReturn(2);
		when(mockService.modemNumberOfActiveWirelessDevices(Matchers.contains("WIRELESS"))).thenReturn(2);
		when(mockService.modemNumberOfActiveDevices(Matchers.contains("WIRELESS"))).thenReturn(2);
	        
	}
}
