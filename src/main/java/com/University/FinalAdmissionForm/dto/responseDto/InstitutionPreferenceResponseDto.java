package com.University.FinalAdmissionForm.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstitutionPreferenceResponseDto {

    private Long id;

    private String institutionName;

}
