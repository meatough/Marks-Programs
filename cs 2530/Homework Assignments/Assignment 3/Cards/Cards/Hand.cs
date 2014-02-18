using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cards
{
    class Hand
    {
        public List<Card> cards { get; private set; }

        public Hand(List<Card> newHand)
        {
            //TODO: put sorting method here
            //Use the method Sort from class List<T> to sort the new hand. Then assign it to the property Cards.
            cards = newHand;
        }

        public bool isFlush(List<Card>checkFlush)
        {
            bool flush = false; ;
            
            int size = checkFlush.Count;
            for(int i = size-1; i > 0; i--)
            {
                if(checkFlush[i].Suite == checkFlush[i-1].Suite)
                {
                    flush = true;
                }
                else
                {
                    flush = false;
                    return flush;
                }
            }
       
            return flush;
        }

        public bool isStraight(List<Card> checkStraight)
        {
            bool straight = false;
            
            int size = checkStraight.Count;
            for(int i = 0; i < size-2; i++)
            {
                if(checkStraight[i].Rank == checkStraight[i+1].Rank-1)
                {
                      straight = true;
                }
                else
                {
                    straight = false;
                    return straight;
                }
            }

            return straight;
        }
        
        public override string ToString()
        {

            int k = 0;
            String s = "";
            while(k < cards.Count)
            {
                s += string.Format("{0, -9}", cards[k]);
                k++;
            }
            if (isStraight(cards) == true)
            {
                string straight = "straight";
                s += string.Format("{0, -9}", straight);
            }

            if (isFlush(cards) == true)
            {
                string flush = "flush";
                s += string.Format("{0, -9}", flush);
            }
            /*
            if(cards.isStraight() == true)
             * {
             *    s += "\t Straight";
             * }
             * if(cards.isStraight() == true)
             * {
             *      s+=
             * }
            */
            return s;
        }
    }
}