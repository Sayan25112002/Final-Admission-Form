package com.University.FinalAdmissionForm.mapper;

import com.University.FinalAdmissionForm.dto.requestDto.StudentDetailRequestDto;
import com.University.FinalAdmissionForm.dto.responseDto.StudentDetailResponseDto;
import com.University.FinalAdmissionForm.entity.StudentDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentDetailMapper {

    StudentDetail toStudentDetail(StudentDetailRequestDto studentDetailRequestDto);

    StudentDetailResponseDto toStudentDetailResponseDto(StudentDetail studentDetail);

    List<StudentDetailResponseDto> toStudentDetailResponseDtoList(List<StudentDetail> studentDetailList);

}
