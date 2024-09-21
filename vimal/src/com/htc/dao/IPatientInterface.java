package com.htc.dao;

import com.htc.entity.Patient;

public interface IPatientInterface {
	public void createPatient(Patient eobj);
	public Patient readPatient(String id);
	public boolean deletePatient(String id);
	boolean updatePatient(String id, int age);
	public void getAllPatient();

}
