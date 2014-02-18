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
    class ConnectGame
    {
        Player player1 = new Player();
        Player player2 = new Player();
        Grid myGrid = new Grid();
        private int turnControl = 0;
        private String title = "Connect Four";
        private String startMessage = "Press enter to begin";
        private String fullMessage = "\n\n\nGame board full,\ngame ends in a draw,\nno one wins";
        private int pos;
        private bool winner;
        ConsoleKeyInfo cki = new ConsoleKeyInfo();
        //Method to play the game
        public void Start()
        {
            setup();
            do
            {
                Player win = TurnHandler();
                if (myGrid.GridFull() == true)
                {
                    player1.ClearFrom(pos);
                    Console.CursorTop = pos;
                    Console.WriteLine("\r" + new string(' ', Console.WindowWidth) + "\r");
                    Color(0, fullMessage, ConsoleColor.Black, ConsoleColor.Green);
                    Console.WriteLine("\n\n\n");
                }
                if (winner == true)
                {
                    player1.ClearFrom(pos);
                    Console.CursorTop = pos;
                    Console.WriteLine("\r" + new string(' ', Console.WindowWidth) + "\r");
                    Console.WriteLine("\r" + new string(' ', Console.WindowWidth) + "\r");
                    Console.ForegroundColor = win.getForegroundColor();
                    Console.BackgroundColor = ConsoleColor.Black;
                    Console.WriteLine("\n\nCongratulations {0}, you win!!!", win.getName());
                }
            } while (myGrid.GridFull() != true && winner != true);
        }
        private void Color(int cursor, string phrase, ConsoleColor backColor, ConsoleColor foreColor)
        {
            Console.CursorLeft = cursor;
            Console.BackgroundColor = backColor;
            Console.ForegroundColor = foreColor;
            Console.WriteLine(phrase);
        }
        //Method to enter player to start game
        private void EnterPlayers()
        {
            Console.WriteLine("Welcome to Connect Four,\nPlease enter players names:\n\n");
            ConsoleColor color1 = ConsoleColor.Red;
            ConsoleColor color2 = ConsoleColor.Blue;
            player1 = player1.CreatePlayer(1, color1);
            Console.WriteLine();
            player2 = player2.CreatePlayer(2, color2);
        }//end enter players metod
        //Method to handle whose turn it is
        private Player TurnHandler()
        {
            player1.ClearFrom(pos);
            int col;
            int color;
            int row;
            Player win;
            if (turnControl % 2 == 0)
            {
                col = player1.myTurn(myGrid);
                color = 1;
                win = player1;
            }
            else
            {
                col = player2.myTurn(myGrid);
                color = 2;
                win = player2;
            }
            row = myGrid.UpdateGameGrid(col, color);
            turnControl++;
            winner = IsWinner(row - 1, col - 1, color);
            if (winner == true)
            {
                Console.WriteLine("Congratulations you win!!");
            }
            return win;
        }
        //Method to figure out if last pebble dropped made a winner
        private bool IsWinner(int row, int column, int color)
        {
            int four = 0;
            //Check for winner vertically
            four = Verticle(row, column, color);
            if (four > 3)
            {
                return true;
            }
            four = 0;
            //Check horizontally for winner
            four = Horizontal(row, column, color);
            if (four > 3)
            {
                return true;
            }
            four = 0;
            //Check left Diagonally for winner
            four = LeftDiagonal(row, column, color);
            if (four > 3)
            {
                return true;
            }
            four = 0;
            //Check right Diagonally for winner
            four = RightDiagonal(row, column, color);
            if (four > 3)
            {
                return true;
            }
            return false;
        }
        //Method to check for matches vertically
        private int Verticle(int row, int column, int color)
        {
            int vert = 0;
            int rowCheck = row;
            while (rowCheck < myGrid.GetLength(0) && myGrid.Value(rowCheck, column) == color)
            {
                if (myGrid.Value(rowCheck, column) == color)
                {
                    vert++;
                }
                rowCheck++;
            }
            return vert;
        }//end verticle method
        //method to check for matches horizontally
        private int Horizontal(int row, int column, int color)
        {
            int zontal = 0;
            int colCheck = column;
            // method to Check to the right of column
            while (colCheck < myGrid.GetLength(1) && myGrid.Value(row, colCheck) == color)
            {
                if (myGrid.Value(row, colCheck) == color)
                {
                    zontal++;
                }
                colCheck++;
            }
            colCheck = column-1;
            //method to check to the left of column
            while (colCheck >= 0 && myGrid.Value(row, colCheck) == color)
            {
                if (myGrid.Value(row, colCheck) == color)
                {
                    zontal++;
                }
                colCheck--;
            }
            return zontal;
        }//end horizontal method
        
        private int LeftDiagonal(int row, int column, int color)
        {
            int lDiag = 0;
            int rowCheck = row;
            int colCheck = column;
            while (rowCheck < myGrid.GetLength(0) && colCheck < myGrid.GetLength(1) && myGrid.Value(rowCheck, colCheck) == color)
            {
                if (myGrid.Value(rowCheck, colCheck) == color)
                {
                    lDiag++;
                }
                colCheck++;
                rowCheck++;
            }
            rowCheck = row - 1;
            colCheck = column - 1;
            while (rowCheck >= 0 && colCheck >= 0 && myGrid.Value(rowCheck, colCheck) == color)
            {
                if (myGrid.Value(rowCheck, colCheck) == color)
                {
                    lDiag++;
                }
                colCheck--;
                rowCheck--;
            }
            return lDiag;
        }
        private int RightDiagonal(int row, int column, int color)
        {
            int rDiag = 0;
            int rowCheck = row;
            int colCheck = column;

            while (rowCheck < myGrid.GetLength(0) && colCheck >= 0 && myGrid.Value(rowCheck, colCheck) == color)
            {
                if (myGrid.Value(rowCheck, colCheck) == color)
                {
                    rDiag++;
                }
                rowCheck++;
                colCheck--;
            }
            rowCheck = row - 1;
            colCheck = column + 1;

            while (rowCheck >= 0 && colCheck < myGrid.GetLength(1) && myGrid.Value(rowCheck, colCheck) == color)
            {
                if (myGrid.Value(rowCheck, colCheck) == color)
                {
                    rDiag++;
                }
                rowCheck--;
                colCheck++;
            }
            return rDiag;
        }
        //initial setup
        private void setup()
        {
            EnterPlayers();
            Console.Clear();
            Console.CursorVisible = false;
            Color(10, title, ConsoleColor.Red, ConsoleColor.Blue);
            int cursor = Console.CursorTop;
            do
            {
                myGrid.PrintGrid();
                pos = Console.CursorTop;
                Console.Write("\n\n\n");               
                Color(0, startMessage, ConsoleColor.Black, ConsoleColor.Green);
                cki = Console.ReadKey(true);
            } while (cki.Key != ConsoleKey.Enter);
        }
    }//end logic class
}//end connect four namespace
