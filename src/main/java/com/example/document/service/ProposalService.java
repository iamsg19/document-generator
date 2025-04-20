package com.example.document.service;

import com.example.document.dto.ProposalRequest;
import com.example.document.model.ProductTemplateMetaData;
import com.example.document.repository.ProductTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProposalService {

    @Autowired
    private ProductTemplateRepository productTemplateRepository;

    @Autowired
    private S3Service s3Service;

    private static final String DEFAULT_VALUE = "NA";
    public String generateProposalForm(ProposalRequest request){
        ProductTemplateMetaData metaData = productTemplateRepository.findByProductCode(request.getProductCode()).orElseThrow(()-> new RuntimeException("Product Not Supported"));

        String template = s3Service.getTemplateContent(metaData.getTemplateFile(), metaData.getProductCode());
        String populated = template;

        Map<String, String> inputData = request.getData() != null ? request.getData() : new HashMap<>();

        // Regex to find all placeholders {{key}}
        Pattern pattern = Pattern.compile("\\{\\{(.*?)\\}\\}");
        Matcher matcher = pattern.matcher(template);

        Set<String> uniquePlaceholders = new HashSet<>();
        while (matcher.find()) {
            uniquePlaceholders.add(matcher.group(1).trim());  // Extract key inside {{ }}
        }

        // Replace all placeholders
        for (String key : uniquePlaceholders) {
            String value = inputData.getOrDefault(key, DEFAULT_VALUE);
            if ("null".equalsIgnoreCase(value) || value == null || value.trim().isEmpty()) {
                value = DEFAULT_VALUE;
            }
            populated = populated.replaceAll("\\{\\{" + Pattern.quote(key) + "\\}\\}", Matcher.quoteReplacement(value));
        }
        return populated;
    }
}
