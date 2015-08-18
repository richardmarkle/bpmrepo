package com.bpm.fsr.wih;

import com.bpm.fsr.mock.ICLStaticIPVO;
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

public class ICLStaticIPWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(ICLStaticIPWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("ICLSTATIC");

    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ICLStaticIPWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {

        final String methodName = " ICLStaticIPWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        mockSpeed();

        ICLStaticIPVO iCLStaticIPVO = mockService.getICLStaticIPVO(processMock);
        if (iCLStaticIPVO == null) {
            iCLStaticIPVO = MockVOHelper.getICLStaticIPVO(false, false, 1, "1.1.1.1", "1.2.2.0", null);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", iCLStaticIPVO.isErrored());
        outputParams.put("hasStaticIP", iCLStaticIPVO.isHasStaticIP());
        outputParams.put("IPQuantity", iCLStaticIPVO.getIPQuantity());
        outputParams.put("startIP", iCLStaticIPVO.getStartIP());
        outputParams.put("endIP", iCLStaticIPVO.getEndIP());
        outputParams.put("ipAddressList", iCLStaticIPVO.getIpAddressList());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockSpeed() {
        List listofIPs = new ArrayList();
        listofIPs.add("10.1.2.3");
        listofIPs.add("10.1.2.4");
        listofIPs.add("10.1.2.5");

        when(mockService.getICLStaticIPVO(Matchers.contains("ICLSTATIC"))).thenReturn(
                MockVOHelper.getICLStaticIPVO(false, true, 1, "1.1.1.1", "1.2.2.0", listofIPs));

        when(mockService.getICLStaticIPVO(Matchers.contains("NICLSTC"))).thenReturn(
                MockVOHelper.getICLStaticIPVO(false, false, 0, "1.1.1.1", "1.2.2.0", listofIPs));
        when(mockService.getICLStaticIPVO(Matchers.contains("ERROR"))).thenReturn(
                MockVOHelper.getICLStaticIPVO(true, false, 0, null, null, null));
    }

}
