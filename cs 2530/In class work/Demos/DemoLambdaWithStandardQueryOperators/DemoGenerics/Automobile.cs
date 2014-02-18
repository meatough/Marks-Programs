using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoGenerics
{

    public enum AutomobileCategory {Car, Bus, Truck}
    class Automobile
    {
        public int Year { get; private set; }
        public AutomobileCategory AC { get; private set; }
        public ConsoleColor Color { get; private set; }

        public Automobile(int year, AutomobileCategory category, ConsoleColor color)
        {
            Year = year;
            AC = category;
            Color = color;
        }

        public void Display()
        {
            ConsoleColor originalColor =  Console.ForegroundColor;

            Console.ForegroundColor = ConsoleColor.Gray; 
            Console.WriteLine("{0}", Year);

            Console.ForegroundColor = Color;
            switch (AC)
            {
                case AutomobileCategory.Bus:
                    AsciiImage.Bus();
                    break;

                case AutomobileCategory.Car:
                    AsciiImage.Car();
                    break;

                case AutomobileCategory.Truck:
                    AsciiImage.Truck();
                    break;
            }
            // TODO
            Console.ForegroundColor = originalColor;
        }
    }
}
