package com.example.document.service;

import com.example.document.converter.DocumentFormat;
import com.example.document.dto.ProposalRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class ProposalFormByThyemleaf {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private TemplateFetchService templateFetchService;

    @Autowired
    private TemplateDataHelper templateDataHelper;

    @Autowired
    private DocumentGenerationService documentGenerationService;

    public String generateProposalForm(ProposalRequest request) throws JsonProcessingException {

        String templateHtml = templateFetchService.getTemplateContent(request.getTemplateSource(), request.getProductCode());

        Context context = templateDataHelper.buildThymeleafContextFromData(request.getData());
        // Process the template using Thymeleaf
         String processedHtml = templateEngine.process(templateHtml, context);

        return documentGenerationService.generateAndUpload(processedHtml, "", DocumentFormat.PDF);
    }
}
