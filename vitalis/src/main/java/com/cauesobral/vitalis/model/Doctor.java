package com.cauesobral.vitalis.model;

import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crm; // Credencial do médico, nao posso usar final
    //pq se nao o jpa nao funciona o update

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    private String specialtyRegistration; // Número da especialidade (QRE)
    private Integer averageAppointmentDuration;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType; // Presencial, telemedicina ou os dois

    private String workHours;
    private String workplace;

    @ElementCollection
    @CollectionTable(name = "doctor_available_days", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "day_of_week")
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> availableDays;

    public Doctor(String fullName, LocalDate birthDate, String gender, String cpf, String country, String state, String
            city, String address, String email, String cellphoneNumber, String crm, Specialty specialty,
                  String specialtyRegistration, Integer averageAppointmentDuration, ServiceType serviceType,
                  String workHours, String workplace, List<DayOfWeek> avaliableDays) {
        super(fullName, birthDate, gender, cpf, country, state, city, address, email, cellphoneNumber);
        this.crm = crm;
        this.specialty = specialty;
        this.specialtyRegistration = specialtyRegistration;
        this.averageAppointmentDuration = averageAppointmentDuration;
        this.serviceType = serviceType;
        this.workHours = workHours;
        this.workplace = workplace;
        this.availableDays = avaliableDays;
    }

    protected Doctor() {
        super(null, null, null, null, null, null, null, null, null, null);
        this.crm = null;
    }

    public Long getId() { return id; }
    public String getCrm() { return crm; }
    public Specialty getSpecialty() { return specialty; }
    public String getSpecialtyRegistration() { return specialtyRegistration; }
    public Integer getAverageAppointmentDuration() { return averageAppointmentDuration; }
    public ServiceType getServiceType() { return serviceType; }
    public String getWorkHours() { return workHours; }
    public String getWorkplace() { return workplace; }
    public List<DayOfWeek> getAvaliableDays() { return availableDays; }

    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }
    public void setAverageAppointmentDuration(Integer averageAppointmentDuration) { this.averageAppointmentDuration = averageAppointmentDuration; }
    public void setServiceType(ServiceType serviceType) { this.serviceType = serviceType; }
    public void setWorkHours(String workHours) { this.workHours = workHours; }
    public void setWorkplace(String workplace) { this.workplace = workplace; }
    public void setAvaliableDays(List<DayOfWeek> avaliableDays) { this.availableDays = avaliableDays; }
    public void setSpecialtyRegistration(String specialtyRegistration) { this.specialtyRegistration = specialtyRegistration; }

    @Override
    public String toString() {
        return "Doctor{" +
                "crm='" + crm + '\'' +
                ", specialty=" + specialty +
                ", specialtyRegistration='" + specialtyRegistration + '\'' +
                ", averageAppointmentDuration=" + averageAppointmentDuration +
                ", serviceType=" + serviceType +
                ", workHours='" + workHours + '\'' +
                ", workplace='" + workplace + '\'' +
                ", availableDays=" + availableDays +
                '}';
    }
}
