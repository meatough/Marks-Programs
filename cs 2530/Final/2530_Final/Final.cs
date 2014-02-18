using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2530_Final
{
    public class Final
    {
        #region Dictionary
        public void PartDictionary()
        {
            Dictionary<string, double> tallestBuildings = new Dictionary<string, double> {
            {"Burj Khalifa", 829.8},
            {"Tokyo Sky Tree", 634}, 
            {"KVLY-TV mast", 628.8}, 
            {"Abraj Al Bait Towers", 601},
            {"Lualualei VLF transmitter", 458},
            {"Ekibastuz GRES-2 Power Station", 419.7 }};

            // 1) add another dictionary entry: "Gateway Arch" and 192 meters
            tallestBuildings.Add("GatewayArch", 192);

            // 2) delete the entry for the following building: "Ekibastuz GRES-2 Power Station"
            tallestBuildings.Remove("Ekibastuz GRES-2 Power Station");

            // 3) display all of the tallest buildings in two straight columns  
            foreach (KeyValuePair<string, double> entry in tallestBuildings)
            {
                Console.WriteLine("{0, -30} {1}", entry.Key, entry.Value);
            }

        }
        #endregion

        #region Delegate | Lambda
        // fields   . . . why are they declared here? Just to save you some scrolling
        private string title = "General";
        private string name = "Watson";

        // methods
        public void PartDelegateLambda()
        {
            // Take a moment to look at class Greetings. It includes three greeting methods
            Func<string, string, string> myFormal = Greetings.FormalWelcome;
            //Func<string, string, string> myFriend = Greetings.FriendGreeting;
            //Func<string, string, string> mySpecial = Greetings.SpecialOccasionGreeting;

            // 1) call the method PrintGreeting. Pass the static method FormalWelcome from class Greetings as an argument
            PrintGreeting(myFormal);

            // 2) call the method PrintGreeting. Pass the static method FriendGreeting as an argument
            

            // 3) call the method PrintGreeting. Pass the static method SpecialOccasionGreeting as an argument
            //    it should print a Birthday greeting
            

        }

        private void PrintGreeting(Func<string, string, string> getGreeting)
        {
            string greeting = getGreeting(title, name);
            DottedLine(greeting.Length + 6);
            Console.WriteLine(".  {0}  .", greeting);
            DottedLine(greeting.Length + 6);
            Console.WriteLine();
        }

        private void DottedLine(int length)
        {
            for (int i = 0; i < length; i++)
            {
                Console.Write('.');
            }
            Console.WriteLine();
        }
        #endregion

        #region Linq
        public void PartLinq()
        {
            // field
            List<RealEstate> houses = new List<RealEstate> {
                new RealEstate(2, 2, 1350, 1992, true),
                new RealEstate(1, 2, 1350, 2009, true),
                new RealEstate(2, 1, 1120, 1996, false),
                new RealEstate(3, 2.5, 2530, 1986, false),
                new RealEstate(2, 2, 1650, 1998, true),
                new RealEstate(1, 2, 1080, 1992, true),
                new RealEstate(3, 3.5, 3150, 2012, false),
                new RealEstate(2, 2, 2100, 2004, false)
            };
            Console.WriteLine("List of houses:");
            Console.WriteLine(string.Join("\n", houses) + "\n");

            // 1)	Write a query that lists all the houses sorted by the year when they
            //      were built (newest houses should be listed first). Then print the result
            Console.WriteLine("List of houses sorted by year:");
            var sortByYear =
              (from h in houses
               orderby h.Year
               select h);

            Console.WriteLine(string.Join("\n", sortByYear) + "\n");

            // 2)	Write a query that lists the year, the numver of bedrooms
            //     and the number of baths for all houses. Then print the result
            Console.WriteLine("\n\nList of year + bedrooms + baths:");
            var yearBedsBaths =
              (from h in houses
               select new { h.Year, h.Beds, h.Baths });

            char start = '{';
            char end = '}';
            foreach (var el in yearBedsBaths)
            {
                Console.WriteLine("{3} Year = {0}, Beds = {1}, Baths = {2} {4}", el.Year, el.Baths, el.Baths, start, end);
            }


            // 3)	Write a query that lists the size (in square feet) and the year
            //      for all houses that are on sale. It should be ordered by size. 
            //      Print the result
            Console.WriteLine("\n\nList of houses on sale:");
            var housesOnSale = 
                from h in houses
                where h.ForSale == true
                select new { h.Sqft, h.Year};

            foreach (var el in housesOnSale)
            {
                Console.WriteLine("{2} sqft = {0}, Year = {1} {3}", el.Sqft, el.Year, start, end);
            }

            // 4)	Group the houses by bedrooms and print the result
            //      the result should be sorted by the number of bedrooms
            Console.WriteLine("\n\nHouses grouped by bedroom:");
            var housesByBedroom =
              from h in houses
              orderby h.Beds
              group h by h.Beds;

            foreach (var group in housesByBedroom)
            {

                Console.Write("{0}\n   ", group.Key);
                //Console.WriteLine("{3} sqft = {0}, Year = {1}", group, el.Baths, el.Baths, start, end);
                Console.WriteLine(String.Join("\n   ", group));
            }

        }
        #endregion

        #region Iterator
        public void PartIterator()
        {
            Numbers myNumbers =
                new Numbers(new List<int>() { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });

            // 1) Go to the file Numbers.cs and implement the three iterators that are described there

            // 2) Here in this method write some code to test all three iterators 
            //    Use single empty lines to make your output clear and easy to read


            Console.WriteLine("Double Elements: ");
            foreach (int n in myNumbers.DoubleElements())
            {
                Console.Write("{0 } ", n);
            }

            Console.WriteLine("\n\nReverse Numbers: ");
            foreach (int n in myNumbers.ReverseNumbers())
            {
                Console.Write("{0 } ", n);
            }

            Console.WriteLine("\n\nThird Elements: ");
            foreach (int n in myNumbers.ThirdElements())
            {
                Console.Write("{0 } ", n);
            }

            Console.WriteLine("\n\n\n");

        }
        #endregion
    }
}
