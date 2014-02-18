using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LabIterator
{
   class Temperatures
   {
      // temperatures in Celsius
      double[] temperatures = { 25, 27.5, 29.1, 28.7, 26, 24.3, 25.7 };

      // iterators
      public IEnumerator<double> GetEnumerator()
      {
         foreach (double el in temperatures)
         {
            yield return el;
         }
      }

      public IEnumerable<double> GetKelvin()
      {
          foreach (double el in temperatures)
          {
              yield return el+273;
          }
      }
      public IEnumerable<double> GetFarenheit()
      {
          foreach (double el in temperatures)
          {
              yield return 32 + el*1.8;
          }
      }

      public IEnumerable<string> CelciusByDay()
      {
          int x = 1;
          string day = "Day ";
          foreach (double el in temperatures)
          {
              yield return day+x+" "+el+"C ";
              x++;
          }
      }



   }
}
