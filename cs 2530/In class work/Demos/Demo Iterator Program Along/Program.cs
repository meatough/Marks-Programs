using System;
using System.Collections;

namespace CS2530.Iterator
{  
   class Program
   {
      static void Main(string[] args)
      {
         #region window size
         Console.WindowWidth = 110;
         Console.WindowHeight = 40;
         #endregion

         DemoIEnumerator();
         DemoIterator();
         // DemoBook();

         Console.WriteLine("\n");
      }

      private static void DemoIEnumerator()
      {
         #region print title
         Console.WriteLine("\nDemo IEnumerator:");
         Console.WriteLine("~~~~~~~~~~~~~~~~~\n");
         #endregion

         string[] teams = { "Bears", "Lions", "Colts" };

         #region 1) create instance of IEnumerator; iterate through array with iterator methods   
         #endregion

         IEnumerator enumerator = teams.GetEnumerator();
          while(enumerator.MoveNext())
          {
              Console.Write("{0} ", enumerator.Current);
          }
          Console.WriteLine();
         
         #region 2) show foreach as comparison
         #endregion

          foreach (string t in teams)
          {
              Console.Write("{0} ", t);
          }

      }

      private static void DemoIterator()
      {
         #region print title
         Console.WriteLine("\nDemo Iterator:");
         Console.WriteLine("~~~~~~~~~~~~~~");
         #endregion
         IteratorTest iTest = new IteratorTest();
         foreach (int n in iTest)
         {
             Console.Write("{0} ", n);
             Console.Write(".. ");
         }
         Console.WriteLine("\n\n\n");
         
          Console.WriteLine("Demo Multiple of 15");
         Console.WriteLine("~~~~~~~~~~~~~~");
         foreach (int n in iTest.MultipleOf15())
         {
             Console.Write("{0} ", n);
             Console.Write(".. ");
         }
         Console.WriteLine("\n\n\n");
         
          Console.WriteLine("Demo Double Number");
         Console.WriteLine("~~~~~~~~~~~~~~");
         foreach (int n in iTest.DoubleNumber())
         {
             Console.Write("{0} ", n);
             Console.Write(".. ");
         }
         Console.WriteLine("\n\n\n");
         
          Console.WriteLine("Demo Reverse");
         Console.WriteLine("~~~~~~~~~~~~~~");
         foreach (int n in iTest.ReverseNumbers())
         {
             Console.Write("{0} ", n);
             Console.Write(".. ");
         }
         Console.WriteLine("\n\n\n");
         
         Console.WriteLine("Demo multiple return statements");
         Console.WriteLine("~~~~~~~~~~~~~~");
         int count = 0;
         foreach (int n in iTest.NumberSquareCube())
         {
             Console.Write("{0} .. ", n);
             if (++count % 3 == 0)
                 Console.WriteLine();
         }
         Console.WriteLine("\n\n\n");
         
         Console.WriteLine("Demo Quote");
         Console.WriteLine("~~~~~~~~~~~~~~");
         foreach(string line in iTest.GetQuote())
         {
             Console.WriteLine(line);
         }
      }//end demo iterator method
   }//end class 
}//end namespace
