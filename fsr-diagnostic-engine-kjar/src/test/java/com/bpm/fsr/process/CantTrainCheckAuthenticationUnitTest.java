package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

public class CantTrainCheckAuthenticationUnitTest extends FSRProcessJunitBaseTestCase {/*

	@Test
	public void testCantTrainCheckAuthentication() {
    	Map<String, Object> params = getInputParams();

    	ProcessInstance processInstance = ksession.startProcess("CantTrainCheckAuthentication", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        testCanSurfNonCTLSite(processInstance);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);
	}

	private static Map<String, Object> getInputParams() {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	params.put("optionChosen", "Yes");

    	return params;
	}
	
	public static void testCanSurfNonCTLSite(ProcessInstance processInstance){
		completeDisplayNextBestAction(processInstance, "krisv", "Verify if customer can surf to non-CTL site", "Verify Can Surf Non CTL Site",getInputParams());
	}
	
*/}