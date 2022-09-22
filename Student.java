package JDBCUI;

public class Student {
	
	int roll=0;
	String name, address;
	
	public Student(int roll, String name, String address)
	{
		super();
		this.roll=roll;
		this.name=name;
		this.address=address;
	}
	public Student(int roll, String name)
	{
		super();
		this.roll=roll;
		this.name=name;
	}
	public Student(String address, int roll)
	{
		super();
		this.roll=roll;
		this.address=address;
	}
	public Student(int roll)
	{
		super();
		this.roll=roll;
	}
	public Student(){	
	}
	
	public void setRoll(int roll)
	{
		this.roll=roll;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public int getRoll()
	{
		return roll;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
}
