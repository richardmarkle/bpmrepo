package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.bpm.fsr.util.FSRActionUtil;

public class CantBrowseOneSiteOnlyFlowUnitTest extends FSRProcessJunitBaseTestCase {
   
	/*@Test
	public void test_AgentAccess_ValidateCTLDNS_EscalateFlow() {
    	Map<String, Object> params = getInputTrueParams();

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseOneSiteFlow", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_AGENT_ABLE_TO_ACCESS, "Verify if you (Agent) are able to access the site", "Verify Agent Able To Access",params);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VALIDATE_CTL_DNS_USED, "Validate if CTL's DNS is being used by the customer", "Validate CTL's DNS",params);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_ESCALATE_TO_TECH_LEAD, "Escalate to Tech Lead", "Escalate to Tech Lead",params);

        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}
	
	@Test
	public void test_AgentAccess_InstructCustomerFlow() {
    	Map<String, Object> params = getInputFalseParams();

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseOneSiteFlow", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_AGENT_ABLE_TO_ACCESS, "Verify if you (Agent) are able to access the site", "Verify Agent Able To Access",params);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_INSTRUCT_CUSTOMER_ABOUT_SITE, "Instruct customer that either site is down, or an issue with that URL", "Instruct Customer About Site or URL",null);

        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}
	
	@Test
	public void test_AgentAccess_ValidateCTLDNS_ChangeDNS_VerifyNonCTLSite_EscalateFlow() {
    	Map<String, Object> params1 = getInputTrueParams();
    	Map<String, Object> params2 = getInputFalseParams();
    	
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseOneSiteFlow", params1);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_AGENT_ABLE_TO_ACCESS, "Verify if you (Agent) are able to access the site", "Verify Agent Able To Access",params1);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VALIDATE_CTL_DNS_USED, "Validate if CTL's DNS is being used by the customer", "Validate CTL's DNS",params2);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CHANGE_DNS, "Instruct customer to change DNS to CTL's DNS", "Change DNS to CTL's DNS",params2);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_NON_CTL_SITE, "Verify if customer can surf to non-CTL site", "Verify Can Surf Non CTL's Site",params2);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_ESCALATE_TO_TECH_LEAD, "Escalate to Tech Lead", "Escalate to Tech Lead",null);

        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}
	
	@Test
	public void test_AgentAccess_ValidateCTLDNS_ChangeDNS_VerifyNonCTLSiteFlow() {
    	Map<String, Object> params1 = getInputTrueParams();
    	Map<String, Object> params2 = getInputFalseParams();
    	
    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseOneSiteFlow", params1);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_AGENT_ABLE_TO_ACCESS, "Verify if you (Agent) are able to access the site", "Verify Agent Able To Access",params1);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VALIDATE_CTL_DNS_USED, "Validate if CTL's DNS is being used by the customer", "Validate CTL's DNS",params2);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CHANGE_DNS, "Instruct customer to change DNS to CTL's DNS", "Change DNS to CTL's DNS",params2);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_NON_CTL_SITE, "Verify if customer can surf to non-CTL site", "Verify Can Surf Non CTL's Site",params1);

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
	*/
}