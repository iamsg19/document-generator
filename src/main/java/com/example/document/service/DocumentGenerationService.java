package com.example.document.service;

import com.example.document.converter.DocumentFormat;
import com.example.document.strategy.HtmlConversionContext;
import org.springframework.stereotype.Service;

@Service
public class DocumentGenerationService {

    private final HtmlConversionContext conversionContext;
    private final S3UploadService s3UploadService;

    public DocumentGenerationService(HtmlConversionContext conversionContext, S3UploadService s3UploadService) {
        this.conversionContext = conversionContext;
        this.s3UploadService = s3UploadService;
    }

    public byte[] generateAndUpload(String htmlContent, String s3Key, DocumentFormat format) {
        byte[] documentBytes = conversionContext.convertHtml(htmlContent, format);
        String contentType = getContentType(format);
        return documentBytes;
        //return s3UploadService.uploadDocument(documentBytes, s3Key, contentType);
    }

    private String getContentType(DocumentFormat format) {
        return switch (format) {
            case PDF -> "application/pdf";
            case EXCEL -> "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        };
    }
}
