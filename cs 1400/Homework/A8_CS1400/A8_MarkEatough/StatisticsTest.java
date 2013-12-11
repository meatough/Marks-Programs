 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A7
 ***********************************************************/ 
 
import java.util.Scanner;
 public class StatisticsTest
 {
 	public static void main(String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		Statistics myStatistics = new Statistics();
		char choice;
		
		do
		{
			System.out.println("\n    1 . . . data set 1 ");
			System.out.println("    2 . . . data set 2 ");
			System.out.println("    3 . . . data set 3 ");
			choice = input.nextLine().charAt(0);
		
			switch (choice)
			{
				case '1': 
					double[] data1 = {13f,18f,13f,14f,13f,16f,14f,21f,13f};
					for (int i = 0; i< data1.length; i++)
					{
						System.out.printf(" %.1f", data1[i]);
					}
					
					System.out.printf("\n min = %.1f\n",myStatistics.min(data1));
					System.out.printf("\n max = %.1f\n",myStatistics.max(data1));
					System.out.printf("\n mean = %.1f\n",myStatistics.mean(data1));
					System.out.printf("\n median = %.1f\n",myStatistics.median(data1));
					System.out.printf("\n range = %.1f\n",myStatistics.max(data1) - myStatistics.min(data1));

				
				break;
			
				case '2': 
					double[] data2 = {13.0,17.5,25.0,20.4,13.5,10.4,11.6,10.2,16.0,23.0,19.5,14.0,15.0,24.2}; 
					for (int i = 0; i< data2.length; i++)
					{
						System.out.printf(" %.1f", data2[i]);
					}
					
					System.out.printf("\n min: %.1f\n",myStatistics.min(data2));
					System.out.printf("\n max: %.1f\n",myStatistics.max(data2));
					System.out.printf("\n mean: %.1f\n",myStatistics.mean(data2));
					System.out.printf("\n median: %.1f\n",myStatistics.median(data2));
					System.out.printf("\n range: %.1f\n",myStatistics.max(data2) - myStatistics.min(data2));

				break;
						
				case '3': 
					for (int i = 0; i< 23; i++)
					{
						System.out.printf(" %d\n",i);
					}
				break;
				
				default:
					System.out.println("The End");
			}


		}while("123".indexOf(choice) != -1);
	}
 }