package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

public class KnownOutageFlowUnitTest extends FSRProcessJunitBaseTestCase {

	@Test
	public void testKnownOutageFlow() {
//		Map<String, Object> params = getInputParams();
//
//		ProcessInstance processInstance = ksession.startProcess(
//				"com.bpm.fsr.process.subprocess.knownOutage", params);
//		ksession.fireAllRules();
//
////		assertNotNull(processInstance);
//		completeDisplayNextBestAction(processInstance, "krisv");
//		completeDisplayNextBestAction(processInstance, "krisv");
////		assertProcessInstanceCompleted(processInstance.getId(), ksession);
	}

	private Map<String, Object> getInputParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agentName", "krisv");
		params.put("outageType", "HSI");

		return params;
	}
}