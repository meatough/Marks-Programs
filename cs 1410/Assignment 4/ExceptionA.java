 /*********************************************************** 
 * Programming Assignment 4											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
//http://www.tutorialspoint.com/java/java_exceptions.htm

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

public class ExceptionA extends Exception
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean continueLoop1 = true;
		boolean continueLoop2 = true;
		
		ExceptionB myEB = new ExceptionB();
		ExceptionC myEC = new ExceptionC();

			
		do
		{
			try
			{				
				myEB.setName();
				
				continueLoop1 = false;
			}//end try
			
			catch(ExceptionB exceptionB)
			{
				System.err.printf("\nException: %s\n", exceptionB);
				input.nextLine();
				System.out.println("You must enter your name before continuing ");
				
				//myEB.printStackTrace();
			}
		}while(continueLoop1);//end do while
		
		do
		{
			try
			{
				myEC.quotient();
				
				
				continueLoop2 = false;
			}
			
			catch(ExceptionC exceptionC)
			{
				System.err.printf("\nException: %s\n", exceptionC);
				input.nextLine();
				System.out.println("Please enter a non zero integer ");
				
				myEC.printStackTrace();
			}//end catch
		
		}while(continueLoop2);
			
	}//end main method
}//end ExceptionA class
	

	
