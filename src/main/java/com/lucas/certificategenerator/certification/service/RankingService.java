package com.lucas.certificategenerator.certification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.certificategenerator.certification.model.CertificationStudent;
import com.lucas.certificategenerator.certification.repository.CertificationStudentRepository;

@Service
public class RankingService {

    @Autowired
    private CertificationStudentRepository repository;

    public List<CertificationStudent> execute() {
        return this.repository.findTop10ByOrderByGradeDesc();
    }

}
