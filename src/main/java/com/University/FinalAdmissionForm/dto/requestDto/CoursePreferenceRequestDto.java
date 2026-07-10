package com.University.FinalAdmissionForm.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursePreferenceRequestDto {

    private String appliedCourse;

    private String subjectApplied;

}
