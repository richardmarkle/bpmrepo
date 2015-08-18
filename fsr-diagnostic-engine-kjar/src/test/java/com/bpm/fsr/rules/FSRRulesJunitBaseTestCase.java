package com.bpm.fsr.rules;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.After;
import org.junit.Before;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;

public class FSRRulesJunitBaseTestCase extends JbpmJUnitBaseTestCase {

	protected RuntimeEngine engine = null;
	protected KieSession ksession = null;

	public FSRRulesJunitBaseTestCase() {
		super(true, false);
	}

	@After
	public void teardownRuntimeManager() {
		disposeRuntimeManager();
	}

	@Before
	public void initKsession() {
		Map<String, ResourceType> resources = new HashMap<String, ResourceType>();
		resources.put("\\rules\\supportedProduct.rdrl", ResourceType.RDRL);

		resources.put("\\rules\\ModemProtocolCRISIPoERule.rdrl",
				ResourceType.RDRL);
		resources.put("\\rules\\ModemProtocolENSIPoERule.rdrl",
				ResourceType.RDRL);

		resources.put("\\rules\\ModemProtocolCRISPPPoERule.rdrl",
				ResourceType.RDRL);
		resources.put("\\rules\\ModemProtocolENSPPPoERule.rdrl",
				ResourceType.RDRL);
		resources.put("\\rules\\ModemProtocolENSTrueSIPRule.rdrl",
				ResourceType.RDRL);
		resources.put("\\rules\\optOutButtonRule.rdrl", ResourceType.RDRL);

		createRuntimeManager(resources, "rules-test");

		engine = getRuntimeEngine();
		assertNotNull(engine);

		ksession = engine.getKieSession();
		ksession.getAgenda().getAgendaGroup("validateProduct").setFocus();
		ksession.getAgenda().getAgendaGroup("ModemProtocolRule").setFocus();
		ksession.getAgenda().getAgendaGroup("optOutButtonRule").setFocus();
	}
}
