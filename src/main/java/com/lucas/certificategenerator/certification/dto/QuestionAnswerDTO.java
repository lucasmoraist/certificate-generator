package com.lucas.certificategenerator.certification.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO{

    private UUID questionId;
    private UUID alternativeId;
    private boolean isCorrect;

}
