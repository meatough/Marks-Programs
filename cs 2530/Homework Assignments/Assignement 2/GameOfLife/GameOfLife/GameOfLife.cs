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
using System.Threading;

namespace GameOfLife
{
    class GameOfLife
    {
        private int[,] lifeGrid;

        private int[,] tempGrid;

        private String title = "Game of Life";

        private String onGoing = "Press any key to stop";

        private String startMessage = "Press enter to begin";

        ConsoleKeyInfo cki = new ConsoleKeyInfo();

        //method to color the game title
        private static void ColorTitle(String myTitle)
        {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.ForegroundColor = ConsoleColor.Yellow;
        }
        //method to color the ongoing message(press any key to stop)
        private static void ColorOngoingMessage(String myTitle)
        {
            Console.BackgroundColor = ConsoleColor.Black;
            Console.ForegroundColor = ConsoleColor.Red;
        }
        //method to color the start message(press enter to start)
        private static void ColorStartMessage(String myTitle)
        {
            Console.BackgroundColor = ConsoleColor.Black;
            Console.ForegroundColor = ConsoleColor.Green;
        }
        //initialize the life grid to the original conditions
        private int[,] InitializeGrid()
        {
            int[,] myGrid = new int[25,40];
            for (int r = 0; r < myGrid.GetLength(0); r++)
            {
                for (int c = 0; c < myGrid.GetLength(1); c++)
                {
                    if (r == 13 && c >= 13 && c <= 25)
                    {
                        myGrid[r, c] = 1;
                    }
                    else if (r >= 8 && r <= 10 && c == 11)
                    {
                        myGrid[r, c] = 1;
                    }
                    else if (r >= 8 && r <= 10 && c == 19)
                    {
                        myGrid[r, c] = 1;
                    }
                    else if (r >= 8 && r <= 10 && c == 27)
                    {
                        myGrid[r, c] = 1;
                    }
                    else
                    {
                        myGrid[r, c] = 0;
                    }
                }
            }
            return myGrid;
        }
            //constructor
            public GameOfLife()
            {
                lifeGrid = InitializeGrid();
                tempGrid = new int[lifeGrid.GetLength(0), lifeGrid.GetLength(1)];
            }
        //method to start the game
        public void Start()
        {
            
                Setup();
                //this is done until the user presses enter
                do
                {
                    PrintGrid();
                    cki = Console.ReadKey(true);
                } while (cki.Key != ConsoleKey.Enter);
                //this is done after the user presses enter and before the user presses any other key
                do
                {
                    // pauses the execution for 50ms
                    Thread.Sleep(50);
                    UpdateLifeGrid();
                    CopyTempGridToGrid();
                    PrintGrid();
                    ColorOngoingMessage(onGoing);
                    Console.WriteLine(onGoing);
                } while (!Console.KeyAvailable);  // checks whether a key has been pressed
                // position cursor for end message
                Console.WriteLine();
        }

        //checks to see if cell is alive or dead
        private bool IsDead(int x)
        {
            bool isDead = true;
            if (x != 0)
            {
                isDead = false;
            }
            return isDead;
        }

        //counts the number of neighbors a cell has
        private int neiborCount(int r, int c)
        {
            int neighborCount = 0;
            for (int rowCheck = r - 1; rowCheck <= r + 1; rowCheck++)
            {
                for (int colCheck = c - 1; colCheck <= c + 1; colCheck++)
                {
                    if (rowCheck == r && colCheck == c)
                    {
                        //we do nothing here
                    }
                    else
                    {
                        if (rowCheck >= 0 && rowCheck < lifeGrid.GetLength(0) && colCheck >= 0 && colCheck < lifeGrid.GetLength(1))
                        {
                            if (IsDead(lifeGrid[rowCheck, colCheck]) == false)
                            {
                                neighborCount++;
                            }
                        }
                    }
                }//end inner for loop
            }//end outer for loop
            return neighborCount;
        }

        //prints the current lifeGrid
        private void PrintGrid()
        {
            // start in line 5 because of user instructions
            Console.CursorTop = 5;

            for (int r = 0; r < lifeGrid.GetLength(0); r++)
            {
                for (int c = 0; c < lifeGrid.GetLength(1); c++)
                {
                    //if cell is dead print a blue background with a black period
                    if(lifeGrid[r,c] == 0)
                    {
                        Console.ForegroundColor = ConsoleColor.Black;
                        Console.BackgroundColor = ConsoleColor.Blue;
                        Console.Write(".");
                    }
                    //if cell is alive print a yellow blackground with a black period
                    else
                    {
                        Console.ForegroundColor = ConsoleColor.Black;
                        Console.BackgroundColor = ConsoleColor.Yellow;
                        Console.Write(".");
                    }
                }
                Console.WriteLine();
            }
            //before user hits enter display the start message
            if (cki.Key != ConsoleKey.Enter)
            {
                ColorStartMessage(startMessage);
                Console.WriteLine(startMessage);
            }
        }
        //copy the temporary grid to the life grid
        private void CopyTempGridToGrid()
        {
            // works great as long as both multi-dimensional arrays have the same size
            Array.Copy(tempGrid, lifeGrid, tempGrid.Length);
        }
        //update the life grid through the temp grid
        private void UpdateLifeGrid()
        {
            for (int r = 0; r < lifeGrid.GetLength(0); r++)
            {
                for (int c = 0; c < lifeGrid.GetLength(1); c++)
                {
                    tempGrid[r, c] = UpdateCell(r, c);
                }
            }
        }
        //update the cells based on their neighbors
        private int UpdateCell(int row, int col)
        {
            int newValue = lifeGrid[row, col];
            //if a cell is dead and has three neighbors, cell comes to life
            if (IsDead(lifeGrid[row, col]) == true && neiborCount(row, col) == 3)
            {
                newValue = 1;
            }
            //if cell is alive and has less than 2 neighbors it dies
            if (IsDead(lifeGrid[row, col]) == false && neiborCount(row, col) < 2)
            {
                newValue = 0;
            }
            //if cell is alive and has more than 4 neighbors it dies
            if (IsDead(lifeGrid[row, col]) == false && neiborCount(row, col) > 3)
            {
                newValue = 0;
            }
            //if none of the above conditions are met cell remains unchanged
            return newValue;
        }
        //Set up the game initially
        private void Setup()
        {
            Console.Clear();
            Console.CursorVisible = false;
            ColorTitle(title);
            Console.WriteLine(title);
            Console.WriteLine("\n\n\n");
        }
    }//end class
}//end namespace
