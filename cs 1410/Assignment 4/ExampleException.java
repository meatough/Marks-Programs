import java.util.Scanner;
import java.util.InputMismatchException;

public class ExampleException
{
	//int numerator;
	//int denominator;
	//int answer;
	
	public static int quotient(int numerator, int denominator)
	{
		return numerator/denominator;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean continueLoop = true;
		
		do
		{
			try
			{
				System.out.print("Please enter integer numerator ");
				int numerator = input.nextInt();
				
				System.out.print("Please enter integer denominator ");
				int denominator = input.nextInt();
				
				int answer = quotient(numerator, denominator);
				
				System.out.printf("\nAnswer: %d/%d = %d\n", numerator, denominator, answer);
				
				continueLoop = false;
			}//end try
			
			catch(InputMismatchException inputMismatchException)
			{
				System.err.printf("\nException: %s\n", inputMismatchException);
				input.nextLine();
				System.out.println("Please enter integers only. \n");
			}//end catch
			
			catch(ArithmeticException arithmaticException)
			{
				System.err.printf("\nException: %s\n", arithmaticException);
				input.nextLine();
				System.out.println("Please enter a non-zero denominator. \n");
			}//end catch
		}while(continueLoop);
	}//end main
}//end class