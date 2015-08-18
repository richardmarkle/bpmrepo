package com.bpm.fsr.rules;

import org.junit.Test;

import com.bpm.fsr.model.ProductRuleFact;


public class SelectedProductUnitTest extends FSRRulesJunitBaseTestCase {	
	
	@Test
	public void testSupportedProduct() {
		ProductRuleFact ruleResult = new ProductRuleFact();
		ruleResult.setProduct("HSI");
		ksession.insert(ruleResult);
		ksession.fireAllRules();
		ksession.dispose();
		
		assertTrue(ruleResult.isRuleResult());
	}

	@Test
	public void testUnSupportedProduct() {
		ProductRuleFact ruleResult = new ProductRuleFact();
		ruleResult.setProduct("POTS");
		ksession.insert(ruleResult);
		ksession.fireAllRules();
		ksession.dispose();
		assertFalse(ruleResult.isRuleResult());
	}
		
}