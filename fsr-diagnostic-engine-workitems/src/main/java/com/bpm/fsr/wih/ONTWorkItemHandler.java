package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.OntVO;
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

public class ONTWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(ONTWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("ONTOK");
        mockValues.add("ONTOK1");
        mockValues.add("ONTOUT");
        mockValues.add("ONTOUT1");
        mockValues.add("ONTOS");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ONTWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {
        final String methodName = " ONTWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        //function call;
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        System.out.println(methodName + " Code - " + processMock);
        System.out.println("Remaining Mock Data - " + processInstance.getVariable("processMock"));

        LOG.info(methodName + "processMock: " + processMock);
        mockProductsFeatures(processMock);

        OntVO ontVO = mockService.getOntVO(processMock);
        if (ontVO == null) {
            ontVO = MockVOHelper.getOntVO("Missing", "Unknown", "", "");
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("ONTAdminStatus", ontVO.getOntAdminStatus());
        outputParams.put("ONTOpStatus", ontVO.getOntOpStatus());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockProductsFeatures(String processMock) {

        //check ONT states
        when(mockService.getOntVO(Matchers.contains("ONTINS"))).thenReturn(MockVOHelper.getOntVO("In Service", "Up", "", ""));
        when(mockService.getOntVO(Matchers.contains("ONTOUTS"))).thenReturn(MockVOHelper.getOntVO("Out of Service MA", "Discovered", "", ""));
        when(mockService.getOntVO(Matchers.contains("ONTAOS"))).thenReturn(MockVOHelper.getOntVO("Missing", "Unknown", "", ""));

    }
}
