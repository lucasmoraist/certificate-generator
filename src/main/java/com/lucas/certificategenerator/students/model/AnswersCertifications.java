package com.lucas.certificategenerator.students.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe responsável pelos relacionamentos
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswersCertifications {
    
    private UUID id;

    private UUID certificationId;

    private UUID studentId;

    private UUID questionId;

    private UUID answerId;

    private boolean isCorrect;

}
