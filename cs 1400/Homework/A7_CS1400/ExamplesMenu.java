 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A7
 ***********************************************************/ 
import java.util.Scanner;

public class ExamplesMenu
{
	public static void main(String[] args)
	{
		Scanner doubleInput = new Scanner(System.in);
		Scanner stringInput = new Scanner(System.in);
		Examples myExamples = new Examples();	
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
					myExamples.createPalindrome();
				break;
			
				case 'C': 
				case 'c': 
					System.out.print("\nEnter cone radius: ");
					double radius = doubleInput.nextDouble();
					myExamples.setRadius(radius);
					
					System.out.print("\nEnter cone height: ");
					double height = doubleInput.nextDouble();
					myExamples.setHeight(height);
					
					myExamples.getSide();
					myExamples.getRadius();
					myExamples.getHeight();
					System.out.printf("\nYour cone has a surface area of %.2f and a volume of %.2f\n", 
					myExamples.surfaceArea(), myExamples.volume());
				break;
			
				case 'E': 
				case 'e': 
					System.out.print("\nAmount in dollars to be converted:$ ");
					double dollars = doubleInput.nextDouble();
					myExamples.setDollars(dollars);
					System.out.printf("You get %.2f euros for your %.2f dollars\n",
					myExamples.convertToEuro(), myExamples.getDollars());
				break;

				case 'S': 
				case 's': 
					System.out.print("\nSet new conversion rate: ");
					double euroConversionRate = doubleInput.nextDouble();
					myExamples.setEuroConversionRate(euroConversionRate);
					System.out.printf("\nYour new conversion rate is %.2f euros per dollar\n",
					myExamples.getEuroConversionRate());
				break;
			
				default:
					System.out.println("The End");
			}
		}while("pPcCeEsS".indexOf(choice) != -1);
	}
	
}