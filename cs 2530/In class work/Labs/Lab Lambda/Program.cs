﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Delegate
{
    class Program
    {
        static List<int> data = new List<int> { 3, 5, 7 };

        static void Main(string[] args)
        {
            DrawAll(ConsoleDrawing.Triangle);

            // TODO 
        }

        private static void DrawAll(Action<int> drawMethod)
        {
            foreach (int number in data)
            {
                drawMethod(number);
                Console.WriteLine();
            }
        }
    }
}
