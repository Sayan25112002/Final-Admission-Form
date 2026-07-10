package com.University.FinalAdmissionForm.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursePreferenceResponseDto {

    private Long id;

    private String appliedCourse;

    private String subjectApplied;

    private List<InstitutionPreferenceResponseDto> institutionPreferenceList;

}
