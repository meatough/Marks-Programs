 /*********************************************************** 
 * Programming Assignment 4											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 

public class ExceptionC	extends ExceptionB
{
	public int numerator;
	public int denominator;
	public int answer;
	
	public void quotient() throws ExceptionC
	{
		System.out.print("Please enter integer numerator ");
		int numerator = input.nextInt();
				
		System.out.printf("Please enter integer denominator ");
		int denominator = input.nextInt();
		
		if(denominator != 0)	
		{	
			int answer = numerator/denominator;
				
			System.out.printf("\nAnswer: %d/%d = %d\n", numerator, denominator, answer);
		}
		else
		{
			System.out.print("Zero is not a valid denominator");
			throw new ExceptionC();
		}
	}
	
	
}//end ExceptionC class






	