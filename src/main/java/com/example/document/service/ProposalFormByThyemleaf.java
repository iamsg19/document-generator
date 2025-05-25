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
    private S3Service s3Service;

    public String generateProposalForm(ProposalRequest request) throws JsonProcessingException {

        String templateHtml = s3Service.getTemplateContentForThyemleaf(request.getProductCode());

        // Prepare Thymeleaf context with dynamic data
        Context context = new Context();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(request.getData());
        Map<String, Object> templateData = null;
        try {
            templateData = objectMapper.readValue(
                    jsonRequest,
                    new TypeReference<Map<String, Object>>() {}
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        context.setVariable("data", templateData);
        String template = templateHtml;
        // Process the template using Thymeleaf
        return templateEngine.process(template, context);
    }
}
