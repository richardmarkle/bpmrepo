/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.wih;

import com.bpm.fsr.mock.KnownOutageVO;
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

/**
 *
 * @author ab19041
 */
public class KnownOutageWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(KnownOutageWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("KOA");
        mockValues.add("KOI");
        mockValues.add("KOF");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public KnownOutageWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        final String methodName = "KnownOutageWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        String product = (String) processInstance.getVariable("product");

        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        LOG.info(methodName + " process mock from process variable: " + (String) processInstance.getVariable("processMock"));

        mockAccountData(product);

        LOG.info(methodName + "processMock: " + processMock);

        KnownOutageVO knownOutageVO = mockService.getKnownOutage(processMock);
        if (knownOutageVO == null) {
            knownOutageVO = MockVOHelper.getKnownOutageVO(false, product, "Final",false);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("outageExists", knownOutageVO.isOutageExists());
        outputParams.put("outageId", knownOutageVO.getOutageId());
        outputParams.put("outageType", knownOutageVO.getOutageType());
        outputParams.put("outageStatus", knownOutageVO.getOutageStatus());
        outputParams.put("productAffected", knownOutageVO.getProductAffected());
        outputParams.put("isCongestionOutagePresent", knownOutageVO.isCongestionOutagePresent());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockAccountData(String product) {
        when(mockService.getKnownOutage(Matchers.contains("KOA"))).thenReturn(MockVOHelper.getKnownOutageVO(true, product, "Initial",false));
        when(mockService.getKnownOutage(Matchers.contains("KOI"))).thenReturn(MockVOHelper.getKnownOutageVO(true, product, "Informational",false));
        when(mockService.getKnownOutage(Matchers.contains("KOF"))).thenReturn(MockVOHelper.getKnownOutageVO(false, product, "Informational",false));
        when(mockService.getKnownOutage(Matchers.contains("CON"))).thenReturn(MockVOHelper.getKnownOutageVO(false, product, "Informational",true));
        
    }
}
