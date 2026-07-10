package com.University.FinalAdmissionForm.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcademicQualificationResponseDto {

    private Long id;

    private String examination;

    private String boardUniversity;

    private String year;

    private String subject;

    private String marks;

    private String fullMarks;

    private String percentage;

}
