package ca.bcit.comp2613.restaurant.model;

public class Employee implements Comparable<Employee>
{
	private String firstName;
	private String lastName;
	private String id;
	private Gender sex;

	public Employee()
	{
		
	}
		
	public Employee( String id, String firstName, String lastName, Gender sex) 
	{
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
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
	public Gender getSex() 
	{
		return sex;
	}

	public void setSex(Gender sex) 
	{
		this.sex = sex;
	}

	@Override
	public String toString()
	{
		return "First Name: " + firstName + "\t Last Name: " + lastName + "\tGender: " + sex;
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