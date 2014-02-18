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
using System.Threading;
namespace ConnectFour
{
    class Grid
    {
        //Game grid variable
        private int[,] gameGrid;
        //Temporary grid variable
        private int[,] tempGrid;
        //Method to initialize grid to empty game board
        private int[,] InitializeGrid()
        {
            int[,] myGrid = new int[6, 7];
            for (int r = 0; r < myGrid.GetLength(0); r++)
            {
                for (int c = 0; c < myGrid.GetLength(1); c++)
                {
                    myGrid[r, c] = 0;
                }
            }
            return myGrid;
        }
        //constructor
        public Grid()
        {
            gameGrid = InitializeGrid();
            tempGrid = new int[gameGrid.GetLength(0), gameGrid.GetLength(1)];
        }
        public int GetLength(int n)
        {
            if (n == 0)
            {
                return gameGrid.GetLength(0);
            }
            else
            {
                return gameGrid.GetLength(1);
            }
        }
        public int Value(int row, int col)
        {
            return gameGrid[row, col];
        }

        //prints the current gameGrid
        public void PrintGrid()
        {
            // start in line 3 because of user instructions
            Console.CursorTop = 3;

            Console.WriteLine("\n");

            Console.BackgroundColor = ConsoleColor.Yellow;

            for (int r = 0; r < gameGrid.GetLength(0); r++)
            {
                Console.CursorLeft = 5;
                for (int c = 0; c < gameGrid.GetLength(1); c++)
                {
                    if (gameGrid[r, c] == 0)
                    {
                        Console.BackgroundColor = ConsoleColor.Yellow;
                        Console.ForegroundColor = ConsoleColor.Black;
                        Console.Write(" . ");
                    }
                    else if (gameGrid[r, c] == 1)
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write(" O ");
                    }
                    else
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write(" O ");
                    }
                }//end inner for loop
                Console.WriteLine();
            }//end outer for loop
        }//end print grid method
        //Method to copy temporary grid to game grid
        private void CopyTempGridToGrid()
        {
            // works great as long as both multi-dimensional arrays have the same size
            Array.Copy(tempGrid, gameGrid, tempGrid.Length);
        }
        //update the game grid through the temp grid
        public int UpdateGameGrid(int column, int color)
        {
            int r;
            for (r = 0; r < gameGrid.GetLength(0); r++)
            {
                if (tempGrid[r, column - 1] == 0)
                {
                    if (r > 0)
                    {
                        tempGrid[r - 1, column - 1] = 0;
                    }
                    tempGrid[r, column - 1] = color;
                    CopyTempGridToGrid();
                    PrintGrid();
                    Thread.Sleep(50);
                }
                else
                {
                    return r;
                }
            }
            return r;
        }//end update grid method
        //method to test whether or not the grid is full
        public bool GridFull()
        {
            for (int c = 0; c < gameGrid.GetLength(1); c++)
            {
                if (gameGrid[0, c] == 0)
                {
                    return false;
                }
            }
            return true;
        }
        public bool ColumnFull(int col)
        {
            if (gameGrid[0, col] == 0)
            {
                return false;
            }
            return true;
        }
    }//end grid class
}//end connect four namespace
