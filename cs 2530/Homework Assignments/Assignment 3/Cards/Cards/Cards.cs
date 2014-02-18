using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cards
{
    enum Rank { Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King }
    enum Suite { Spades = 9824, Clubs = 9827, Hearts = 9829, Diamonds = 9830 }

    struct Card : IComparable<Card>
    {
        public Rank Rank { get; private set; }
        public Suite Suite { get; private set; }

        public Card(Suite mySuite, Rank myRank) : this()
        {
            Suite = mySuite;
            Rank = myRank;
        }
        
        public override string ToString()
        {
            return string.Format("{0} {1}", (char)Suite, Rank);
        }
        
        public int CompareTo(Card other)
        {
            //If ranks are not equal, compare ranks 
            if (this.Rank != other.Rank)
            {
                return (int)this.Rank.CompareTo((int)other.Rank);
            }
            //if ranks are equal, compare suites
            else
            {
                return (int)this.Suite.CompareTo((int)other.Suite);
            }
        }
    }
}
