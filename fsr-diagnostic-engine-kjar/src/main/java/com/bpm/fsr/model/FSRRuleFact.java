package com.bpm.fsr.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

@org.kie.api.definition.type.Label(value = "FSRRuleFact")
public class FSRRuleFact implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label(value = "Rule Result")
    @org.kie.api.definition.type.Position(value = 0)
    private boolean ruleResult = false;

    public FSRRuleFact() {
    }
    
    public FSRRuleFact(boolean ruleResult) {
        this.ruleResult = ruleResult;
    }

    public boolean isRuleResult() {
        return this.ruleResult;
    }
    
    public void setRuleResult(boolean ruleResult) {
        this.ruleResult = ruleResult;
    }

}