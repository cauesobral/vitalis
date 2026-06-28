package com.cauesobral.vitalis.model;

import java.time.LocalDate;

public class Companion extends Person {

    private String kinshipDegree; // Grau de parentesco com o paciente

    public Companion(String fullName, LocalDate birthDate, String gender, String cpf,
                     String country, String state, String city, String address,
                     String email, String cellphoneNumber, String kinshipDegree) {
        super(fullName, birthDate, gender, cpf, country, state, city, address, email, cellphoneNumber);
        this.kinshipDegree = kinshipDegree;
    }

    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
    }
}
