package com.bpm.fsr.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

@org.kie.api.definition.type.Label(value = "ProductRuleFact")
public class ProductRuleFact extends com.bpm.fsr.model.FSRRuleFact implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label(value = "product")
    @org.kie.api.definition.type.Position(value = 1)
    private java.lang.String product;

    public ProductRuleFact() {
    }
    
    public ProductRuleFact(java.lang.String product) {
        this.product = product;
    }

    public java.lang.String getProduct() {
        return this.product;
    }
    
    public void setProduct(java.lang.String product) {
        this.product = product;
    }

}