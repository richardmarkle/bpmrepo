package com.bpm.fsr.wih;

import com.bpm.fsr.mock.ASSIABasicsVO;
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

public class ASSIABasicsWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ASSIABasicsWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("STBL");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ASSIABasicsWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        final String methodName = "ASSIABasicsWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);

        mockASSIABasics(processMock);

        ASSIABasicsVO assiaBasicsVO = mockService.getASSIABasics(processMock);
        if (assiaBasicsVO == null) {
            assiaBasicsVO = MockVOHelper.getASSIABasicsVO(false,false,false,false, "Unstable","2015-05-27 04:21:43",null);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("supported",assiaBasicsVO.isSupported());
        outputParams.put("monitored", assiaBasicsVO.isMonitored());
        outputParams.put("lineStability", assiaBasicsVO.getLineStability());
        outputParams.put("optimizerEndTime",assiaBasicsVO.getOptimizerEndTime());
        outputParams.put("optimized",assiaBasicsVO.isOptimized());
        

        workItemManager.completeWorkItem(workItem.getId(), outputParams);

    }

    @Override
    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockASSIABasics(String telephoneNumber) {
        when(mockService.getASSIABasics(Matchers.contains("STBL"))).thenReturn(MockVOHelper.getASSIABasicsVO(false,true,true,true, "Stable","2015-05-27 04:21:43","2015-07-21 04:21:43"));
        when(mockService.getASSIABasics(Matchers.contains("UNSTBL"))).thenReturn(MockVOHelper.getASSIABasicsVO(false,true,true,true, "Very Unstable","2015-05-27 04:21:43","2015-06-27 04:21:43"));
    }

}
