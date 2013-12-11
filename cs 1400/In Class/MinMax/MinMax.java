//enter 2 values and then the program will tell you if integer 1 is greater than equal to or less than integer 2

import java.util.Scanner;

public class MinMax
{
	public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	int number1;
	int number2;
	
	System.out.print("enter first integer: ");
	number1=input.nextInt();
	
	System.out.print("enter second integer: ");
	number2=input.nextInt();
	
	if (number1==number2)
		System.out.printf("%d is equal to %d", number1, number2);
		
	if (number1>number2)
		System.out.printf("%d is greater than %d", number1, number2);
		
	if (number1<number2)
		System.out.printf("%d is less than %d", number1, number2);
	}
}