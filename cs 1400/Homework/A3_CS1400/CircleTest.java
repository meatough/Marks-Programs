 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A3
 ***********************************************************/ 
import java.util.Scanner;

public class CircleTest
{
	public static void main(String[] args)
	{
		//create new radius object
		Scanner input;
		input = new Scanner(System.in);
		
		System.out.print("Radius: ");
		double radius = input.nextDouble();
		
		Circle myCircle = new Circle(radius);
				
		//print my circe info
		System.out.printf("\nRadius = %.1f", myCircle.getRadius());
		System.out.printf("\nDiameter = %.1f", myCircle.diameter());
		System.out.printf("\nArea = %.1f", myCircle.area());
		System.out.printf("\nCircumference = %.1f", myCircle.circumference());
	}
}
