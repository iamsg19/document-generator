package com.example.document.repository;

import com.example.document.model.ProposalFormThyemleafTemplates;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProposalFormThyemleafTemplateRepository extends MongoRepository<ProposalFormThyemleafTemplates, String> {
    Optional<ProposalFormThyemleafTemplates> findByProductType(String productType);

}
