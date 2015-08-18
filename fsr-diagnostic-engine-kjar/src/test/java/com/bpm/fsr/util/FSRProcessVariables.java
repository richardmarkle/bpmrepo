package com.bpm.fsr.util;

public class FSRProcessVariables {

	//input variables to start the global flow
	public static final String IN_AGENT_NAME = "agentName";
	public static final String IN_TELEPHONE_NUMBER = "telephoneNumber"; 
	public static final String IN_ACCOUNT_NUMBER = "accountNumber";
	public static final String IN_BILLING_TELEPHONE_NUMBER = "billingTelephoneNumber";
	public static final String IN_CUSTOMER_CODE = "customerCode";
	public static final String IN_PRODUCT = "product";
	public static final String IN_CALL_REASON = "callReason";
	public static final String IN_ACCOUNT_TYPE = "accountType";
	public static final String PROCESS_MOCK = "processMock";
	
	//process variables used in business process
	public static final String IN_MODEM_SUPPORTED = "isModemSupported";
	public static final String IN_MODEM_CONNECTED= "isModemConnected";
	public static final String IN_MODEM_STATUS = "modemStatus";
	public static final String IN_BRIDGE_MODE = "isInBridgeMode";
	public static final String IN_LCRIS_WITH_SIP = "isLcrisWithSip";
	public static final String IN_NON_CTL_SITE_SURFABLE = "isNonCTLSiteSurfable";
}
