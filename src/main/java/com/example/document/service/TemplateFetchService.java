package com.example.document.service;

import com.example.document.strategy.TemplateSourceContext;
import org.springframework.stereotype.Service;

@Service
public class TemplateFetchService {

    private final TemplateSourceContext templateSourceContext;

    public TemplateFetchService(TemplateSourceContext templateSourceContext) {
        this.templateSourceContext = templateSourceContext;
    }

    public String getTemplateContent(String sourceType, String templateIdentifier) {
        return templateSourceContext.getTemplate(sourceType, templateIdentifier);
    }
}
