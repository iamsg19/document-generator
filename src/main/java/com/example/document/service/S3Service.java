package com.example.document.service;

import com.example.document.model.ProductTemplateMetaData;
import com.example.document.model.ProposalFormTemplates;
import com.example.document.model.ProposalFormThyemleafTemplates;
import com.example.document.repository.ProposalFormTemplateRepository;
import com.example.document.repository.ProposalFormThyemleafTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class S3Service {

    @Autowired
    private ProposalFormTemplateRepository proposalFormTemplateRepository;

    @Autowired
    private ProposalFormThyemleafTemplateRepository proposalFormThyemleafTemplateRepository;

    public String getTemplateContent(String templateFile, String productType) {
        try {
            ProposalFormTemplates template = proposalFormTemplateRepository.findByProductType(productType).orElseThrow(()-> new RuntimeException("Product Not Supported"));

//            ClassPathResource resource = new ClassPathResource("templates/" + templateFile);
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
//                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
//            }
            return template.getTemplateBody();
        } catch (Exception e) {
            throw new RuntimeException("Error reading template file: " + templateFile, e);
        }
    }

    public String getTemplateContentForThyemleaf(String productType) {
        try {
            ProposalFormThyemleafTemplates template = proposalFormThyemleafTemplateRepository.findByProductType(productType).orElseThrow(()-> new RuntimeException("Product Not Supported"));

//            ClassPathResource resource = new ClassPathResource("templates/" + templateFile);
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
//                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
//            }
            return template.getTemplateBody();
        } catch (Exception e) {
            throw new RuntimeException("Error reading template file: ", e);
        }
    }
}
