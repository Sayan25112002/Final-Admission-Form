package com.University.FinalAdmissionForm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AcademicQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examination;

    private String boardUniversity;

    private String year;

    private String subject;

    private String marks;

    private String fullMarks;

    private String percentage;

    @ManyToOne
    @JoinColumn(name = "studentDetailId")
    @JsonIgnore
    private StudentDetail studentDetail;

}