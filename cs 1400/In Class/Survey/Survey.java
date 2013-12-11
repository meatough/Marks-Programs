import java.util.Scanner;

public class Survey
{
	public static void main(String[] args)
	{
		//fields
		Scanner input = new Scanner(System.in);
		int[] results = new int[3];
		char choice;
		
		//statements
		System.out.println("Where would you like to go?");
		
		do
		{
			System.out.print("New Orleans(n), San Francisco(s), Washington DC(w)  ");
			choice = input.nextLine().charAt(0);
			
			switch(choice)
			{
				case'N':
				case'n':
				  ++results[0];
				  break;
				  
				case'S':
				case's':
				  ++results[1];
				  break;
				  
				case'W':
				case'w':
				  ++results[2];
				  break;
				
				default:
					System.out.println("The End");				
			}
		}while("NnSsWw".indexOf(choice) != -1);
		
		System.out.printf("Number of people who want to go to New Orleans: %d\n",results[0]);
		System.out.printf("Number of people who want to go to San Francisco: %d\n",results[1]);
		System.out.printf("Number of people who want to go to Washington DC: %d",results[2]);
	}
}