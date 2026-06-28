package com.cauesobral.vitalis.dto;

import com.cauesobral.vitalis.model.Allergy;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

// Dados recebidos pelo controller ao criar ou atualizar um paciente
public class PatientRequestDTO {

    @NotBlank(message = "Nome completo é obrigatório")
    private String fullName;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate birthDate;

    @NotBlank(message = "Gênero é obrigatório")
    private String gender;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    private String country;
    private String state;
    private String city;
    private String address;

    @Email(message = "E-mail inválido")
    private String email;

    private String cellphoneNumber;

    // Dados médicos
    private String bloodType;
    private double height;
    private double weight;
    private String immunizationStatus;
    private boolean isPregnant;

    private List<Allergy> allergies;
    private List<String> chronicDiseases;
    private List<String> continuousMedication;
    private List<String> medicalConditions;
    private List<String> riskFactors;
    private List<String> disabilities;

    public PatientRequestDTO() {}

    public String getFullName() { return fullName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getGender() { return gender; }
    public String getCpf() { return cpf; }
    public String getCountry() { return country; }
    public String getState() { return state; }
    public String getCity() { return city; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getCellphoneNumber() { return cellphoneNumber; }
    public String getBloodType() { return bloodType; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public String getImmunizationStatus() { return immunizationStatus; }
    public boolean isPregnant() { return isPregnant; }
    public List<Allergy> getAllergies() { return allergies; }
    public List<String> getChronicDiseases() { return chronicDiseases; }
    public List<String> getContinuousMedication() { return continuousMedication; }
    public List<String> getMedicalConditions() { return medicalConditions; }
    public List<String> getRiskFactors() { return riskFactors; }
    public List<String> getDisabilities() { return disabilities; }
}
