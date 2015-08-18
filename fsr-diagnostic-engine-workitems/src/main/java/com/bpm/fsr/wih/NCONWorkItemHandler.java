package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.NconVO;
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

public class NCONWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(NCONWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("CROS");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public NCONWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {
        final String methodName = " NCONWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        System.out.println("processMock before getMockCode: - " + processMock);
        //function call;
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        System.out.println(methodName + " Code - " + processMock);
        System.out.println("Remaining Mock Data - " + processInstance.getVariable("processMock"));

        LOG.info(methodName + "processMock: " + processMock);
        System.out.println(methodName + " --processMock - " + processMock);
        checkCrossConnect(processMock);

        NconVO nconVO = mockService.checkCrossConnect(processMock);
        System.out.println("nconVO-->" + nconVO);
        if (nconVO != null) {
            System.out.println("crossConnectOK-->" + nconVO.isCrossConnectOK());
        }
        if (nconVO == null) {
            nconVO = MockVOHelper.checkCrossConnect(false);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("crossConnectOK", nconVO.isCrossConnectOK());

        outputParams.put("equipmentID", "123456");
        outputParams.put("locationID", "12345678");
        outputParams.put("equipmentIP", "10.1.12.1");
        outputParams.put("gpoinAid", "352432");

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    public void checkCrossConnect(String processMock) {
        when(mockService.checkCrossConnect(Matchers.contains("CROS"))).thenReturn(
                MockVOHelper.checkCrossConnect(true));
    }

}
