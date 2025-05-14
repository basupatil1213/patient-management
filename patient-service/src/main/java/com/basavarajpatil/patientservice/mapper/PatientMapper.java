package com.basavarajpatil.patientservice.mapper;

import com.basavarajpatil.patientservice.dto.PatientRequestDTO;
import com.basavarajpatil.patientservice.dto.PatientResponseDTO;
import com.basavarajpatil.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toPatientResponseDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());

        return patientResponseDTO;
    }

    public static Patient toPatientModel(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));

        return patient;
    }
}
