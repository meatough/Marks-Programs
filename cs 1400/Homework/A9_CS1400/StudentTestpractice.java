import java.util.Random;

public class StudentTestpractice
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		final int ARRAY_LENGTH = 13;
		int[] dice = new int[ARRAY_LENGTH];
		
		System.out.print("	Sum		Frequency	Percentage");
								
		for (int i = 0; i< 100000; i++)
		{
			int diceRolls = 1 + rand.nextInt(6) + 1 + rand.nextInt(6);
			++dice[diceRolls];
		}
		
		for (int i = 2; i < ARRAY_LENGTH; i++)
		{
			System.out.println();
			System.out.printf("	%d		%d		%d%%",i,dice[i],dice[i]/1000);
		}
	}
}
