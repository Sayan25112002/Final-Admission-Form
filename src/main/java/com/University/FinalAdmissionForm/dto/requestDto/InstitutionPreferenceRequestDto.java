package com.University.FinalAdmissionForm.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionPreferenceRequestDto {

    private String institutionName;

}
