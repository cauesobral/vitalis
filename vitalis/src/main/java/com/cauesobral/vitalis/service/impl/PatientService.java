package com.cauesobral.vitalis.service.impl;

import com.cauesobral.vitalis.dto.PatientRequestDTO;
import com.cauesobral.vitalis.dto.PatientResponseDTO;
import com.cauesobral.vitalis.exception.BusinessException;
import com.cauesobral.vitalis.model.Patient;
import com.cauesobral.vitalis.repository.PatientRepository;
import com.cauesobral.vitalis.validation.PatientValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponseDTO create(PatientRequestDTO dto) {
        PatientValidation.validate(dto);

        if (patientRepository.existsByCpf(dto.getCpf())) {
            throw new BusinessException("Já existe um paciente com o CPF: " + dto.getCpf());
        }

        Patient patient = new Patient(
                dto.getFullName(), dto.getBirthDate(), dto.getGender(), dto.getCpf(),
                dto.getCountry(), dto.getState(), dto.getCity(), dto.getAddress(),
                dto.getEmail(), dto.getCellphoneNumber(),
                dto.getBloodType(), dto.getHeight(), dto.getWeight(),
                dto.getImmunizationStatus(), dto.getAllergies(), dto.getChronicDiseases(),
                dto.getContinuousMedication(), dto.getMedicalConditions(),
                dto.getRiskFactors(), dto.getDisabilities(), dto.isPregnant()
        );

        Patient saved = patientRepository.save(patient);
        return PatientResponseDTO.fromPatient(saved);
    }

    public PatientResponseDTO findById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Paciente não encontrado com id: " + id));
        return PatientResponseDTO.fromPatient(patient);
    }

    public List<PatientResponseDTO> findAll() {
        return patientRepository.findAll()
                .stream()
                .map(PatientResponseDTO::fromPatient)
                .collect(Collectors.toList());
    }
}
