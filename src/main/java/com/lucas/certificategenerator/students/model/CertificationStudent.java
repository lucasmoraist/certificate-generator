package com.lucas.certificategenerator.students.model;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationStudent {
    
    private UUID id;

    private UUID studentId;

    private String technology;

    private int grade;

    private List<AnswersCertifications> answersCertifications;
}
