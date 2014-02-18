/***************************************************************
 * Intermiadiate Programming in c#
 * Console ReadCsvFile Program
 * Programmer: Mark Eatough
 * Course: CSIS 2530 
 * Created October 30, 2013
 *  
 * This program uses linq to querry data after importing it from a 
 * csv file and parsing it out to an object called daily values
 ****************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Diagnostics;

namespace ReadCsvFile
{
   class Program
   {
      static void Main(string[] args)
      {

         List<DailyValues> stockValues = DailyValues.GetStockValues("Toyota.csv");

         Console.WriteLine("\n= = =   Q u e s t i o n   a   = = = \n");
         questionA(stockValues);

         Console.WriteLine("\n= = =   Q u e s t i o n   b   = = = \n");
         questionB(stockValues);

         Console.WriteLine("\n= = =   Q u e s t i o n   c   = = = \n");
         questionC(stockValues);

         Console.WriteLine("\n= = =   Q u e s t i o n   d   = = = \n");
         questionD(stockValues);

         Console.WriteLine("\n= = =   Q u e s t i o n   e   = = = \n");
         questionE(stockValues);
      }

      #region question A - E
      // Find the highest and the lowest amount the stock ever traded for
      // and display the values together with the corresponding dates
      private static void questionA(List<DailyValues> stockValues)
      {
          var HighestTrade =
              stockValues.Aggregate((agg, next) => next.High > agg.High ? next : agg);
          Console.WriteLine("Highest price traded: {0} on {1:yyyy/MM/dd}", HighestTrade.High, HighestTrade.Date);

          var LowestTrade =
              stockValues.Aggregate((agg, next) => next.Low < agg.Low ? next : agg);
          Console.WriteLine("Lowest price traded: {0} on {1:yyyy/MM/dd}", LowestTrade.Low, LowestTrade.Date);
      }

      // Calculate the average volume traded per day
      private static void questionB(List<DailyValues> values)
      {
          decimal average = values.Average(v => v.Volume); 
          Console.WriteLine("Avg Volume traded per day: {0:N1}", average);
      }

      // How many times was the trading volume higher than the average? How many times was it lower? 
      private static void questionC(List<DailyValues> values)
      {
          decimal average = values.Average(v => v.Volume); 

          int higherAve = values.Count(n => n.Volume > average);
          Console.WriteLine("Volume > Average:  {0}", higherAve);

          int lowerAve = values.Count(n => n.Volume < average);
          Console.WriteLine("Volume < Average: {0}", lowerAve);
      }

      // In descending order list the 10 highest ‘open values’ with the corresponding dates  
      private static void questionD(List<DailyValues> values)
      {
          var highestOpenings =
              (from v in values
               orderby v.Open descending
               select new { v.Open, v.Date }).Take(10);

          Console.WriteLine("10 highest opening values:");
          foreach (var el in highestOpenings)
          {
              Console.WriteLine("{0} {1:yyyy/MM/dd}", el.Open, el.Date);
          }
      }

      // Calculate the average volume traded for each of the calendar years
      private static void questionE(List<DailyValues> values)
      {
          var averageVolumePerYear =
            from v in values
            group v by v.Date.Year into g
            select new { Year = g.Key, AverageVolume = g.Average(v => (decimal)v.Volume) };

        Console.WriteLine("Average volume per calender year:");
        foreach(var group in averageVolumePerYear)
        {
          Console.WriteLine("{0}: {1:N1}", group.Year, group.AverageVolume);
        }
      }
      #endregion
   }
}

