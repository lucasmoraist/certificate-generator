package com.lucas.certificategenerator.students.service;

import org.springframework.stereotype.Service;

import com.lucas.certificategenerator.students.dto.VerifyHasCertificationDTO;
import com.lucas.certificategenerator.students.repository.CertificationStudentRepository;

@Service
public class VerifyIfHasCertificationService {

    private final CertificationStudentRepository repository;

    public VerifyIfHasCertificationService(CertificationStudentRepository repository) {
        this.repository = repository;
    }

    public boolean execute(VerifyHasCertificationDTO dto) {
        var result = this.repository.findByEmailAndTechnology(dto.email(), dto.technology());

        if (!result.isEmpty()) {
            return true;
        }
        return false;
    }

}
