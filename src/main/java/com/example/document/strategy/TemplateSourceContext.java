package com.example.document.strategy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateSourceContext {

    private final List<TemplateSourceStrategy> strategies;

    public TemplateSourceContext(List<TemplateSourceStrategy> strategies) {
        this.strategies = strategies;
    }

    public String getTemplate(String sourceType, String templateIdentifier) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(sourceType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported template source: " + sourceType))
                .getTemplate(templateIdentifier);
    }
}
