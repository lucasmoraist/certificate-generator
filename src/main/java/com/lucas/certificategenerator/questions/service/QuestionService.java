package com.lucas.certificategenerator.questions.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lucas.certificategenerator.questions.dto.AlternativeResultDTO;
import com.lucas.certificategenerator.questions.dto.QuestionResultDTO;
import com.lucas.certificategenerator.questions.model.Alternatives;
import com.lucas.certificategenerator.questions.model.Question;
import com.lucas.certificategenerator.questions.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    /**
     * Método para encontrar e mapear QuestionResultDTO por tecnologia.
     * 
     * @param technology A tecnologia pela qual as questões devem ser encontradas.
     * @return Uma lista de QuestionResultDTO mapeados das questões encontradas.
     */
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology) {
        // Encontrar as questões no repositório com base na tecnologia fornecida
        var result = this.repository.findByTechnology(technology);

        // Mapear as questões encontradas para QuestionResultDTO usando o método
        // mapQuestionDTO
        var toMap = result.stream().map(question -> mapQuestionDTO(question))
                .collect(Collectors.toList());

        // Retornar a lista mapeada de QuestionResultDTO
        return toMap;
    }

    /**
     * Método estático para mapear uma questão para QuestionResultDTO.
     * 
     * @param question A questão a ser mapeada.
     * @return QuestionResultDTO mapeado da questão fornecida.
     */
    static QuestionResultDTO mapQuestionDTO(Question question) {
        // Construir um QuestionResultDTO com os detalhes da questão fornecida
        var description = QuestionResultDTO.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription()).build();

        // Mapear as alternativas da questão para AlternativeResultDTO e configurá-las
        // em QuestionResultDTO
        List<AlternativeResultDTO> alternativeResultDTO = question.getAlternatives()
                .stream().map(alternative -> mapAlternativeDTO(alternative))
                .collect(Collectors.toList());

        description.setAlternatives(alternativeResultDTO);

        // Retornar o QuestionResultDTO mapeado
        return description;
    }

    /**
     * Método estático para mapear uma alternativa para AlternativeResultDTO.
     * 
     * @param alternatives A alternativa a ser mapeada.
     * @return AlternativeResultDTO mapeado da alternativa fornecida.
     */
    static AlternativeResultDTO mapAlternativeDTO(Alternatives alternatives) {
        // Construir um AlternativeResultDTO com os detalhes da alternativa fornecida
        return AlternativeResultDTO.builder()
                .id(alternatives.getId())
                .description(alternatives.getDescription()).build();
    }

}
