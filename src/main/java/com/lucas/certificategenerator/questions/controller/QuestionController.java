package com.lucas.certificategenerator.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.certificategenerator.questions.dto.QuestionResultDTO;
import com.lucas.certificategenerator.questions.service.QuestionService;

@RestController
@RequestMapping("/nlw/question")
public class QuestionController {
    
    @Autowired
    private QuestionService service;

    @GetMapping("/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        return this.service.findByTechnology(technology);
    }

}
