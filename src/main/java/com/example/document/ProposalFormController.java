package com.example.document;

import com.example.document.dto.ProposalRequest;
import com.example.document.service.ProposalFormByThyemleaf;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProposalFormController {

    @Autowired
    private ProposalFormByThyemleaf proposalFormByThyemleaf;

    @PostMapping("/generate")
    public ResponseEntity<String> generateForm(@RequestBody ProposalRequest request) throws JsonProcessingException {
        String formHtml = proposalFormByThyemleaf.generateProposalForm(request);
        return ResponseEntity.ok().body(formHtml);
    }
}
