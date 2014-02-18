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
    class Player
    {
        private string playerName;
        private ConsoleColor myForeColor;
        private ConsoleColor myBackColor;
        private int gridValue;
        private int pos;
        //public Grid myGrid = new Grid();

        //default constructor
        public Player()
        {

        }
        //parameterized constructor
        public Player(string n, ConsoleColor cf, ConsoleColor cb, int gv)
        {
            playerName = n;
            myForeColor = cf;
            myBackColor = cb;
            gridValue = gv;
        }
        public string getName()
        {
            return playerName;
        }
        public ConsoleColor getForegroundColor()
        {
            return myForeColor;
        }


        string n = "";
        //still need to add more from turn handler
        public int myTurn(Grid g)
        {
            pos = Console.CursorTop;
            ClearFrom(pos);
            Console.BackgroundColor = myBackColor;
            Console.ForegroundColor = myForeColor;
            Console.Write("\n\n\n");
            Console.Write("{0}'s turn, Enter your column: ", playerName);
            n = Console.ReadLine();
            int col = TakeInput(n, pos, g);
            return col;
        }//end my turn method
        public Player CreatePlayer(int playerNumber, ConsoleColor playerColor)
        {
            Console.ForegroundColor = playerColor;
            Console.Write("Player {0} will be {1}\nEnter Player {0} Name: ", playerNumber, playerColor.ToString());
            string name = Console.ReadLine();
            Player myPlayer = new Player(name, playerColor, ConsoleColor.Black, playerNumber);

            return myPlayer;
        }
        //method to take valid input
        private int TakeInput(string n, int p, Grid g)
        {
            int col;
            while (!(int.TryParse(n, out col)) || int.Parse(n) > g.GetLength(1)
                    || int.Parse(n) < 1 || g.ColumnFull(col-1) == true)
            {
                Console.SetCursorPosition(0, pos);
                ClearFrom(p);
                if (!(int.TryParse(n, out col)))
                {
                    Console.Write("\n\n\n{0} is not an integer, \nplease enter a number between 1 and {1}: ",
                        n, g.GetLength(1));
                }
                else if (int.Parse(n) > g.GetLength(1) || int.Parse(n) < 1)
                {
                    Console.Write("\n\n\n{0} is not in column range, \nplease enter a number between 1 and {1}: ",
                        n, g.GetLength(1));
                }
                else if (g.ColumnFull(col-1) == true)
                {
                    Console.Write("\n\n\nColumn {0} is full, \nplease enter a different column: ", n);
                }
                n = Console.ReadLine();
            }//end while loop
            return col;
        }//End take input method
        //Method to clear unwanted text
        public void ClearFrom(int p)
        {
            for (int i = p; i < Console.CursorSize; i++)
            {
                Console.WriteLine("\r" + new string(' ', Console.WindowWidth) + "\r");
                Console.BackgroundColor = myBackColor;
            }
            Console.CursorTop = p;
        }
    }
}
