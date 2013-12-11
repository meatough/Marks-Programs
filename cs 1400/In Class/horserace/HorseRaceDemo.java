public class HorseRaceDemo
{
	public static void main (String[] args)
	{	
		java.util.Random rand = new java.util.Random();
		//horserace:
		//there are 5 horses in the race: 1 - 5
		//each member of the group of 7 spectators bets on one or more of the horses
		int[][] bets = {
			{2},
			{4},
			{1,3,5},
			{1,2,3},
			{3,5},
			{1,3,4,5},
			{1}
		};
		
		
		//use a random number to establish the winning horse
		int winner = 1 + rand.nextInt(5);
		
		//display winner(s), (index of person(s) who bet on the winning horse)
		System.out.printf("The winner(s) are ");
		for (int person = 0; person < bets.length; person++)
		{
			for (int horse = 0; horse < bets[person].length; horse++)
			{
				if (bets[person][horse] == winner)
				{
					System.out.printf("%d(%d) ",person ,winner);
				}
			}
		}
		 
	}
	
	//display winners
}