/*********************************************************** 
 * Programming Assignment 7											*
 * Face card program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created April 15, 2012												*
 * Modified April 24, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 
 enum Suit
{
	DIAMONDS("Diamonds"),
	CLUBS("Clubs"),
	HEARTS("Hearts"),
	SPADES("Spades");
	
	String label; //string label for the suit
	
	Suit( String label )
	{
		this.label = label;
	}
	
	String label()
	{
		return label;
	}
}//end enum Suit

/*
* defines the rank (face value) of each card
*/
enum Rank
{
	ACE("Ace"),
	DEUCE("Duece"),
	THREE("Three"),
	FOUR("Four"),
	FIVE("Five"),
	SIX("Six"),
	SEVEN("Seven"),
	EIGHT("Eight"),
	NINE("Nine"),
	TEN("Ten"),
	JACK("Jack"),
	QUEEN("Queen"),
	KING("King");

	String label; //string label for the rank
	
	Rank( String label )
	{
		this.label = label;
	}
	
	String label()
	{
		return label;
	}
}//end enum Rank

/*
* represents one face card in a standard 52 card deck
*/
public class Card 
{
	private Rank rank;
	private Suit suit;

	public Card(Suit suit, Rank rank) 
	{
		this.suit = suit;
		this.rank = rank;
    }

	@Override
	public String toString()
	{
		return String.format("%s of %s", rank.label(), suit.label());	
	}

}//end class CardEnum
