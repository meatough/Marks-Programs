/************************

Justin and Mark
CS 1400
Classwork

***********************/
enum Suit {DIAMONDS, HEARTS, CLUBS, SPADES}
			
enum Rank {DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

public class Card
{
	private Rank rank;
	private Suit suit;
	
	public Card (Rank r, Suit s)
	{
		rank = r;
		suit = s;
	}
				
		@Override 
		public String toString()
		{
			return String.format("%s of %s",rank, suit);   
		}	
			
	//}//end main
	
}//end class	