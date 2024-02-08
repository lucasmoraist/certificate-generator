package com.lucas.certificategenerator.certification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import com.lucas.certificategenerator.certification.dto.CertificationAnswerDTO;
import com.lucas.certificategenerator.certification.dto.VerifyHasCertificationDTO;
import com.lucas.certificategenerator.certification.model.AnswersCertifications;
import com.lucas.certificategenerator.certification.model.CertificationStudent;
import com.lucas.certificategenerator.certification.repository.CertificationStudentRepository;
import com.lucas.certificategenerator.questions.model.Question;
import com.lucas.certificategenerator.questions.repository.QuestionRepository;
import com.lucas.certificategenerator.students.model.Student;
import com.lucas.certificategenerator.students.repository.StudentRepeository;

@Service
public class CertificationAnswerService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StudentRepeository studentRepeository;

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyIfHasCertificationService verifyIfHasCertificationService;
    

    public CertificationStudent execute(CertificationAnswerDTO dto) throws Exception{

        var haveCertification = this.verifyIfHasCertificationService.execute(new VerifyHasCertificationDTO(dto.getEmail(), dto.getTechnology()));

        if(haveCertification){
            throw new Exception("Você já tirou sua certificação");
        }
        System.out.println("Email é " + haveCertification);
        // Buscar alternativas das perguntas
        List<Question> questionsEntity = this.questionRepository.findByTechnology(dto.getTechnology());
        // Lista de respostas
        List<AnswersCertifications> answersCertifications = new ArrayList<>();
        // Contagem de acertos
        AtomicInteger countCorrectAnswers = new AtomicInteger(0);
        // Está percorrendo cada resposta de questão na lista de respostas de questões
        dto.getQuestionAnswers()
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

                    if (findCorrectAlternative.getId().equals(questionAnswer.getAlternativeId())) {
                        questionAnswer.setCorrect(true);
                        countCorrectAnswers.incrementAndGet();
                    } else {
                        questionAnswer.setCorrect(false);
                    }

                    var answersCertificationsEntity = AnswersCertifications.builder()
                            .answerId(questionAnswer.getAlternativeId())
                            .questionId(questionAnswer.getQuestionId())
                            .isCorrect(questionAnswer.isCorrect())
                            .build();

                    answersCertifications.add(answersCertificationsEntity);
                });

        
        // Salvar as informações da certificação


        var student = this.studentRepeository.findByEmail(dto.getEmail());
        UUID studentId;

        // Verificando se o estudante existe
        if (student.isEmpty()) {
            // Caso ele não exista, será criado um novo estudante
            Student newStudent = Student.builder()
                    .email(dto.getEmail())
                    .build();

            newStudent = this.studentRepeository.save(newStudent);
            studentId = newStudent.getId();
        } else {
            studentId = student.get().getId();
        }

        CertificationStudent certificationStudent = CertificationStudent.builder()
                .technology(dto.getTechnology())
                .grade(countCorrectAnswers.get())
                .studentID(studentId)
                .build();

        // Rodando entre as respostas
        answersCertifications.stream().forEach(answersCertification -> {
            answersCertification.setCertificationId(certificationStudent.getId());
            answersCertification.setCertificationStudent(certificationStudent);
        });

        // Setando as respostas
        certificationStudent.setAnswersCertifications(answersCertifications);

        var certificationStudentCreated = certificationStudentRepository.save(certificationStudent);

        return certificationStudentCreated;
       

    }

}
