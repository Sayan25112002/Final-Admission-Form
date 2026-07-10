package com.University.FinalAdmissionForm.service;

import com.University.FinalAdmissionForm.dto.requestDto.AcademicQualificationRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.CoursePreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.InstitutionPreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.StudentDetailRequestDto;
import com.University.FinalAdmissionForm.dto.responseDto.AcademicQualificationResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.CoursePreferenceResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.InstitutionPreferenceResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.StudentDetailResponseDto;

import java.io.IOException;
import java.util.List;

public interface AdmissionService {

    StudentDetailResponseDto createStudentDetail(StudentDetailRequestDto studentDetailRequestDto) throws IOException;

    AcademicQualificationResponseDto createAcademicQualification(AcademicQualificationRequestDto academicQualificationRequestDto, Long studentDetailId);

    CoursePreferenceResponseDto createCoursePreference(CoursePreferenceRequestDto coursePreferenceRequestDto, Long studentDetailId);

    InstitutionPreferenceResponseDto createInstitutionPreference(InstitutionPreferenceRequestDto institutionPreferenceRequestDto, Long coursePreferenceId);

    List<StudentDetailResponseDto> getAllStudentDetails();

    StudentDetailResponseDto getStudentDetailById(Long studentDetailId);

}
