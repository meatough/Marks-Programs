using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq1
{
   class Program
   {
      #region list of cities 
      private static List<City> cities = new List<City> {
            new City("Boston", UsState.MA, 617594, 48.3),
            new City("Columbus", UsState.OH, 787033, 217.2),
            new City("Houston", UsState.TX, 2099451, 599.6),
            new City("Indianapolis", UsState.IN, 820445, 176.5),
            new City("Los Angeles", UsState.CA, 3792621, 468.7),
            new City("New York", UsState.NY, 8175133, 302.6),
            new City("Phoenix", UsState.AZ, 1445632, 516.7),
            new City("Salt Lake City", UsState.UT, 186440, 111.1),
            new City("Sandy", UsState.UT, 90000, 30),
            new City("Seattle", UsState.WA, 608660, 83.9)
        };
      #endregion

      #region Main
      static void Main(string[] args)
      {
         Console.WriteLine("\nL I N Q   D E M O");
         Console.WriteLine("~~~~~~~~~~~~~~~~~~~~");

         Console.WriteLine("\n\n1) All states:");
         AllStates();

         Console.WriteLine("\n\n2) All states no doubles:");
         AllStatesNoDoubles();

         Console.WriteLine("\n\n3) Cities with more than 1 million people:");
         CitiesGreaterThan1000000();

         Console.WriteLine("\n\n4) Name and population where more than 1 million:");
         NameAndPopulationWhereGreater1000000();

         Console.WriteLine("\n\n5) Cities whose name starts with 'S':");
         CitiesWhoseNameStartsWithS();

         Console.WriteLine("\n\n6) Cities sorted by area (large to small):");
         CitiesSortedByArea();

         Console.WriteLine("\n\n7) Group by State:");
         GroupByState();

         Console.WriteLine("\n\n7) Group by First letter:");
         GroupByFirstLetter();

         Console.WriteLine("\n\n. . . press enter . . .");
         Console.Read();
      }
      #endregion

      #region TODO 1
      #endregion
      private static void AllStates()
      {
          IEnumerable<UsState>states =
              from c in cities
              select c.State;

          Console.WriteLine(String.Join(", ", states));
      }

      #region TODO 2
      #endregion
      private static void AllStatesNoDoubles()
      {
          IEnumerable<UsState> uniqueStates =
              (from c in cities
              select c.State).Distinct();

          Console.WriteLine(String.Join(", ", uniqueStates));
      }
      
      #region TODO 3
      #endregion
      private static void CitiesGreaterThan1000000()
      {
          var largeCity =
               from c in cities
               where c.Population > 1000000
               select new { c.Name };
          Console.WriteLine(String.Join("\n", largeCity));
      }

      #region TODO 4
      #endregion
      private static void NameAndPopulationWhereGreater1000000()
      {
          var namesAndPopulations =
              from c in cities
              where c.Population > 1000000
              select new { c.Name, c.Population };

          //Console.WriteLine(String.Join("\n", namesAndPopulations));
          foreach (var el in namesAndPopulations)
          {
              Console.WriteLine("{0,-15} {1:#,#}", el.Name, el.Population);
          }
      }

      #region TODO 5
      #endregion
      private static void CitiesWhoseNameStartsWithS()
      {
          IEnumerable<City> sCities =
              from c in cities
              where c.Name[0] == 'S'
              select c;

          Console.WriteLine(String.Join("\n", sCities));
      }

      #region TODO 6
      #endregion
      private static void CitiesSortedByArea()
      {
          IEnumerable<City> citiesByArea =
              from c in cities
              orderby c.Area
              select c;

          Console.WriteLine(String.Join("\n", citiesByArea));
      }

      #region If Time .. add cities in Utah and NY
      #endregion
      private static void GroupByState()
      {
          var citiesByState =
              from c in cities
              group c by c.State;

          foreach(var group in citiesByState)
          {

              Console.Write("{0}\n   ", group.Key);
              Console.WriteLine(String.Join("\n   ", group));
          }
      }

      private static void GroupByFirstLetter()
      {
          var citiesByState =
              from c in cities
              group c by c.Name[0] into g
              select new { FirstLetter = g.Key, Cities = g, Size = g.Count() };

          foreach (var group in citiesByState)
          {

              Console.Write(" {0}: ({1})\n   ", group.FirstLetter, group.Size);
              Console.WriteLine(String.Join("\n   ", group.Cities));
          }
      }
   }
}
