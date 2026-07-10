package com.University.FinalAdmissionForm.mapper;

import com.University.FinalAdmissionForm.dto.requestDto.AcademicQualificationRequestDto;
import com.University.FinalAdmissionForm.dto.responseDto.AcademicQualificationResponseDto;
import com.University.FinalAdmissionForm.entity.AcademicQualification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AcademicQualificationMapper {

    AcademicQualification toAcademicQualification(AcademicQualificationRequestDto academicQualificationRequestDto);

    AcademicQualificationResponseDto toAcademicQualificationResponseDto(AcademicQualification academicQualification);

    List<AcademicQualificationResponseDto> toAcademicQualificationResponseDtoList(List<AcademicQualification> academicQualifications);

}
