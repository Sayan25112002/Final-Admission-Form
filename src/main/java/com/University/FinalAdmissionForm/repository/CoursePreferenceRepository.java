package com.University.FinalAdmissionForm.repository;

import com.University.FinalAdmissionForm.entity.CoursePreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePreferenceRepository extends JpaRepository<CoursePreference, Long> {
}
