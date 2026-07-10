package com.University.FinalAdmissionForm.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailRequestDto {

    private MultipartFile universityLogoFile;

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

    private String dobProof;

    private String tenthProof;

    private String twelfthProof;

    private String graduationProof;

    private String photoProof;

    private String disabilityProof;

    private String paymentStatus;

}
