 /*********************************************************** 
 * Programming Assignment 4											*
 * Distance program														*
 * Programmer: Mark Eatough											*
 * Course: CS1410 														*
 * Created February 28, 2012											*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
import java.util.Scanner;

public class ExceptionB extends ExceptionA
{
	public String name;
	public char choice;

	Scanner charInput = new Scanner(System.in);
	Scanner input = new Scanner(System.in);
	
	public ExceptionB()	//default constructor
	{
	}
	
	public void setName() throws ExceptionB
	{
		System.out.println("\n    1 . . . enter your name ");
		System.out.println("    2 . . . continue to program ");
		
		choice = charInput.nextLine().charAt(0);
		
		if(choice == '1')
		{
			System.out.print("What is your name? ");
			String name = input.nextLine();
		}
		
		if(choice != '1')
		{
			System.out.println("Error, you must enter your name ");
			throw new ExceptionB();
		}
		
		//if(choice != '1')
		//{
			//System.out.printf("%s is not a valid choice", choice);
			//throw new ExceptionB();
		//}
		
		//if(choice != '1')
		//{
			//System.out.printf("%s is not a valid choice", choice);
			//throw new ExceptionB();
		//}

				
	}//end method		
}//end class
