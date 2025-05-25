package com.example.document.converter;

public interface DocumentConverter {
    byte[] convert(String htmlContent);
    DocumentFormat getFormat(); // Enum: PDF, EXCEL, etc.
}

