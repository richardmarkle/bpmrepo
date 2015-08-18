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

public class ModemRebootWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ModemRebootWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("MRB");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ModemRebootWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        final String methodName = " ModemRebootWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        mockData();
        boolean ismodemRebootInitiated = mockService.modemReboot(processMock);
        System.out.println("ismodemRebootInitiated - " + ismodemRebootInitiated);

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("modemRebootInitiated", ismodemRebootInitiated);
        System.out.println("Modem Reboot value is set from WIH***");

        workItemManager.completeWorkItem(workItem.getId(), outputParams);

    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        // TODO Auto-generated method stub

    }

    private void mockData() {
        when(mockService.modemReboot(Matchers.contains("MRB"))).thenReturn(true);
    }
}
