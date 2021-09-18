//Entity class για δημιουργία πίνακα Patient στην βάση δεδομένων MariaDB.
// Entity class to create a Patient table in the MariaDB database.

package com.test.coronadatabase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String lastName, firstName, birthDate, city,address;
    private int patientAmka, postcode,telephone;
    private boolean coronaPatient;

    public Patient() {
    }

    public Patient(String lastName, String firstName, String birthDate, String city, String address, int patientAmka, int postcode, int telephone, boolean coronaPatient) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.city = city;
        this.address = address;
        this.patientAmka = patientAmka;
        this.postcode = postcode;
        this.telephone = telephone;
        this.coronaPatient = coronaPatient;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getPatientAmka() {
        return patientAmka;
    }

    public int getPostcode() {
        return postcode;
    }

    public int getTelephone() {
        return telephone;
    }

    public boolean isCoronaPatient() {
        return coronaPatient;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPatientAmka(int patientAmka) {
        this.patientAmka = patientAmka;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setCoronaPatient(boolean coronaPatient) {
        this.coronaPatient = coronaPatient;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
