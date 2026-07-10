package com.University.FinalAdmissionForm.repository;

import com.University.FinalAdmissionForm.entity.AcademicQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicQualificationRepository extends JpaRepository<AcademicQualification, Long> {
}
