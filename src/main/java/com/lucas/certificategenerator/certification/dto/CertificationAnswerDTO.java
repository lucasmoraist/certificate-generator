package com.lucas.certificategenerator.certification.dto;

import java.util.List;

public record CertificationAnswerDTO(
    String email,
    String technology,
    List<QuestionAnswerDTO> questionAnswers
) {}