package com.University.FinalAdmissionForm.mapper;

import com.University.FinalAdmissionForm.dto.requestDto.CoursePreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.responseDto.CoursePreferenceResponseDto;
import com.University.FinalAdmissionForm.entity.CoursePreference;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoursePreferenceMapper {

    CoursePreference toCoursePreference(CoursePreferenceRequestDto coursePreferenceRequestDto);

    CoursePreferenceResponseDto toCoursePreferenceResponseDto(CoursePreference coursePreference);

    List<CoursePreferenceResponseDto> toCoursePreferenceResponseDtoList(List<CoursePreference> coursePreferenceList);

}
