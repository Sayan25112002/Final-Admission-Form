package com.University.FinalAdmissionForm.service.implementation;

import com.University.FinalAdmissionForm.dto.requestDto.AcademicQualificationRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.CoursePreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.InstitutionPreferenceRequestDto;
import com.University.FinalAdmissionForm.dto.requestDto.StudentDetailRequestDto;
import com.University.FinalAdmissionForm.dto.responseDto.AcademicQualificationResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.CoursePreferenceResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.InstitutionPreferenceResponseDto;
import com.University.FinalAdmissionForm.dto.responseDto.StudentDetailResponseDto;
import com.University.FinalAdmissionForm.entity.AcademicQualification;
import com.University.FinalAdmissionForm.entity.CoursePreference;
import com.University.FinalAdmissionForm.entity.InstitutionPreference;
import com.University.FinalAdmissionForm.entity.StudentDetail;
import com.University.FinalAdmissionForm.mapper.AcademicQualificationMapper;
import com.University.FinalAdmissionForm.mapper.CoursePreferenceMapper;
import com.University.FinalAdmissionForm.mapper.InstitutionPreferenceMapper;
import com.University.FinalAdmissionForm.mapper.StudentDetailMapper;
import com.University.FinalAdmissionForm.repository.AcademicQualificationRepository;
import com.University.FinalAdmissionForm.repository.CoursePreferenceRepository;
import com.University.FinalAdmissionForm.repository.InstitutionPreferenceRepository;
import com.University.FinalAdmissionForm.repository.StudentDetailRepository;
import com.University.FinalAdmissionForm.service.AdmissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {

    private final StudentDetailRepository studentDetailRepository;
    private final AcademicQualificationRepository academicQualificationRepository;
    private final CoursePreferenceRepository coursePreferenceRepository;
    private final InstitutionPreferenceRepository institutionPreferenceRepository;
    private final AcademicQualificationMapper  academicQualificationMapper;
    private final StudentDetailMapper studentDetailMapper;
    private final CoursePreferenceMapper coursePreferenceMapper;
    private final InstitutionPreferenceMapper institutionPreferenceMapper;

    @Override
    public StudentDetailResponseDto createStudentDetail(StudentDetailRequestDto studentDetailRequestDto) throws IOException {
        String universityFilePath = saveFile(studentDetailRequestDto.getUniversityLogoFile());
        studentDetailRequestDto.setUniversityLogo(universityFilePath);
        StudentDetail studentDetail = studentDetailMapper.toStudentDetail(studentDetailRequestDto);
        StudentDetail savedStudentDetail = studentDetailRepository.save(studentDetail);
        return studentDetailMapper.toStudentDetailResponseDto(savedStudentDetail);
    }

    @Override
    public AcademicQualificationResponseDto createAcademicQualification(AcademicQualificationRequestDto academicQualificationRequestDto, Long studentDetailId) {
        AcademicQualification academicQualification = academicQualificationMapper.toAcademicQualification(academicQualificationRequestDto);
        StudentDetail studentDetail = studentDetailRepository.findById(studentDetailId).orElseThrow(()->new EntityNotFoundException("Student Detail Not Found"));
        academicQualification.setStudentDetail(studentDetail);
        studentDetail.getAcademicQualificationList().add(academicQualification);
        AcademicQualification savedAcademicQualification = academicQualificationRepository.save(academicQualification);
        return academicQualificationMapper.toAcademicQualificationResponseDto(savedAcademicQualification);
    }

    @Override
    public CoursePreferenceResponseDto createCoursePreference(CoursePreferenceRequestDto coursePreferenceRequestDto, Long studentDetailId) {
        CoursePreference coursePreference = coursePreferenceMapper.toCoursePreference(coursePreferenceRequestDto);
        StudentDetail studentDetail = studentDetailRepository.findById(studentDetailId).orElseThrow(()->new EntityNotFoundException("Student Detail Not Found"));
        coursePreference.setStudentDetail(studentDetail);
        studentDetail.getCoursePreferenceList().add(coursePreference);
        CoursePreference savedCoursePreference = coursePreferenceRepository.save(coursePreference);
        return coursePreferenceMapper.toCoursePreferenceResponseDto(savedCoursePreference);
    }

    @Override
    public InstitutionPreferenceResponseDto createInstitutionPreference(InstitutionPreferenceRequestDto institutionPreferenceRequestDto, Long coursePreferenceId) {
        InstitutionPreference institutionPreference = institutionPreferenceMapper.toInstitutePreference(institutionPreferenceRequestDto);
        CoursePreference coursePreference = coursePreferenceRepository.findById(coursePreferenceId).orElseThrow(()->new EntityNotFoundException("Student Detail Not Found"));
        institutionPreference.setCoursePreference(coursePreference);
        coursePreference.getInstitutionPreferenceList().add(institutionPreference);
        InstitutionPreference savedInstitutionPreference = institutionPreferenceRepository.save(institutionPreference);
        return institutionPreferenceMapper.toInstitutionPreferenceResponseDto(savedInstitutionPreference);
    }

    @Override
    public List<StudentDetailResponseDto> getAllStudentDetails() {
        List<StudentDetail> studentDetailList = studentDetailRepository.findAll();
        return studentDetailMapper.toStudentDetailResponseDtoList(studentDetailList);
    }

    @Override
    public StudentDetailResponseDto getStudentDetailById(Long studentDetailId) {
        StudentDetail studentDetail = studentDetailRepository.findById(studentDetailId).orElseThrow(()->new EntityNotFoundException("Student Detail Not Found"));
        return studentDetailMapper.toStudentDetailResponseDto(studentDetail);
    }

    @Override
    public byte[] generateFinalAdmissionForm(Long id) throws JRException {
        String resourceDir = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\";
        Path finalPath = Paths.get(resourceDir,"FinalAdmissionForm.jrxml");
        Path coursePath = Paths.get(resourceDir,"CourseAndInstitutionPreference.jrxml");
        JasperReport finalReport = JasperCompileManager.compileReport(finalPath.toString());
        JasperReport courseReport = JasperCompileManager.compileReport(coursePath.toString());
        StudentDetail studentDetail = studentDetailRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Student Detail Not Found"));
        JRBeanCollectionDataSource studentDataSource = new JRBeanCollectionDataSource(Collections.singletonList(studentDetail));
        Map<String,Object> parameters = new HashMap<>();
        for (Field field : studentDetail.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                parameters.put(field.getName(), field.get(studentDetail));
            } catch (IllegalAccessException e) {
                throw new JRRuntimeException(e);
            }
        }
        parameters.put("academicQualificationList", studentDetail.getAcademicQualificationList());
        parameters.put("coursePreferenceList", studentDetail.getCoursePreferenceList());
        parameters.put("courseInstitutionReport", courseReport);
        JasperPrint  jasperPrint = JasperFillManager.fillReport(finalReport,parameters,studentDataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String uploadDir = System.getProperty("user.dir")+"\\src\\main\\resources\\webapp\\images\\";
        Files.createDirectories(Paths.get(uploadDir));
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir,fileName);
        Files.write(path, file.getBytes());
        return path.toString();
    }
}
