package com.htc.entity;

import java.util.Objects;

import com.htc.exceptions.InvalidAgeException;








public class Patient {
	
	private String id;
	private String name;
	private double age;
	private String address;

	public Patient(String id, String name, double age, String address) throws InvalidAgeException {
		super();
		if(age > 0) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;}
		else throw new InvalidAgeException("Age is Invalid");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(address, other.address)
				&& Double.doubleToLongBits(age) == Double.doubleToLongBits(other.age) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}
