using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;


namespace ExtensionMethod
{
   static class MyExtensions
   {
      //#region DEMO A: Power long
      //#endregion
       public static long Power(this int number, int exponent)
       {
           return (long)Math.Pow(number, exponent);
       }     
   }

   class Program
   {
      static void Main(string[] args)
      {
         try
         {
            TestPower();
         }
         catch (Exception ex)
         {
            Console.WriteLine("A problem occurred . . . " + ex.Message);
         }
      }

      #region  tests the extension method Power()
      private static void TestPower()
      {
          Console.Write("Number: ");
          string reply = Console.ReadLine();
          int n;
          if (int.TryParse(reply, out n))
          {
              Console.WriteLine("n.Power(3) = {0}", n.Power(3));
          }
          else
          {
              Console.WriteLine("The input could not be parsed to an integer");  
          }
      }

      private static int ReadInt(string prompt)
      {
         Console.Write(prompt + ": ");
         string line = Console.ReadLine();
         int number;
         if (!(int.TryParse(line, out number)))
            throw new InvalidCastException(string.Format(
               "{0} can't be converted to an integer", line));
         return number;
      }
      #endregion
   }
}