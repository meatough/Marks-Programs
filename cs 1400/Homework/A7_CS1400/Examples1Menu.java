 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A7
 ***********************************************************/ 

import java.util.Scanner;

public class Examples1Menu
{
	public static void main(String[] args)
	{
		Scanner doubleInput = new Scanner(System.in);
		Scanner stringInput = new Scanner(System.in);
		Examples1 myExamples1 = new Examples1();	
		char choice;
		
		do
		{
			System.out.println("\n    P . . . Create Palindrome ");
			System.out.println("    C . . . Cone Info ");
			System.out.println("    E . . . Euro Conversion ");
			System.out.println("    S . . . Set New Euro Conversion Rate ");
			choice = stringInput.nextLine().charAt(0);

		
			switch (choice)
			{
				case 'P': 
				case 'p': 
					myExamples1.createPalindrome("student");					
				break;
			
				case 'C': 
				case 'c': 
					myExamples1.displayConeInfo(10,3);
				break;
			
				case 'E': 
				case 'e': 
					System.out.printf("You will get %.2f euros for your %.2f dollars\n", 
					(myExamples1.convertToEuros(102)-2)*myExamples1.euroConversionRate, myExamples1.convertToEuros(102));
				break;

				case 'S': 
				case 's': 
					System.out.print("\nSet new conversion rate: ");
					double euroConversionRate = doubleInput.nextDouble();
					myExamples1.setEuroConversionRate(euroConversionRate);
				break;
			
				default:
					System.out.println("The End");
			}
		}while("pPcCeEsS".indexOf(choice) != -1);
	}
	
}