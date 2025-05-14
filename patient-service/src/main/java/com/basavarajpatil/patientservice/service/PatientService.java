package com.basavarajpatil.patientservice.service;


import com.basavarajpatil.patientservice.dto.PatientResponseDTO;
import com.basavarajpatil.patientservice.mapper.PatientMapper;
import com.basavarajpatil.patientservice.model.Patient;
import com.basavarajpatil.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                        .map(PatientMapper::toPatientResponseDTO)
                        .toList();
    }
}
