package com.lucas.certificategenerator.certification.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationAnswerDTO {

    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionAnswers;

}