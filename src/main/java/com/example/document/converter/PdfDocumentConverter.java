package com.example.document.converter;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class PdfDocumentConverter implements DocumentConverter {

    @Override
    public byte[] convert(String htmlContent) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withHtmlContent(htmlContent, null);
        builder.toStream(out);
        try {
            builder.run();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("PDF generation failed", e);
        }
    }

    @Override
    public DocumentFormat getFormat() {
        return DocumentFormat.PDF;
    }
}

