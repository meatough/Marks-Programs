import java.util.Scanner;

public class SumAvePro
{
	public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	int number;
	
	System.out.print("Please enter a positive 3 digit integer:  ");
	number=input.nextInt();
	
	int firstdigit=number/100;
	int seconddigit=number/10 % 10;
	int thirddigit=number % 10;

	System.out.printf("Sum = %d", firstdigit+seconddigit+thirddigit);
	System.out.printf("Ave = %d", (firstdigit+seconddigit+thirddigit)/3);
	System.out.printf("Pro = %d", firstdigit*seconddigit*thirddigit);
	}
}