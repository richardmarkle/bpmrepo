package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.PollDSLAMActualsVO;
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

public class PollDSLAMActualsWorkItemHandler implements WorkItemHandler {

	private static final Logger LOG = LoggerFactory
			.getLogger(PollDSLAMActualsWorkItemHandler.class);

	private final static List<String> mockValues = new ArrayList();

	/*
	 * static { mockValues.add("GEQ11"); mockValues.add("HSIPORT");
	 * mockValues.add("DSLAM"); mockValues.add("TRAIN"); }
	 */
	@Mock
	MockService mockService;

	private final KieSession kieSession;

	public PollDSLAMActualsWorkItemHandler(KieSession kieSession) {
		this.kieSession = kieSession;
		MockitoAnnotations.initMocks(this);
	}

	@Override
	public void executeWorkItem(WorkItem workItem,
			WorkItemManager workItemManager) {

		final String methodName = "PollDSLAMActualsWorkItemHandler.executeWorkItem() ";
		LOG.info(methodName);
		WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
				.getProcessInstance((workItem.getProcessInstanceId()));
		String processMock = (String) processInstance
				.getVariable("processMock");
		// function call;
		// processMock = MockVOHelper.getMockCode(processMock, processInstance,
		// mockValues);
		processMock = MockVOHelper.getMockCode(processMock, processInstance);
		System.out.println(methodName + " Code - " + processMock);
		System.out.println("Remaining Mock Data - "
				+ processInstance.getVariable("processMock"));

		LOG.info(methodName + "processMock: " + processMock);
		mockPollDSLAMData(processMock);

		PollDSLAMActualsVO pollDSLAMActualsVO = mockService
				.getPollDSLAMActuals(processMock);
		if (pollDSLAMActualsVO == null) {
			pollDSLAMActualsVO = MockVOHelper.getPollDSLAMActualsVO(false,
					false, false, false, 10, 10, false, false, 0, 0, 0, 0,
					null, "Down", null, 0, 0, null, null, null, null, null,
					null, null, null);
		}

		Map<String, Object> outputParams = new HashMap<String, Object>();
		outputParams.put("isErrored", pollDSLAMActualsVO.isErrored());
		outputParams.put("isPollDSLAMSupported",
				pollDSLAMActualsVO.isPollDSLAMSupported());
		outputParams.put("isModemTrained", pollDSLAMActualsVO.isModemTrained());
		outputParams.put("isNoiseMarginAvailable",
				pollDSLAMActualsVO.isNoiseMarginAvailable());
		outputParams
				.put("noiseMarginUp", pollDSLAMActualsVO.getNoiseMarginUp());
		outputParams.put("noiseMarginDown",
				pollDSLAMActualsVO.getNoiseMarginDown());
		outputParams.put("provisionedSpeedAvailable",
				pollDSLAMActualsVO.isProvisionedSpeedAvailable());
		outputParams.put("actualSpeedAvailable",
				pollDSLAMActualsVO.isActualSpeedAvailable());
		outputParams.put("provisionedSpeedUp",
				pollDSLAMActualsVO.getProvisionedSpeedUp());
		outputParams.put("provisionedSpeedDown",
				pollDSLAMActualsVO.getProvisionedSpeedDown());
		outputParams
				.put("actualSpeedUp", pollDSLAMActualsVO.getActualSpeedUp());
		outputParams.put("actualSpeedDown",
				pollDSLAMActualsVO.getActualSpeedDown());
		outputParams.put("portAdminStatus",
				pollDSLAMActualsVO.getPortAdminStatus());
		outputParams.put("portOpStatus", pollDSLAMActualsVO.getPortOpStatus());
		outputParams.put("crossConnectStatus",
				pollDSLAMActualsVO.getCrossConnectStatus());
		outputParams.put("provisionedSpeedUp_2",
				pollDSLAMActualsVO.getProvisionedSpeedUp_2());
		outputParams.put("provisionedSpeedDown_2",
				pollDSLAMActualsVO.getProvisionedSpeedDown_2());
		outputParams.put("portAdminStatus_2",
				pollDSLAMActualsVO.getPortAdminStatus_2());
		outputParams.put("portOpStatus_2",
				pollDSLAMActualsVO.getPortOpStatus_2());
		outputParams.put("actualsSubscriberVPI",
				pollDSLAMActualsVO.getActualsSubscriberVPI());
		outputParams.put("actualsSubscriberVCI",
				pollDSLAMActualsVO.getActualsSubscriberVCI());
		outputParams.put("actualsSubscriberVLAN",
				pollDSLAMActualsVO.getActualsSubscriberVLAN());
		outputParams.put("actualsNetworkVPI",
				pollDSLAMActualsVO.getActualsNetworkVPI());
		outputParams.put("actualsNetworkVCI",
				pollDSLAMActualsVO.getActualsNetworkVCI());
		outputParams.put("actualsNetworkVLAN",
				pollDSLAMActualsVO.getActualsNetworkVLAN());

		workItemManager.completeWorkItem(workItem.getId(), outputParams);

	}

