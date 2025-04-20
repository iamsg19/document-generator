package com.example.document.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proposal_form_templates")
public class ProposalFormTemplates {
    private String productType;
    private String templateBody;
    private String templateVersion;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTemplateBody() {
        return templateBody;
    }

    public void setTemplateBody(String templateBody) {
        this.templateBody = templateBody;
    }

    public String getTemplateVersion() {
        return templateVersion;
    }

    public void setTemplateVersion(String templateVersion) {
        this.templateVersion = templateVersion;
    }
}
