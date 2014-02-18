﻿using System;

namespace Delegate
{
    static class ConsoleDrawing
    {
        public static void Square(int number)
        {
            Console.ForegroundColor = ConsoleColor.Blue;
            for (int i = 0; i < number; i++)
            {
                for (int j = 0; j < number; j++)
                    Console.Write("o ");
                Console.WriteLine();
            }
        }


        public static void Triangle(int number)
        {
            Console.ForegroundColor = ConsoleColor.Red;
            for (int i = 0; i < number; i++)
            {
                for (int j = 0; j < i + 1; j++)
                    Console.Write("o ");
                Console.WriteLine();
            }
        }
    }
}
