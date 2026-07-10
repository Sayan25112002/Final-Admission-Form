package com.University.FinalAdmissionForm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CoursePreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appliedCourse;

    private String subjectApplied;

    @ManyToOne
    @JoinColumn(name = "coursePreferenceId")
    @JsonIgnore
    private StudentDetail studentDetail;

    @OneToMany(mappedBy = "coursePreference")
    @JsonIgnore
    private List<InstitutionPreference> institutionPreferenceList;

}
