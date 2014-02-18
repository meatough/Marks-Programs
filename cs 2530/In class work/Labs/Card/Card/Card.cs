using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Card
{
    enum Rank { Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace }
    enum Suite { Spades = 9824, Clubs = 9827, Hearts = 9829, Diamonds = 9830 }
    struct Card
    {
        //auto implemented properties
        public Suite Suite { get; private set; }
        public Rank Rank { get; private set; }
        //constructor
        public Card( Suite mySuite, Rank myRank) : this()
        {
            Suite = mySuite;
            Rank = myRank;
        }
        
        public override string ToString()
        {
            return string.Format("{0} {1}", (char)Suite, Rank);
        }
    }
}
