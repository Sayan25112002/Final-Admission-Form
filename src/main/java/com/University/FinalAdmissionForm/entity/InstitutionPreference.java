package com.University.FinalAdmissionForm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InstitutionPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institutionName;

    @ManyToOne
    @JoinColumn(name = "coursePreferenceId")
    @JsonIgnore
    private CoursePreference coursePreference;

}
