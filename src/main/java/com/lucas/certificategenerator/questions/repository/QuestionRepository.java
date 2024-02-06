package com.lucas.certificategenerator.questions.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.certificategenerator.questions.model.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID>{
    
    List<Question> findByTechnology(String technology);

}
