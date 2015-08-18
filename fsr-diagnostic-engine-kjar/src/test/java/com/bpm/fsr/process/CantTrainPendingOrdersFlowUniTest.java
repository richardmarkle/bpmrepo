package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

public class CantTrainPendingOrdersFlowUniTest extends FSRProcessJunitBaseTestCase{
	
	/*@Test
	public void testCantTrainFlow_FutureDD() {
		Map<String, Object> params = getInputParams();
		 
		 System.out.println("*****testCantTrainFlow_FutureDD********");
    	ProcessInstance processInstance = ksession.startProcess("CantTrainPendingOrders", params);
    	testRecommendPendingOrder_ImpactFutureDD_Send_care(processInstance);
		ksession.fireAllRules();
		
		
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	@Test
	public void testCantTrainFlow_ImpactTodayDD() {
		Map<String, Object> params = getInputParams();
		 
		System.out.println("*****testCantTrainFlow_ImpactTodayDD****");
    	ProcessInstance processInstance = ksession.startProcess("CantTrainPendingOrders", params);
    	ksession.fireAllRules();
    	testRecommendPendingOrder_ImpactTodayDD_Resolve_ticket(processInstance);
		
		
		
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	@Test
	public void testCantTrainFlow_ImpactTodayDD_SendCare() {
		Map<String, Object> params = getInputParams();
		 
		System.out.println("*****testCantTrainFlow_ImpactTodayDD_SendCare****");
    	ProcessInstance processInstance = ksession.startProcess("CantTrainPendingOrders", params);
    	ksession.fireAllRules();
    	testRecommendPendingOrder_ImpactTodayDD_Resolve_Sendcare(processInstance);
		
		
		
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	@Test
	public void testCantTrainFlow_ImpactTodayDD_LocalAdviseCustomer() {
		Map<String, Object> params = getInputParams();
		 
		System.out.println("*****testCantTrainFlow_ImpactTodayDD_LocalAdviseCustomer****");
    	ProcessInstance processInstance = ksession.startProcess("CantTrainPendingOrders", params);
    	ksession.fireAllRules();
    	testRecommendPendingOrder_ImpactTodayDD_Local_AdviseCustomer(processInstance);
		
		
		
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	@Test
	public void testCantTrainFlow_NonImpactTodayDD() {
		Map<String, Object> params = getInputParams();
		 
		System.out.println("*****testCantTrainFlow_NonImpactTodayDD****");
    	ProcessInstance processInstance = ksession.startProcess("CantTrainPendingOrders", params);
    	ksession.fireAllRules();
    	testRecommendPendingOrder_NonImpactTodayDD_Provision(processInstance);
		
		
		
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	@Test
	public void testCantTrainFlow_CompleteOrder() {
		Map<String, Object> params = getInputParams();
		 
		System.out.println("*****testCantTrainFlow_CompleteOrder****");
    	ProcessInstance processInstance = ksession.startProcess("CantTrainPendingOrders", params);
    	ksession.fireAllRules();
    	testRecommendPendingOrder_CompleteOrder(processInstance);
		
			
        assertProcessInstanceCompleted(processInstance.getId(), ksession);	
	}
	
	
	 private static Map<String, Object> getInputParams() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	params.put("agentName", "krisv");
	    	 return params;
		}
	 
	 private static  Map<String, Object> getInputOptionParams() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	//params.put("agentName", "krisv");
	    	//params.put("optionChosen","Yes");
	    	params.put("dropDownChoice","Impact Future DD or Past DD");
	    	//params.put("outageType", "HSI");    	

	    	return params;
		}
	 private static  Map<String, Object> getInputOptionParams1() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	
	    	params.put("dropDownChoice","Impact Today DD");
	    	

	    	return params;
		}
	 private static  Map<String, Object> getInputOptionParams2() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	
	    	params.put("dropDownChoice","Non-Impact Today DD");
	    	

	    	return params;
		}
	 private static  Map<String, Object> getInputOptionParams3() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	
	    	params.put("dropDownChoice","Complete order");
	    	

	    	return params;
		}
	 
	 private static  Map<String, Object> getInputTrueParams() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	
	    	params.put("optionChosen","Yes");
	    	
	    	return params;
		}
	 private static  Map<String, Object> getInputFalseParams() {
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	
	    	params.put("optionChosen","No");
	    	
	    	return params;
		}
	 
	 
	 public static void testRecommendPendingOrder_ImpactFutureDD_Send_care(ProcessInstance processInstance)
	 {
		
		 completeDisplayNextBestAction(processInstance, "krisv", "Investigate order due date and impact", "Investigate order due date and impact",getInputOptionParams());
		 completeDisplayNextBestAction(processInstance, "krisv", "Send to Care if customer would like to discuss issue further", "Send to Care to discuss Issue Further",getInputOptionParams());
	 }
	 
	 public static void testRecommendPendingOrder_ImpactTodayDD_Resolve_ticket(ProcessInstance processInstance)
	 {
		
		 completeDisplayNextBestAction(processInstance, "krisv", "Investigate order due date and impact", "Investigate order due date and impact",getInputOptionParams1());
		 completeDisplayNextBestAction(processInstance, "krisv", "Verify if tech dispatch needed", "Verify If the customer Tech dispatch needed",getInputTrueParams());
		 completeDisplayNextBestAction(processInstance, "krisv", "Check WMT for tech visit details and ask customer if  scheduled visit is sufficient to resolve his/her issues", "Check WMTand ask customer If that visit sufficient to resolve the issues",getInputTrueParams());
		 
	 }
	 
	 public static void testRecommendPendingOrder_ImpactTodayDD_Resolve_Sendcare(ProcessInstance processInstance)
	 {
		
		 completeDisplayNextBestAction(processInstance, "krisv", "Investigate order due date and impact", "Investigate order due date and impact",getInputOptionParams1());
		 completeDisplayNextBestAction(processInstance, "krisv", "Verify if tech dispatch needed", "Verify If the customer Tech dispatch needed",getInputTrueParams());
		 completeDisplayNextBestAction(processInstance, "krisv", "Check WMT for tech visit details and ask customer if  scheduled visit is sufficient to resolve his/her issues", "Check WMTand ask customer If that visit sufficient to resolve the issues",getInputFalseParams());
		 completeDisplayNextBestAction(processInstance, "krisv", "Send to Care if customer would like to discuss issue further", "Send to Care to discuss Issue Further",getInputTrueParams());
		 
	 }
	 
	 public static void testRecommendPendingOrder_ImpactTodayDD_Local_AdviseCustomer(ProcessInstance processInstance)
	 {
		
		 completeDisplayNextBestAction(processInstance, "krisv", "Investigate order due date and impact", "Investigate order due date and impact",getInputOptionParams1());
		 completeDisplayNextBestAction(processInstance, "krisv", "Verify if tech dispatch needed", "Verify If the customer Tech dispatch needed",getInputFalseParams());
		 completeDisplayNextBestAction(processInstance, "krisv", "Advise customer order will be completed by 8 PM or earlier", "Advise the customer about order completion by 5PM",getInputTrueParams());
		 
	 }
	 public static void testRecommendPendingOrder_NonImpactTodayDD_Provision(ProcessInstance processInstance)
	 {
		
		 completeDisplayNextBestAction(processInstance, "krisv", "Investigate order due date and impact", "Investigate order due date and impact",getInputOptionParams2());
		 completeDisplayNextBestAction(processInstance, "krisv", "Advise customer order will be completed by 8 PM or earlier", "Advise the customer about order completion by 8PM",getInputTrueParams());
		 
		 
	 }
	 public static void testRecommendPendingOrder_CompleteOrder(ProcessInstance processInstance)
	 {
		
		 completeDisplayNextBestAction(processInstance, "krisv", "Investigate order due date and impact", "Investigate order due date and impact",getInputOptionParams3());
		
	 }*/
	 
}
