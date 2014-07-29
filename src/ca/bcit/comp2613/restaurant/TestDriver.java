package ca.bcit.comp2613.restaurant;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.model.Manager;
import ca.bcit.comp2613.restaurant.util.EmployeeManagement;
import ca.bcit.comp2613.restaurant.util.ManagerManagement;

public class TestDriver 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		PropertyConfigurator.configure(TestDriver.class.getResourceAsStream("log4j.properties")	);
		Logger log = Logger.getLogger(TestDriver.class);
		
		log.info("------------EMPLOYEES------------");
		//System.out.println("------------EMPLOYEES------------");
		ArrayList<Employee> employee = EmployeeManagement.createEmployee();
		EmployeeManagement.printEmployees(employee);
		
		log.info("\n------------FIND EMPLOYEES------------");
		//System.out.println("------------FIND EMPLOYEES------------");
		ArrayList<Employee> findEmps = EmployeeManagement.searchFirstName(employee, "RUSSELL");
		EmployeeManagement.printEmployees(findEmps);
		
		log.info("\n------------MANAGERS------------");
		//System.out.println("\n------------MANAGEMENTS------------");
		ArrayList<Manager> manager = ManagerManagement.createManager();
		ManagerManagement.printManager(manager);
		
		log.info("\n------------FIND MANAGERS------------");
		//System.out.println("------------FIND MANAGEMENTS------------");
		ArrayList<Manager> findMngrs = ManagerManagement.searchFirstNameRegex(manager, "DANA");
		ManagerManagement.printManager(findMngrs);
		
		//System.out.println(Arrays.toString(Gender.values()));
	}
	 
}
