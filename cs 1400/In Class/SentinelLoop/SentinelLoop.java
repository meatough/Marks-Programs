import java.util.Scanner;

public class SentinelLoop
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("enter integer (exit with -1): ");
		double number = input.nextDouble();
		
		int counter = 0;
		double sum = 0;
		
		while( number != -1)
		{
			sum = sum + number;
			counter++;
			
			System.out.print("enter integer (exit with -1): ");
			number = input.nextDouble();

		
		}
		
		System.out.printf("Sum = %.0f, Average = %.2f", sum, sum / counter);
		
	}
}