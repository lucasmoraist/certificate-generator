package com.lucas.certificategenerator.certification.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.lucas.certificategenerator.students.model.AnswersCertifications;
import com.lucas.certificategenerator.students.model.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_cg_certification")
@Table(name = "t_cg_certification")
public class CertificationStudent {
    
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80)
    private String technology;

    @Column(length = 10)
    private int grade;

    @Column(name = "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student studentEntity;

    @OneToMany
    @JoinColumn(name = "answers_certifications_id", insertable = false, updatable = false)
    private List<AnswersCertifications> answersCertifications;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
