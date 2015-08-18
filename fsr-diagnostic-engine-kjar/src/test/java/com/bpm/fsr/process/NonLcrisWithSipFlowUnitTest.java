package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.bpm.fsr.util.FSRActionUtil;

public class NonLcrisWithSipFlowUnitTest extends FSRProcessJunitBaseTestCase {/*
	
	 @Test
     public void testNonLcrosWithSipFlow_NonCtlDns__Nonctlsite_UnSurf_LineStat_Reboot()
	 
	 {
		 System.out.println("*----------testNonLcrosWithSipFlow_NonCtlDns__Nonctlsite_UnSurf_LineStat_Reboot-----------*");
		 Map<String, Object> params1 = getInputTrueParams();
	    	Map<String, Object> params2 = getInputFalseParams();
	       
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.NonLcrisWithSip",params1);
			ksession.fireAllRules();
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VALIDATE_CTL_DNS_USED, "Validate if CTL’s DNS is being used by the customer", "Validate CTL's DNS",params2);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CHANGE_DNS, "Instruct customer to change DNS to CTL’s DNS", "Change DNS to CTL's DNS",params2);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_NON_CTL_SITE, "Verify if customer can surf to non-CTL site", "Verify Can Surf Non CTL's Site",params2);
	        
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_3RD_PARTY_ROUTER, "Verify from customer if there is 3rd party router behind modem", "Verify 3rd Party Router is Used",params2);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_INSTRUCT_AGENT_TO_REBOOT, "Instruct agent to reboot modem (ACS)", "Instruct Agent to Reboot Modem (ACS)",params2);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_VERIFY_POWERCYCLE, "Verify with customer powercycle is complete", "Verify Powercycle is Complete",params2);
	        assertProcessInstanceCompleted(processInstance.getId(), ksession);	

}
	 @Test
      public void testNonLcrosWithSipFlow_NonCtlDns__Nonctlsite_Surf()
	 
	  {
		 System.out.println("*----------testNonLcrosWithSipFlow_NonCtlDns__Nonctlsite_Surf-----------*");
		    Map<String, Object> params1 = getInputTrueParams();
	    	Map<String, Object> params2 = getInputFalseParams();
	       
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.NonLcrisWithSip",params1);
			ksession.fireAllRules();
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VALIDATE_CTL_DNS_USED, "Validate if CTL's DNS is being used by the customer", "Validate CTL's DNS",params2);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CHANGE_DNS, "Instruct customer to change DNS to CTL's DNS", "Change DNS to CTL's DNS",params2);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_NON_CTL_SITE, "Verify if customer can surf to non-CTL site", "Verify Can Surf Non CTL's Site",params1);
	        assertProcessInstanceCompleted(processInstance.getId(), ksession);	

}
	 
	 @Test
     public void testNonLcrisWithSipFlow_CtlDns()
	 
	  {
		 System.out.println("*----------testNonLcrisWithSipFlow_CtlDns-----------*");
		    Map<String, Object> params1 = getInputTrueParams();
	    	Map<String, Object> params2 = getInputFalseParams();
	       
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.NonLcrisWithSip",params1);
			ksession.fireAllRules();
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VALIDATE_CTL_DNS_USED, "Validate if CTL’s DNS is being used by the customer", "Validate CTL's DNS",params1);
			 completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_3RD_PARTY_ROUTER, "Verify from customer if there is 3rd party router behind modem", "Verify 3rd Party Router is Used",params2);
		        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_INSTRUCT_AGENT_TO_REBOOT, "Instruct agent to reboot modem (ACS)", "Instruct Agent to Reboot Modem (ACS)",params2);
		        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_VERIFY_POWERCYCLE, "Verify with customer powercycle is complete", "Verify Powercycle is Complete",params2);
			assertProcessInstanceCompleted(processInstance.getId(), ksession);	

}
	 private Map<String, Object> getInputTrueParams() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	params.put("agentName", "krisv");
	    	params.put("userOption",true);
	    	//params.put("outageType", "HSI");    	

	    	return params;
		}
		
		private Map<String, Object> getInputFalseParams() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	params.put("agentName", "krisv");
	    	params.put("userOption",false);
	    	//params.put("outageType", "HSI");    	

	    	return params;
		}
*/}
