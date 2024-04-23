package com.tests.config;

import java.util.ArrayList;
import java.util.List;

import com.tests.pojo.Company;

public class CompanyGenerator {

	private ArrayList<Company> companies;
	private String header = "name,num_employees,num_customers,country\n";
	private String preparedCompanies = "";
	
	private Company comp1;
	private Company comp2;
	private Company comp3;
	private Company comp4;
	private Company comp5;
	
	public CompanyGenerator() {
		super();
		createCompanies();
	}

	public String getCompanies() {
		return prepareCsvContent(companies);
	}
	
	private void createCompanies() {
		companies = new ArrayList<Company>();
		companies.add(comp1 = new Company("TestName1", 10, 20, "SRB"));
		companies.add(comp2 = new Company("TestName2", 20, 30, "CAD"));
		companies.add(comp3 = new Company("TestName3", 30, 40, "USA"));
		companies.add(comp4 = new Company("TestName4", 40, 50, "CYP"));
		companies.add(comp5 = new Company("TestName5", 50, 60, "ITA"));
	}

	private String prepareCsvContent(ArrayList<Company> comps) {
		for (Company company : comps) {
			preparedCompanies = preparedCompanies + prepareOneLine(company);
		}
		return header + preparedCompanies;
	}

	private static String prepareOneLine(Company comp) {
		String oneLine = comp.getName() + "," + 
						 comp.getNumberOfEmployees() + "," + 
						 comp.getNumberOfCustomers() + "," + 
						 comp.getCountry() + "\n";
		return oneLine;
	}

}
