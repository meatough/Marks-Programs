using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LabIterator
{
   class Program
   {
      static void Main(string[] args)
      {
         #region window size
         Console.WindowWidth = 110;
         Console.WindowHeight = 40;
         #endregion

         Temperatures temperatures = new Temperatures();

         Console.WriteLine("\nIterator:");
         foreach (double el in temperatures)
         {
            Console.Write("{0:0.0} ", el);
         }
 
         Console.WriteLine("\n\nGetKelvin:");
         foreach (double el in temperatures.GetKelvin())
         {
             Console.Write("{0:0.0} ", el);
         }

         Console.WriteLine("\n\nGetFarenheit:");
         foreach (double el in temperatures.GetFarenheit())
         {
             Console.Write("{0:0.0} ", el);
         }

         Console.WriteLine("\n\nGetCelciusByDay:");
         foreach (string el in temperatures.CelciusByDay())
         {
             Console.Write("{0:0.0} ", el);
         }



         Console.WriteLine("\n");
      }
   }
}
