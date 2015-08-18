package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.bpm.fsr.util.FSRActionUtil;

public class BridgeModeFlowUnitTest extends FSRProcessJunitBaseTestCase {/*
	@Test
	public void testBridgeModeFlow_PowerCysle_IssueSolve_Ticket() {
		Map<String, Object> params = getInputParams();
		 
		 Map<String, Object> params1 = getInputTrueParams();
    	

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.BridgeMode", params);
		ksession.fireAllRules();
		
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_VERIFY_POWER_CYCLE_ALL_EQUIPMENTS, "Instruct customer to power cycle all equipments behind modem and check Whether issue is solved", "Verify Power Cycle all Equipment behind Modem and Issue Solve",params1);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	@Test
	public void testBridgeModeFlow_PowerCysle_Issue_UnSolve_OffBridge_Reboot() {
		Map<String, Object> params = getInputParams();
		 
	
		 Map<String, Object> params1 = getInputTrueParams();
		 Map<String, Object> params2 = getInputFalseParams();

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.BridgeMode", params);
		ksession.fireAllRules();
		
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_VERIFY_POWER_CYCLE_ALL_EQUIPMENTS, "Instruct customer to power cycle all equipments behind modem and check Whether issue is solved", "Verify Power Cycle all Equipment behind Modem and Issue Solve",params2);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_CONFIRM_CUSTOMER_OUTOF_BRIDGEMODE, "Verify if the customer wants to taken out of bridge mode", "Like to Taken Modem out of Brigdged Mode",params1);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_INSTRUCT_CUSTOMER_ABOUT_OUTOF_BRIDGEMODE, "Instruct the customer to manually take modem out of bridge mode and verify the configuration back in default setting.", "Manually taken modem out of bridge mode and set default setting",params2);
		assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	
	@Test
	public void testBridgeModeFlow_PowerCysle_Issue_UnSolve_InBridge_LeaseCTLModem() {
		Map<String, Object> params = getInputParams();
		 
	
		 Map<String, Object> params1 = getInputTrueParams();
		 Map<String, Object> params2 = getInputFalseParams();

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.BridgeMode", params);
		ksession.fireAllRules();
		
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_VERIFY_POWER_CYCLE_ALL_EQUIPMENTS, "Instruct customer to power cycle all equipments behind modem and check Whether issue is solved", "Verify Power Cycle all Equipment behind Modem and Issue Solve",params2);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_CONFIRM_CUSTOMER_OUTOF_BRIDGEMODE, "Verify if the customer wants to taken out of bridged mode", "Like to Taken Modem out of Bridged Mode",params1);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_INSTRUCT_CUSTOMER_ABOUT_OUTOF_BRIDGEMODE, "Instruct the customer to manually take modem out of bridged mode and verify the configuration back in default setting.Provide Instruction on how customer can get back into bridged mode later. ", "Manually taken modem out of bridge mode and set default setting",params1);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_CONFIRM_CUSTOMER_USE_THIRD_PARTY_MODEM, "Verify if customer is using third party modem.", "Verify if the Customer use thrid party modem",params1);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_VERIFY_CUSTOMER_TO_LEASE_CTLMODEM, "If customer would like to lease a CTL modem then refer to CARE else refer to device OEM.", "Verify the customer like to lease a CTL modem",params1);
		
		assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	@Test
	public void testBridgeModeFlow_PowerCysle_Issue_UnSolve_InBridge_FactoryReset() {
		Map<String, Object> params = getInputParams();
		 
	
		 Map<String, Object> params1 = getInputTrueParams();
		 Map<String, Object> params2 = getInputFalseParams();

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.BridgeMode", params);
		ksession.fireAllRules();
		
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_VERIFY_POWER_CYCLE_ALL_EQUIPMENTS, "Instruct customer to power cycle all equipments behind modem and check Whether issue is solved", "Verify Power Cycle all Equipment behind Modem and Issue Solve",params2);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_CONFIRM_CUSTOMER_OUTOF_BRIDGEMODE, "Verify if the customer wants to taken out of bridge mode", "Like to Taken Modem out of Brigdged Mode",params1);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_INSTRUCT_CUSTOMER_ABOUT_OUTOF_BRIDGEMODE, "Instruct the customer to manually take modem out of bridge mode and verify the configuration back in default setting.", "Manually taken modem out of bridge mode and set default setting",params1);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_CONFIRM_CUSTOMER_USE_THIRD_PARTY_MODEM, "Verify if customer is using third party modem.", "Verify if the Customer use thrid party modem",params2);
		//completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_VERIFY_CUSTOMER_TO_LEASE_CTLMODEM, "If customer would like to lease a CTL modem then refer to CARE else refer to device OEM.", "Verify the customer like to lease a CTL modem",params1);
		
		assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	@Test
	public void testBridgeModeFlow_PowerCysle_Issue_UnSolve_OutofBridge_ITPerson() {
		Map<String, Object> params = getInputParams();
		 
	
		 Map<String, Object> params1 = getInputTrueParams();
		 Map<String, Object> params2 = getInputFalseParams();

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.BridgeMode", params);
		ksession.fireAllRules();
		
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_VERIFY_POWER_CYCLE_ALL_EQUIPMENTS, "Instruct customer to power cycle all equipments behind modem and check Whether issue is solved", "Verify Power Cycle all Equipment behind Modem and Issue Solve",params2);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_CONFIRM_CUSTOMER_OUTOF_BRIDGEMODE, "Verify if the customer wants to taken out of bridged mode", "Like to Taken Modem out of Bridged Mode",params2);
		completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.BM_INSTRUCT_CUSTOMER_TO_CONTACT_ITPERSON, "Instruct the customer to contact the IT person that has setup their network.", "Contact IT person that has Setup this Network",params1);
		assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	
		 private Map<String, Object> getInputParams() {
		    	Map<String, Object> params = new HashMap<String, Object>();
		    	params.put("agentName", "krisv");
		    	 return params;
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

