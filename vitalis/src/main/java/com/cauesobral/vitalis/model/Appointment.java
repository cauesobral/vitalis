package com.cauesobral.vitalis.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

// Representa o agendamento da ida ao médico
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime scheduledAt;  // Horário agendado
    private LocalDateTime arrivedAt;    // Horário de chegada real

    public Appointment() {}

    public Long getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public AppointmentStatus getStatus() { return status; }
    public Priority getPriority() { return priority; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }
    public LocalDateTime getArrivedAt() { return arrivedAt; }

    public void setId(Long id) { this.id = id; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public void setStatus(AppointmentStatus status) { this.status = status; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setScheduledAt(LocalDateTime scheduledAt) { this.scheduledAt = scheduledAt; }
    public void setArrivedAt(LocalDateTime arrivedAt) { this.arrivedAt = arrivedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Appointment{id=" + id + ", status=" + status + ", priority=" + priority
                + ", scheduledAt=" + scheduledAt + ", arrivedAt=" + arrivedAt + "}";
    }
}
