/************************

Justin and Mark
CS 1400
Classwork

***********************/
import java.util.Scanner;
import java.util.ArrayList;

public class CardTest
{
	public static void main(String[] args)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card (Rank.JACK, Suit.CLUBS));
		cards.add(new Card (Rank.QUEEN, Suit.SPADES));	
		cards.add(new Card (Rank.FIVE, Suit.DIAMONDS));
	
		for (Card el : cards)
		{ 
			System.out.println(el);
		}
	
	}//end main
	
	
}//end class	