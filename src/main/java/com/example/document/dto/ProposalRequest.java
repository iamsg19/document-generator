package com.example.document.dto;

import java.util.Map;

public class ProposalRequest {
    private String productCode;
    private Map<String, String> data;

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
}
