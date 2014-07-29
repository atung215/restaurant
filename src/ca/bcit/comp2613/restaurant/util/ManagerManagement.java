package ca.bcit.comp2613.restaurant.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ca.bcit.comp2613.restaurant.model.Gender;
import ca.bcit.comp2613.restaurant.model.Manager;

public class ManagerManagement 
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
	
	public ManagerManagement() 
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
	

	
	public static ArrayList<Manager> createManager()
	{
		ArrayList<Manager> managers = new ArrayList<>();
		// String[] names = RANDOM_NAMES.split("\\s");
		for(int loop = 0; loop < 100; loop++)
		{
			Manager mngr = new Manager();
			mngr.setId(Integer.toString(loop));
			mngr.setFirstName(getRandomFirstName());
			mngr.setLastName(getRandomLastName());
			mngr.setSex(getRandomGender());
			managers.add(mngr);
		}
		return managers;
	}
	
	public static void printManager(ArrayList<Manager> managers)
	{
		PropertyConfigurator.configure(EmployeeManagement.class.getResourceAsStream("StaffManagelog4j.properties")	);
		Logger log = Logger.getLogger(EmployeeManagement.class);
		
		Comparator<Manager> mngsCompare = new Comparator<Manager>()
				{
					public int compare(Manager m1, Manager m2)
					{
						int result = m1.getLastName().compareTo(m2.getLastName());
						if(result == 0)
						{
							 m1.getFirstName().compareTo(m2.getFirstName());
						}
						return result;
					}
				};
		Collections.sort(managers, mngsCompare);
		for (Manager manager : managers)
		{
			log.info(manager);
		}
	}
	
	public static ArrayList<Manager> searchFirstNameRegex(ArrayList<Manager> managers, String regex)
	{
		PropertyConfigurator.configure(EmployeeManagement.class.getResourceAsStream("StaffManagelog4j.properties")	);
		Logger log = Logger.getLogger(EmployeeManagement.class);
		
		ArrayList<Manager> findMngr = new ArrayList<>();
		for(Manager manager : managers)
		{
			if(manager.getFirstName().equals(regex))
			{
				log.info( manager);
			}
		}
		return findMngr;
	}
	
	public static void save(List<Manager> managers, Manager manager)
	{
		boolean foundUpdate = false;
		for (Manager allManager : managers) {
			if (allManager.getId().equals(manager.getId())) {
				allManager.setFirstName(manager.getFirstName());
				allManager.setLastName(manager.getLastName());
				foundUpdate = true;
				break;
			}
		}
		if (!foundUpdate) { // do an insert
			managers.add(manager);
		}
	}
	
	public static void delete(List<Manager> managers, Manager manager) 
	{
		Iterator<Manager> iter = managers.iterator();
		while (iter.hasNext()) 
		{
			Manager allManagers = iter.next();
			if (allManagers.getId().equals(manager.getId()))
			{
				iter.remove();
				break;
			}
		}
	}
	
	
	
	
}
