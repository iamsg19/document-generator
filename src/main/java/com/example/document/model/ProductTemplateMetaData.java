package com.example.document.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "product_templates")
public class ProductTemplateMetaData {
    @Id
    private String id;
    private String productCode;
    private String productName;
    private String templateFile;
    private List<String> placeHolders;

    public String getId() {
        return id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public List<String> getPlaceHolders() {
        return placeHolders;
    }

    public void setPlaceHolders(List<String> placeHolders) {
        this.placeHolders = placeHolders;
    }
}
