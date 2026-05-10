package com.pm.patientservice.mapper;


import com.pm.patientservice.dto.request.PatientRequestDTO;
import com.pm.patientservice.dto.response.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.utils.DateTimeUtil;

public class PatientMapper {

  public static PatientResponseDTO toDto(Patient patient) {
    PatientResponseDTO dto = new PatientResponseDTO();
    dto.setId(patient.getId().toString());
    dto.setName(patient.getName());
    dto.setEmail(patient.getEmail());
    dto.setAddress(patient.getAddress());
    dto.setDateOfBirth(patient.getDateOfBirth().toString());
    return dto;
  }

  public static Patient toModel(PatientRequestDTO patientRequestDTO) {
    Patient patient = new Patient();
    patient.setName(patientRequestDTO.getName());
    patient.setEmail(patientRequestDTO.getEmail());
    patient.setAddress(patientRequestDTO.getAddress());
    patient.setDateOfBirth(
        DateTimeUtil.convertInstantToLocalDate(patientRequestDTO.getDateOfBirth()));
    patient.setRegisteredDate(
        DateTimeUtil.convertInstantToLocalDate(patientRequestDTO.getRegisteredDate()));
    return patient;
  }

 
}
