package com.example.document.strategy;

public interface TemplateSourceStrategy {
    boolean supports(String sourceType);
    String getTemplate(String templateIdentifier);
}
