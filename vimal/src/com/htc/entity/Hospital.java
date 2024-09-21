package com.htc.entity;

import java.util.HashMap;
import java.util.Objects;

import com.htc.dao.IPatientInterface;



public class Hospital implements IPatientInterface {
	private String hospitalname;
	private String location;
	HashMap<String, Patient> hospmap = new HashMap<String, Patient>();

	public Hospital(String hospitalname, String location) {
		super();
		this.setHospitalname(hospitalname);
		this.setLocation(location);
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalname=" + hospitalname + ", location=" + location + ", hospmap=" + hospmap + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hospitalname, hospmap, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		return Objects.equals(hospitalname, other.hospitalname) && Objects.equals(hospmap, other.hospmap)
				&& Objects.equals(location, other.location);
	}

	@Override
	public void createPatient(Patient eobj) {
		// TODO Auto-generated method stub
		hospmap.put(eobj.getId(), eobj);
	}

	@Override
	public Patient readPatient(String id) {
		// TODO Auto-generated method stub
		return hospmap.get(id);
	}

	@Override
	public boolean deletePatient(String id) {
		// TODO Auto-generated method stub
		Patient p = hospmap.get(id);
		hospmap.remove(id,p);
		return false;
	}

	@Override
	public boolean updatePatient(String id, int age) {
		// TODO Auto-generated method stub
		Patient p = hospmap.get(id);
		p.setAge(age);
		return false;
	}

	@Override
	public void getAllPatient() {
		// TODO Auto-generated method stub
		System.out.print(hospmap.toString());
	}
}
