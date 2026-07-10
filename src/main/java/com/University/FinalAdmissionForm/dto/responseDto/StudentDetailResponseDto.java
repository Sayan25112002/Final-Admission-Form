package com.University.FinalAdmissionForm.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailResponseDto {

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

    private List<AcademicQualificationResponseDto> academicQualificationList;

    private List<CoursePreferenceResponseDto> coursePreferenceList;

    private String paymentStatus;

}
