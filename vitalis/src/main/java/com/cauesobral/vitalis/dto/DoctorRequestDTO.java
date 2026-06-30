package com.cauesobral.vitalis.dto;

import com.cauesobral.vitalis.model.ServiceType;
import com.cauesobral.vitalis.model.Specialty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class DoctorRequestDTO {

    // Person
    @NotBlank
    private String fullName;

    @NotNull
    private LocalDate birthDate;

    @NotBlank
    private String gender;

    @NotBlank
    private String cpf;

    private String country;
    private String state;
    private String city;
    private String address;

    private String email;
    private String cellphoneNumber;

    // Doctor
    @NotBlank
    private String crm;

    @NotNull
    private Specialty specialty;

    private String specialtyRegistration;

    private Integer averageAppointmentDuration;

    @NotNull
    private ServiceType serviceType;

    private String workHours;

    private String workplace;

    private List<DayOfWeek> availableDays;

    // getters/setters

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCellphoneNumber() { return cellphoneNumber; }
    public void setCellphoneNumber(String cellphoneNumber) { this.cellphoneNumber = cellphoneNumber; }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public Specialty getSpecialty() { return specialty; }
    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }

    public String getSpecialtyRegistration() { return specialtyRegistration; }
    public void setSpecialtyRegistration(String specialtyRegistration) { this.specialtyRegistration = specialtyRegistration; }

    public Integer getAverageAppointmentDuration() { return averageAppointmentDuration; }
    public void setAverageAppointmentDuration(Integer averageAppointmentDuration) { this.averageAppointmentDuration = averageAppointmentDuration; }

    public ServiceType getServiceType() { return serviceType; }
    public void setServiceType(ServiceType serviceType) { this.serviceType = serviceType; }

    public String getWorkHours() { return workHours; }
    public void setWorkHours(String workHours) { this.workHours = workHours; }

    public String getWorkplace() { return workplace; }
    public void setWorkplace(String workplace) { this.workplace = workplace; }

    public List<DayOfWeek> getAvailableDays() { return availableDays; }
    public void setAvailableDays(List<DayOfWeek> availableDays) { this.availableDays = availableDays; }
}