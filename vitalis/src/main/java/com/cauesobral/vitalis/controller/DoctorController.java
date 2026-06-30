package com.cauesobral.vitalis.controller;

import com.cauesobral.vitalis.dto.DoctorRequestDTO;
import com.cauesobral.vitalis.dto.DoctorResponseDTO;
import com.cauesobral.vitalis.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> create(@Valid @RequestBody DoctorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctorService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> findAll() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @GetMapping("/crm/{crm}")
    public ResponseEntity<DoctorResponseDTO> findByCrm(@PathVariable String crm) {
        return ResponseEntity.ok(doctorService.findByCrm(crm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody DoctorRequestDTO dto) {

        return ResponseEntity.ok(doctorService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}