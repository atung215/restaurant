package ca.bcit.comp2613.restaurant;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.model.Management;
import ca.bcit.comp2613.restaurant.util.StaffManagement;

public class TestDriver 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		PropertyConfigurator.configure(TestDriver.class.getResourceAsStream("log4j.properties")	);
		Logger log = Logger.getLogger(TestDriver.class);
		
		log.info("------------EMPLOYEES------------");
		//System.out.println("------------EMPLOYEES------------");
		ArrayList<Employee> employee = StaffManagement.createEmployee();
		StaffManagement.printEmployees(employee);
		
		log.info("------------FIND EMPLOYEES------------");
		//System.out.println("------------FIND EMPLOYEES------------");
		ArrayList<Employee> findEmps = StaffManagement.searchFirstName(employee, "RUSSELL");
		StaffManagement.printEmployees(findEmps);
		
		log.info("\n------------MANAGEMENTS------------");
		//System.out.println("\n------------MANAGEMENTS------------");
		ArrayList<Management> manager = StaffManagement.createManagement();
		StaffManagement.printManagements(manager);
		
		log.info("------------FIND MANAGEMENTS------------");
		//System.out.println("------------FIND MANAGEMENTS------------");
		ArrayList<Management> findMngrs = StaffManagement.searchFirstNameRegex(manager, "DANA");
		StaffManagement.printManagements(findMngrs);
		
		//System.out.println(Arrays.toString(Gender.values()));
	}
	 
}
