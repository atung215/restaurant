package ca.bcit.comp2613.restaurant.model;

public enum Gender 
{
	MALE("M"), FEMALE("FE");
	
	private String gender;
	
	Gender(String gender)
	{
		this.gender = gender;
		// TODO Auto-generated constructor stub
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

}