	@Override
	public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

	}

	private void mockPollDSLAMData(String processMock) {

		when(mockService.getPollDSLAMActuals(Matchers.contains("GEQ11")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, false, false, 0, 0, 0, 0, null,
								"Down", null, 0, 0, null, null, null, null,
								null, null, null, null));
		
		when(mockService.getPollDSLAMActuals(Matchers.contains("LEQ11")))
		.thenReturn(
				MockVOHelper.getPollDSLAMActualsVO(false, true, false,
						true, 10, 10, false, false, 0, 0, 0, 0, null,
						"Down", null, 0, 0, null, null, null, null,
						null, null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("HSIPORT")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, false, false, 0, 0, 0, 0, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("DSLAM")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, false, false, 0, 0, 0, 0, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("TRAIN")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, true,
								true, 13, 13, false, false, 0, 0, 0, 0, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("VPIVCI")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, true,
								true, 13, 13, false, false, 0, 0, 0, 0, null,
								"Up", null, 0, 0, null, null, "0", "32", null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("VPIEVCI")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, true,
								true, 13, 13, false, false, 0, 0, 0, 0, null,
								"Up", null, 0, 0, null, null, "8", "35", null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("PROV")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, true, false, 0, 0, 0, 0, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("PROF")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, true, false, 8, 8, 0, 0, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));
		when(mockService.getPollDSLAMActuals(Matchers.contains("ALL")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, true, true, 10, 10, 10, 10, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("PROACCPT")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, true, true, 10, 10, 5, 5, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));

		when(mockService.getPollDSLAMActuals(Matchers.contains("PROUNACCPT")))
				.thenReturn(
						MockVOHelper.getPollDSLAMActualsVO(false, true, false,
								true, 13, 13, true, true, 5, 5, 5, 5, null,
								"Up", null, 0, 0, null, null, null, null, null,
								null, null, null));

		/*
		 * when(mockService.getPollDSLAMActuals(Matchers.contains("PROUNACCPT")))
		 * .thenReturn( MockVOHelper.getPollDSLAMActualsVO(isErrored,
		 * isPollDSLAMSupported, isModemTrained, isNoiseMarginAvailable,
		 * noiseMarginUp, noiseMarginDown, provisionedSpeedAvailable,
		 * actualSpeedAvailable, provisionedSpeedUp, provisionedSpeedDown,
		 * actualSpeedUp, actualSpeedDown, portAdminStatus, portOpStatus,
		 * crossConnectStatus, provisionedSpeedUp_2, provisionedSpeedDown_2,
		 * portAdminStatus_2, portOpStatus_2, actualsSubscriberVPI,
		 * actualsSubscriberVCI, actualsSubscriberVLAN, actualsNetworkVPI,
		 * actualsNetworkVCI, actualsNetworkVLAN));
		 */
		
		when(mockService.getPollDSLAMActuals(Matchers.contains("ACTPROG")))
		.thenReturn(
				MockVOHelper.getPollDSLAMActualsVO(false, true, true,
						true, 13, 13, true, true, 5, 5, 5, 5, null,
						"Up", null, 0, 0, null, null, null, null, null,
						null, null, null));
		
		when(mockService.getPollDSLAMActuals(Matchers.contains("ACTPROL")))
		.thenReturn(
				MockVOHelper.getPollDSLAMActualsVO(false, true, true,
						true, 13, 13, true, true, 10, 10, 5, 5, null,
						"Up", null, 0, 0, null, null, null, null, null,
						null, null, null));
		
	}

}
