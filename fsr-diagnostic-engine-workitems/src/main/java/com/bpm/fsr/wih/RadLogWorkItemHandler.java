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
import com.bpm.fsr.mock.RadLogVO;
import com.bpm.fsr.mock.SpeedsVO;

public class RadLogWorkItemHandler implements WorkItemHandler {
	 private static final Logger LOG = LoggerFactory
	            .getLogger(RadLogWorkItemHandler.class);
	    private final static List<String> mockValues = new ArrayList();

	    static {
	        mockValues.add("RAD");
	        
	    }

	    @Mock
	    MockService mockService;

	    private final KieSession kieSession;

	    public RadLogWorkItemHandler(KieSession kieSession) {
	        this.kieSession = kieSession;
	        MockitoAnnotations.initMocks(this);
	    }

	    @Override
	    public void executeWorkItem(WorkItem workItem,
	            WorkItemManager workItemManager) {

	        final String methodName = " RadLogWorkItemHandler.executeWorkItem() ";
	        LOG.info(methodName);

	        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
	                .getProcessInstance((workItem.getProcessInstanceId()));
	        String processMock = (String) processInstance.getVariable("processMock");
	        LOG.info(methodName + " process mock before mock code: " + processMock);
	        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
	        processMock = MockVOHelper.getMockCode(processMock, processInstance);
	        LOG.info(methodName + " process mock after mock code: " + processMock);
	        mockSpeed();

	        RadLogVO radLogVO = mockService.getRadLogVO(processMock);
	        if (radLogVO == null) {
	        	radLogVO = MockVOHelper.getRadLogVO(false,false,"", "", 1, 1, 1, 1,1,1,0,1,false, "1.1.1.1");
	        }

	        Map<String, Object> outputParams = new HashMap<String, Object>();
	        outputParams.put("isErrored", radLogVO.isErrored());
	        outputParams.put("logWasFound", radLogVO.isLogWasFound());
	        outputParams.put("lastEvent", radLogVO.getLastEvent());
	        outputParams.put("lastEventTimeStamp", radLogVO.getLastEventTimeStamp());
	        outputParams.put("stopUserError", radLogVO.getStopUserError());
	        outputParams.put("stopUserRequest", radLogVO.getStopUserRequest());

	        outputParams.put("stopLostCarrier", radLogVO.getStopLostCarrier());
	        outputParams.put("stopPortError", radLogVO.getStopPortError());
	        outputParams.put("stopAdminRequest", radLogVO.getStopAdminRequest());
	        
	        outputParams.put("startOk", radLogVO.getStartOk());
	        outputParams.put("aliveOk", radLogVO.getAliveOk());
	        outputParams.put("stopNasRequest", radLogVO.getStopNasRequest());
	        outputParams.put("ipAddressFound", radLogVO.isIpAddressFound());
	        outputParams.put("lastLoggedIP", radLogVO.getLastLoggedIP());

	        workItemManager.completeWorkItem(workItem.getId(), outputParams);
	    }

	    @Override
	    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

	    }

	    private void mockSpeed() {

		/*
		 * when(mockService.getRadLogVO(Matchers.contains("RAD"))).thenReturn(
		 * MockVOHelper.getRadLogVO(isErrored, logWasFound, lastEvent,
		 * lastEventTimeStamp, stopUserError, stopUserRequest, stopLostCarrier,
		 * stopPortError, stopAdminRequest, startOk, aliveOk, stopNasRequest,
		 * ipAddressFound, lastLoggedIP)
		 */
	    	
	        when(mockService.getRadLogVO(Matchers.contains("RAD"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"", "", 1, 1, 1, 1,1,1,1,1,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("QRAD"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"Start-OK", "", 0, 0, 0,0,4,5,1,0,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("QRADSNR"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"Stop/Nas-Request", "", 0, 0, 0,0,4,5,1,0,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("RADGrt3"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"", "", 1, 1, 1, 1,1,4,1,1,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("QRADSAR"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"Stop/Admin-Request", "", 1, 1, 1, 1,1,4,1,1,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("QRADSUR"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"Stop/User-Request", "", 1, 1, 1, 1,1,4,1,1,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("QRADSUE"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"Stop/User-Error", "", 1, 1, 1, 1,1,4,1,1,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("QRADSLC"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"Stop/Lost-Carrier", "", 1, 1, 1, 1,1,4,1,1,true, "10.1.2.5"));
	        
	        when(mockService.getRadLogVO(Matchers.contains("QRADSPE"))).thenReturn(
	                MockVOHelper.getRadLogVO(false, true,"Stop/Port-Error", "", 1, 1, 1, 1,1,4,1,1,true, "10.1.2.5"));
	       

	    }

}
