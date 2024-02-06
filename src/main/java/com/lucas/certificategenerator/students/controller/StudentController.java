package com.lucas.certificategenerator.students.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.certificategenerator.students.dto.VerifyHasCertificationDTO;
import com.lucas.certificategenerator.students.service.VerifyIfHasCertificationService;

@RestController
@RequestMapping("/nwl/students")
public class StudentController {

    private final VerifyIfHasCertificationService service;

    public StudentController(VerifyIfHasCertificationService service){
        this.service = service;
    }
    
    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO dto){
        var result = this.service.execute(dto);

        if(result){
            return "Pode fazer a prova";
        }

        return "Não pode fazer a prova";
    }

}
