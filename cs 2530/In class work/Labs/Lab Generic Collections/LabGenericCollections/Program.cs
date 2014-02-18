using System;
using System.Collections.Generic;
namespace DemoGenerics
{
    class Program
    {
        static void Main(string[] args)
        {
            DemoList();       // vowels
            DemoDictionary(); // rivers
        }

        #region Demo List
        private static void DemoList()
        {
            List<char> vowels = new List<char>()
            {
                'a',
                'e',
                'i',
                'o',
            };
            vowels.Add('u');
            
            Console.WriteLine("\nList Demo: (vowels)");
            Console.WriteLine("===================\n");
            foreach (char v in vowels)
            {
                Console.Write("{0}, ", v);
            }

            if (vowels.Contains('x') == true)
                Console.WriteLine("Vowels list contains x");
            else
                Console.WriteLine("\n\nVowels list does not contain x");
            vowels.RemoveAt(1);

            Console.WriteLine("\n\n\nList Demo: (vowels)");
            Console.WriteLine("===================\n");
            foreach (char v in vowels)
            {
                Console.Write("{0}, ", v);
            }
        }
        #endregion

        #region Demodictionary
        private enum Continent { Africa, Antarctica, Asia, Australia, Europe, NorthAmerica, SouthAmerica }
        
       static void DemoDictionary()
        {
            Dictionary<string, Continent> rivers = new Dictionary<string, Continent>
            {
                {"Nile", Continent.Africa},
                {"Mississippi", Continent.SouthAmerica},
                {"Danube", Continent.Europe}                            
            };

            rivers.Add("Ganges", Continent.Asia);
            rivers["Mississippi"] = Continent.NorthAmerica;

            Console.WriteLine("\n\nDanube is in: {0}", rivers["Danube"]);

            Console.WriteLine("\n\nDictionary Demo: (rivers)");
            Console.WriteLine("=========================\n");


            foreach (KeyValuePair<string, Continent> entry in rivers)
            {
                Console.WriteLine("{0, -12} {1}", entry.Key, entry.Value);
            }

        }
        #endregion
    }
}
