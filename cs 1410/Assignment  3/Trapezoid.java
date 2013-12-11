 /*********************************************************** 
 * Programming Assignment 3											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 
import java.util.Scanner;


public class Trapezoid extends Quadrilateral
{
	Scanner input = new Scanner(System.in);
	
	public double side1;
	public double side2;
	public double side3;
	public double side4;
	public double height;
	double area;
		
	public Trapezoid()	//default constructor
	{
	}
	
	public Trapezoid(double s1, double s2, double s3, double s4, double h)	//parameterized constructor
	{
		side1 = s1;
		side2 = s2;
		side3 = s3;
		side4 = s4;
		height = h;
	}
	
	public void buildTrapezoid()	//Need Trig HERE!!!
	{
		System.out.printf("Enter length of larger base ");
		side1 = input.nextDouble();
		
		System.out.printf("enter length of smaller base ");
		side3 = input.nextDouble();
		
		System.out.printf("enter length of right side ");
		side2 = input.nextDouble();
		
		System.out.printf("enter length of left side ");
		side4 = input.nextDouble();
		
		System.out.printf("enter height less than or equal to shorter of the 2 sides ");
		height = input.nextDouble();
	}
	
	public void trapezoidPoints()
	{
		point2X = side1;
		point3X = side1 - Math.sqrt(side2*side2 - height*height);
		point3Y = height;
		point4X = Math.sqrt(side4*side4 - height*height);
		point4Y = height;
		
		System.out.printf("\n\nThe four points of Trapezoid are: (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f) (%.1f, %.1f)\n\n\n",
		point1X, point1Y, point2X, point2Y,point3X, point3Y, point4X, point4Y);		
	}
	
	public void trapezoidArea()
	{
		area = (0.5)*(side1 + side3)*height;
		System.out.printf("Area = %.2f", area);

	}
	
}
