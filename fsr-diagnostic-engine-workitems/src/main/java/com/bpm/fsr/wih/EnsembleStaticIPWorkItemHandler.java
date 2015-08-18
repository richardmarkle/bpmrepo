/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.wih;

import com.bpm.fsr.mock.EnsembleStaticIPVO;
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
public class EnsembleStaticIPWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(EnsembleStaticIPWorkItemHandler.class);
    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public EnsembleStaticIPWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {

        final String methodName = " EnsembleStaticIPWorkItemHandler.executeWorkItem() ";
        LOG.info(methodName);

        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
                .getProcessInstance((workItem.getProcessInstanceId()));
        String processMock = (String) processInstance.getVariable("processMock");
        LOG.info(methodName + " process mock before mock code: " + processMock);
        //processMock = MockVOHelper.getMockCode(processMock, processInstance, mockValues);
        processMock = MockVOHelper.getMockCode(processMock, processInstance);
        LOG.info(methodName + " process mock after mock code: " + processMock);
        mockData();

        EnsembleStaticIPVO ensembleStaticIPVO = mockService.getEnsStaticIPVO(processMock);
        if (ensembleStaticIPVO == null) {
            ensembleStaticIPVO = MockVOHelper.getEnsStaticIPVO(false, false, 1, null, null, null);
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", ensembleStaticIPVO.isErrored());
        outputParams.put("hasStaticIP", ensembleStaticIPVO.isHasStaticIP());
        outputParams.put("IPQuantity", ensembleStaticIPVO.getIPQuantity());
        outputParams.put("startIP", ensembleStaticIPVO.getStartIP());
        outputParams.put("endIP", ensembleStaticIPVO.getEndIP());
        outputParams.put("ipAddressList", ensembleStaticIPVO.getIpAddressList());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockData() {
        List listofIPs = new ArrayList();
        listofIPs.add("10.1.2.3");
        listofIPs.add("10.1.2.4");
        listofIPs.add("10.1.2.5");

        when(mockService.getEnsStaticIPVO(Matchers.contains("ENSSIP"))).thenReturn(
                MockVOHelper.getEnsStaticIPVO(false, true, 1, "10.1.2.0", "10.1.2.10", listofIPs));
        when(mockService.getEnsStaticIPVO(Matchers.contains("ERROR"))).thenReturn(
                MockVOHelper.getEnsStaticIPVO(true, false, 1, "1.1.1.1", "1.2.2.0", listofIPs));
        when(mockService.getEnsStaticIPVO(Matchers.contains("SIPQTYZ"))).thenReturn(
                MockVOHelper.getEnsStaticIPVO(false, true, 0, null, null, listofIPs));
        when(mockService.getEnsStaticIPVO(Matchers.contains("ENSQTY"))).thenReturn(
                MockVOHelper.getEnsStaticIPVO(false, false, 1, "10.1.2.0", "10.1.2.10", listofIPs));
        when(mockService.getEnsStaticIPVO(Matchers.contains("ENSHSZQ"))).thenReturn(
                MockVOHelper.getEnsStaticIPVO(false, true, 0, null, null, listofIPs));
        when(mockService.getEnsStaticIPVO(Matchers.contains("ENSNSZQ"))).thenReturn(
                MockVOHelper.getEnsStaticIPVO(false, false, 0, null, null, listofIPs));
    }
}
