package com.test.coronadatabase;

import com.test.coronadatabase.domain.Patient;
import com.test.coronadatabase.domain.PatientRepository;
import com.test.coronadatabase.domain.User;
import com.test.coronadatabase.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.test.coronadatabase.web.PatientController"})
public class CoronadatabaseApplication {
	@Autowired  //Dependency injection: Εισάγουμε τo Patient Repository ώστε να μπορώ να σώζω Patient Objects στην Database.
	           // Dependency injection: We import the Patient Repository so that I can save Patient Objects in the Database.
	private PatientRepository repository; //Αφού έχω κάνει injection το repository μπορώ να κάνω χρήση μετα των CRUD μεθόδων που αυτό διαθέτει.
	                                     // After I have injected the repository I can use it after the CRUD methods that it has.


	@Autowired  //Dependency injection: Εισάγουμε τo User Repository ώστε να μπορώ να σώζω test users στην Database.
	private UserRepository urepository; //Αφού έχω κάνει injection το repository μπορώ να κάνω χρήση μετα των CRUD μεθόδων που αυτό διαθέτει.

	public static void main(String[] args) {

		SpringApplication.run(CoronadatabaseApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(){ //To Spring Boot Command Line Runner Interface μας επιτρέπει να εκτελούμε επιπρόσθετο κώδικα πριν η εφαρμογή αρχίσει.
		return args -> {
			// Save demo data to database
			repository.save(new Patient("LastName1","FirstName1","28/9/1975",
					"Athens","SomePlace1",1111111,18344,"2109784456",false));
			repository.save(new Patient("LastName2","FirstName2","28/9/1980",
					"Athens","SomePlace2",1111456,18380,"2109784456",false));
			repository.save(new Patient("LastName3","FirstName3","28/9/2000",
					"Athens","SomePlace3",1111111,18344,"2109784456",false));

			// username: user password: user
			urepository.save(new User("user",
					"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					"USER"));
			// username: admin password: admin
			urepository.save(new User("admin",
					"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
					"ADMIN"));
		};
	}

}

