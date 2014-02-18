using System;
using System.Collections;
using System.Collections.Generic;

namespace CS2530.Iterator
{
   class IteratorTest 
   {
      // fields
      #region List<string> quote

       private List<string> quote = new List<string>() { 
            "Far better it is to dare mighty things,",
            "to win glorious triumphs,",
            "even though checkered by failure,",
            "than to take rank with those poor spirits",
            "who neither enjoy much nor suffer much,",
            "because they live in the gray twilight",
            "that knows not victory nor defeat.",
            "– Theodore Roosevelt"
       };

      #endregion

      #region int[] numbers
      private int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
      #endregion

      // iterators
      #region TODO 1: create GetEnumerator method for numbers 
      public IEnumerator<int> GetEnumerator()
      {
          foreach (int n in numbers)
          {
              yield return n;
          }
      }
      #endregion            

      #region TODO 2: modify GetEnumerator - e.g. each number doubeled, only multiple of 15
      public IEnumerable<int> DoubleNumber()
      {
          foreach (int n in numbers)
          {
              yield return 2 * n;
          }
      }

      public IEnumerable<int> MultipleOf15()
      {
          foreach (int n in numbers)
          {
              if (n % 15 == 0)
              {
                  yield return n;
              }
          }
      }
      #endregion

      #region Exercise Iterator
      public IEnumerable<int> ReverseNumbers()
      {
          for (int i = numbers.Length - 1; i > 0; i--)
          {
              yield return numbers[i];
          }
      }
      #endregion

      #region TODO 3: demo multiple return statments (e.g. square, cube)
      public IEnumerable<int> NumberSquareCube()
      {
          foreach (int n in numbers)
          {
              yield return n;
              yield return n * n;
              yield return (int)Math.Pow(n, 3);
          }
      }
      #endregion

      #region TODO 4: add a named iterator QuoteIterator - demo yield return and list return
      public IEnumerable<string> GetQuote()
      {
          //return quote;
          foreach (string line in quote)
          {
              yield return line;
          }
      }
      #endregion 

   }
}
