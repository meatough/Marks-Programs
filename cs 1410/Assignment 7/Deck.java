/*********************************************************** 
 * Programming Assignment 7											*
 * Face card program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created April 15, 2012												*
 * Modified April 24, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 

import java.util.ArrayList;

/*
* represents a deck of 52 face cards
*/
public class Deck
{
	//52 cards (number suits * number ranks) in the deck
	private ArrayList<Card> deck = 
		new ArrayList<Card>(Suit.values().length * Rank.values().length);

	// constructor: assigns suit and rank then adds a card to the deck
	public Deck()
	{
		for( Suit suit : Suit.values() )
			for( Rank rank : Rank.values() )
				deck.add( new Card(suit, rank) );
	}//end Deck()
	
	// display each card in the deck
	public void display()
	{
		for( Card card : deck )
			System.out.println( card );
	}//end display()

}//end class Deck
