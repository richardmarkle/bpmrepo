package com.bpm.fsr.util;

public class FSRActionUtil {

	private FSRActionUtil() {
		
	}
	
	public static final String UNSUPPORTED_PRODUCT = "FSRG0001";

	public static final String KO_ADVISE_CUSTOMER = "KO0001";
	public static final String KO_VERIFY_CUSTOMER_NOTIFICATION = "KO0002";

	public static final String CB_CONFIRM_CAPTURE_ISSUE_DEVICE_TYPE ="CB0001";
	public static final String CB_CONFIRM_CUSTOMER_CONNECT_DEVICE = "CB0002";
	public static final String CB_CONFIRM_CUSTOMER_BROWSE_ONESITE_ALLSITES = "CB0003";
	public static final String CB_VERIFY_INSTRUCTION_TOCONNECT_MODEM = "CB0004";
	public static final String CB_CONFIRM_CUSTOMER_TROUBLESHOOTING_WIRELESS ="CB0005";
	public static final String CB_CONFIRM_CUSTOMER_SURF_NONCTLSITES = "CB0006";
	public static final String CB_REFER_CUSTOMER_TO_OEM ="CB0007";
	
	public static final String CB_BRIDGE_MODE_CALL = "CB0021";
	public static final String CB_MANUAL_ASSOCIATE_MODEM_CALL = "CB0022";
	public static final String CB_NON_CTL_SITE_SURFABLE_CALL = "CB0023";
	
	public static final String CB_VERIFY_AGENT_ABLE_TO_ACCESS = "CB0031";
	public static final String CB_VALIDATE_CTL_DNS_USED = "CB0032";
	public static final String CB_INSTRUCT_CUSTOMER_ABOUT_SITE = "CB0033";
	public static final String CB_ESCALATE_TO_TECH_LEAD = "CB0034";
	public static final String CB_CHANGE_DNS = "CB0035";
	public static final String CB_VERIFY_NON_CTL_SITE= "CB0036";

	public static final String CB_INSTRUCT_AGENT= "CB0061";
	public static final String CB_VERIFY_3RD_PARTY_ROUTER= "CB0062";
	public static final String CB_CONFIRM_BYPASS_ROUTER= "CB0063";
	public static final String CB_CONTACT_IT_PERSON= "CB0064";
	public static final String CB_INSTRUCTIONS_TO_BYPASS_ROUTER= "CB0065";
	
	public static final String RM_INSTRUCT_CUSTOMER_TO_REBOOT = "RM0001";
	public static final String RM_INSTRUCT_AGENT_TO_REBOOT = "RM0002";
	public static final String RM_VERIFY_POWERCYCLE = "RM0003";
	
	public static final String BM_VERIFY_POWER_CYCLE_ALL_EQUIPMENTS ="BM0001";
	public static final String BM_CONFIRM_CUSTOMER_OUTOF_BRIDGEMODE ="BM0002";
	public static final String BM_INSTRUCT_CUSTOMER_ABOUT_OUTOF_BRIDGEMODE ="BM0003";
	public static final String BM_INSTRUCT_CUSTOMER_TO_CONTACT_ITPERSON ="BM0004";
	public static final String BM_CONFIRM_CUSTOMER_USE_THIRD_PARTY_MODEM ="BM0005";
	public static final String BM_VERIFY_CUSTOMER_TO_LEASE_CTLMODEM ="BM0006";
	public static final String BM_MANUALLY_CONFIGURE_MODEM ="BM0007";
	public static final String BM_FACTORY_RESET_UNSUCCESSFUL ="BM0008";
	
}