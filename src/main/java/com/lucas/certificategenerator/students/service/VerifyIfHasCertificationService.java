package com.lucas.certificategenerator.students.service;

import org.springframework.stereotype.Service;

import com.lucas.certificategenerator.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationService {
    
    public boolean execute(VerifyHasCertificationDTO dto){
        if(dto.email().equals("lucas@lucas.com") && dto.technology().equals("JAVA")){
            return true;
        }
        return false;
    }

}
