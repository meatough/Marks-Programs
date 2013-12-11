 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A3
 ***********************************************************/ 
 
 public class Employee
 {
 	//private fields
	private String name;
	{
	}
	
	private double hoursWorked;
	{
	}
	
	private double hourlyRate;
	{
	}
	
	//constructors
	public Employee (String n, double hW, double hR)
	{
		name = n;
		
		hoursWorked = hW;
		
		hourlyRate = hR;
	}


	//public methods
	public String getName()
	{
		return name;
	}
	
	public double getHoursWorked()
	{
		return hoursWorked;
	}
	
	public void setHoursWorked(double myHours)
	{
		if (myHours>=0)
		hoursWorked = myHours;
		else hoursWorked = 10;
	}
	
	public double getHourlyRate()
	{
		return hourlyRate;
	}
	
	public void setHourlyRate(double myRate)
	{
		if (myRate>=0)
		hourlyRate = myRate;
		else hourlyRate = 7;
	}
	
	public double grossPay()
	{
		if (hoursWorked <= 40)
			return (hoursWorked * hourlyRate);
			
		else 
			return ((hoursWorked - 40) * (1.5 * hourlyRate) + (40 * hourlyRate));
	}
	
 }