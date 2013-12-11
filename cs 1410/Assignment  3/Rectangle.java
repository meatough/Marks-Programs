 /*********************************************************** 
 * Programming Assignment 3											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 



public class Rectangle extends Parallelogram
{
 	public Rectangle()	//default constructor
	{
	
	}
	
	public void buildRectangle()
	{
	
		System.out.printf("Enter rectangle length ");
		side1 = input.nextDouble();
		side3 = side1;
		
		System.out.printf("enter rectangle width ");
		side2 = input.nextDouble();
		side4 = side2;
	}
	
	public void rectanglePoints()
	{
		point2X = side1;
		point3X = side3;
		point3Y = side2;
		point4X = 0;
		point4Y = side4;
		
		System.out.printf("\n\nThe four points of Rectangle are: (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f)\n\n\n",
		point1X, point1Y, point2X, point2Y,point3X, point3Y, point4X, point4Y);
	}
	
	public void rectangleArea()
	{
		area = side1*side2;
		System.out.printf("Area = %.2f", area);
	}
}
