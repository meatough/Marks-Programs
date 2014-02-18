using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Cards
{
    class Program
    {
        static void Main(string[] args)
        {
            // create a new deck and display
            Deck deck = new Deck();
            Console.WriteLine("New Deck:\n");
            Console.WriteLine(deck);

            // shuffle deck and display
            deck.Shuffle();
            Console.WriteLine("\n\nShuffeled Deck:\n");
            Console.WriteLine(deck);

            // deal hands from testDeck and display
            deck = new Deck(TestDeck());
            Console.WriteLine("\n\nDealing hands of 5 cards from the test deck:\n");
            while (deck.Cards.Count >= 5)
            {
                Hand hand = new Hand(deck.Deal(5));
                Console.WriteLine(hand);
            }

            Console.WriteLine();
        }
        
        #region TestDeck .. to test IsStraight and IsFlush
        private static List<Card> TestDeck()
        {
            List<Card> testDeck = new List<Card>();
            //Hand myHand = new Hand(testDeck);

            // StaightFlush
            testDeck.Add(new Card(Suite.Spades, Rank.Five));
            testDeck.Add(new Card(Suite.Spades, Rank.Six));
            testDeck.Add(new Card(Suite.Spades, Rank.Seven));
            testDeck.Add(new Card(Suite.Spades, Rank.Eight));
            testDeck.Add(new Card(Suite.Spades, Rank.Nine));
            /*
            if (myHand.isFlush() == true && myHand.isStraight() == true)
            {
                Console.WriteLine("Test passed");
            }
            else
            {
                Console.WriteLine("Test failed");
            }*/
            // Flush
            testDeck.Add(new Card(Suite.Clubs, Rank.Four));
            testDeck.Add(new Card(Suite.Clubs, Rank.Six));
            testDeck.Add(new Card(Suite.Clubs, Rank.Seven));
            testDeck.Add(new Card(Suite.Clubs, Rank.Eight));
            testDeck.Add(new Card(Suite.Clubs, Rank.Queen));
            /*
            if (myHand.isFlush() == true)
            {
                Console.WriteLine("Test passed");
            }
            else
            {
                Console.WriteLine("Test failed");
            }
            */
            // Straight
            testDeck.Add(new Card(Suite.Diamonds, Rank.Six));
            testDeck.Add(new Card(Suite.Diamonds, Rank.Seven));
            testDeck.Add(new Card(Suite.Hearts, Rank.Eight));
            testDeck.Add(new Card(Suite.Hearts, Rank.Nine));
            testDeck.Add(new Card(Suite.Clubs, Rank.Ten));
            /*
            if (myHand.isStraight() == true)
            {
                Console.WriteLine("Test passed");
            }
            else
            {
                Console.WriteLine("Test failed");
            }
            */

            // not quite a flush
            testDeck.Add(new Card(Suite.Clubs, Rank.Deuce));
            testDeck.Add(new Card(Suite.Clubs, Rank.Nine));
            testDeck.Add(new Card(Suite.Clubs, Rank.Six));
            testDeck.Add(new Card(Suite.Clubs, Rank.Queen));
            testDeck.Add(new Card(Suite.Diamonds, Rank.Ten));
            /*
            if (myHand.isFlush() == false)
            {
                Console.WriteLine("Test passed");
            }
            else
            {
                Console.WriteLine("Test failed");
            }
            */
            // not quite a straight
            testDeck.Add(new Card(Suite.Clubs, Rank.Eight));
            testDeck.Add(new Card(Suite.Spades, Rank.Ten));
            testDeck.Add(new Card(Suite.Hearts, Rank.Jack));
            testDeck.Add(new Card(Suite.Spades, Rank.Queen));
            testDeck.Add(new Card(Suite.Diamonds, Rank.King));
            /*
            if (myHand.isStraight() == false)
            {
                Console.WriteLine("Test passed");
            }
            else
            {
                Console.WriteLine("Test failed");
            }
            */
            return testDeck;
        }
        #endregion
    }
}