package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.After;
import org.junit.Before;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;

import com.bpm.fsr.wih.KnownOutageWorkItemHandler;
import com.bpm.fsr.wih.LegacyMarketWorkItemHandler;
import com.bpm.fsr.wih.ModemInformationWorkItemHandler;
import com.bpm.fsr.wih.ModemRebootWorkItemHandler;
import com.bpm.fsr.wih.ModemStatusWorkItemHandler;
import com.bpm.fsr.wih.ModemSupportedWorkItemHandler;

public class FSRProcessJunitBaseTestCase extends JbpmJUnitBaseTestCase {

	protected RuntimeEngine engine = null;
	public static RuntimeEngine engine1 = null;
	protected KieSession ksession = null;

	public FSRProcessJunitBaseTestCase() {
		super(true, false);
	}

	@After
	public void teardownRuntimeManager() {
		disposeRuntimeManager();
	}

	@Before
	public void initKsession() {
		Map<String, ResourceType> resources = new HashMap<String, ResourceType>();

		// process
		resources.put("fsrGlobalFlow.bpmn", ResourceType.BPMN2);
		resources.put("knownOutage.bpmn", ResourceType.BPMN2);
		resources.put("CantBrowse.bpmn", ResourceType.BPMN2);
		resources.put("CantBrowseOneSiteFlow.bpmn", ResourceType.BPMN2);
		resources.put("TicketingNode.bpmn", ResourceType.BPMN2);
		resources.put("CantBrowseAllSites.bpmn", ResourceType.BPMN2);
		resources.put("AssociateModem.bpmn", ResourceType.BPMN2);
		resources.put("BridgeMode.bpmn", ResourceType.BPMN2);
		resources.put("LcrisWithSip.bpmn", ResourceType.BPMN2);
		resources.put("NonLcrisWithSip.bpmn", ResourceType.BPMN2);
		resources.put("CantBrowseLineStatResolution.bpmn", ResourceType.BPMN2);
		resources.put("RebootModem.bpmn", ResourceType.BPMN2);
		resources.put("refreshHealthCheck.bpmn", ResourceType.BPMN2);
		resources.put("CantTrainCheckAuthentication.bpmn", ResourceType.BPMN2);
		resources.put("ModemAuthDetermineModemProtocol.bpmn",
				ResourceType.BPMN2);
		resources.put("CantTrainTechDispatch.bpmn", ResourceType.BPMN2);
		resources.put("CantTrainPortStatus.bpmn", ResourceType.BPMN2);
		resources.put("CantTrain.bpmn", ResourceType.BPMN2);
		resources.put("CantTrainVerifyProvisioned.bpmn", ResourceType.BPMN2);

		// rules
		resources.put("\\rules\\supportedProduct.rdrl", ResourceType.RDRL);
		createRuntimeManager(resources, "fsr-test");

		engine = getRuntimeEngine();
		engine1 = engine;
		assertNotNull(engine);

		ksession = engine.getKieSession();

		// Workitem handlers
		KnownOutageWorkItemHandler knownOutageWorkItemHandler = new KnownOutageWorkItemHandler(
				ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("KnownOutages",
				knownOutageWorkItemHandler);
		ModemStatusWorkItemHandler modemStatusWorkItemHandler = new ModemStatusWorkItemHandler(
				ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("ModemStatus",
				modemStatusWorkItemHandler);
		ModemSupportedWorkItemHandler modemSupportedWorkItemHandler = new ModemSupportedWorkItemHandler(
				ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("ModemSupported",
				modemSupportedWorkItemHandler);
		ModemInformationWorkItemHandler modemInformationWorkItemHandler = new ModemInformationWorkItemHandler(
				ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("ModemInfo",
				modemInformationWorkItemHandler);
		LegacyMarketWorkItemHandler legacyMarketWorkItemHandler = new LegacyMarketWorkItemHandler(
				ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("LegacyMarket",
				legacyMarketWorkItemHandler);
		ModemRebootWorkItemHandler modemRebootWorkItemHandler = new ModemRebootWorkItemHandler(
				ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("ModemReboot",
				modemRebootWorkItemHandler);

		ksession.getAgenda().getAgendaGroup("validateProduct").setFocus();
	}

	/**
	 * start and complete select POC task
	 * 
	 * @param processInstance
	 */
	protected void completeDisplayNextBestAction(
			ProcessInstance processInstance, String agentName) {
		TaskService taskService = engine.getTaskService();

		List<TaskSummary> tasksOwned = taskService.getTasksOwned(agentName,
				"en-UK");
		assertTrue(!tasksOwned.isEmpty());

		TaskSummary selectPOCtaskSummary = tasksOwned.get(0);

		// Task life cycle - if it is assigned to a user, the status will be in
		// Reserved, if it is assigned to a group, the status should be claimed
		// before starting
		assertEquals(Status.Reserved, selectPOCtaskSummary.getStatus());
		taskService.start(selectPOCtaskSummary.getId(), agentName);

		Task obtainDataTask = taskService.getTaskById(selectPOCtaskSummary
				.getId());

		long taskContentId = obtainDataTask.getTaskData()
				.getDocumentContentId();
		assertTrue(taskContentId != -1);

		Content content = taskService.getContentById(taskContentId);
		Object unmarshalledObject = ContentMarshallerHelper.unmarshall(
				content.getContent(), null);
		if (!(unmarshalledObject instanceof Map)) {
			fail("The variables should be a Map");

		}
		Map<String, Object> unmarshalledvars = (Map<String, Object>) unmarshalledObject;

		System.out.println(unmarshalledvars);
		assertEquals(agentName, unmarshalledvars.get("ActorId"));
		String instructionHtml = (String) unmarshalledvars
				.get("instructionHtml");

		taskService.complete(selectPOCtaskSummary.getId(), agentName, null);
	}

	/**
	 * start and complete select POC task with Parameters
	 * 
	 * @param processInstance
	 */
	public static void completeDisplayNextBestAction(
			ProcessInstance processInstance, String agentName,
			String contentText, String nodeName, Map<String, Object> params) {
		TaskService taskService = engine1.getTaskService();

		List<TaskSummary> tasksOwned = taskService.getTasksOwned(agentName,
				"en-UK");
		assertTrue(!tasksOwned.isEmpty());

		TaskSummary selectPOCtaskSummary = tasksOwned.get(0);
		assertEquals(nodeName, selectPOCtaskSummary.getName());

		// Task life cycle - if it is assigned to a user, the status will be in
		// Reserved, if it is assigned to a group, the status should be claimed
		// before starting
		assertEquals(Status.Reserved, selectPOCtaskSummary.getStatus());
		taskService.start(selectPOCtaskSummary.getId(), agentName);

		Task obtainDataTask = taskService.getTaskById(selectPOCtaskSummary
				.getId());

		long taskContentId = obtainDataTask.getTaskData()
				.getDocumentContentId();
		assertTrue(taskContentId != -1);

		Content content = taskService.getContentById(taskContentId);
		Object unmarshalledObject = ContentMarshallerHelper.unmarshall(
				content.getContent(), null);
		if (!(unmarshalledObject instanceof Map)) {
			fail("The variables should be a Map");

		}
		Map<String, Object> unmarshalledvars = (Map<String, Object>) unmarshalledObject;

		System.out.println(unmarshalledvars);
		assertEquals(agentName, unmarshalledvars.get("ActorId"));
		String instructionHtml = (String) unmarshalledvars
				.get("instructionHtml");
		assertEquals(contentText, instructionHtml);

		taskService.complete(selectPOCtaskSummary.getId(), agentName, params);
	}

	/**
	 * 
	 * @param processInstance
	 */
	protected void testNodeTriggered(ProcessInstance processInstance,
			String nodeName) {
		assertNodeTriggered(processInstance.getId(), nodeName);
	}
}