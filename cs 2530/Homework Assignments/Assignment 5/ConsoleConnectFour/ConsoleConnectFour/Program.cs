/***************************************************************
 * Intermiadiate Programming in c#
 * Console Connect Four Program
 * Programmer: Mark Eatough
 * Course: CSIS 2530 
 * Created October 3, 2013
 *  
 * This program simulates a connect four game.  Player one is red
 * and player 2 is blue, players take turns dropping thier 
 * respectively colored pebbles.  Pebbles fall to the bottom or to
 * a pebble. If a player has four in a row in any direction they win.  
 * The game continues until someone gets four in a row or the game 
 * board is full.  
 ****************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConnectFour
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.SetWindowSize(45, 40);
            ConnectGame game = new ConnectGame();
            game.Start();
        }
    }
}
