using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Lab
{
   class Program
   {
      static void Main(string[] args)
      {
         try
         {
            Method1();
         }
         catch (Exception ex)
         {
             ex.ToString();


            Console.WriteLine("\nException: ");
            Console.WriteLine("----------");
            Console.WriteLine(ex); 

            Console.WriteLine("\n\nInner exception: ");
            Console.WriteLine("----------------");
            Console.WriteLine(ex.InnerException);

            Console.WriteLine("\n\nInner exception of inner exception: ");
            Console.WriteLine("-----------------------------------");
            Console.WriteLine(ex.InnerException.InnerException);

         }
      }

      static void Method1()
      {
         try
         {
            Console.WriteLine("In Method1: calling Method2");
            Method2();
         }
         catch (Exception ex)
         {
            Console.WriteLine("In Method1 re-throwing the exception");
            throw new Exception("Rethrowing exception in Method1 ", ex);
            //throw new Exception("problem in Method1");
         }
      }

      static void Method2()
      {
         Method3();
      }

      static void Method3()
      {
         try
         {
            Console.WriteLine("In Method3 trying to convert a string to an integer");
            Convert.ToInt32("I am not a number");
         }
         catch (FormatException ex)
         {
            Console.WriteLine("In Method3 re-throwing the exception");
            throw new Exception("Problem converting a string to an integer.", ex);
         }
      }
   }
}
