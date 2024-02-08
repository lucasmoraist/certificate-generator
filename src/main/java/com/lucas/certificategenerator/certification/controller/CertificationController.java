package com.lucas.certificategenerator.certification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.certificategenerator.certification.dto.CertificationAnswerDTO;
import com.lucas.certificategenerator.certification.service.CertificationAnswerService;




@RestController
@RequestMapping("/nlw/certification")
public class CertificationController {
    
    @Autowired
    private CertificationAnswerService service;

    @PostMapping("/answer")
    public CertificationAnswerDTO certificationAnswer(@RequestBody CertificationAnswerDTO dto) {
        return this.service.execute(dto);
    }

}
