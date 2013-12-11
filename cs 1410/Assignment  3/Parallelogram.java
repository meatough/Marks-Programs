 /*********************************************************** 
 * Programming Assignment 3											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 

public class Parallelogram extends Trapezoid
{		
 	public Parallelogram()//default constructor
	{
	}
	
	public void buildParallelogram()	//Need Trig HERE!!!
	{
		System.out.printf("Enter length ");
		side1 = input.nextDouble();
		side3 = side1;
				
		System.out.printf("enter width ");
		side2 = input.nextDouble();
		side2 = side4;
		
		System.out.printf("enter height less than or equal width ");
		height = input.nextDouble();
	}

	public void parallelogramPoints()
	{
		point2X = side1;
		point3X = side1 + Math.sqrt(side2*side2 - height*height);
		point3Y = height;
		point4X = Math.sqrt(side2*side2 - height*height);
		point4Y = height;
		
		System.out.printf("\n\nThe four points of parallelogram are: (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f)\n\n\n",
		point1X, point1Y, point2X, point2Y,point3X, point3Y, point4X, point4Y);		
	}
	
	public void parallelogramArea()
	{
		area = side1*height;
		System.out.printf("Area = %.2f", area);
	}

}
