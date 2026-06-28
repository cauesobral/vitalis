package com.cauesobral.vitalis.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

// Dados recebidos ao agendar uma consulta
public class AppointmentRequestDTO {

    @NotNull(message = "ID do paciente é obrigatório")
    private Long patientId;

    @NotNull(message = "ID do médico é obrigatório")
    private Long doctorId;

    @NotNull(message = "Data e horário são obrigatórios")
    private LocalDateTime scheduledAt;

    public AppointmentRequestDTO() {}

    public Long getPatientId() { return patientId; }
    public Long getDoctorId() { return doctorId; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }
}
