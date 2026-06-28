package com.cauesobral.vitalis.dto;

import com.cauesobral.vitalis.model.Appointment;
import com.cauesobral.vitalis.model.AppointmentStatus;
import com.cauesobral.vitalis.model.Priority;

import java.time.LocalDateTime;

// Dados devolvidos ao cliente após criar ou consultar um agendamento
public class AppointmentResponseDTO {

    private Long id;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private AppointmentStatus status;
    private Priority priority;
    private LocalDateTime scheduledAt;
    private LocalDateTime arrivedAt;

    public AppointmentResponseDTO() {}

    public static AppointmentResponseDTO fromAppointment(Appointment appointment) {
        AppointmentResponseDTO dto = new AppointmentResponseDTO();
        dto.id = appointment.getId();
        dto.patientId = appointment.getPatient().getId();
        dto.patientName = appointment.getPatient().getFullName();
        dto.doctorId = appointment.getDoctor().getId();
        dto.doctorName = appointment.getDoctor().getFullName();
        dto.status = appointment.getStatus();
        dto.priority = appointment.getPriority();
        dto.scheduledAt = appointment.getScheduledAt();
        dto.arrivedAt = appointment.getArrivedAt();
        return dto;
    }

    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public Long getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public AppointmentStatus getStatus() { return status; }
    public Priority getPriority() { return priority; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }
    public LocalDateTime getArrivedAt() { return arrivedAt; }
}
