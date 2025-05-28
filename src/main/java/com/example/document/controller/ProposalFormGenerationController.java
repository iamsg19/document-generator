package com.example.document.controller;

import com.example.document.dto.ProposalRequest;
import com.example.document.service.ProposalFormGenerationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProposalFormGenerationController {

    @Autowired
    private ProposalFormGenerationService proposalFormGenerationService;

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateForm(@RequestBody ProposalRequest request) throws JsonProcessingException {

        return ResponseEntity.ok().body(proposalFormGenerationService.generateProposalForm(request));
    }
}
