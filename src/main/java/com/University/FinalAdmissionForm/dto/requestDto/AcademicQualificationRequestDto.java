package com.University.FinalAdmissionForm.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcademicQualificationRequestDto {

    private String examination;

    private String boardUniversity;

    private String year;

    private String subject;

    private String marks;

    private String fullMarks;

    private String percentage;

}
