using System;

namespace l03Demo
{
   enum Direction { Up = 0x2191, Down = 0x2193, Left = 0x2190, Right = 0x2192 }

   class Program
   {
      static void Main(string[] args)
      {
         EnumDemo();
         Console.WriteLine("\n\n");
      }

      static void EnumDemo()
      {
         Console.WriteLine("\n\nDemo Enum:\n");

         // create variable of type Direction; print name, decimal, hex, symbol
         Direction d1 = Direction.Up;
         Console.WriteLine("{0} {1} {1:x} {2}", d1, (int)d1, (char)d1);
         Direction d2 = Direction.Down;
         Console.WriteLine("{0} {1} {1:x} {2}", d2, (int)d2, (char)d2);
         Direction d3 = Direction.Left;
         Console.WriteLine("{0} {1} {1:x} {2}", d3, (int)d3, (char)d3);
         Direction d4 = Direction.Right;
         Console.WriteLine("{0} {1} {1:x} {2}", d4, (int)d4, (char)d4);
         Console.WriteLine();

         // print the names of all enumerators
         Console.WriteLine("\nNames:");
         foreach (String name in Enum.GetNames(typeof(Direction)))
         {
             Console.Write("{0} ", name);
         }
         
         // print the value of all enumerators
         Console.WriteLine("\n\nValues:");
         foreach (int value in Enum.GetValues(typeof(Direction)))
         {
             Console.Write("{0:x} ", value);
         }
         Console.WriteLine();
         // print the chcaracter representation of all enumerators
         Console.WriteLine("\nArrows:");
         foreach (int arrow in Enum.GetValues(typeof(Direction)))
         {
             Console.Write("{0} ", (char)arrow);
         }
      }
   }
}
