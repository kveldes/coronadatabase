/*
**Παρέχει CRUD λειτουργικότητα για την Patient Entity Class.
Οι  <Patient,Long> τύποι παραμέτρων καθορίζουν ότι είναι το repository για την Patient Enity class
 και ο τύπος του ID field είναι long.
 ** Provides CRUD functionality for the Patient Entity Class.
 The <Patient, Long> parameter types specify that it is the repository for the Patient Enity class
 and the ID field type is long.
*/


package com.test.coronadatabase.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface PatientRepository extends CrudRepository<Patient, Long> {
    /**
     * Fetch Patients by patientAmka
     */
    List<Patient> findBypatientAmka(@Param("patientAmka") String patientAmka);
    /**
     * Fetch Patients by lastName
     */
    List<Patient> findBylastName(@Param("lastName") String lastName);
    /**
     * Fetch Patients by coronaPatient
     */
    List<Patient> findBycoronaPatient(@Param("coronaPatient") String coronaPatient);

}
