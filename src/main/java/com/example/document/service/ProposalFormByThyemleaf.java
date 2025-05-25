package com.example.document.service;

import com.example.document.dto.ProposalRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProposalFormByThyemleaf {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private TemplateFetchService templateFetchService;

    @Autowired
    private TemplateDataHelper templateDataHelper;

    public String generateProposalForm(ProposalRequest request) throws JsonProcessingException {

        String templateHtml = templateFetchService.getTemplateContent("db", request.getProductCode());

        Context context = templateDataHelper.buildThymeleafContextFromData(request.getData());
        // Process the template using Thymeleaf
        return templateEngine.process(templateHtml, context);
    }
}
