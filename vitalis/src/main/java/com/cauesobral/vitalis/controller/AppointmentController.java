package com.cauesobral.vitalis.controller;

import com.cauesobral.vitalis.dto.AppointmentRequestDTO;
import com.cauesobral.vitalis.dto.AppointmentResponseDTO;
import com.cauesobral.vitalis.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> schedule(
            @Valid @RequestBody AppointmentRequestDTO dto) {

        AppointmentResponseDTO response = appointmentService.schedule(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}/arrive")
    public ResponseEntity<AppointmentResponseDTO> arrive(
            @PathVariable("id") Long id) {

        AppointmentResponseDTO response = appointmentService.arrive(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/triage")
    public ResponseEntity<AppointmentResponseDTO> advanceToTriaged(
            @PathVariable("id") Long id) {

        AppointmentResponseDTO response = appointmentService.advanceToTriaged(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/consult")
    public ResponseEntity<AppointmentResponseDTO> advanceToInConsultation(
            @PathVariable("id") Long id) {

        AppointmentResponseDTO response = appointmentService.advanceToInConsultation(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/discharge")
    public ResponseEntity<AppointmentResponseDTO> discharge(
            @PathVariable("id") Long id) {

        AppointmentResponseDTO response = appointmentService.discharge(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<AppointmentResponseDTO> cancel(
            @PathVariable("id") Long id) {

        AppointmentResponseDTO response = appointmentService.cancel(id);
        return ResponseEntity.ok(response);
    }
}