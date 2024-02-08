package com.lucas.certificategenerator.certification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.certificategenerator.certification.model.CertificationStudent;
import com.lucas.certificategenerator.certification.service.RankingService;

@RestController
@RequestMapping("/nlw/ranking")
public class RankingController {

    @Autowired
    private RankingService service;

    @GetMapping("/top10")
    public List<CertificationStudent> top10(){
        return this.service.execute();
    }

}
