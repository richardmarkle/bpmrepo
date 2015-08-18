package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
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

@ApplicationScoped
public class RefreshHealthCheckWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RefreshHealthCheckWorkItemHandler.class);
    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("REFHC");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public RefreshHealthCheckWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = " RefreshHealthCheckWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);

        mockData();
        boolean isRefreshHealthCheckInitiated = mockService.refreshHealthCheckInitiated(processMock);
        System.out.println("isRefreshHealthCheckInitiated - " + isRefreshHealthCheckInitiated);
        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("refreshInitiated", isRefreshHealthCheckInitiated);

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData() {
        when(mockService.refreshHealthCheckInitiated(Matchers.contains("REFHC"))).thenReturn(true);
    }

}
