 /*********************************************************** 
 * Programming Assignment 2
 * Distance program
 * Programmer: Mark Eatough
 * Course: CS1410 
 * Created February 2, 2012
 * Modified February 27, 2012
 * Modified by Mark Eatough
 ***********************************************************/ 
//jar cf Distance.jar;

import java.util.ArrayList;
import java.util.Scanner;

public class Distance
{
	Scanner input = new Scanner(System.in);
	
	//private fields
	private int feet; 	//distance in feet
	{
	}
	
	private int inches;	//distance in inches
	{
	}
			
	//constructors
	public Distance()	//default constructor
	{
	}
	
	public Distance(int ft, int inch)	//parameterized constructor
	{
		feet = ft;
		inches = inch;
	}
	
	//public methods
	public Distance addDistance(Distance d)		//method to add a distance
	{
		System.out.print("\nEnter feet to add ");
       int f = input.nextInt();
		
		System.out.print("\nEnter inches to add ");
       int i = input.nextInt();
					
		feet = f + feet;
		inches=i + inches;
		
		if(inches >= 12)
		{
			feet++; 
			inches = inches-12;
		}

		return new Distance(feet, inches);
	}
	
	public Distance subDistance(Distance d)			//Method to subtract a distance
	{
		System.out.print("\nEnter feet to subtract ");
      int   f = input.nextInt();
		
		System.out.print("\nEnter inches to subtract ");
      int   i = input.nextInt();
			
		feet = feet-f;
		inches= inches-i;

		if(inches <= -1)
		{
			feet--; 
			inches = inches+12;
		}
		
		return new Distance(feet, inches);
	}
	
	public boolean equals(Object obj)	//equals method to create distance object
	{
		boolean flag = false;
		Distance d = ( Distance )obj;
		if( d.feet == feet && d.inches == inches )
		flag = true;
		return flag;
	}
	
	public int hashCode()	//hashcode method
	{
		return feet;
	}
	
	@Override
      public String toString()	//toString method
      {
			return String.format("%d feet %d inches", feet, inches); 
		}

}//end distance class