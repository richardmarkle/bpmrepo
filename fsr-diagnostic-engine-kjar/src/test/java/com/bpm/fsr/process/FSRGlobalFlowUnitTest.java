package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.bpm.fsr.util.FSRActionUtil;
import com.bpm.fsr.util.FSRProcessVariables;

public class FSRGlobalFlowUnitTest extends FSRProcessJunitBaseTestCase {/*

	@Test
	public void testFsrGlobalFlowUnsupportedProduct() {
    	Map<String, Object> params = getInputParams("POTS", "777779999");
        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.fsrGlobalFlow", params);
		ksession.fireAllRules();

        assertNotNull(processInstance);
        //assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}

	@Test
	public void testNoKnownOutages() {
    	Map<String, Object> params = getInputParams("HSI", "777779999");
		
        ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.fsrGlobalFlow", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        testNodeTriggered(processInstance, "KnownOutages");
        //assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}	

	private Map<String, Object> getInputParams(String product, String telephoneNumber) {
		
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put(FSRProcessVariables.IN_ACCOUNT_NUMBER, "123457800");
        params.put(FSRProcessVariables.IN_ACCOUNT_TYPE, "EN");
        params.put(FSRProcessVariables.IN_AGENT_NAME, "krisv");        
        params.put(FSRProcessVariables.IN_CALL_REASON, "test reason");        
        params.put(FSRProcessVariables.IN_PRODUCT, product);        
        params.put(FSRProcessVariables.IN_TELEPHONE_NUMBER, telephoneNumber);
        params.put(FSRProcessVariables.PROCESS_MOCK, "KOA");        
        
        return params;
	}
*/}