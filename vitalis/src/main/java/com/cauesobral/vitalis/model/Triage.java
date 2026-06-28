package com.cauesobral.vitalis.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "triages")
public class Triage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private String symptoms;          // Sintomas relatados pelo paciente
    private String vitalSigns;        // Sinais vitais (pressão, temperatura, etc.)

    @Enumerated(EnumType.STRING)
    private Priority priority;        // Prioridade definida pela triagem

    private String notes;             // Observações do profissional de triagem

    // @NoArgsConstructor — exigido pelo JPA
    public Triage() {}

    // @Data → getters
    public Long getId() { return id; }
    public Appointment getAppointment() { return appointment; }
    public String getSymptoms() { return symptoms; }
    public String getVitalSigns() { return vitalSigns; }
    public Priority getPriority() { return priority; }
    public String getNotes() { return notes; }

    public void setId(Long id) { this.id = id; }
    public void setAppointment(Appointment appointment) { this.appointment = appointment; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public void setVitalSigns(String vitalSigns) { this.vitalSigns = vitalSigns; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triage)) return false;
        Triage that = (Triage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Triage{id=" + id + ", symptoms='" + symptoms + "', vitalSigns='" + vitalSigns
                + "', priority=" + priority + ", notes='" + notes + "'}";
    }
}
