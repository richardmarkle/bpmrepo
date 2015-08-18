package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;

//import com.bpm.fsr.wih.ModemStatusWorkItemHandler;
//import com.bpm.fsr.wih.ModemSupportedWorkItemHandler;

public class CantBrowseAllSitesTest extends FSRProcessJunitBaseTestCase {

	/*@Test
	public void testModemSupported_NonBridgeMode_LcrisWithSip() {

		System.out.println("------------------------------testModemSupported_NonBridgeMode_LcrisWithSip--------------------------------------------");
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
       //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Connected");
        params.put("isModemConnected", true);
        //isLcrisWithSip
        params.put("isLcrisWithSip", true);
        params.put("legacyMarket", "Ensemble");

        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//Non-BridgedMode
		bridgeUserTaskOutputs.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	/*@Test
	public void testModemSupported_NonBridgeMode_NonLcrisWithSip() {
		
		System.out.println("----------------------------testModemSupported_NonBridgeMode_NonLcrisWithSip----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
        //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Connected");
        params.put("isModemConnected", true);
        //NonLcrisWithSip
        params.put("isLcrisWithSip", false);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//Non-BridgedMode
		bridgeUserTaskOutputs.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	/*@Test
	public void testModemSupported_ModemNotAssociated_NonBridgeMode_LcrisWithSip() {
		System.out.println("----------------------------testModemSupported_ModemNotAssociated_NonBridgeMode_LcrisWithSip----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
       //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Not Associated");
        params.put("isModemConnected", true);
        //isLcrisWithSip
        params.put("isLcrisWithSip", true);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		
		//Manually-Associate-Modem
		Map<String, Object> manuallyAssociateModemUserTaskOutputs = new HashMap<String, Object>();
		manuallyAssociateModemUserTaskOutputs.put("agentName","krisv");
		completeDisplayNextBestAction(processInstance,"krisv","CB0022","Instruct agent to manually associate modem in ACS","Instruct agent to manually associate modem in ACS",manuallyAssociateModemUserTaskOutputs);
		
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//Non-BridgedMode
		bridgeUserTaskOutputs.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	/*@Test
	public void testModemSupported_ModemNotAssociated_NonBridgeMode_NonLcrisWithSip() {
		System.out.println("---------------------------testModemSupported_ModemNotAssociated_NonBridgeMode_NonLcrisWithSip-----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
        //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Not Associated");
        params.put("isModemConnected", true);
        //NonLcrisWithSip
        params.put("isLcrisWithSip", false);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		
		//Manually-Associate-Modem
		Map<String, Object> manuallyAssociateModemUserTaskOutputs = new HashMap<String, Object>();
		manuallyAssociateModemUserTaskOutputs.put("agentName","krisv");
		completeDisplayNextBestAction(processInstance,"krisv","CB0022","Instruct agent to manually associate modem in ACS","Instruct agent to manually associate modem in ACS",manuallyAssociateModemUserTaskOutputs);
				
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//Non-BridgedMode
		bridgeUserTaskOutputs.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/*@Test
	public void testModemSupported_ModemAssociated_BridgeMode_Surfable() {
		
		System.out.println("----------------------------testModemSupported_ModemAssociated_BridgeMode_Surfable----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
        //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Connected");
        params.put("isModemConnected", true);
        //NonLcrisWithSip
        params.put("isLcrisWithSip", false);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//BridgedMode
		bridgeUserTaskOutputs.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		
		//nonCTLSiteSurfable
		Map<String, Object> nonCTLSiteSurfable = new HashMap<String, Object>();
		nonCTLSiteSurfable.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0023","Verify if customer can surf to non-CTL site","Verify if customer can surf to non-CTL site",nonCTLSiteSurfable);
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	/*@Test
	public void testModemSupported_ModemNotAssociated_BridgeMode_Surfable() {
		System.out.println("----------------------------testModemSupported_ModemNotAssociated_BridgeMode_Surfable----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
       //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Not Associated");
        params.put("isModemConnected", true);
        //isLcrisWithSip
        params.put("isLcrisWithSip", true);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		
		//Manually-Associate-Modem
		Map<String, Object> manuallyAssociateModemUserTaskOutputs = new HashMap<String, Object>();
		manuallyAssociateModemUserTaskOutputs.put("agentName","krisv");
		completeDisplayNextBestAction(processInstance,"krisv","CB0022","Instruct agent to manually associate modem in ACS","Instruct agent to manually associate modem in ACS",manuallyAssociateModemUserTaskOutputs);
		
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//BridgedMode
		bridgeUserTaskOutputs.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		
		//nonCTLSiteSurfable
		Map<String, Object> nonCTLSiteSurfable = new HashMap<String, Object>();
		nonCTLSiteSurfable.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0023","Verify if customer can surf to non-CTL site","Verify if customer can surf to non-CTL site",nonCTLSiteSurfable);
		
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	
	//**********************************************************************************************************************
	/*@Test
	public void testModemSupported_BridgeMode_NotSurfable_LcrisWithSip() {

		System.out.println("------------------------------testModemSupported_BridgeMode_NotSurfable_LcrisWithSip--------------------------------------------");
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
       //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Connected");
        params.put("isModemConnected", true);
        //isLcrisWithSip
        params.put("isLcrisWithSip", true);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		
		//Non-BridgedMode
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		bridgeUserTaskOutputs.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		
		//nonCTLSiteSurfable
		Map<String, Object> nonCTLSiteSurfable = new HashMap<String, Object>();
		nonCTLSiteSurfable.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0023","Verify if customer can surf to non-CTL site","Verify if customer can surf to non-CTL site",nonCTLSiteSurfable);
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	/*@Test
	public void testModemSupported_BridgeMode_NotSurfable_NonLcrisWithSip() {
		
		System.out.println("----------------------------testModemSupported_BridgeMode_NotSurfable_NonLcrisWithSip----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
        //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Connected");
        params.put("isModemConnected", true);
        //NonLcrisWithSip
        params.put("isLcrisWithSip", false);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//Non-BridgedMode
		bridgeUserTaskOutputs.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		
		//nonCTLSiteSurfable
		Map<String, Object> nonCTLSiteSurfable = new HashMap<String, Object>();
		nonCTLSiteSurfable.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0023","Verify if customer can surf to non-CTL site","Verify if customer can surf to non-CTL site",nonCTLSiteSurfable);
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	/*@Test
	public void testModemSupported_ModemNotAssociated_BridgeMode_NotSurfable_LcrisWithSip() {
		System.out.println("----------------------------testModemSupported_ModemNotAssociated_BridgeMode_NotSurfable_LcrisWithSip----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
       //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Not Associated");
        params.put("isModemConnected", true);
        //isLcrisWithSip
        params.put("isLcrisWithSip", true);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		
		//Manually-Associate-Modem
		Map<String, Object> manuallyAssociateModemUserTaskOutputs = new HashMap<String, Object>();
		manuallyAssociateModemUserTaskOutputs.put("agentName","krisv");
		completeDisplayNextBestAction(processInstance,"krisv","CB0022","Instruct agent to manually associate modem in ACS","Instruct agent to manually associate modem in ACS",manuallyAssociateModemUserTaskOutputs);
		
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//Non-BridgedMode
		bridgeUserTaskOutputs.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		
		//nonCTLSiteSurfable
		Map<String, Object> nonCTLSiteSurfable = new HashMap<String, Object>();
		nonCTLSiteSurfable.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0023","Verify if customer can surf to non-CTL site","Verify if customer can surf to non-CTL site",nonCTLSiteSurfable);
		
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
	/*@Test
	public void testModemSupported_ModemNotAssociated_BridgeMode_NotSurfable_NonLcrisWithSip() {
		System.out.println("---------------------------testModemSupported_ModemNotAssociated_BridgeMode_NotSurfable_NonLcrisWithSip-----------------------------------------------");

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("agentName", "krisv");
        //ModemSupported
        params.put("isModemSupported", true);
        params.put("modemStatus", "Not Associated");
        params.put("isModemConnected", true);
        //NonLcrisWithSip
        params.put("isLcrisWithSip", false);
		ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.CantBrowseAllSites",params);
		ksession.fireAllRules();
		assertNotNull(processInstance);
		
		//Manually-Associate-Modem
		Map<String, Object> manuallyAssociateModemUserTaskOutputs = new HashMap<String, Object>();
		manuallyAssociateModemUserTaskOutputs.put("agentName","krisv");
		completeDisplayNextBestAction(processInstance,"krisv","CB0022","Instruct agent to manually associate modem in ACS","Instruct agent to manually associate modem in ACS",manuallyAssociateModemUserTaskOutputs);
				
		Map<String, Object> bridgeUserTaskOutputs = new HashMap<String, Object>();
		//BridgedMode
		bridgeUserTaskOutputs.put("userOption",true);
		completeDisplayNextBestAction(processInstance,"krisv","CB0021","Verify from Customer if in Bridged Mode","Verify from Customer if in Bridged Mode",bridgeUserTaskOutputs);
		
		//nonCTLSiteSurfable
		Map<String, Object> nonCTLSiteSurfable = new HashMap<String, Object>();
		nonCTLSiteSurfable.put("userOption",false);
		completeDisplayNextBestAction(processInstance,"krisv","CB0023","Verify if customer can surf to non-CTL site","Verify if customer can surf to non-CTL site",nonCTLSiteSurfable);
				
		System.out.println("--------------------------------------------------------------------------");
		
	}*/
	
}