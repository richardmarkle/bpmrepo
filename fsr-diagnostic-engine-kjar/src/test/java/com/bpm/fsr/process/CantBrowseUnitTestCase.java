
package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.bpm.fsr.util.FSRActionUtil;

public class CantBrowseUnitTestCase  extends FSRProcessJunitBaseTestCase{

	/* @Test
     public void testCantBrowseFlow_Wireless_Connect_Nonctlsite_Browse()
	 
	 {
		 System.out.println("*----------testcantBrowseFlow_Wireless_Connect_Nonctlsite_Browse-----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		   outputParams.put("deviceType_out",false);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("agentName","krisv");
	       outputParams1.put("IsConnected_out",true);
	       outputParams2.put("IsNonctlsite_out",true);
	       
	       ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse",params);
			ksession.fireAllRules();
  	   
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture the nature of browsing issue the customer is facing", "Capture the Browsing Issue",outputParams);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_TROUBLESHOOTING_WIRELESS, "Instruction for trouble shoot the wireless issue manually", "Wireless Manual Troubleshooting",outputParams1);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_SURF_NONCTLSITES, "Can able to surf non ctl sites on any one wireless device", "Verify to surf non ctl sites on wireless device",outputParams2);
	        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
     }
	 
	 @Test
     public void testCantBrowseFlow_Wireless_Connect_Nonctlsite_Unbrowse()
	 
	 {
		 System.out.println("*----------testCantBrowseFlow_Wireless_Connect_Nonctlsite_Unbrowse-----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		 Map<String, Object> outputParams3 = new HashMap<String, Object>();
		   outputParams.put("deviceType_out",false);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("agentName","krisv");
	       outputParams1.put("IsConnected_out",true);
	       outputParams2.put("IsNonctlsite_out",false);
	       outputParams2.put("agentName","krisv");
	       outputParams3.put("agentName","krisv");
	       outputParams3.put("IsBrowse_out",true);
	       
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse",params);
			ksession.fireAllRules();
  	   
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture  the nature of customer issue", "Capture the Browsing Issue",outputParams);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_TROUBLESHOOTING_WIRELESS, "Instruction for trouble shoot the wireless issue manually", "Wireless Manual Troubleshooting",outputParams1);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_SURF_NONCTLSITES, "Can able to surf non ctl sites on any one wireless device", "Verify to surf non ctl sites on wireless device",outputParams2);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_BROWSE_ONESITE_ALLSITES, "Verify with customer is unable to browse one site or all sites", "Verify to browse one site or all sites",outputParams3);
	        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
     }
	 
	 
	 @Test
     public void testCantBrowseFlow_Wireless_Connect_Nonctlsite_Unbrowse_Onesite()
	 
	 {
		 System.out.println("*----------testCantBrowseFlow_Wireless_Connect_Nonctlsite_Unbrowse_Onesite-----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		 Map<String, Object> outputParams3 = new HashMap<String, Object>();
		   outputParams.put("deviceType_out",false);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("agentName","krisv");
	       outputParams1.put("IsConnected_out",true);
	       outputParams2.put("IsNonctlsite_out",false);
	       outputParams2.put("agentName","krisv");
	       outputParams3.put("agentName","krisv");
	       outputParams3.put("IsBrowse_out",false);
	       
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse",params);
			ksession.fireAllRules();
  	   
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture  the nature of customer issue", "Capture the Browsing Issue",outputParams);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_TROUBLESHOOTING_WIRELESS, "Instruction for trouble shoot the wireless issue manually", "Wireless Manual Troubleshooting",outputParams1);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_SURF_NONCTLSITES, "Can able to surf non ctl sites on any one wireless device", "Verify to surf non ctl sites on wireless device",outputParams2);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_BROWSE_ONESITE_ALLSITES, "Verify with customer is unable to browse one site or all sites", "Verify to browse one site or all sites",outputParams3);
	        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
     }
	 
	 @Test
     public void testCantBrowseFlow_Wireless_OEM()
	 {
		 
		 System.out.println("*----------testCantBrowseFlow_Wireless_OEM-----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		   outputParams.put("deviceType_out",false);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("IsConnected_out",false);
	       outputParams1.put("agentName","krisv");
	       outputParams2.put("agentName","krisv");
	       	       	       		 
		    ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse", params);
			ksession.fireAllRules();
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture the nature of browsing issue the customer is facing", "Capture the Browsing Issue",outputParams);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_TROUBLESHOOTING_WIRELESS, "Instruction for trouble shoot the wireless issue manually", "Wireless Manual Troubleshooting",outputParams1);
	        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_REFER_CUSTOMER_TO_OEM, "Refer the customer to OEM", "Refer to OEM",outputParams2);
	        assertProcessInstanceCompleted(processInstance.getId(), ksession);
		 
		 
	 }
	 
	 
	 @Test
     public void testCantBrowseFlow_Wired_Browse_Allsite()
	 {
		 System.out.println("*----------testCantBrowseFlow_Wired_Browse_Allsite----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		   outputParams.put("deviceType_out",true);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("wiredDeviceConnection_out",true);
	       outputParams1.put("agentName","krisv");
	       outputParams2.put("agentName","krisv");
	       outputParams2.put("IsBrowse_out",true);
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse", params);
			ksession.fireAllRules();
			
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture  the nature of customer issue", "Capture the Browsing Issue",outputParams);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_CONNECT_DEVICE, "Verify the customer is currently connected to a wired device", "Verify  conncection with wired device",outputParams1);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_BROWSE_ONESITE_ALLSITES, "Verify with customer is unable to browse one site or all sites", "Verify to browse one site or all sites",outputParams2);
	       	assertProcessInstanceCompleted(processInstance.getId(), ksession);
	 }
		 
	 
	 @Test
     public void testCantBrowseFlow_Wired_Browse_Onesite()
	 {
		 System.out.println("*----------testCantBrowseFlow_Wired_Browse_Onesite----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		   outputParams.put("deviceType_out",true);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("wiredDeviceConnection_out",true);
	       outputParams1.put("agentName","krisv");
	       outputParams2.put("agentName","krisv");
	       outputParams2.put("IsBrowse_out",false);
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse", params);
			ksession.fireAllRules();
			
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture  the nature of customer issue", "Capture the Browsing Issue",outputParams);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_CONNECT_DEVICE, "Verify the customer is currently connected to a wired device", "Verify  conncection with wired device",outputParams1);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_BROWSE_ONESITE_ALLSITES, "Verify with customer is unable to browse one site or all sites", "Verify to browse one site or all sites",outputParams2);
	       	assertProcessInstanceCompleted(processInstance.getId(), ksession);
	 }
	 
	 
	 @Test
     public void testCantBrowseFlow_Wired_Modem_Browse_Allsite()
	 {
		 System.out.println("*----------testCantBrowseFlow_Wired_Modem_Browse_Allsite----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		 Map<String, Object> outputParams3 = new HashMap<String, Object>();
		   outputParams.put("deviceType_out",true);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("wiredDeviceConnection_out",false);
	       outputParams1.put("agentName","krisv");
	       outputParams2.put("agentName","krisv");
	       outputParams2.put("IsBrowse_out",true);
	       outputParams3.put("agentName","krisv");
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse", params);
			ksession.fireAllRules();
			
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture  the nature of customer issue", "Capture the Browsing Issue",outputParams);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_CONNECT_DEVICE, "Verify the customer is currently connected to a wired device", "Verify  conncection with wired device",outputParams1);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_INSTRUCTION_TOCONNECT_MODEM, "Instruct customer to connect device to modem", "Instruct to connect device to modem",outputParams3);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_BROWSE_ONESITE_ALLSITES, "Verify with customer is unable to browse one site or all sites", "Verify to browse one site or all sites",outputParams2);
	       	assertProcessInstanceCompleted(processInstance.getId(), ksession);
	 }
	 
	 
	 @Test
     public void testCantBrowseFlow_Wired_Modem_Browse_Onesite()
	 {
		 System.out.println("*----------testCantBrowseFlow_Wired_Modem_Browse_Onesite----------*");
		 Map<String, Object> params = getInputParams();
		 Map<String, Object> outputParams = new HashMap<String, Object>();
		 Map<String, Object> outputParams1 = new HashMap<String, Object>();
		 Map<String, Object> outputParams2 = new HashMap<String, Object>();
		 Map<String, Object> outputParams3 = new HashMap<String, Object>();
		 outputParams.put("deviceType_out",true);
		   outputParams.put("agentName","krisv");
	       outputParams1.put("wiredDeviceConnection_out",false);
	       outputParams1.put("agentName","krisv");
	       outputParams2.put("agentName","krisv");
	       outputParams2.put("IsBrowse_out",false);
	       outputParams3.put("agentName","krisv");
	        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.CantBrowse", params);
			ksession.fireAllRules();
			
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE, "Capture  the nature of customer issue", "Capture the Browsing Issue",outputParams);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_CONNECT_DEVICE, "Verify the customer is currently connected to a wired device", "Verify  conncection with wired device",outputParams1);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_VERIFY_INSTRUCTION_TOCONNECT_MODEM, "Instruct customer to connect device to modem", "Instruct to connect device to modem",outputParams3);
			completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.CB_CONFIRM_CUSTOMER_BROWSE_ONESITE_ALLSITES, "Verify with customer is unable to browse one site or all sites", "Verify to browse one site or all sites",outputParams2);
	       	assertProcessInstanceCompleted(processInstance.getId(), ksession);
	 }
	 
	private Map<String, Object> getInputParams() {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	 return params;
	}*/
}
