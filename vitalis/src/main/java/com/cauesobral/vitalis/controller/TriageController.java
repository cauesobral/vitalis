package com.cauesobral.vitalis.controller;

import com.cauesobral.vitalis.dto.TriageRequestDTO;
import com.cauesobral.vitalis.dto.TriageResponseDTO;
import com.cauesobral.vitalis.service.TriageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/triages")
public class TriageController {

    private final TriageService triageService;

    public TriageController(TriageService triageService) {
        this.triageService = triageService;
    }

    @PostMapping("/emergency")
    public ResponseEntity<TriageResponseDTO> createEmergency() {
        return ResponseEntity.ok(triageService.createEmergency());
    }

    @PostMapping("/appointment/{appointmentId}")
    public ResponseEntity<TriageResponseDTO> createFromAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(triageService.createFromAppointment(appointmentId));
    }

    @PostMapping("/{id}/start")
    public ResponseEntity<TriageResponseDTO> start(@PathVariable Long id) {
        return ResponseEntity.ok(triageService.startTriage(id));
    }
    @GetMapping("/queue")
    public ResponseEntity<List<TriageResponseDTO>> queue() {
        return ResponseEntity.ok(triageService.getQueue());
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<TriageResponseDTO> finish(
            @PathVariable Long id,
            @RequestBody TriageRequestDTO dto) {

        return ResponseEntity.ok(triageService.finishTriage(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<TriageResponseDTO>> findAll() {
        return ResponseEntity.ok(triageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TriageResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(triageService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        triageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}