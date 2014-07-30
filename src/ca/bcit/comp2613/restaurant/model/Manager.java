package ca.bcit.comp2613.restaurant.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Manager 
{
	@Id
	private String id;
	private String firstName;
	private String lastName;	
	private Gender sex;
	
	@ManyToMany(cascade = CascadeType.ALL)
	
	@JoinTable(name = "manager_employee",
	joinColumns = { @JoinColumn(name = "manager_id") },
	inverseJoinColumns = { @JoinColumn(name = "employee_id") } )
	
	private List<Employee> employees;
	
	public Manager()
	{
		
	}
	
	public Manager(String id, String firstName, String lastName, Gender sex) 
	{
		// TODO Auto-generated constructor stub
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;		
		this.sex = sex;
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
		public String getId() 
		{
			return id;
		}

		public void setId(String id)
		{
			this.id = id;
		}
		

		// get set gender
		public Gender getSex() {
			return sex;
		}

		public void setSex(Gender sex) {
			this.sex = sex;
		}

		public List<Employee> getEmployees() 
		{
			return employees;
		}

		public void setEmployees(List<Employee> employees)
		{
			this.employees = employees;
		}

		@Override
		public String toString()
		{
			return "ID: \t" + id + "\tFirst Name: " + firstName + " \t Last Name: " + lastName + "\t Gender: " + sex;
		}
		
		
} // end Class Management
