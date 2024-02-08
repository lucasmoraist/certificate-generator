package com.lucas.certificategenerator.certification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> certificationAnswer(@RequestBody CertificationAnswerDTO dto) throws Exception{
        try{
            var result = this.service.execute(dto);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

}
