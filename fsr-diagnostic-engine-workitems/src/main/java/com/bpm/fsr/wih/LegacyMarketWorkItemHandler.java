package com.bpm.fsr.wih;

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

public class LegacyMarketWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LegacyMarketWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("CRIS");
        mockValues.add("ENSEMBLE");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public LegacyMarketWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = " ModemInformationWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        LOG.info(methodName + "processMock: " + processMock);
        System.out.println("processMock - " + processMock);
        mockData();
        String legacyMarket = mockService.legacyMarket(processMock);

        if (legacyMarket == null) {
            legacyMarket = "CRIS";
        }
        System.out.println("legacyMarket - " + legacyMarket);

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("legacyMarket", legacyMarket);

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData() {

        when(mockService.legacyMarket(Matchers.contains("CRIS"))).thenReturn("CRIS");
        when(mockService.legacyMarket(Matchers.contains("ENSEMBLE"))).thenReturn("Ensemble");

    }

}
