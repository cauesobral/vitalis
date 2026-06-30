package com.cauesobral.vitalis.service;

import com.cauesobral.vitalis.dto.TriageRequestDTO;
import com.cauesobral.vitalis.dto.TriageResponseDTO;
import com.cauesobral.vitalis.model.Priority;
import com.cauesobral.vitalis.model.Triage;
import com.cauesobral.vitalis.model.TriageStatus;
import com.cauesobral.vitalis.repository.TriageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TriageServiceTest {

    @Mock
    private TriageRepository triageRepository;

    @Mock
    private PriorityCalculatorService priorityCalculatorService;

    @InjectMocks
    private TriageService triageService;

    @Test
    void shouldCreateEmergencyTriage() {
    //comentar que eh should pq significa "deveria" em ingles
        // mock da regra de prioridade
        when(priorityCalculatorService.calculate(any(Triage.class)))
                .thenReturn(Priority.RED);

        // mock do save do repository
        Triage saved = new Triage();
        when(triageRepository.save(any(Triage.class)))
                .thenReturn(saved);

        // chamada do método real
        var result = triageService.createEmergency();

        // validações mínimas
        assertNotNull(result);
    }
    @Test
    void shouldFinishTriageSuccessfully() {

        // GIVEN - triagem existente
        Triage triage = new Triage();
        triage.setStatus(TriageStatus.IN_PROGRESS);

        when(triageRepository.findById(1L))
                .thenReturn(Optional.of(triage));

        when(priorityCalculatorService.calculate(any(Triage.class)))
                .thenReturn(Priority.ORANGE);

        when(triageRepository.save(any(Triage.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // DTO de entrada
        TriageRequestDTO dto = new TriageRequestDTO();
        dto.setSymptoms("dor no peito");
        dto.setHeartRate(120);
        dto.setTemperature(38.0);
        dto.setSystolicPressure(140);
        dto.setDiastolicPressure(90);
        dto.setOxygenSaturation(92);
        dto.setWeight(80.0);
        dto.setHeight(1.75);
        dto.setNotes("paciente estável");

        // WHEN
        TriageResponseDTO result = triageService.finishTriage(1L, dto);

        // THEN
        assertNotNull(result);
    }
}