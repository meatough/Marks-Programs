public class ArrayDemo6
{
	public static void main(String[] args)
	{
		final int ARRAY_LENGTH = 6;
		
		int[] diceRolls = {1,3,5,6,2,3,4,1,5,6,1,2,3,5,4,2,2,3,2,5,1,6,4};
		int[] dice = new int[ARRAY_LENGTH];
								
		for (int i = 0; i< diceRolls.length; i++)
		{
			++dice[diceRolls[i]-1];
		}
		
		for (int i = 0; i < ARRAY_LENGTH; i++)
		{
			System.out.printf("%d... %d times ",i,dice[i]);
		}
	}
}
