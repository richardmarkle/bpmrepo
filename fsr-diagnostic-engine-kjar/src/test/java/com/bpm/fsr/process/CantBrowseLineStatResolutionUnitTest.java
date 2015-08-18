package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.bpm.fsr.util.FSRActionUtil;

public class CantBrowseLineStatResolutionUnitTest extends FSRProcessJunitBaseTestCase {

	
	/*@Test
	public void test_InstructAgent_Flow() {
		System.out.println("-----------test_InstructAgent_Flow---------");
    	
		Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseLineStatResolution", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_INSTRUCT_AGENT, "Instruct Agent to Dispatch Tech", "Instruct Agent to Dispatch Tech",params);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}*/
	
	/*@Test
	public void test_Verify3rdPartyRouter_RebootModem_Flow() {
		System.out.println("-----------test_Verify3rdPartyRouter_Flow---------");
		Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	params.put("userOption", false);
    	
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseLineStatResolution", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_3RD_PARTY_ROUTER, "Verify from customer if there is 3rd party router behind modem", "Verify 3rd Party Router is Used",params);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_INSTRUCT_AGENT_TO_REBOOT, "Instruct agent to reboot modem (ACS)", "Instruct Agent to Reboot Modem (ACS)",params);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_VERIFY_POWERCYCLE, "Verify with customer powercycle is complete", "Verify Powercycle is Complete",params);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}*/
	
	/*@Test
	public void test_Verify3rdPartyRouter_ByPassRouter_ContactIT_Flow() {
		System.out.println("-----------test_Verify3rdPartyRouter_ByPassRouter_ContactIT_Flow---------");
		Map<String, Object> thirdPartyBypassRouter = new HashMap<String, Object>();
		thirdPartyBypassRouter.put("agentName", "krisv");
		thirdPartyBypassRouter.put("userOption", true);
    	Map<String, Object> contactIT = new HashMap<String, Object>();
    	contactIT.put("agentName", "krisv");
    	contactIT.put("userOption", false);
    	
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseLineStatResolution", thirdPartyBypassRouter);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_3RD_PARTY_ROUTER, "Verify from customer if there is 3rd party router behind modem", "Verify 3rd Party Router is Used",thirdPartyBypassRouter);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_BYPASS_ROUTER, "Confirm if customer  would like to bypass the router", "Confirm to bypass the Router",contactIT);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONTACT_IT_PERSON, "Instruct customer to contact IT person that set up their network", "Instruct Customer to Contact IT Person",null);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}
	
	@Test
	public void test_Verify3rdPartyRouter_ByPass_Instructions_VerifyNonCTLYes_Flow() {
		System.out.println("-----------test_Verify3rdPartyRouter_ByPass_Instructions_VerifyNonCTL_Flow---------");
		Map<String, Object> thirdPartyBypassRouterInstructions = new HashMap<String, Object>();
		thirdPartyBypassRouterInstructions.put("agentName", "krisv");
		thirdPartyBypassRouterInstructions.put("userOption", true);
    	
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseLineStatResolution", thirdPartyBypassRouterInstructions);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_3RD_PARTY_ROUTER, "Verify from customer if there is 3rd party router behind modem", "Verify 3rd Party Router is Used",thirdPartyBypassRouterInstructions);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_BYPASS_ROUTER, "Confirm if customer  would like to bypass the router", "Confirm to bypass the Router",thirdPartyBypassRouterInstructions);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_INSTRUCTIONS_TO_BYPASS_ROUTER, "Provide customer instructions on how to bypass the router", "Provide Instructions to Customer",thirdPartyBypassRouterInstructions);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_NON_CTL_SITE, "Verify if customer can surf to non-CTL site", "Verify Can Surf Non CTL's Site",thirdPartyBypassRouterInstructions);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}*/
	
	/*@Test
	public void test_Verify3rdPartyRouter_ByPass_Instructions_VerifyNonCTLNoFlow() {
		System.out.println("-----------test_Verify3rdPartyRouter_ByPass_Instructions_VerifyNonCTL_Flow---------");
		Map<String, Object> thirdPartyBypassRouterInstructions = new HashMap<String, Object>();
		thirdPartyBypassRouterInstructions.put("agentName", "krisv");
		thirdPartyBypassRouterInstructions.put("userOption", true);
		Map<String, Object> nonCTLSiteNotAccessable = new HashMap<String, Object>();
		nonCTLSiteNotAccessable.put("agentName", "krisv");
		nonCTLSiteNotAccessable.put("userOption", false);
    	
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseLineStatResolution", thirdPartyBypassRouterInstructions);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_3RD_PARTY_ROUTER, "Verify from customer if there is 3rd party router behind modem", "Verify 3rd Party Router is Used",thirdPartyBypassRouterInstructions);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_BYPASS_ROUTER, "Confirm if customer  would like to bypass the router", "Confirm to bypass the Router",thirdPartyBypassRouterInstructions);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_INSTRUCTIONS_TO_BYPASS_ROUTER, "Provide customer instructions on how to bypass the router", "Provide Instructions to Customer",thirdPartyBypassRouterInstructions);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_NON_CTL_SITE, "Verify if customer can surf to non-CTL site", "Verify Can Surf Non CTL's Site",nonCTLSiteNotAccessable);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}*/
}