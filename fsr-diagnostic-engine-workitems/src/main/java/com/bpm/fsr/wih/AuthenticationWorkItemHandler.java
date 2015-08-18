package com.bpm.fsr.wih;

import com.bpm.fsr.mock.AuthenticationVO;
import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;

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

import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("AUTH");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public AuthenticationWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        final String methodName = "AuthenticationWorkItemHandler.executeWorkItem() ";
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
        mockAuthenticationData(processMock);

        AuthenticationVO authenticationVO = mockService.getAuthenticationVO(processMock);
        if (authenticationVO == null) {
        	authenticationVO = MockVOHelper.getAuthenticationVO("ROS", false, "10.1.2.3", "10.1.2.5", "",getBackDate(23));
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("sourceSystem", authenticationVO.getSourceSystem());
        outputParams.put("isAuthenticated", authenticationVO.isAuthenticated());
        outputParams.put("wanIP", authenticationVO.getWanIP());
        outputParams.put("macAddress", authenticationVO.getMacAddress());
        outputParams.put("authenticatedUserName", authenticationVO.getAuthenticatedUserName());
        outputParams.put("sessionStartTime", authenticationVO.getSessionStartTime());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);

    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockAuthenticationData(String processMock) {
        when(mockService.getAuthenticationVO(Matchers.contains("AUTH"))).thenReturn(MockVOHelper.getAuthenticationVO("ROS", true, "10.1.2.3", "10.1.2.5", "username",""));
        when(mockService.getAuthenticationVO(Matchers.contains("AUTHCDTG"))).thenReturn(MockVOHelper.getAuthenticationVO("ROS", true, "10.1.2.3", "10.1.2.5", "username",getBackDate(23)));
        when(mockService.getAuthenticationVO(Matchers.contains("AUTHCDTB"))).thenReturn(MockVOHelper.getAuthenticationVO("ROS", true, "10.1.2.3", "10.1.2.5", "username",getBackDate(25)));
    }
    
    public String getBackDate(int backTime){
    	
    	java.util.Date currentDate = new java.util.Date();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(java.util.Calendar.HOUR, -backTime);
        java.util.Date backDate = cal.getTime();
        System.out.println("24HrBackDate = "+backDate);
        
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        java.lang.String inDateStr = dateFormat.format(backDate);

        return inDateStr;
    }

}
