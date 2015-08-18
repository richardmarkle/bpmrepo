package com.bpm.fsr.rules;

import org.junit.Test;

import com.bpm.fsr.model.ModemProtocolRuleFact;

public class ModemProtocolRuleUnitTest extends FSRRulesJunitBaseTestCase {
	@Test
	public void testModemProtocolCRISIPoERule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("CRIS");
		modemProtocolRuleFact.setBbcosPresent(false);
		modemProtocolRuleFact.setProtocol("IPoE");
		modemProtocolRuleFact.setImprovStaticIPPresent(false);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getiPoE());
	}

	@Test
	public void testModemProtocolCRISDHCPRule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("CRIS");
		modemProtocolRuleFact.setBbcosPresent(false);
		modemProtocolRuleFact.setProtocol("DHCP");
		modemProtocolRuleFact.setImprovStaticIPPresent(false);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getiPoE());
	}

	@Test
	public void testModemProtocolENSDHCPRule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("DHCP");
		modemProtocolRuleFact.setImprovStaticIPPresent(false);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getiPoE());
	}

	@Test
	public void testModemProtocolENSIPoERule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("IPoE");
		modemProtocolRuleFact.setImprovStaticIPPresent(false);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getiPoE());
	}

	@Test
	public void testModemProtocolCRISPPPoEPRule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("CRIS");
		modemProtocolRuleFact.setBbcosPresent(false);
		modemProtocolRuleFact.setProtocol("PPPoE");
		modemProtocolRuleFact.setPrismOnAccount(false);
		modemProtocolRuleFact.setImprovStaticIPPresent(false);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getlCRISPPPoE());
	}

	@Test
	public void testModemProtocolCRISPPPoEPFalseRule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("CRIS");
		modemProtocolRuleFact.setBbcosPresent(false);
		modemProtocolRuleFact.setProtocol("DHCP");
		modemProtocolRuleFact.setPrismOnAccount(false);
		modemProtocolRuleFact.setImprovStaticIPPresent(false);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertFalse(modemProtocolRuleFact.getlCRISPPPoE());
	}

	@Test
	public void testModemProtocolENSPPPoEPRuleZero() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("PPPoE");
		modemProtocolRuleFact.setIclIPQty(0);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getlENSPPPoE());
	}

	@Test
	public void testModemProtocolENSPPPoEPRuleGreaterZero() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("PPPoE");
		modemProtocolRuleFact.setIclIPQty(3);
		modemProtocolRuleFact.setMartensStaticIPpresent(true);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getlENSPPPoE());
	}

	@Test
	public void testModemProtocolENSPPPoEPFalseRule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("DHCP");
		modemProtocolRuleFact.setIclIPQty(3);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertFalse(modemProtocolRuleFact.getlENSPPPoE());
	}

	@Test
	public void testModemProtocolENSTrueSIPRuleZero() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("PPPoE");
		modemProtocolRuleFact.setMartensStaticIPpresent(true);
		modemProtocolRuleFact.setIclIPQty(0);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertFalse(modemProtocolRuleFact.getlENSTrueSip());
	}

	@Test
	public void testModemProtocolENSTrueSIPRuleGreaterZero() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("IPoE");
		modemProtocolRuleFact.setMartensStaticIPpresent(true);
		modemProtocolRuleFact.setIclIPQty(3);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertTrue(modemProtocolRuleFact.getlENSTrueSip());
	}

	@Test
	public void testModemProtocolENSTrueSIPFalseRule() {
		ModemProtocolRuleFact modemProtocolRuleFact = new ModemProtocolRuleFact();
		modemProtocolRuleFact.setLegacyMarket("Ensemble");
		modemProtocolRuleFact.setBbcosPresent(true);
		modemProtocolRuleFact.setProtocol("PPPoE");
		modemProtocolRuleFact.setMartensStaticIPpresent(true);
		modemProtocolRuleFact.setIclIPQty(3);

		ksession.insert(modemProtocolRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertFalse(modemProtocolRuleFact.getlENSTrueSip());
	}

}
