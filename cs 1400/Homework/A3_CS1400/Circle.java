 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A3
 ***********************************************************/ 
 
public class Circle
{
	
	//private fields
	private double radius;
	{
	
	}
	
	//constructors
	public Circle (double r)
	{
		radius=r;
	}
	
	//public methods
	public double getRadius()
	{
		return radius;
	}
	
	public double diameter()
	{
		return 2 * radius;
	}
	
	public double area()
	{
		return Math.PI * radius * radius;
	}
	
	public double circumference()
	{
		return Math.PI * 2 * radius;
		//return Math.sin(radius)/2;
	}
}