package ca.bcit.comp2613.restaurant.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.model.Gender;


public class EmployeeManagement
{
	
	
	public static String NAME_STRING = "This is a string instance that creates random words"
			+ " to use for names it will be splitted with a method to insert the field in the name property"
			+ " it will be capitalized after it is insert into the property to have clearer view"
			+ " this is java application assignment two it is one of the course in bcit"
			+ " the string should create about one hundred instance of each class"
			+ " there are two class in this assignment one of them is employee and the other"
			+ " one is called management there will be some method created but not used"
			+ " the assignment have one method call toString method";
	
	// used for random names
	public static String RANDOM_NAMES = "JORDAN EMMA MATTHEW ANDY KEVIN SCOTT DANIEL PAMELA DANA"
			+ " VINCIENT SIMON WINNIE BERNICE SHEERY MINDY ALEX TIFFANY JESSICA ALVIN CINDY PAUL"
			+ " RUSSELL ERIC TIMMY JASON";	
	
	static Random rand = new Random();
	
	public EmployeeManagement() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static Gender getRandomGender()
	{
		Gender randGender = null;
		Gender[] genders = Gender.values();
		randGender = genders[rand.nextInt(genders.length)];
		return randGender;
	}
	
	public static String getRandomFirstName()
	{
		String randFirstName = null;
		String[] first = RANDOM_NAMES.split("\\s");
		randFirstName = first[rand.nextInt(first.length)];
		return randFirstName;		
	}
	
	public static String getRandomLastName()
	{
		String randLastName = null;
		String[] last = RANDOM_NAMES.split("\\s");
		randLastName = last[rand.nextInt(last.length)];
		return randLastName;		
	}
	
	
	public static ArrayList<Employee> createEmployee()
	{
		ArrayList<Employee> Emps = new ArrayList<Employee>();
		
		for(int loop = 1; loop < 101; loop++)
		{
			String firstName = getRandomFirstName();
			String lastName = getRandomLastName();
			Gender gender = getRandomGender();
			Employee employee = new Employee(Integer.toString(loop), firstName, lastName, gender);
			Emps.add(employee);
		}
		return Emps;		
	}
	
	public static void printEmployees(ArrayList<Employee> employees) 
	{
		PropertyConfigurator.configure(EmployeeManagement.class.getResourceAsStream("StaffManagelog4j.properties")	);
		Logger log = Logger.getLogger(EmployeeManagement.class);
		
		
		Collections.sort(employees);
		for (Employee employee : employees)
		{
			log.info( employee);
		}
		
	}
	
	public static ArrayList<Employee> searchFirstName(ArrayList<Employee> employees, String firstName)
	{
		ArrayList<Employee> findEmp = new ArrayList<>();
		for(Employee employee : employees)
		{
			if(employee.getFirstName().equals(firstName))
			{
				findEmp.add(employee);
			}
		}
		return findEmp;
	}

	

} // end class
