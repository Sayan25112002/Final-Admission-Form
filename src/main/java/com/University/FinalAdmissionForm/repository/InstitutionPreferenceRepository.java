package com.University.FinalAdmissionForm.repository;

import com.University.FinalAdmissionForm.entity.InstitutionPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionPreferenceRepository extends JpaRepository<InstitutionPreference, Long> {
}
