package com.lucas.certificategenerator.students.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.certificategenerator.students.model.Student;

public interface StudentRepeository extends JpaRepository<Student, UUID>{
    
    Optional<Student> findByEmail(String email);

}
