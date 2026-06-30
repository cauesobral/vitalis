package com.cauesobral.vitalis.controller;

import com.cauesobral.vitalis.dto.TriageRequestDTO;
import com.cauesobral.vitalis.dto.TriageResponseDTO;
import com.cauesobral.vitalis.service.TriageService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<TriageResponseDTO> createEmergency(
            @RequestBody TriageRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(triageService.createEmergency(dto));
    }

    @PostMapping("/appointment/{appointmentId}")
    public ResponseEntity<TriageResponseDTO> createFromAppointment(
            @PathVariable Long appointmentId,
            @RequestBody TriageRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(triageService.createFromAppointment(appointmentId, dto));
    }

    @GetMapping
    public ResponseEntity<List<TriageResponseDTO>> findAll() {
        return ResponseEntity.ok(triageService.findAll());
    }
    @PatchMapping("/{id}/start")
    public ResponseEntity<TriageResponseDTO> startTriage(@PathVariable Long id) {
        return ResponseEntity.ok(triageService.startTriage(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TriageResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(triageService.findById(id));
    }
    @PatchMapping("/{id}/finish")
    public ResponseEntity<TriageResponseDTO> finishTriage(
            @PathVariable Long id,
            @RequestBody TriageRequestDTO dto) {

        return ResponseEntity.ok(triageService.finishTriage(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        triageService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/queue")
    public ResponseEntity<List<TriageResponseDTO>> getQueue() {
        return ResponseEntity.ok(triageService.getQueue());
    }
}