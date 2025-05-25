package com.example.document.strategy;

import com.example.document.converter.DocumentConverter;
import com.example.document.converter.DocumentFormat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class HtmlConversionContext {

    private final Map<DocumentFormat, DocumentConverter> converterMap;

    public HtmlConversionContext(List<DocumentConverter> converters) {
        this.converterMap = converters.stream()
                .collect(Collectors.toMap(DocumentConverter::getFormat, Function.identity()));
    }

    public byte[] convertHtml(String htmlContent, DocumentFormat format) {
        DocumentConverter converter = converterMap.get(format);
        if (converter == null) {
            throw new IllegalArgumentException("Unsupported format: " + format);
        }
        return converter.convert(htmlContent);
    }
}