package com.University.FinalAdmissionForm.controller;

import com.University.FinalAdmissionForm.dto.requestDto.AcademicQualificationRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.CoursePreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.InstitutionPreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.StudentDetailRequestDto;
import com.University.FinalAdmissionForm.dto.responseDto.AcademicQualificationResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.CoursePreferenceResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.InstitutionPreferenceResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.StudentDetailResponseDto;
import com.University.FinalAdmissionForm.service.AdmissionService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdmissionController {

    private final AdmissionService admissionService;

    @PostMapping("/createStudentDetail")
    public StudentDetailResponseDto createStudentDetail(@ModelAttribute StudentDetailRequestDto studentDetailRequestDto) throws IOException {
        System.out.println("Controller reached");
        return admissionService.createStudentDetail(studentDetailRequestDto);
    }

    @PostMapping("/createAcademicQualification/{studentDetailId}")
    public AcademicQualificationResponseDto createAcademicQualification(@RequestBody AcademicQualificationRequestDto academicQualificationRequestDto ,@PathVariable Long studentDetailId){
        return admissionService.createAcademicQualification(academicQualificationRequestDto,studentDetailId);
    }

    @PostMapping("/createCoursePreference/{studentDetailId}")
    public CoursePreferenceResponseDto createCoursePreference(@RequestBody CoursePreferenceRequestDto coursePreferenceRequestDto, @PathVariable Long studentDetailId){
        return admissionService.createCoursePreference(coursePreferenceRequestDto,studentDetailId);
    }

    @PostMapping("/createInstitutePerformance/{coursePreferenceId}")
    public InstitutionPreferenceResponseDto createInstitutionPreference(@RequestBody InstitutionPreferenceRequestDto institutionPreferenceRequestDto, @PathVariable Long coursePreferenceId){
        return admissionService.createInstitutionPreference(institutionPreferenceRequestDto,coursePreferenceId);
    }


    @GetMapping("/getAllStudentList")
    public List<StudentDetailResponseDto> getAllStudentList(){
        return admissionService.getAllStudentDetails();
    }

    @GetMapping("/getStudentDetail/{id}")
    public StudentDetailResponseDto getStudentDetail(@PathVariable Long id){
        return admissionService.getStudentDetailById(id);
    }

    @GetMapping("/generateNewAdmissionForm/{id}")
    public HttpEntity<byte[]> generateNewAdmissionForm(@PathVariable Long id) throws JRException {
        byte[] admissionForm = admissionService.newGenerateFinalAdmissionForm(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment","Final Application Form.pdf");
        return new HttpEntity<>(admissionForm,headers);
    }
}
