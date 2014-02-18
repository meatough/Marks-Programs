using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoGenerics
{
   class Program
   {
       private static List<Automobile> automobiles = new List<Automobile> {
          new Automobile(2005, AutomobileCategory.Bus, ConsoleColor.Yellow),
          new Automobile(2012, AutomobileCategory.Car, ConsoleColor.Red),
          new Automobile(2002, AutomobileCategory.Truck, ConsoleColor.Blue),
          new Automobile(2005, AutomobileCategory.Car, ConsoleColor.Green),
          new Automobile(2010, AutomobileCategory.Car, ConsoleColor.Red) };

       static void DisplayAll(IEnumerable<Automobile> autos)
       {
           foreach (Automobile a in autos)
           {
               a.Display();
               Console.WriteLine();
           }
       }

      static void Main(string[] args)
      {

          DisplayAll(automobiles);
          
          Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
          Console.WriteLine("automobiles that were built up until 2010\n");
          // TODO


          Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
          Console.WriteLine("automobiles that are red\n");
          // TODO


          Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
          Console.WriteLine("automobiles that are blue or that were built in 2005\n");
          // TODO


          Console.WriteLine("\n* * * * * * * * * * * * * * * * *");
          Console.WriteLine("automobiles that are not Red and not a bus\n");
          // TODO

      }


   }
}
