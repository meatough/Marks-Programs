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
        public int[,] tempGrid;
        //Method to initialize grid to empty game board
        private int[,] InitializeGrid()
        {
            int[,] gameGrid = new int[6, 7];
            for (int r = 0; r < gameGrid.GetLength(0); r++)
            {
                for (int c = 0; c < gameGrid.GetLength(1); c++)
                {
                    gameGrid[r, c] = 0;
                }
            }
            return gameGrid;
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

        //Method to copy temporary grid to game grid
        public void CopyTempGridToGrid()
        {
            // works great as long as both multi-dimensional arrays have the same size
            Array.Copy(tempGrid, gameGrid, tempGrid.Length);
        }
        //method to check if grid is full
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
        //method to check if column is full
        public bool ColumnFull(int col)
        {
            if (gameGrid[0, col-1] == 0)
            {
                return false;
            }
            return true;
        }
        //method to check for winner of game, calls four methods to check
        public bool IsWinner(int row, int column, int color)
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
            while (rowCheck < gameGrid.GetLength(0) && gameGrid[rowCheck, column] == color)
            {
                if (gameGrid[rowCheck, column] == color)
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
            while (colCheck < gameGrid.GetLength(1) && gameGrid[row, colCheck] == color)
            {
                if (gameGrid[row, colCheck] == color)
                {
                    zontal++;
                }
                colCheck++;
            }
            colCheck = column - 1;
            //method to check to the left of column
            while (colCheck >= 0 && gameGrid[row, colCheck] == color)
            {
                if (gameGrid[row, colCheck] == color)
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
            while (rowCheck < gameGrid.GetLength(0) && colCheck < gameGrid.GetLength(1) && gameGrid[rowCheck, colCheck] == color)
            {
                if (gameGrid[rowCheck, colCheck] == color)
                {
                    lDiag++;
                }
                colCheck++;
                rowCheck++;
            }
            rowCheck = row - 1;
            colCheck = column - 1;
            while (rowCheck >= 0 && colCheck >= 0 && gameGrid[rowCheck, colCheck] == color)
            {
                if (gameGrid[rowCheck, colCheck] == color)
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

            while (rowCheck < gameGrid.GetLength(0) && colCheck >= 0 && gameGrid[rowCheck, colCheck] == color)
            {
                if (gameGrid[rowCheck, colCheck] == color)
                {
                    rDiag++;
                }
                rowCheck++;
                colCheck--;
            }
            rowCheck = row - 1;
            colCheck = column + 1;

            while (rowCheck >= 0 && colCheck < gameGrid.GetLength(1) && gameGrid[rowCheck, colCheck] == color)
            {
                if (gameGrid[rowCheck, colCheck] == color)
                {
                    rDiag++;
                }
                rowCheck--;
                colCheck++;
            }
            return rDiag;
        }

    }//end grid class
}//end connect four namespace
