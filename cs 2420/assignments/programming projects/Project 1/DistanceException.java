 /*********************************************************** 
 * Programming Assignment 1
 * Distance program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created January 28, 2013
 * Modified January 31, 2013
 * Modified by Mark Eatough
 ***********************************************************/

import java.util.Scanner;
 
 
 public class DistanceException extends Exception
 {
 	public DistanceException()
	{
	}	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean continueLoop1 = true;
		boolean continueLoop2 = true;
		Distance defaultDistance = new Distance();
		Distance myDistance;
		
		do
		{
			try
			{
				System.out.print("enter feet to add ");
				int theFeet = input.nextInt();
				
				System.out.print("enter inches to add ");
				int theInches = input.nextInt();
				
				myDistance = new Distance(theFeet, theInches);
				
				defaultDistance.addDistance(myDistance);
				
				System.out.printf("Your current distance is %s", defaultDistance);
				
				continueLoop1 = false;
			}
			catch(IllegalArgumentException DistanceException)
			{
				System.err.printf("\n\n\nException: %s\n", DistanceException);
				input.nextLine();
				System.out.println("\n\nPlease enter positive integers only. \n");
			}
		}while(continueLoop1);
		
			do
		{
			try
			{
				System.out.print("\n\n\nenter feet to subtract ");
				int theFeet = input.nextInt();
				
				System.out.print("enter inches to subtract ");
				int theInches = input.nextInt();
				
				myDistance = new Distance(theFeet, theInches);
				
				defaultDistance.subDistance(myDistance);
				
				System.out.printf("Your current distance is %s", defaultDistance);
				
				continueLoop2 = false;
			}
			catch(IllegalArgumentException DistanceException)
			{
				System.err.printf("\n\n\nException: %s\n", DistanceException);
				input.nextLine();
				System.out.println("\n\nPlease enter positive integers only. \n");
			}
		}while(continueLoop2);
	}//end main
}//end class
