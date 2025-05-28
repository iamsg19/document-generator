package com.example.document.strategy;

import com.example.document.service.S3Service;
import org.springframework.stereotype.Service;

@Service
public class S3TemplateSource implements TemplateSourceStrategy {

    private final S3Service s3Service;

    public S3TemplateSource(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Override
    public boolean supports(String sourceType) {
        return "dataFromS3".equalsIgnoreCase(sourceType);
    }

    @Override
    public String getTemplate(String key) {
        return s3Service.getTemplateContentByKey(key);
    }
}
