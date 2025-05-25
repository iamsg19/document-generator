package com.example.document.strategy;

import com.example.document.model.ProposalFormThyemleafTemplates;
import com.example.document.repository.ProposalFormThyemleafTemplateRepository;
import org.springframework.stereotype.Service;

@Service
public class DatabaseTemplateSource implements TemplateSourceStrategy {

    private final ProposalFormThyemleafTemplateRepository repository;

    public DatabaseTemplateSource(ProposalFormThyemleafTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(String sourceType) {
        return "db".equalsIgnoreCase(sourceType);
    }

    @Override
    public String getTemplate(String productType) {
        return repository.findByProductType(productType)
                .map(ProposalFormThyemleafTemplates::getTemplateBody)
                .orElseThrow(() -> new RuntimeException("Template not found in DB for product type: " + productType));
    }
}
