 /*********************************************************** 
 * Programming Assignment 3											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*	
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 
public class Points extends Square
{
	public void trapezoidPoints()
	{
		
	}
	
	public void parallelogramPoints()
	{
		point2X = side1;
		
	}
	
	public void rectanglePoints()
	{
		point2X = side1;
		point3X = side3;
		point3Y = side2;
		point4X = 0;
		point4Y = side4;
		
		System.out.printf("\n\nThe four points of rectangle are: (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f)\n\n\n",
		point1X, point1Y, point2X, point2Y,point3X, point3Y, point4X, point4Y);
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
}