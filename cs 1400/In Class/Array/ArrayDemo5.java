public class ArrayDemo5
{
	public static void main(String[] args)
	{
		final int ARRAY_LENGTH = 7;
		
		int[] diceRolls = {1,3,5,6,2,3,4,1,5,6,1,2,3,5,4,2,2,3,2,5,1,6,4};
		int[] dice = new int[ARRAY_LENGTH];
								
		for (int i = 0; i< diceRolls.length; i++)
		{
			++dice[diceRolls[i]];
		}
		
		for (int i = 1; i < ARRAY_LENGTH; i++)
		{
			System.out.printf("%d... %d times ",i,dice[i]);
		}
	}
}
