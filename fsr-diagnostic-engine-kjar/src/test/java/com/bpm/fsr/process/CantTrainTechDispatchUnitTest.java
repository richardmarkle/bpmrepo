package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

public class CantTrainTechDispatchUnitTest extends FSRProcessJunitBaseTestCase{/*
	
	@Test
	public  void testRecommendTechDispatch_Accept() {
    	Map<String, Object> params = getInputParamsAccept();

    	ProcessInstance processInstance = ksession.startProcess("CantTrainTechDispatch",params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        
        testRecommendTechDispatch_Accept(processInstance);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);
	}
	
	@Test
	public  void testRecommendTechDispatch_Reject() {
    	Map<String, Object> params = getInputParamsAccept();

    	ProcessInstance processInstance = ksession.startProcess("CantTrainTechDispatch",params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        
        testRecommendTechDispatch_Reject(processInstance);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);
	}

	private static Map<String, Object> getInputParamsAccept() {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	params.put("optionChosen", "Accept");

    	return params;
	}
	
	private static Map<String, Object> getInputParamsReject() {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	params.put("optionChosen", "Reject");

    	return params;
	}
	
	public static void testRecommendTechDispatch_Accept(ProcessInstance processInstance){
		completeDisplayNextBestAction(processInstance, "krisv", "Recommend Tech Dispatch for further investigation", "Recommend Tech Dispatch",getInputParamsAccept());
		completeDisplayNextBestAction(processInstance, "krisv", "Dispatch Tech", "Dispatch Tech",getInputParamsAccept());
	}
	
	public static void testRecommendTechDispatch_Reject(ProcessInstance processInstance){
		completeDisplayNextBestAction(processInstance, "krisv", "Recommend Tech Dispatch for further investigation", "Recommend Tech Dispatch",getInputParamsReject());
	}
	

*/}
