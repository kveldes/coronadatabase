//Η κλάση αύτη είναι ένας RESTful controller ώστε να διαχειρίζεται όλα τα HTTP αιτήματα.
// This class is a RESTful controller to handle all HTTP requests.
package com.test.coronadatabase.web;

import com.test.coronadatabase.domain.Patient;
import com.test.coronadatabase.domain.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    //Dependency Injection του PatientRepository ώστε να είμαστε σε θέση να επιστρέψουμε Patients από την Db.
    //Εν συνέχεια μπορούμε να κάνουμε χρήση της μεθόδου Findall που το Repository περιέχει για να κάνουμεe fetch όλους τους Patients.
    // Dependency Injection of PatientRepository so that we can return Patients from Db.
    // Then we can use the Findall method that the Repository contains to fetch all Patients.

    // Dependency Injection of PatientRepository so that we can return Patients from Db.
    // Then we can use the Findall method that the Repository contains to fetch all Patients.
    // Dependency Injection of PatientRepository so that we can return Patients from Db.
    // Then we can use the Findall method that the Repository contains to fetch all Patients.

    @Autowired
    private PatientRepository repository;


    //Η μέθοδος αυτή του PatientController διάμεσου της σήμανσης @RequestMapping καθορίζει το endpoint που η μέθοδος δείχνει.
    // Όταν ένας χρήστης πάει στο endpoint  /patients τότε εκτελείτε η getPatients() μέθοδος η οποία επιστρέφει όλα τα patient objects
    // υπό μορφή JSON objects από την Jackson Library.
    //Η μεθοδος αυτη by default επεξεργαζετε ολες τις HTTP μεθοδους (Get,Put,Post,Delete,k.o.k).
    @RequestMapping("/patients")
    public Iterable<Patient> getPetients() {
        return repository.findAll();
    }
}
