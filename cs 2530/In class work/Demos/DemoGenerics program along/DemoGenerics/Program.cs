using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoGenerics
{
   class Program
   {
      static void Main(string[] args)
      {
          DemoDictionary();
          DemoQueue();
      }

      #region Demo Dictionary
      static void DemoDictionary()
      {
         // Create and initialize a new dictionary with
         // Tokyo 32450000,  New York 19750000, Mumbai 19200000 
         // London 12875000, Paris 12161000,  Cambridge 125700 
          Dictionary<string, long> cities = new Dictionary<string, long>{
                {"Tokyo", 32450000},
                {"New York", 19750000},
                {"Mumbai", 19200000},
                {"London", 12875000},
                {"Paris", 12161000}, 
                {"Cambridge", 125700}                               
            };
         // Use a method to add Berlin with 3337000
          cities.Add("Berlin", 3337000);
         // try adding Cambridge (MA) with a population of 106,000
         // compile and run``````````````````````````````
          //cities.Add("Cambridge", 106000);
         // Use the item property (indexer) to print the populiation of Paris
          Console.WriteLine("Population of Paris: {0}", cities["Paris"]);
         // Use the indexer to change the population of Paris to 1234567
          cities["Paris"] = 1234567;
         // If a key does not exist, setting the indexer for that key adds a new key/value pair.
         // use an indexer to add Melbourne with a population of 3188000
          cities["Prag"] = 318800;
          Console.WriteLine("Population of Prag: {0}", cities["Prag"]);
         // But: the indexer throws an exception if you try to look up a key that does not exist
         // try to look up Salt Lake City - Compile and run
          Console.WriteLine("Population of Prag: {0}", cities["Prag"]);
         // If you don't know whether a key exists in a given dictionary you can use TryGetValue  
         // TryGetValue returns null; it does not throw an exception (compare to TryParse)
         // check before accessing Salt Lake City
          long slcPopulation;
          if (cities.TryGetValue("SLC", out slcPopulation))
          {
              Console.WriteLine("Population of Paris: {0}", slcPopulation);
          }
         // Alternative: check with ContainsKey
          if (cities.ContainsKey("Paris"))
          {
              Console.WriteLine("Population of Paris: {0}", cities["Paris"]);
          }

         // When using foreach to enumerate dictionary elements,
         // the elements are retrieved as KeyValuePair objects.
          Console.WriteLine("\n\n");
          foreach(KeyValuePair<string, long> entry in cities)
          {
              Console.WriteLine(entry);
          }

          Console.WriteLine("\n\n");
          foreach (KeyValuePair<string, long> entry in cities)
          {
              Console.WriteLine("{0, -12} {1}", entry.Key, entry.Value);
          }
         // Use the Values property to list all values of the collection

         // Use the Keys property to list al keys of the collection

         // Delete Paris from the collection

         // use a foreach loop to print all dictionary entries
      }
      #endregion

      #region DemoQueue
      private static void DemoQueue()
      {
         // Timed exercise:
         // ---------------

         // create queue of strings called waitingList

         // add 3 people

         // use foreach to list all people in queue

         // peek to see who is next

         // remove on person

         // list all members in queue again

      }
      #endregion
   }
}
