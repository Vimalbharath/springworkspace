package com.htc.main;

import com.htc.entity.Hospital;
import com.htc.entity.Patient;
import com.htc.exceptions.InvalidAgeException;


public class MainMethod {
	public static void main(String[] args) throws InvalidAgeException {
		
		// Creating patients
		Patient p1 = new Patient("P01", "Vijay", 23, "Madurai");
		Patient p2 = new Patient("P02", "Raj", 76, "Trichy");
		Patient p3 = new Patient("P03", "Giri", 12, "Namakkal");
		try {
			Patient p4 = new Patient("P04", "Sri", -12, "Chennai");
		}
		
		catch(InvalidAgeException e) {
			e.printStackTrace();
		
	   	 System.out.println("Exception handled:Age is Invalid,Enter correct age" );
		}
		
		// Adding to map
		Hospital hosp = new Hospital("Jipmer", "Pondy");
		
		// Adding patients
		hosp.createPatient(p1);
		hosp.createPatient(p2);
		hosp.createPatient(p3);
		
		// Display all
		hosp.getAllPatient();
		
		//Update Patient age
		hosp.updatePatient("P01",45);
		hosp.getAllPatient();
		
		//Delete Patient
		hosp.deletePatient("P01");
		hosp.getAllPatient();
		
		

	}
}
