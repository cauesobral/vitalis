package com.cauesobral.vitalis.service;

import com.cauesobral.vitalis.dto.TriageRequestDTO;
import com.cauesobral.vitalis.dto.TriageResponseDTO;
import com.cauesobral.vitalis.exception.BusinessException;
import com.cauesobral.vitalis.model.Appointment;
import com.cauesobral.vitalis.model.Triage;
import com.cauesobral.vitalis.model.TriageStatus;
import com.cauesobral.vitalis.repository.AppointmentRepository;
import com.cauesobral.vitalis.repository.TriageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriageService {

    private final TriageRepository triageRepository;
    private final AppointmentRepository appointmentRepository;
    private final PriorityCalculatorService priorityCalculatorService;

    public TriageService(TriageRepository triageRepository,
                         AppointmentRepository appointmentRepository,
                         PriorityCalculatorService priorityCalculatorService) {
        this.triageRepository = triageRepository;
        this.appointmentRepository = appointmentRepository;
        this.priorityCalculatorService = priorityCalculatorService;
    }

    public TriageResponseDTO createEmergency() {

        Triage triage = new Triage();

        triage.setPriority(priorityCalculatorService.calculate(triage));

        return toResponse(triageRepository.save(triage));
    }

    public TriageResponseDTO createFromAppointment(Long appointmentId, TriageRequestDTO dto) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new BusinessException("Appointment não encontrado"));

        Triage triage = new Triage();

        triage.setAppointment(appointment);

        fillFields(triage, dto);

        triage.setPriority(priorityCalculatorService.calculate(triage));

        return toResponse(triageRepository.save(triage));
    }

    public List<TriageResponseDTO> findAll() {
        return triageRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public TriageResponseDTO findById(Long id) {
        return toResponse(triageRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Triagem não encontrada")));
    }
    public TriageResponseDTO startTriage(Long id) {

        Triage triage = triageRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Triagem não encontrada"));

        if (triage.getStatus() == TriageStatus.IN_PROGRESS) {
            throw new BusinessException("Triagem já iniciada");
        }

        if (triage.getStatus() == TriageStatus.FINISHED) {
            throw new BusinessException("Triagem já finalizada");
        }

        triage.setStatus(TriageStatus.IN_PROGRESS);

        return toResponse(triageRepository.save(triage));
    }
    public void delete(Long id) {

        Triage triage = triageRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Triagem não encontrada"));

        triageRepository.delete(triage);
    }
    public List<TriageResponseDTO> getQueue() {

        List<TriageStatus> statuses = List.of(
                TriageStatus.NOT_STARTED,
                TriageStatus.IN_PROGRESS
        );

        return triageRepository.findQueue(statuses)
                .stream()
                .map(this::toResponse)
                .toList();
    }
    private void fillFields(Triage triage, TriageRequestDTO dto) {
        triage.setSymptoms(dto.getSymptoms());
        triage.setHeartRate(dto.getHeartRate());
        triage.setTemperature(dto.getTemperature());
        triage.setSystolicPressure(dto.getSystolicPressure());
        triage.setDiastolicPressure(dto.getDiastolicPressure());
        triage.setOxygenSaturation(dto.getOxygenSaturation());
        triage.setWeight(dto.getWeight());
        triage.setHeight(dto.getHeight());
        triage.setNotes(dto.getNotes());
    }
    public TriageResponseDTO finishTriage(Long id, TriageRequestDTO dto) {

        Triage triage = triageRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Triagem não encontrada"));

        if (triage.getStatus() == TriageStatus.NOT_STARTED) {
            throw new BusinessException("Triagem não iniciada");
        }

        if (triage.getStatus() == TriageStatus.FINISHED) {
            throw new BusinessException("Triagem já finalizada");
        }

        triage.setSymptoms(dto.getSymptoms());
        triage.setHeartRate(dto.getHeartRate());
        triage.setTemperature(dto.getTemperature());
        triage.setSystolicPressure(dto.getSystolicPressure());
        triage.setDiastolicPressure(dto.getDiastolicPressure());
        triage.setOxygenSaturation(dto.getOxygenSaturation());
        triage.setWeight(dto.getWeight());
        triage.setHeight(dto.getHeight());
        triage.setNotes(dto.getNotes());

        triage.setPriority(priorityCalculatorService.calculate(triage));

        triage.setStatus(TriageStatus.FINISHED);

        return toResponse(triageRepository.save(triage));
    }
    private TriageResponseDTO toResponse(Triage triage) {

        TriageResponseDTO dto = new TriageResponseDTO();

        dto.setId(triage.getId());
        dto.setAppointmentId(
                triage.getAppointment() != null ? triage.getAppointment().getId() : null
        );
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