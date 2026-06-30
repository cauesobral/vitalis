package com.cauesobral.vitalis.controller;

import com.cauesobral.vitalis.dto.TriageRequestDTO;
import com.cauesobral.vitalis.dto.TriageResponseDTO;
import com.cauesobral.vitalis.service.TriageService;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<TriageResponseDTO> create(@Valid @RequestBody TriageRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(triageService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<TriageResponseDTO>> findAll() {
        return ResponseEntity.ok(triageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TriageResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(triageService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TriageResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody TriageRequestDTO dto) {

        return ResponseEntity.ok(triageService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        triageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}