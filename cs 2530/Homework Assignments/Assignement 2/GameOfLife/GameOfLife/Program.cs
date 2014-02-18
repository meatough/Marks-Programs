/***************************************************************
 * Intermiadiate Programming in c#
 * Game of Life Program
 * Programmer: Mark Eatough
 * Course: CSIS 2530 
 * Created September 5, 2013
 *  
 * This program simulates the game of life, if a dead cell has 
 * exactly 3 living neighbors it regenerates.  If a live cell has
 * less than 2 living neighbors or more than 3 living neighbors 
  * it dies.  Game starts when user presses enter, game ends when
 * user presses any key.
 ****************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfLife
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.SetWindowSize(45, 40);
            GameOfLife game = new GameOfLife();
            game.Start();
        }
    }
}
