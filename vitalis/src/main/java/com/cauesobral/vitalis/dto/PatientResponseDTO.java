package com.cauesobral.vitalis.dto;

import com.cauesobral.vitalis.model.Allergy;
import com.cauesobral.vitalis.model.Patient;

import java.time.LocalDate;
import java.util.List;

// Dados devolvidos ao cliente — expostos com segurança, sem campos internos do JPA
public class PatientResponseDTO {

    private Long id;
    private String fullName;
    private LocalDate birthDate;
    private String gender;
    private String cpf;
    private String country;
    private String state;
    private String city;
    private String address;
    private String email;
    private String cellphoneNumber;
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

    public PatientResponseDTO() {}

    public static PatientResponseDTO fromPatient(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.id = patient.getId();
        dto.fullName = patient.getFullName();
        dto.birthDate = patient.getBirthDate();
        dto.gender = patient.getGender();
        dto.cpf = patient.getCpf();
        dto.country = patient.getCountry();
        dto.state = patient.getState();
        dto.city = patient.getCity();
        dto.address = patient.getAddress();
        dto.email = patient.getEmail();
        dto.cellphoneNumber = patient.getCellphoneNumber();
        dto.bloodType = patient.getBloodType();
        dto.height = patient.getHeight();
        dto.weight = patient.getWeight();
        dto.immunizationStatus = patient.getImmunizationStatus();
        dto.isPregnant = patient.isPregnant();
        dto.allergies = patient.getAllergies();
        dto.chronicDiseases = patient.getChronicDiseases();
        dto.continuousMedication = patient.getContinuousMedication();
        dto.medicalConditions = patient.getMedicalConditions();
        dto.riskFactors = patient.getRiskFactors();
        dto.disabilities = patient.getDisabilities();
        return dto;
    }

    public Long getId() { return id; }
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
