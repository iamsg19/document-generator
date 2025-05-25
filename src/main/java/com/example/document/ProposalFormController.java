package com.example.document;

import com.example.document.dto.ProposalRequest;
import com.example.document.service.ProposalFormByThyemleaf;
import com.example.document.service.ProposalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProposalFormController {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private ProposalFormByThyemleaf proposalFormByThyemleaf;

    @PostMapping("/generate")
    public ResponseEntity<String> generateForm(@RequestBody ProposalRequest request) throws JsonProcessingException {
        String formHtml = "";
        if("Yes".equalsIgnoreCase(request.getWithThyemleaf())){
            formHtml = proposalFormByThyemleaf.generateProposalForm(request);
        }else{
          formHtml  = proposalService.generateProposalForm(request);
        }
        return ResponseEntity.ok().body(formHtml);
    }
}
