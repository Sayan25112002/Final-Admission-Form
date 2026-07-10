package com.University.FinalAdmissionForm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String universityLogo;

    private String universityName;

    private String applicationDetail;

    private String applicationId;

    private String registrationDate;

    private String applicantName;

    private String fatherName;

    private String motherName;

    private String dateOfBirth;

    private String gender;

    private String nationality;

    private String religion;

    private String category;

    private String bloodGroup;

    private String differentlyAbled;

    private String aadharCardNumber;

    private String abcId;

    private String higherEducationId;

    private String mobileNumber;

    private String address;

    private String district;

    private String pinCode;

    private String state;

    private String country;

    private String accountHolderName;

    private String accountNumber;

    private String ifscCode;

    private String bankBranch;

    private String universityLastAttended;

    private String collegeLastAttended;

    @OneToMany(mappedBy = "studentDetail")
    @JsonIgnore
    private List<AcademicQualification> academicQualificationList;

    @OneToMany(mappedBy = "studentDetail")
    @JsonIgnore
    private List<CoursePreference> coursePreferenceList;

    private String dobProof;

    private String tenthProof;

    private String twelfthProof;

    private String graduationProof;

    private String photoProof;

    private String disabilityProof;

    private String paymentStatus;

}
