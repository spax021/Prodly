package com.tests.pojo;

public class Company {

	private String name;
	private int numberOfEmployees;
	private int numberOfCustomers;
	private String country;
	
	public Company() {
		super();
	}
	
	public Company(String name, int numberOfEmployees, int numberOfCustomers, String country) {
		super();
		this.name = name;
		this.numberOfEmployees = numberOfEmployees;
		this.numberOfCustomers = numberOfCustomers;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public String getCountry() {
		return country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
