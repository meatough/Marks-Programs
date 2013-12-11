 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A6
 ***********************************************************/ 

import java.util.Scanner; 

public class TriangleTest
{
	public static void main (String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		
		System.out.print("Side A: ");
		double sideA = input.nextInt();
		
		System.out.print("Side B: ");
		double sideB = input.nextInt();

		System.out.print("Side C: ");
		double sideC = input.nextInt();
		
		Triangle myTriangle = new Triangle(sideA, sideB, sideC);
		
		System.out.printf("The sides of length (%.1f, %.1f, %.1f)",
		myTriangle.getSideA(), myTriangle.getSideB(), myTriangle.getSideC());
		
		if (myTriangle.isTriangle(sideA, sideB, sideC))
		{
			System.out.print(" make a triangle");
		}
		else
		{
			System.out.print(" do not make a triangle");
		}
		
		if (myTriangle.isRight())
		{
			System.out.print(" that is right.");
		}
		else
		{
			System.out.print("");
		}

		if (myTriangle.isEquilateral())
		{
			System.out.print(" that is equilateral");
		}
		else
		{
			System.out.print("");	
		}	
	}
}