package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.ModemInfoVO;
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

public class ModemInformationWorkItemHandler implements WorkItemHandler {

    private static final Logger LOG = LoggerFactory
            .getLogger(ModemInformationWorkItemHandler.class);

    private final static List<String> mockValues = new ArrayList();

    static {
        mockValues.add("SWIPM");
    }

    @Mock
    MockService mockService;

    private final KieSession kieSession;

    public ModemInformationWorkItemHandler(KieSession kieSession) {
        this.kieSession = kieSession;
        MockitoAnnotations.initMocks(this);
    }

    public void executeWorkItem(WorkItem workItem,
            WorkItemManager workItemManager) {
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

        mockModemInfoData(processMock);

        ModemInfoVO modemInfoVO = mockService.getModemInfoVO(processMock);
        if (modemInfoVO == null) {
            modemInfoVO = MockVOHelper.getModemInfoVO(false, "123456", false,
                    "10.1.2.3", "NO", true, false, false, null, null, null, "TES");
        }

        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("isErrored", modemInfoVO.isErrored());
        outputParams.put("modemSerialNumber", modemInfoVO.getModemSerialNumber());
        outputParams.put("modemWanIpPresent", modemInfoVO.isModemWanIpPresent());
        outputParams.put("modemWanIP", modemInfoVO.getModemWanIP());
        outputParams.put("modemFirmwareLatest", modemInfoVO.getModemFirmwareLatest());
        outputParams.put("modemConnectedDevicesPresent", modemInfoVO.isModemConnectedDevicesPresent());
        outputParams.put("modemActiveConnectedDevicePresent", modemInfoVO.isModemActiveConnectedDevicePresent());
        outputParams.put("modemEthernetConnectedDevicePresent", modemInfoVO.isModemEthernetConnectedDevicePresent());
        outputParams.put("modemMake", modemInfoVO.getModemMake());
        outputParams.put("modemModel", modemInfoVO.getModemModel());
        outputParams.put("modemFirmware", modemInfoVO.getModemFirmware());
        outputParams.put("modemAuthenticatedPPPusername", modemInfoVO.getModemAuthenticatedPPPusername());

        workItemManager.completeWorkItem(workItem.getId(), outputParams);
    }

    public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

    }

    private void mockModemInfoData(String processMock) {

        when(mockService.getModemInfoVO(Matchers.contains("SWIPM"))).thenReturn(
                MockVOHelper.getModemInfoVO(false, "123456", true, "10.1.2.3", "Yes", true,
                        true, true, null, null, "YES", "username"));

        when(mockService.getModemInfoVO(Matchers.contains("MDMMM"))).thenReturn(
                MockVOHelper.getModemInfoVO(false, "123456", true, "10.1.2.3", "Yes", true,
                        true, true, "Westell", "VEVG2500", "YES", "username"));

        when(mockService.getModemInfoVO(Matchers.contains("ERROR"))).thenReturn(
                MockVOHelper.getModemInfoVO(true, null, false, null, null, false,
                        false, false, null, null, null, null));

    }
}
