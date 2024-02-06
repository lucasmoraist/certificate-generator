package com.lucas.certificategenerator.students.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucas.certificategenerator.students.model.CertificationStudent;

public interface CertificationStudentRepository extends JpaRepository<CertificationStudent, UUID>{
    
    @Query("SELECT c FROM t_cg_certification c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudent> findByEmailAndTechnology(String email, String technology);

}
