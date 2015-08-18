package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

public class LcrisWithSipUnitTest extends FSRProcessJunitBaseTestCase {/*

	@Test
	public void testKnownOutageFlow() {
    	Map<String, Object> params = getInputParams();
    	params.put("isModemSupported", true);
    	//params.put("isWanIpImprovStaticIpMatch", true);

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.LcrisWithSip", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        Map<String, Object> outputParams = new HashMap<String, Object>();
        outputParams.put("userOption", true);
        completeDisplayNextBestAction(processInstance, "krisv", "CB0023", "Verify if customer can surf to non-CTL site", "Verify if customer can surf to non-CTL site",outputParams);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}
	
	@Test
	public void testKnownOutageFlow2() {
		System.out.println("--------------------------------------------------");
    	Map<String, Object> params = getInputParams();
    	params.put("isModemSupported", true);
    	//params.put("isWanIpImprovStaticIpMatch", false);
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.LcrisWithSip", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        Map<String, Object> outputParams1 = new HashMap<String, Object>();
        outputParams1.put("userOption", true);
        completeDisplayNextBestAction(processInstance, "krisv", "CB0441", "Determine IMPROV Static IP & instruct customer to update modem Static IP if it does not match", "Determine IMPROV Static IP & instruct customer to update modem Static IP if it does not match",outputParams1);
       // assertProcessInstanceCompleted(processInstance.getId(), ksession);	
        
        Map<String, Object> outputParams2 = new HashMap<String, Object>();
        outputParams2.put("userOption", true);
        completeDisplayNextBestAction(processInstance, "krisv", "CB0023", "Verify if customer can surf to non-CTL site", 
        		"Verify if customer can surf to non-CTL site",outputParams2);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}

	private Map<String, Object> getInputParams() {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");

    	return params;
	}
*/}
