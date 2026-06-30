package com.cauesobral.vitalis.service;

import com.cauesobral.vitalis.dto.TriageRequestDTO;
import com.cauesobral.vitalis.dto.TriageResponseDTO;
import com.cauesobral.vitalis.exception.BusinessException;
import com.cauesobral.vitalis.model.Triage;
import com.cauesobral.vitalis.repository.TriageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriageService {

    private final TriageRepository triageRepository;

    public TriageService(TriageRepository triageRepository) {
        this.triageRepository = triageRepository;
    }

    public TriageResponseDTO create(TriageRequestDTO dto) {

        Triage triage = new Triage();

        mapDtoToEntity(dto, triage);

        triage = triageRepository.save(triage);

        return toResponse(triage);
    }

    public List<TriageResponseDTO> findAll() {
        return triageRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TriageResponseDTO findById(Long id) {

        Triage triage = triageRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Triagem não encontrada."));

        return toResponse(triage);
    }

    public TriageResponseDTO update(Long id, TriageRequestDTO dto) {

        Triage triage = triageRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Triagem não encontrada."));

        mapDtoToEntity(dto, triage);

        triage = triageRepository.save(triage);

        return toResponse(triage);
    }

    public void delete(Long id) {

        if (!triageRepository.existsById(id)) {
            throw new BusinessException("Triagem não encontrada.");
        }

        triageRepository.deleteById(id);
    }

    private void mapDtoToEntity(TriageRequestDTO dto, Triage triage) {

        triage.setSymptoms(dto.getSymptoms());
        triage.setHeartRate(dto.getHeartRate());
        triage.setTemperature(dto.getTemperature());
        triage.setSystolicPressure(dto.getSystolicPressure());
        triage.setDiastolicPressure(dto.getDiastolicPressure());
        triage.setOxygenSaturation(dto.getOxygenSaturation());
        triage.setWeight(dto.getWeight());
        triage.setHeight(dto.getHeight());
        triage.setNotes(dto.getNotes());

        // prioridade pode ser calculada depois
        triage.setPriority(dto.getPriority());
    }

    private TriageResponseDTO toResponse(Triage triage) {

        TriageResponseDTO dto = new TriageResponseDTO();

        dto.setId(triage.getId());

        if (triage.getAppointment() != null) {
            dto.setAppointmentId(triage.getAppointment().getId());
        }

        dto.setSymptoms(triage.getSymptoms());
        dto.setHeartRate(triage.getHeartRate());
        dto.setTemperature(triage.getTemperature());
        dto.setSystolicPressure(triage.getSystolicPressure());
        dto.setDiastolicPressure(triage.getDiastolicPressure());
        dto.setOxygenSaturation(triage.getOxygenSaturation());
        dto.setWeight(triage.getWeight());
        dto.setHeight(triage.getHeight());
        dto.setPriority(triage.getPriority());
        dto.setNotes(triage.getNotes());

        return dto;
    }
}