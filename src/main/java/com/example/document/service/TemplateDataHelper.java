package com.example.document.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class TemplateDataHelper {

    private final ObjectMapper objectMapper;

    public TemplateDataHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Context buildThymeleafContextFromData(Object rawData) {
        try {
            // Convert POJO to Map
            String json = objectMapper.writeValueAsString(rawData);
            Map<String, Object> templateData = objectMapper.readValue(
                    json, new TypeReference<Map<String, Object>>() {}
            );

            Context context = new Context();
            context.setVariable("data", templateData);
            return context;

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while processing template data", e);
        }
    }
}
