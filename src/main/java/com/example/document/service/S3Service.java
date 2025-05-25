package com.example.document.service;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

    public String getTemplateContentByKey(String templateFile) {
        try {
            return "<p>S3 Template</p>";
        } catch (Exception e) {
            throw new RuntimeException("Error reading template file: " + templateFile, e);
        }
    }
}
