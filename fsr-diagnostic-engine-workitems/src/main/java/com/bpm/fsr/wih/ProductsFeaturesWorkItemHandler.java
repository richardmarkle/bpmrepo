package com.bpm.fsr.wih;

import com.bpm.fsr.mock.MockService;
import com.bpm.fsr.mock.MockVOHelper;
import com.bpm.fsr.mock.ProductsFeaturesVO;
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

public class ProductsFeaturesWorkItemHandler implements WorkItemHandler {

	private static final Logger LOG = LoggerFactory
			.getLogger(ModemInformationWorkItemHandler.class);
	private final static List<String> mockValues = new ArrayList();

	static {
		mockValues.add("GPON");
	}

	@Mock
	MockService mockService;

	private final KieSession kieSession;

	public ProductsFeaturesWorkItemHandler(KieSession kieSession) {
		this.kieSession = kieSession;
		MockitoAnnotations.initMocks(this);
	}

	public void executeWorkItem(WorkItem workItem,
			WorkItemManager workItemManager) {
		final String methodName = " ProductsFeaturesWorkItemHandler.executeWorkItem() ";
		LOG.info(methodName);

		WorkflowProcessInstance processInstance = (WorkflowProcessInstance) kieSession
				.getProcessInstance((workItem.getProcessInstanceId()));
		String processMock = (String) processInstance
				.getVariable("processMock");
		System.out.println(methodName + " --processMock - " + processMock);

		// function call;
		// processMock = MockVOHelper.getMockCode(processMock, processInstance,
		// mockValues);
		processMock = MockVOHelper.getMockCode(processMock, processInstance);
		System.out.println(methodName + " Code - " + processMock);
		System.out.println("Remaining Mock Data - "
				+ processInstance.getVariable("processMock"));

		LOG.info(methodName + "processMock: " + processMock);
		mockProductsFeatures(processMock);

		ProductsFeaturesVO producstFeatures = mockService
				.getProductsFeatures(processMock);
		if (producstFeatures == null) {
			producstFeatures = MockVOHelper.getProductsFeaturesVO(false, false,
					false, false, null, false, null, "ADSL", false);
		}

		Map<String, Object> outputParams = new HashMap<String, Object>();
		outputParams.put("hasPRISMonAccount",
				producstFeatures.isHasPRISMonAccount());
		outputParams.put("hasGPON", producstFeatures.isHasGPON());
		outputParams.put("isMadisonRiverCustomer",
				producstFeatures.isMadisonRiverCustomer());
		outputParams.put("hasAtEaseFeature",
				producstFeatures.isHasAtEaseFeature());
		outputParams.put("atEaseLevel", producstFeatures.getAtEaseLevel());

		outputParams.put("isErrored", producstFeatures.isErrored());
		outputParams.put("hasTechInstallUSOC",
				producstFeatures.isHasTechInstallUSOC());
		outputParams.put("marketUnit", producstFeatures.getMarketUnit());
		outputParams.put("accessTech", producstFeatures.getAccessTech());

		workItemManager.completeWorkItem(workItem.getId(), outputParams);
	}

	public void abortWorkItem(WorkItem wi, WorkItemManager wim) {

	}

	private void mockProductsFeatures(String processMock) {

		/*
		 * when(mockService.getProductsFeatures(Matchers.contains("GPON"))).
		 * thenReturn( MockVOHelper.getProductsFeaturesVO(hasPRISMonAccount,
		 * hasGPON, isMadisonRiverCustomer, hasAtEaseFeature, atEaseLevel,
		 * hasTechInstallUSOC, marketUnit, accessTech, isErrored)
		 */

		when(mockService.getProductsFeatures(Matchers.contains("GPON")))
				.thenReturn(
						MockVOHelper.getProductsFeaturesVO(true, true, true,
								true, null, false, null, null, false));

		when(mockService.getProductsFeatures(Matchers.contains("HPRISM")))
				.thenReturn(
						MockVOHelper.getProductsFeaturesVO(true, true, true,
								true, null, false, null, "GPON", false));

		when(mockService.getProductsFeatures(Matchers.contains("ERROR")))
				.thenReturn(
						MockVOHelper.getProductsFeaturesVO(false, false, false,
								false, null, false, null, null, true));

		when(mockService.getProductsFeatures(Matchers.contains("EASE")))
				.thenReturn(
						MockVOHelper.getProductsFeaturesVO(true, true, true,
								true, "4", false, null, null, false));

		when(mockService.getProductsFeatures(Matchers.contains("EASEC")))
				.thenReturn(
						MockVOHelper.getProductsFeaturesVO(true, true, true,
								true, "3", false, null, null, false));

		when(mockService.getProductsFeatures(Matchers.contains("CUSTYPE")))
				.thenReturn(
						MockVOHelper.getProductsFeaturesVO(false, false, false,
								false, null, false, "Business", null, true));

	}
}
