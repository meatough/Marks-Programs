import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class PartyGuests
{
	public static void main(String[] args)	
	{
		Scanner input;
		input = new Scanner(System.in);
		
		Random rand = new Random();
	
		ArrayList<String> guests = new ArrayList<String>();
		
		for (int i = 0 ; i<7 ; i++)
		{
			System.out.printf("enter guests name: %s ", i+1);
			guests.add(i, input.nextLine());
		} 
		
		System.out.print("Your invited guests are: ");
		for (String s : guests)
		{
			System.out.printf("%s ", s);
		}
		
		System.out.println("\n\ntwo of your guests cannot attend");
		
		guests.remove(rand.nextInt(7));
		guests.remove(rand.nextInt(6));
		
		System.out.println("\nThe attending guests will now be: ");
		
		for (String s : guests)
		{
			System.out.printf("%s, ", s);
		}
		
		System.out.printf(" \n\nThe number of people attending the party will be: %d", guests.size());
	}
}