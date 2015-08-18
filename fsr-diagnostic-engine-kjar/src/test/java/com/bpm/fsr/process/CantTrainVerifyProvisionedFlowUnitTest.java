package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

public class CantTrainVerifyProvisionedFlowUnitTest extends FSRProcessJunitBaseTestCase {
	
	/*@Test
	public void testVerifyProvisioned_Escalate()
	{
		Map<String, Object> params = getInputParams();
		 
		 System.out.println("*****testCantTrainFlow_FutureDD********");
   	ProcessInstance processInstance = ksession.startProcess("CantTrainVerifyProvisioned", params);
   //	testRecommendPendingOrder_ImpactFutureDD_Send_care(processInstance);
   	testRecommendProvisioned_CallDSLTG(processInstance);
		ksession.fireAllRules();
		
	   assertProcessInstanceCompleted(processInstance.getId(), ksession);	
		
		
	}*/

	
	
	private static Map<String, Object> getInputParams() {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	
    	params.put("legacyMarket","CRIS");
    	 return params;
	}
	
	public static void testRecommendProvisioned_CallDSLTG(ProcessInstance processInstance)
	 {
		
		 completeDisplayNextBestAction(processInstance, "krisv", "Call DSLTG to correct provisioning", "Call DSLTG to correct provisioning",null);
		// completeDisplayNextBestAction(processInstance, "krisv", "Send to Care if customer would like to discuss issue further", "Send to Care to discuss Issue Further",getInputOptionParams());
	 }
}
