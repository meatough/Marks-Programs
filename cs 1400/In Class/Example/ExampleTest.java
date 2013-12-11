import java.util.Scanner;

public class ExampleTest
{
	public static void main (String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		Example myExample = new Example();
		
		System.out.print("Choose an example: (1): ");
		int choice = input.nextInt();
		
		switch (choice)
		{
			case 1: myExample.example1();
			break;
		}
	}
}