package com.University.FinalAdmissionForm.mapper;

import com.University.FinalAdmissionForm.dto.requestDto.InstitutionPreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.responseDto.InstitutionPreferenceResponseDto;
import com.University.FinalAdmissionForm.entity.InstitutionPreference;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstitutionPreferenceMapper {

    InstitutionPreference toInstitutePreference(InstitutionPreferenceRequestDto institutionPreferenceRequestDto);

    InstitutionPreferenceResponseDto toInstitutionPreferenceResponseDto(InstitutionPreference institutionPreference);

    List<InstitutionPreferenceResponseDto> toInstitutionPreferenceResponseDtoList(List<InstitutionPreference> institutionPreferenceList);

}
