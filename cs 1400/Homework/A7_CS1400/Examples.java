 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A7
 ***********************************************************/ 
 
public class Examples
{
	//field
	
	private double euroConversionRate = 0.69;
	
	private double dollars;
	{
	}
	
	private double height;
	{
	}
	
	private double radius;
	{
	}
	
	private double side;
	{
	}
		
	//methods
	
	public void createPalindrome()
	{
	
	}
		
	public double getRadius()
	{
		return radius;
	}
	
	public void setRadius(double myRadius)
	{
		if (radius >= 0)
		radius = myRadius;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setHeight(double myHeight)
	{
		if (height >= 0)
		height = myHeight;
	}
	
	public double getSide()
	{
		return side = Math.hypot(radius, height);
	}
	
	public double surfaceArea()
	{
		return (Math.PI * radius * side) + (Math.PI * radius * radius);
	}
	
	public double volume()
	{
		return radius * radius * height * Math.PI / 3;
	}
	
	public double getDollars()
	{
		return dollars;
	}
	
	public void setDollars(double myMoney)
	{
		if (dollars >= 0)
		dollars = myMoney;	
	}
	
	public double convertToEuro()
	{
		return (dollars - 2) * euroConversionRate;
	}
	
	public void setEuroConversionRate(double myRate)
	{
		if (euroConversionRate >= 0)
		euroConversionRate = myRate;
	}
	
	public double getEuroConversionRate()
	{
		return euroConversionRate;
	}
}