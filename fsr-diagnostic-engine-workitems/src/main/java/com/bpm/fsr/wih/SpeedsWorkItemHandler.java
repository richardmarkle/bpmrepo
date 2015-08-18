package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.SpeedsVO;
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

public class SpeedsWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(StaticIPWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("PROV");
        mockValues.add("PROF");
        mockValues.add("PROU");
        mockValues.add("PROD");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public SpeedsWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {

        final String methodName = " SpeedsWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        mockSpeed();

        SpeedsVO speedsVO = mockService.getSpeedsVO(processMock);
        if (speedsVO == null) {
            speedsVO = MockVOHelper.getSpeedsVO(false, false, false, 10, 10, 7, 7, 1, 1);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("purchasedSpeedAvailable", speedsVO.isPurchasedSpeedAvailable());
        outputParams.put("purchasedSpeedUp", speedsVO.getPurchasedSpeedUp());
        outputParams.put("purchasedSpeedDown", speedsVO.getPurchasedSpeedDown());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockSpeed() {

		/*
		 * when(mockService.getSpeedsVO(Matchers.contains("PROV"))).thenReturn(
		 * MockVOHelper.getSpeedsVO(purchasedSpeedAvailable,
		 * provisionedSpeedAvailable, actualSpeedAvailable, purchasedSpeedUp,
		 * purchasedSpeedDown, provisionedSpeedUp, provisionedSpeedDown,
		 * actualSpeedUp, actualSpeedDown)
		 */
        when(mockService.getSpeedsVO(Matchers.contains("PROV"))).thenReturn(
                MockVOHelper.getSpeedsVO(false, true, false, 1, 1, 1, 1, 1, 1));
        when(mockService.getSpeedsVO(Matchers.contains("PROF"))).thenReturn(
                MockVOHelper.getSpeedsVO(true, true, true, 10, 10, 8, 8, 1, 1));
        when(mockService.getSpeedsVO(Matchers.contains("PROU"))).thenReturn(
                MockVOHelper.getSpeedsVO(true, true, true, 800, 1600, 8, 8, 1, 1));
        when(mockService.getSpeedsVO(Matchers.contains("PROD"))).thenReturn(
                MockVOHelper.getSpeedsVO(true, true, true, 200, 200, 8, 8, 1, 1));

    }

}
