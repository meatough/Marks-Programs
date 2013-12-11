 /*********************************************************** 
 * Programming Assignment 3											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 



public class Square extends Rectangle
{
	
	public Square()	//default constructor
	{
	}
	
	public void buildSquare()	//method to build square
	{
		System.out.printf("Enter length of sides ");
		side1 = input.nextDouble();
		side4 = side3 = side2 = side1;
		point2X = side1;
		point3X = side3;
		point3Y = side2;
		point4X = 0;
		point4Y = side4;
	} 
	
	public void squarePoints()
	{
		point2X = side1;
		point3X = side3;
		point3Y = side2;
		point4X = 0;
		point4Y = side4;
		
		System.out.printf("\n\nThe four points of Square are: (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f)\n\n\n",
		point1X, point1Y, point2X, point2Y,point3X, point3Y, point4X, point4Y);				
	}

	
	public void squareArea()
	{
		//double area = side1*side2;
		//System.out.printf("Area = %.2f", area);
		rectangleArea();
	}
}
