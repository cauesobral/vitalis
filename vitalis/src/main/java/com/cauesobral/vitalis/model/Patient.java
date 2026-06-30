package com.cauesobral.vitalis.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // características do paciente
    private String bloodType;
    private double height;
    private double weight;
    private String immunizationStatus; // Quais vacinas tomou
    private boolean isPregnant;

    @ElementCollection
    @CollectionTable(name = "patient_allergies", joinColumns = @JoinColumn(name = "patient_id"))
    private List<Allergy> allergies;

    @ElementCollection
    @CollectionTable(name = "patient_chronic_diseases", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "disease")
    private List<String> chronicDiseases;

    @ElementCollection
    @CollectionTable(name = "patient_continuous_medication", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "medication")
    private List<String> continuousMedication;

    @ElementCollection
    @CollectionTable(name = "patient_medical_conditions", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "condition")
    private List<String> medicalConditions; // Histórico: AVC, epilepsia, cardiopatia etc.

    @ElementCollection
    @CollectionTable(name = "patient_risk_factors", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "risk_factor")
    private List<String> riskFactors;

    @ElementCollection
    @CollectionTable(name = "patient_disabilities", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "disability")
    private List<String> disabilities;

    public Patient(String fullName, LocalDate birthDate, String gender, String cpf, String country, String state,
                   String city, String address, String email, String cellphoneNumber,
                   String bloodType, double height, double weight, String immunizationStatus,
                   List<Allergy> allergies, List<String> chronicDiseases, List<String> continuousMedication,
                   List<String> medicalConditions, List<String> riskFactors, List<String> disabilities,
                   boolean isPregnant) {
        super(fullName, birthDate, gender, cpf, country, state, city, address, email, cellphoneNumber);
        this.bloodType = bloodType;
        this.height = height;
        this.weight = weight;
        this.immunizationStatus = immunizationStatus;
        this.allergies = allergies;
        this.chronicDiseases = chronicDiseases;
        this.continuousMedication = continuousMedication;
        this.medicalConditions = medicalConditions;
        this.riskFactors = riskFactors;
        this.disabilities = disabilities;
        this.isPregnant = isPregnant;
    }

    // Construtor vazio exigido pelo JPA
    protected Patient() {
        super(null, null, null, null, null, null, null, null, null, null);
    }

    public Long getId() { return id; }
    public String getBloodType() { return bloodType; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public String getImmunizationStatus() { return immunizationStatus; }
    public List<Allergy> getAllergies() { return allergies; }
    public List<String> getChronicDiseases() { return chronicDiseases; }
    public List<String> getContinuousMedication() { return continuousMedication; }
    public List<String> getMedicalConditions() { return medicalConditions; }
    public List<String> getRiskFactors() { return riskFactors; }
    public List<String> getDisabilities() { return disabilities; }
    public boolean isPregnant() { return isPregnant; }

    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setImmunizationStatus(String immunizationStatus) { this.immunizationStatus = immunizationStatus; }
    public void setAllergies(List<Allergy> allergies) { this.allergies = allergies; }
    public void setChronicDiseases(List<String> chronicDiseases) { this.chronicDiseases = chronicDiseases; }
    public void setContinuousMedication(List<String> continuousMedication) { this.continuousMedication = continuousMedication; }
    public void setMedicalConditions(List<String> medicalConditions) { this.medicalConditions = medicalConditions; }
    public void setRiskFactors(List<String> riskFactors) { this.riskFactors = riskFactors; }
    public void setDisabilities(List<String> disabilities) { this.disabilities = disabilities; }
    public void setPregnant(boolean pregnant) { isPregnant = pregnant; }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", bloodType='" + bloodType + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", immunizationStatus='" + immunizationStatus + '\'' +
                ", allergies=" + allergies +
                ", chronicDiseases=" + chronicDiseases +
                ", continuousMedication=" + continuousMedication +
                ", medicalConditions=" + medicalConditions +
                ", riskFactors=" + riskFactors +
                ", disabilities=" + disabilities +
                ", isPregnant=" + isPregnant +
                '}';
    }
}
