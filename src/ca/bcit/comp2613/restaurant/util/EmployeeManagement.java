package ca.bcit.comp2613.restaurant.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.model.Gender;
import ca.bcit.comp2613.restaurant.model.Manager;


public class EmployeeManagement
{
		
	public static String LASTNAMES = "EMPLOYEE CASHIER PRODUCTION FRONTCOUNTR";
	
	// used for random names
	public static String RANDOM_NAMES = "JORDAN EMMA MATTHEW ANDY KEVIN SCOTT DANIEL PAMELA DANA"
			+ " VINCIENT SIMON WINNIE BERNICE SHEERY MINDY ALEX TIFFANY JESSICA ALVIN CINDY PAUL"
			+ " RUSSELL ERIC TIMMY JASON";	
	
	static Random rand = new Random();
	
	public EmployeeManagement() 
	{
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
		String[] last = LASTNAMES.split("\\s");
		randLastName = last[rand.nextInt(last.length)];
		return randLastName;		
	}
	
	
	public static ArrayList<Employee> createEmployee()
	{
		ArrayList<Employee> Emps = new ArrayList<Employee>();
		
		for(int loop = 0; loop < 100; loop++)
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

	public static void save(List<Employee> employees, Employee employee) 
	{
		boolean foundUpdate = false;
		for (Employee allEmployee :employees)
		{
			if (allEmployee.getId().equals(employee.getId()))
			{
				allEmployee.setFirstName(employee.getFirstName());
				allEmployee.setLastName(employee.getLastName());
				foundUpdate = true;
				break;
			}
		}
		if (!foundUpdate) { // do an insert
			employees.add(employee);
		}		
	}

	public static void delete(List<Employee> employees, Employee employee) 
	{
		Iterator<Employee> iter = employees.iterator();
		while (iter.hasNext()) 
		{
			Employee allEmployee = iter.next();
			if (allEmployee.getId().equals(employee.getId()))
			{
				iter.remove();
				break;
			}
		}		
	}

	public static Employee findID(Long id, List<Employee> employees) 
	{
		for(Employee allEmployees : employees)
		{
			if(allEmployees.getId().equals(id))
			{
				return allEmployees;
			}
		}
		return null;
	}

	public static void assignEmployeesToManagers(List<Manager> managers, List<Employee> employees)
	{
		int employeeTotal = employees.size();
		for(Manager manager : managers)
		{
			Random rand = new Random();
			for(int count = 0; count < 10; count++)
			{
				int randEmployee = rand.nextInt(employeeTotal);
				Employee randomEmployee = employees.get(randEmployee);
				if(manager.getEmployees() == null)
				{
					manager.setEmployees(new ArrayList<Employee>());
				}
				ManagerManagement.addToGroup(manager, randomEmployee, employees);
			}
		}
	}
	

} // end class
