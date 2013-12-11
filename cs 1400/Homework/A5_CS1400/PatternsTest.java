 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A5
 ***********************************************************/ 
 
 import java.util.Scanner;

public class PatternsTest
{
	public static void main (String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		Patterns myPatterns = new Patterns();
		
		System.out.print("Choose a pattern: (1-4): ");
		int choice = input.nextInt();
		
		switch (choice)
		{
			case 1: myPatterns.pattern1();
			break;
			
			case 2: myPatterns.pattern2();
			break;
			
			case 3: myPatterns.pattern3();
			break;
			
			case 4: myPatterns.pattern4();
			break;
			

		}
		
	}
}