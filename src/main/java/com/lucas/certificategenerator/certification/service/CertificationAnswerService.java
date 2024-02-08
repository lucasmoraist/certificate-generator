package com.lucas.certificategenerator.certification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.lucas.certificategenerator.certification.dto.CertificationAnswerDTO;
import com.lucas.certificategenerator.questions.model.Question;
import com.lucas.certificategenerator.questions.repository.QuestionRepository;

@Service
public class CertificationAnswerService {

    @Autowired
    private QuestionRepository questionRepository;

    public CertificationAnswerDTO execute(CertificationAnswerDTO dto) {

        // Buscar alternativas das perguntas
        List<Question> questionsEntity = this.questionRepository.findByTechnology(dto.technology());

        // Está percorrendo cada resposta de questão na lista de respostas de questões
        dto.questionAnswers()
                .stream().forEach(questionAnswer -> {

                    // Encontra a questão correspondente na lista de entidades de perguntas com base
                    // no ID da questão na resposta
                    var question = questionsEntity.stream()
                            .filter(q -> q.getId().equals(questionAnswer.getQuestionId())).findFirst().get();
                    
                    // Encontra a alternativa correta associada à questão atual
                    var findCorrectAlternative = question.getAlternatives().stream()
                            .filter(alternative -> alternative.isCorrect()).findFirst().get();

                    // Verifica se o ID da alternativa selecionada pelo usuário é igual ao ID da
                    // alternativa correta
                    
                    if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeId())){
                        questionAnswer.setCorrect(true);
                    }else{
                        questionAnswer.setCorrect(false);
                    }
                    
                });
 
        return dto;
        // Salvar as informações da certificação

    }

}
