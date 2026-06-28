package com.cauesobral.vitalis.controller;

import com.cauesobral.vitalis.dto.PatientRequestDTO;
import com.cauesobral.vitalis.dto.PatientResponseDTO;
import com.cauesobral.vitalis.service.impl.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> create(@Valid @RequestBody PatientRequestDTO dto) {
        PatientResponseDTO response = patientService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> findById(@PathVariable Long id) {
        PatientResponseDTO response = patientService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> findAll() {
        List<PatientResponseDTO> response = patientService.findAll();
        return ResponseEntity.ok(response);
    }
}
