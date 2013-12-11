 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A6
 ***********************************************************/ 
 
 public class Triangle
{
	//private fields

	private double sideA;
	
	
	private double sideB;
	
	
	private double sideC;
	
	
	//constructors
	//don't need if statement on constructor???
	public Triangle(double a, double b, double c)
	{
		sideA = a;
		sideB = b;
		sideC = c;
	}
	
	//public methods
	public double getSideA()
	{
		return sideA;
	}
	
	public double getSideB()
	{
		return sideB;
	}
	
	public double getSideC()
	{
		return sideC;
	}
	
	//sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideB
	public boolean isTriangle(double sideA, double sideB, double sideC)
	{
		boolean result = false;
		if	(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideB)
		{
			result = true;
		}
		return result;
	}
	
	//sideA = sideB = sideC 
	public boolean isEquilateral()
	{
		boolean result = false;
		
		if (sideA == sideB && sideB == sideC)
		{
			result = true;
		}
		return result;
	}
	
	//sideA^2 + sideB^2 = sideC^2 || sideB^2 + sideC^2 = sideA^2 || sideA^2 + sideC^2 = sideB^2
	public boolean isRight()
	{
		boolean result;
		
		if	(sideA*sideA + sideB*sideB == sideC*sideC || 
			sideB*sideB + sideC*sideC == sideA*sideA || 
			sideA*sideA + sideC*sideC == sideB*sideB)
		{
			result = true;
		}
		
		else
		{ 
			result = false;
		}
		
		return result;
	}
	
}