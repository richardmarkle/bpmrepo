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

import com.bpm.fsr.mock.IclVO;
import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;


public class ICLWorkItemHandler implements WorkItemHandler {
	private static final Logger LOG = LoggerFactory
			.getLogger(ICLWorkItemHandler.class);
	
	@Mock
    MockService mockService;
    
    private KieSession kieSession;    

    public ICLWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;        
        MockitoAnnotations.initMocks(this);        
    }
    
    public void executeWorkItem(WorkItem workItem,
			WorkItemManager workItemManager) {
		final String methodName = " ICLWorkItemHandler.executeWorkItem() ";
		LOG.info(methodName);
		
		WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
		String processMock = (String) processInstance.getVariable("processMock");   
		//function call;
		processMock = MockVOHelper.getMockCode(processMock,processInstance);
		System.out.println(methodName+" Code - "+processMock);
		System.out.println( "Remaining Mock Data - "+processInstance.getVariable("processMock"));

		LOG.info(methodName + "processMock: " + processMock);
		mockIcl(processMock);

		IclVO iclVO = mockService.getIclVO(processMock);
		if (iclVO == null) {
			iclVO = MockVOHelper.getIclVO("",false ,false,"","","","","","");
		}

		Map<String, Object> outputParams = new HashMap<String, Object>();
		outputParams.put("sourceSystem",iclVO.getSourceSystem());
		outputParams.put("translated",iclVO.isTranslated());
		outputParams.put("isVPIVCIPresent",iclVO.isVPIVCIPresent());
		outputParams.put("subscriberVPI", iclVO.getSubscriberVPI());
		outputParams.put("subscriberVCI", iclVO.getSubscriberVCI());
		outputParams.put("subscriberVLAN", iclVO.getSubscriberVLAN());
		outputParams.put("networkVPI", iclVO.getNetworkVPI());
		outputParams.put("networkVCI", iclVO.getNetworkVCI());
		outputParams.put("networkVLAN", iclVO.getNetworkVLAN());

		workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }
    
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

	}
    
    private void mockIcl(String processMock) {
    	
		when(mockService.getIclVO(Matchers.contains("TRAN"))).thenReturn(MockVOHelper.getIclVO("", true, false,"","","","","",""));
		when(mockService.getIclVO(Matchers.contains("MART"))).thenReturn(MockVOHelper.getIclVO("", false, true,"","","","","",""));
		when(mockService.getIclVO(Matchers.contains("ICLVPI"))).thenReturn(MockVOHelper.getIclVO("", false, true,"0","32","","","",""));
		when(mockService.getIclVO(Matchers.contains("ICLEVPI"))).thenReturn(MockVOHelper.getIclVO("", false, true,"8","35","","","",""));
	}

}
