package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.StaticIPVO;
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

public class StaticIPWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(StaticIPWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("SIP");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public StaticIPWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {

        final String methodName = " StaticIPWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        mockStaticIPData(processMock);

        StaticIPVO staticIPVO = mockService.getStaticIPVO(processMock);
        if (staticIPVO == null) {
            staticIPVO = MockVOHelper.getStaticIPVO(false, 3, "1.1.1.1", "1.2.2.0", null, false);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("hasStaticIP", staticIPVO.isHasStaticIP());
        outputParams.put("IPQuantity", staticIPVO.getIPQuantity());
        outputParams.put("startIP", staticIPVO.getStartIP());
        outputParams.put("endIP", staticIPVO.getEndIP());
        outputParams.put("ipAddressList", staticIPVO.getIpAddressList());
        outputParams.put("isErrored", staticIPVO.isErrored());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockStaticIPData(String telephoneNumber) {
        List listofIPs = new ArrayList();
        listofIPs.add("10.1.2.3");
        listofIPs.add("10.1.2.4");
        listofIPs.add("10.1.2.5");
        /*when(mockService.getStaticIPVO(Matchers.startsWith("22"))).thenReturn(
         MockVOHelper.getStaticIPVO(true, 3, "10.1.2.3", "10.1.2.5", listofIPs));
         when(mockService.getStaticIPVO(Matchers.startsWith("99"))).thenReturn(
         MockVOHelper.getStaticIPVO(true, 3, "10.1.2.3", "10.1.2.5", listofIPs));
         when(mockService.getStaticIPVO(Matchers.startsWith("98"))).thenReturn(
         MockVOHelper.getStaticIPVO(true, 3, "10.1.2.3", "10.1.2.5", listofIPs));*/
        when(mockService.getStaticIPVO(Matchers.contains("SIP"))).thenReturn(
                MockVOHelper.getStaticIPVO(true, 3, "10.1.2.3", "10.1.2.5", listofIPs, false));
        /*when(mockService.getStaticIPVO(Matchers.contains("99"))).thenReturn(
         MockVOHelper.getStaticIPVO(true, 3, "10.1.2.3", "10.1.2.5", listofIPs));
         when(mockService.getStaticIPVO(Matchers.contains("98"))).thenReturn(
         MockVOHelper.getStaticIPVO(true, 3, "10.1.2.3", "10.1.2.5", listofIPs));*/
        when(mockService.getStaticIPVO(Matchers.contains("ERROR"))).thenReturn(
                MockVOHelper.getStaticIPVO(false, 0, null, null, null, true));

    }
}
