package com.example.document.dto;

import java.util.Map;

public class ProposalRequest {
    private String productCode;
    private Map<String, String> data;
    private String withThyemleaf;
    private String templateSource;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getWithThyemleaf() {
        return withThyemleaf;
    }

    public void setWithThyemleaf(String withThyemleaf) {
        this.withThyemleaf = withThyemleaf;
    }

    public String getTemplateSource() {
        return templateSource;
    }

    public void setTemplateSource(String templateSource) {
        this.templateSource = templateSource;
    }
}
