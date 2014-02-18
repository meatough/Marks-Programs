using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Card
{
    class Program
    {
        static void Main(string[] args)
        {
            Card aceSpades = new Card(Suite.Spades, Rank.Ace);
            Card queenHearts = new Card(Suite.Hearts, Rank.Queen);
            Card fiveDiamonds = new Card(Suite.Diamonds, Rank.Five);
            Card nineClubs = new Card(Suite.Clubs, Rank.Nine);
            Console.WriteLine("{0} {1} {2} {3}", aceSpades.ToString(), queenHearts.ToString(), fiveDiamonds.ToString(), nineClubs.ToString());
            
         }
    }
}
