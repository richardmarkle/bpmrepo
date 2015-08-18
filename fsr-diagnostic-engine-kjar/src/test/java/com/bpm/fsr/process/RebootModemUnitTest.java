package com.bpm.fsr.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;

import com.bpm.fsr.util.FSRActionUtil;

public class RebootModemUnitTest extends FSRProcessJunitBaseTestCase {/*

	@Test
	public void test_InstructCustomer_Flow() {
    	Map<String, Object> params = getInputParams();

    	ProcessInstance processInstance = ksession.startProcess("com.bpm.fsr.process.subprocess.RebootModem", params);
		ksession.fireAllRules();
        
        assertNotNull(processInstance);
        //completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_INSTRUCT_CUSTOMER_TO_REBOOT, "Instruct customer to reboot modem", "Instruct Customer to Reboot Modem",params);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_INSTRUCT_AGENT_TO_REBOOT, "Instruct agent to reboot modem (ACS)", "Instruct Agent to Reboot Modem (ACS)",params);
        completeDisplayNextBestAction(processInstance, "krisv", FSRActionUtil.RM_VERIFY_POWERCYCLE, "Verify with customer powercycle is complete", "Verify Powercycle is Complete",params);
        assertProcessInstanceCompleted(processInstance.getId(), ksession);		
	}

	private Map<String, Object> getInputParams() {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("agentName", "krisv");
    	params.put("userOption", true);

    	return params;
	}
	
*/}