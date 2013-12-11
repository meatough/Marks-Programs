import java.util.Scanner;

public class hoppetyhoptest
{
	public static void main (String[] args)
	{
		Scanner input = new Scanner(System.in);
		hoppetyhop exciting = new hoppetyhop();
		System.out.print("Enter a number: ");
		int k = input.nextInt();
		
		exciting.hoppety(k);
	}
}