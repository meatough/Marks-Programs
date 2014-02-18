using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cards
{
    class Deck
    {
        public List<Card> Cards { get; private set; }

        public Deck()
        {
            Cards = NewDeck();
        }
        public Deck(List<Card> cardDeck)
        {
            Cards = cardDeck;
        }
        //shuffles the deck
        public void Shuffle()
        {
            Random rand = new Random();
            int size = Cards.Count;
            int j;
            Card temp;

            for (int i = size - 1; i > 0; i--)
            {
                j = rand.Next(i);
                temp = Cards[i];
                Cards[i] = Cards[j];
                Cards[j] = temp;
            }
        }
        //deals the number of cards specified by the parameter
        public List<Card> Deal(int i)
        {
            int last = Cards.Count-1;
            List<Card> toHand = new List<Card>();
            int j = 0;
            while (j < i)
            {
                toHand.Add(Cards[0]);
                Cards.RemoveAt(0);
                j++;
            }
            return toHand;
        }
        //creates and returns a string based on the cards in the deck
        public override string ToString()
        {
            //when the string is printed we should have four 
            //equally spaced columns
            int k = 0;
            String s = "";
            while(k < Cards.Count)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (k < Cards.Count)
                    {
                        s += string.Format("{0, -9}\t", Cards[k]);
                    }
                    k++;
                }
                s += "\n";
            }
            return s;
        }
        //creates a new complete and sorted deck
        public static List<Card> NewDeck()
        {
            //No need for a sorting method.  loop through ranks 
            //and suites in propper order to sort as it is created
            List<Card> myDeck = new List<Card>();
            Card myCard; 
            foreach (Cards.Rank r in Enum.GetValues(typeof(Rank)))
            {
                foreach (Cards.Suite s in Enum.GetValues(typeof(Suite)))
                {
                    myCard = new Card(s, r);
                    myDeck.Add(myCard);
                }
            }
            return myDeck;
           
        }
    }
}