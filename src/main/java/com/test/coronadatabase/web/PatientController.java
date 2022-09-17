/*
 -5-
  Η κλάση αυτή είναι ένας RESTful controller ώστε να διαχειρίζεται όλα τα HTTP αιτήματα.
  This class is a RESTful controller to handle all HTTP requests.
*/
package com.test.coronadatabase.web;

import com.test.coronadatabase.domain.Patient;
import com.test.coronadatabase.domain.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    /*
     Dependency Injection του PatientRepository ώστε να είμαστε σε θέση να επιστρέψουμε Patients από την Db.
     Εν συνέχεια μπορούμε να κάνουμε χρήση της μεθόδου Findall που το Repository περιέχει για να κάνουμε fetch όλους τους Patients.
    */

    @Autowired
    private PatientRepository repository;


    /**
     * Η μέθοδος αυτή του PatientController διάμεσου της σήμανσης @RequestMapping καθορίζει το endpoint που η μέθοδος δείχνει.
     * Όταν ένας χρήστης πάει στο endpoint  /patients τότε εκτελείτε η getPatients() μέθοδος η οποία επιστρέφει όλα τα patient objects
     * υπό μορφή JSON objects από την Jackson Library.
     * Η μέθοδος αυτή by default επεξεργάζεστε ολες τις HTTP μεθόδους (Get,Put,Post,Delete,k.o.k).
     */
    @RequestMapping("/patients")
    public Iterable<Patient> getPetients() {
        return repository.findAll();
    }
}
