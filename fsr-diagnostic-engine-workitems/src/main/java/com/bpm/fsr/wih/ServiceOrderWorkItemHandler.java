package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.ServiceOrderVO;
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

public class ServiceOrderWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(StaticIPWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("PEND");
        mockValues.add("AFT5");
        mockValues.add("NOOR");
        mockValues.add("FUOR");
        mockValues.add("TOOR");
        mockValues.add("PAOR");
        mockValues.add("OSB5");
        mockValues.add("OSA5");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ServiceOrderWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {

        final String methodName = " ServiceOrderWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        System.out.println(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        mockServiceOrder();
        System.out.println(methodName + " process mock after mock code: " + processMock);

        ServiceOrderVO ServiceOrderVO = mockService.getServiceOrderVO(processMock);
        if (ServiceOrderVO == null) {
        	ServiceOrderVO = MockVOHelper.getServiceOrderVO(false,"test","test",false, false,false,4);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("serviceOrderPresent", ServiceOrderVO.isServiceOrderPresent());
        outputParams.put("serviceOrderStatus", ServiceOrderVO.getServiceOrderStatus());
        outputParams.put("wfadoStatus",ServiceOrderVO.getWfadoStatus());
        outputParams.put("isPastDueOrder", ServiceOrderVO.isPastDueOrder());
        outputParams.put("isFutureOrder", ServiceOrderVO.isFutureOrder());
        outputParams.put("isDueTodayOrder", ServiceOrderVO.isDueTodayOrder());
        outputParams.put("currentHourInCustomerTZ", ServiceOrderVO.getCurrentHourInCustomerTZ());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockServiceOrder() {

    	when(mockService.getServiceOrderVO(Matchers.contains("PEND"))).thenReturn(
				MockVOHelper.getServiceOrderVO(true, "pending", "PLD", true, true, true,4));
    	when(mockService.getServiceOrderVO(Matchers.contains("AFT5"))).thenReturn(
				MockVOHelper.getServiceOrderVO(true, "pending","", true, true, true,6));
    	when(mockService.getServiceOrderVO(Matchers.contains("NOOR"))).thenReturn(
				MockVOHelper.getServiceOrderVO(false, null, null, true, true, true,0));
    	when(mockService.getServiceOrderVO(Matchers.contains("FUOR"))).thenReturn(
				MockVOHelper.getServiceOrderVO(true,"pending", null, false, true, false,0));
    	when(mockService.getServiceOrderVO(Matchers.contains("TOOR"))).thenReturn(
				MockVOHelper.getServiceOrderVO(true,null, null, false, false,true,0));
    	when(mockService.getServiceOrderVO(Matchers.contains("PAOR")) ).thenReturn(
				MockVOHelper.getServiceOrderVO(true, null, null, true, false, false,0));
    	when(mockService.getServiceOrderVO(Matchers.contains("OSA5")) ).thenReturn(
				MockVOHelper.getServiceOrderVO(false, "Completed", null, false, false, true, 18));
    	when(mockService.getServiceOrderVO(Matchers.contains("OSB5")) ).thenReturn(
				MockVOHelper.getServiceOrderVO(false, "Auto-Complete", "PAC", false, false, true, 4));
    	
    }
}
