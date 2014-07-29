package ca.bcit.comp2613.restaurant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.util.EmployeeManagement;

public class Report
{

	public static void main(String[] args) 
	{
		PropertyConfigurator.configure(TestDriver.class.getResourceAsStream("log4j.properties")	);
		Logger log = Logger.getLogger(Report.class);
		try
		{
			log.info("Writing to text file....");
			ArrayList<Employee> employee = EmployeeManagement.createEmployee();
			Collections.sort(employee);
			FileUtils.writeLines(new File("employee.txt"), employee );
			log.info(FileUtils.readFileToString(new File("employee.txt") ));
		}
		catch(IOException ex)
		{
			ex.printStackTrace();			
		}
		
	}
	
	

	

}
