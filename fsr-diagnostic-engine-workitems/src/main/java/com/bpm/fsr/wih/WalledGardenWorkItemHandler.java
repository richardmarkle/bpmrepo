package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.WalledGardenVO;
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

public class WalledGardenWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(StaticIPWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("PEND");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public WalledGardenWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {

        final String methodName = " WalledGardenWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);

        LOG.info(methodName + "processMock: " + processMock);
        mockWalledGarden();

        WalledGardenVO walledGardenVO = mockService.getWalledGardenVO(processMock);
        if (walledGardenVO == null) {
            walledGardenVO = MockVOHelper.getWalledGardenVO(false, "false");
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("inWalledGarden", walledGardenVO.isInWalledGarden());
        outputParams.put("walledGardenType", walledGardenVO.getWalledGardenType());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockWalledGarden() {

        when(mockService.getWalledGardenVO(Matchers.contains("PEND"))).thenReturn(
                MockVOHelper.getWalledGardenVO(true, "true"));
        when(mockService.getWalledGardenVO(Matchers.contains("TEMPDENY"))).thenReturn(
                MockVOHelper.getWalledGardenVO(true, "TEMPDENY"));
        when(mockService.getWalledGardenVO(Matchers.contains("LATEPAY"))).thenReturn(
                MockVOHelper.getWalledGardenVO(false, "LatePay/Notice"));
        when(mockService.getWalledGardenVO(Matchers.contains("EUP"))).thenReturn(
                MockVOHelper.getWalledGardenVO(false, "EUP/Notice"));
        when(mockService.getWalledGardenVO(Matchers.contains("PROACT"))).thenReturn(
                MockVOHelper.getWalledGardenVO(false, "Repair/Filters"));
        when(mockService.getWalledGardenVO(Matchers.contains("SEASUS"))).thenReturn(
                MockVOHelper.getWalledGardenVO(false, "Suspend/Seasonal"));

    }
}
