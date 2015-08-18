package com.bpm.fsr.rules;

import org.junit.Test;

import com.bpm.fsr.model.OptOutButtonRuleFact;

public class OptOutButtonRuleUnitTest extends FSRRulesJunitBaseTestCase {

	@Test
	public void testOptOutButtonWallGardern() {

		OptOutButtonRuleFact optOutButtonRuleFact = new OptOutButtonRuleFact();
		optOutButtonRuleFact.setInWalledGarden(true);

		ksession.insert(optOutButtonRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertEquals(null, optOutButtonRuleFact.getOptOutButtonText());

	}

	@Test
	public void testOptOutButtonKnownOutage() {

		OptOutButtonRuleFact optOutButtonRuleFact = new OptOutButtonRuleFact();
		optOutButtonRuleFact.setOutageExists(true);

		ksession.insert(optOutButtonRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertEquals(null, optOutButtonRuleFact.getOptOutButtonText());
	}

	@Test
	public void testOptOutButtonNull() {

		OptOutButtonRuleFact optOutButtonRuleFact = new OptOutButtonRuleFact();

		ksession.insert(optOutButtonRuleFact);
		ksession.fireAllRules();
		ksession.dispose();

		assertEquals("Opt Out", optOutButtonRuleFact.getOptOutButtonText());
	}
}
