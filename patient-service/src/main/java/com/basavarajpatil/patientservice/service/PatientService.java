package com.basavarajpatil.patientservice.service;


import com.basavarajpatil.patientservice.dto.PatientRequestDTO;
import com.basavarajpatil.patientservice.dto.PatientResponseDTO;
import com.basavarajpatil.patientservice.exception.EmailAlreadyExistsException;
import com.basavarajpatil.patientservice.exception.PatientNotFoundException;
import com.basavarajpatil.patientservice.mapper.PatientMapper;
import com.basavarajpatil.patientservice.model.Patient;
import com.basavarajpatil.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail()))
            throw  new EmailAlreadyExistsException("A patient with this email" + " already exists " + patientRequestDTO.getEmail());

        Patient newPatient = patientRepository.save(PatientMapper.toPatientModel(patientRequestDTO));

        return PatientMapper.toPatientResponseDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id,
                                            PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with ID: " + id));

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id))
            throw  new EmailAlreadyExistsException("A patient with this email" + " already exists " + patientRequestDTO.getEmail());

        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);

        return PatientMapper.toPatientResponseDTO(updatedPatient);

    }


    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }


}
