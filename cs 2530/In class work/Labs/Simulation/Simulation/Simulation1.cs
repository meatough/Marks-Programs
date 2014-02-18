using System;
using System.Threading;

namespace Simulation
{
    class Flight
    {
      private int[,] grid = {
      {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
                // pauses the execution for 30ms
                Thread.Sleep(30);
                UpdateGrid();
                CopyTempGridToGrid();
                PrintGrid();
            } while (!Console.KeyAvailable);  // checks whether a key has been pressed

            // position cursor for end message
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

        private int UpdateCell(int row, int col)
        {
            int newValue;
            if (col > 0)
            //if (col > 0 && row > 0)
            {
                newValue = grid[row, col - 1];
                //newValue = grid[row - 1, col - 1];
                //newValue = grid[row, col - 1];
            }
            else  // first column gets value of last column
            {
                newValue = grid[row, grid.GetUpperBound(1)];
                //newValue = grid[grid.GetUpperBound(0), grid.GetUpperBound(1)];
            }
            return newValue;
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
            Console.Clear();
            Console.CursorVisible = false;
            Console.WriteLine("Press any key to stop");
        }
    }
}
