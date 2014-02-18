using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Flight
{
    class Flight
    {
      private int[,] grid = {
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        private int[,] tempGrid;

        public Flight()
        {
            tempGrid = new int[grid.GetLength(0), grid.GetLength(1)];
        }

        public void Start()
        {
            Setup();

            do
            {
                UpdateGrid();
                CopyTempGridToGrid();
                PrintGrid();
                Thread.Sleep(30);
            } while (!Console.KeyAvailable);

            Console.WriteLine();
        }

        private void CopyTempGridToGrid()
        {
            // works great as long as both multi-dimensional arrays have the same size
            Array.Copy(tempGrid, grid, tempGrid.Length);
        }

        private void UpdateGrid()
        {
            for (int r = 0; r < grid.GetLength(0); r++)
            {
                for (int c = 0; c < grid.GetLength(1); c++)
                {
                    tempGrid[r, c] = UpdateCell(r, c);
                }
            }
        }

        private int UpdateCell(int r, int c)
        {
            int myValue;
            //if (r > 0 && c > 0)
            if(c > 0)
            {
                myValue = grid[r, c - 1];
                //myValue = grid[r - 1, c];
                //myValue = grid[r - 1, c-1];
            }
            else  // first column gets value of last column
            {
                myValue = grid[r, grid.GetUpperBound(1)];
                //myValue = grid[grid.GetUpperBound(0), c];
                //myValue = grid[grid.GetUpperBound(0), grid.GetUpperBound(1)];
            }
            return myValue;
        }

        private void PrintGrid()
        {
            // start in line 2 because of user instructions
            Console.CursorTop = 2;

            for (int r = 0; r < grid.GetLength(0); r++)
            {
                for (int c = 0; c < grid.GetLength(1); c++)
                {
                    Console.Write(grid[r, c] == 0 ? "." : "o");
                }
                Console.WriteLine();
            }
        }

        private void Setup()
        {
            PrintGrid();
        }
    }
}
