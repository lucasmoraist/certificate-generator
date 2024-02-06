package com.lucas.certificategenerator.students.model;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    private UUID id;

    private String email;

    private List<CertificationStudent> certificationStudents;

}
