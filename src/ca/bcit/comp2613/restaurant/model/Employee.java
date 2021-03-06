package ca.bcit.comp2613.restaurant.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee implements Comparable<Employee>
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;	
	private Gender sex;
	private double hourlyRate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	
	@JoinTable(name = "manager_employee", 
	joinColumns = { @JoinColumn(name = "employee_id")	}, 
	inverseJoinColumns = { @JoinColumn(name = "manager_id") } )
	
	private List<Manager> managers;

	public Employee()
	{
		
	}
		
	public Employee( Long id, String firstName, String lastName, Gender sex, double hourlyRate) 
	{
		// TODO Auto-generated constructor stub
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;		
		this.sex = sex;
		this.hourlyRate = hourlyRate;
	}
	
	public Employee( String id, String firstName, String lastName, Gender sex, double hourlyRate) 
	{
		// TODO Auto-generated constructor stub
		this.id = Long.parseLong(id);
		this.firstName = firstName;
		this.lastName = lastName;		
		this.sex = sex;
		this.hourlyRate = hourlyRate;
	}

	// get set first Name
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	
	// get set last name
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	
	// get set id
	public Long getId() 
	{
		return id;
	}	
	
	// get set gender
	public Gender getSex() 
	{
		return sex;
	}

	public void setSex(Gender sex) 
	{
		this.sex = sex;
	}
	
	public double getHourlyRate()
	{
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	}

	public List<Manager> getManagers()
	{
		return managers;		
	}
	
	public void setManagers(List<Manager> managers)
	{
		this.managers = managers;		
	}

	@Override
	public String toString()
	{
		return "ID: \t" + id + "\tFirst Name: " + firstName + "\t Last Name: " + lastName + "\tGender: " + sex;
	}

	@Override
	public int compareTo(Employee ee) 
	{
		if(ee == null)
		{
			return 1;
		}
		int result = firstName.compareTo(ee.firstName);
		if(result == 0)
		{
			return this.lastName.compareTo(lastName);
		}
		return result;
	}
	
} // end class Employee