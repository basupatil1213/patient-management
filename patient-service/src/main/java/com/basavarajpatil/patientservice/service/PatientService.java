package com.basavarajpatil.patientservice.service;


import com.basavarajpatil.patientservice.dto.PatientRequestDTO;
import com.basavarajpatil.patientservice.dto.PatientResponseDTO;
import com.basavarajpatil.patientservice.mapper.PatientMapper;
import com.basavarajpatil.patientservice.model.Patient;
import com.basavarajpatil.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;


import java.util.List;

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

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        Patient newPatient = patientRepository.save(PatientMapper.toPatientModel(patientRequestDTO));

        return PatientMapper.toPatientResponseDTO(newPatient);
    }
}
