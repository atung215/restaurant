package ca.bcit.comp2613.restaurant.model;

public class Management 
{
	private String firstName;
	private String lastName;
	private String id;
	private Gender sex;
	
	public Management()
	{
		
	}
	
	public Management(String id, String firstName, String lastName, Gender sex) 
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
		public Gender getSex() {
			return sex;
		}

		public void setSex(Gender sex) {
			this.sex = sex;
		}

		@Override
		public String toString()
		{
			return "ID: " + id + "\tFirst Name: " + firstName + " \t Last Name: " + lastName + "\t Gender: " + sex;
		}
		
		
} // end Class Management
