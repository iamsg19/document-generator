package com.example.document.repository;

import com.example.document.model.ProductTemplateMetaData;
import com.example.document.model.ProposalFormTemplates;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProposalFormTemplateRepository extends MongoRepository<ProposalFormTemplates, String> {
    Optional<ProposalFormTemplates> findByProductType(String productType);

}
