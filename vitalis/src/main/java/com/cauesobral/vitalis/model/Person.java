package com.cauesobral.vitalis.model;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDate;

//superclasse de doctor, patient e companion
//escolhi usar superclasse person porque no futuro facilita escalabilidade
// se for adicionado mais uma classe de pessoa (funcionario, dentista, por exemplo)
@MappedSuperclass
public class Person {
    private String fullName;
    private final LocalDate birthDate;
    private final String gender;
    private final String cpf;

    private String country;
    private String state;
    private String city;
    private String address;

    private String email;
    private String cellphoneNumber;

    public Person(String fullName, LocalDate birthDate, String gender, String cpf,
                  String country, String state, String city, String address, String email, String cellphoneNumber) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.cpf = cpf;

        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;

        this.email = email;
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", cpf='" + cpf + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", cellphoneNumber='" + cellphoneNumber + '\'' +
                '}';
    }
}
