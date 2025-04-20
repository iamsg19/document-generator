package com.example.document.repository;

import com.example.document.model.ProductTemplateMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductTemplateRepository extends MongoRepository<ProductTemplateMetaData, String> {
    Optional<ProductTemplateMetaData> findByProductCode(String productCode);
}
