package com.cauesobral.vitalis.model;

import jakarta.persistence.*;
import java.util.Objects;

//Entidade triagem - tem os dados da triagem nela
@Entity
@Table(name = "triages")
public class Triage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = true)
    private Appointment appointment;

    private String symptoms;

    private Integer heartRate;
    private Double temperature;
    private Integer systolicPressure;
    private Integer diastolicPressure;
    private Integer oxygenSaturation;
    private Double weight;
    private Double height;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.BLUE; //comeca no nivel 0

    @Enumerated(EnumType.STRING)
    private TriageStatus status;

    private String notes;

    public Triage() {
        this.status = TriageStatus.NOT_STARTED;
    }

    public TriageStatus getStatus() {
        return status;
    }

    public void setStatus(TriageStatus status) {
        this.status = status;
    }

    public Long getId() { return id; }

    public Appointment getAppointment() { return appointment; }
    public void setAppointment(Appointment appointment) { this.appointment = appointment; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public Integer getHeartRate() { return heartRate; }
    public void setHeartRate(Integer heartRate) { this.heartRate = heartRate; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Integer getSystolicPressure() { return systolicPressure; }
    public void setSystolicPressure(Integer systolicPressure) { this.systolicPressure = systolicPressure; }

    public Integer getDiastolicPressure() { return diastolicPressure; }
    public void setDiastolicPressure(Integer diastolicPressure) { this.diastolicPressure = diastolicPressure; }

    public Integer getOxygenSaturation() { return oxygenSaturation; }
    public void setOxygenSaturation(Integer oxygenSaturation) { this.oxygenSaturation = oxygenSaturation; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public String getNotes() { return notes; }
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

}