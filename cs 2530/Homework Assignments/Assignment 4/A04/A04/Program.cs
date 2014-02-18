/***************************************************************
 * Intermiadiate Programming in c#
 * Generic Collections Program
 * Programmer: Mark Eatough
 * Course: CSIS 2530 
 * Created September 5, 2013
 *  
 * This program modifies a list of integers, and takes a string 
 * from a user, puts the words of the string into a dictionary as
 * the key, and puts the number of times the word occurs as the 
 * value
 ****************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace A04
{
    class Program
    {
        static void Main(string[] args)
        {
            ModifyList();
            /*
             I chose to use a dictionary for the FindDuplicateWordsInSentence() method because
             a dictionary allowed me to pair the word with a word count very easily which was very
             helpful for the specifications of this method
             */
            FindDuplicateWordsInSentence(); 
        }

        #region DemoModList
        public static void ModifyList()
        {
            //Create integer list object
            List<int> randList = new List<int>();
            //create random object with seed value of 17
            Random randInt = new Random(2);
            //populate list with 25 random number between 20 and 80 inclusive
            PopulateList(randList, randInt);
            //Print out list of random numbers
            Console.WriteLine("\nPrint list of 25 integers");
            Console.WriteLine("===================\n");
            PrintList(randList);
            //remove every third integer
            RemoveThirds(randList);
            //Print list again after removing every third integer
            Console.WriteLine("\n\n\nPrint list after removing ever third element");
            Console.WriteLine("===================\n");
            PrintList(randList);
            //at position 3 insert 5 prime numbers 
            InsertIfPrime(randList, randInt, 3, 5);
            //print list again after inserting 5 prime numbers at position 3
            Console.WriteLine("\n\n\nPrint list after inserting 5 prime numbers at position 3");
            Console.WriteLine("===================\n");
            PrintList(randList);
            //reverse the list
            ReverseList(randList);
            //print list again after reversing it
            Console.WriteLine("\n\n\nPrint list after reversing it");
            Console.WriteLine("===================\n");
            PrintList(randList);
            //sort the list
            randList.Sort();
            //print list again after sorting it
            Console.WriteLine("\n\n\nPrint list after sorting it");
            Console.WriteLine("===================\n");
            PrintList(randList);
            //Calculate mean
            int mean = CalculateMean(randList);
            //Calculate median
            //int medianIndex = (randList.Count) / 2;
            int median = CalculateMedian(randList);
            //Calculate Range
            int range = CalculateRange(randList);
            //Print our mean, median and range
            Console.WriteLine("\n\n\nMean = {0}", mean);
            Console.WriteLine("Median = {0}", median);
            Console.WriteLine("Range = {0}\n\n", range);
        }
        #endregion
        //method to print list
        private static void PrintList(List<int> myList)
        {
            foreach (ValueType item in myList)
            {
                Console.Write("{0}, ", item);
            }
        }
        //method to add 25 elements to list with 25 random numbers 
        //between 20 and 80 and a seed value of 17
        private static void PopulateList(List<int> myList, Random myRand)
        {
            for (int i = 0; i < 25; i++)
            {
                myList.Add(myRand.Next(20, 81));
            }
        }
        //method to remove every third integer
        private static void RemoveThirds(List<int> myList)
        {
            for (int j = myList.Count - 1; j > 0; j--)
            {
                if (j % 3 == 2)
                {
                    myList.RemoveAt(j);
                }
            }
        }
        //method to test if number is prime
        private static bool IsPrime(int n)
        {
            double o = Math.Floor(Math.Sqrt(n));
            int p = (int)o;
            while (p > 1)
            {
                if (n % p == 0)
                {
                    return false;
                }
                p--;
            }
            return true;
        }
        //method to add number if it is prime
        private static void InsertIfPrime(List<int> myList, Random myRand, int pos, int ins)
        {
            int i = 0;
            int myInt;
            while (i < ins)
            {
                myInt = myRand.Next(20, 81);
                if (IsPrime(myInt) == true)//(myInt%2 != 0)
                {
                    myList.Insert(pos, myInt);
                    i++;
                }
            }
        }
        //method to reverse list
        private static void ReverseList(List<int> myList)
        {
            int i = 0;
            int j = myList.Count - 1;
            int tempInt;
            while (j > i)
            {
                tempInt = myList[i];
                myList[i] = myList[j];
                myList[j] = tempInt;

                j--;
                i++;
            }
        }
        //method to calculate mean
        private static int CalculateMean(List<int> myList)
        {
            int mean = 0;
            foreach (int item in myList)
            {
                mean += item;
            }
            mean /= myList.Count;
            return mean;
        }
        //method to calculate range
        private static int CalculateRange(List<int> myList)
        {
            myList.Sort();
            int range = myList[myList.Count - 1] - myList[0];
            return range;
        }
        //method to calculate median
        private static int CalculateMedian(List<int> myList)
        {
            myList.Sort();
            int medianIndex = (myList.Count) / 2;
            int median = myList[medianIndex];
            return median;
        }

        #region DemoParseSentance
        public static void FindDuplicateWordsInSentence()
        {
            Dictionary<string, int> duplicate = new Dictionary<string, int>();
            string test = "The optimist thinks this is the best of all possible worlds; the pessimist fears it is true.";
            Console.WriteLine(test);
            ParseSentanceToWords(duplicate, test);
            PrintDictionary(duplicate);
            WordsMoreOnce(duplicate);
            ShortestWords(duplicate);
            MostWords(duplicate);

            UserSentance();
        }
        #endregion
        private static void AddOrIncrement(Dictionary<string, int> myDict, string word)
        {
            if (myDict.ContainsKey(word) == false)
            {
                myDict.Add(word, 1);
            }
            else
            {
                myDict[word]++;
            }
        }
        private static void ParseSentanceToWords(Dictionary<string, int> myDict, string sentance)
        {
            int i = 0;
            int j = 0;
            while (i < sentance.Length)
            {
                if (char.IsLetter(sentance[i]) == false || i == sentance.Length - 1 && char.IsLetter(sentance[i]))
                {
                    string word = "";
                    while (j < i)
                    {
                        if (char.IsLetter(sentance[j]))
                        {
                            word += char.ToLower(sentance[j]);
                            if (j == i - 1 && char.IsLetter(sentance[i]))
                            {
                                word += char.ToLower(sentance[i]);
                            }
                        }
                        j++;
                    }
                    j = i;
                    if (word.Length > 0)
                    {
                        AddOrIncrement(myDict, word);
                    }
                }
                i++;
            }
        }
        //method to print out all words, and how many times they occur
        private static void PrintDictionary(Dictionary<string, int> myDict)
        {
            foreach (KeyValuePair<string, int> entry in myDict)
            {
                Console.WriteLine("{0, -12} {1}", entry.Key, entry.Value);
            }
        }
        //method to return shortest word(s)
        private static void ShortestWords(Dictionary<string, int> myDict)
        {
            string shortest = "";
            int temp = myDict.Keys.ElementAt(0).Length;
            foreach (KeyValuePair<string, int> entry in myDict)
            {
                if (entry.Key.Length == temp)
                {
                    shortest += " " + entry.Key;
                }
                else if (entry.Key.Length < temp)
                {
                    shortest = entry.Key;
                    temp = entry.Key.Length;
                }
            }
            Console.WriteLine("Shortest word(s): {0}", shortest);
        }
        //method to print the word(s) that appear the most often
        private static void MostWords(Dictionary<string, int> myDict)
        {
            string most = ""; 
            int i = myDict.Values.ElementAt(0);
            foreach (KeyValuePair<string, int> entry in myDict)
            {
                if (entry.Value == i)
                {
                    most +=" " + entry.Key;
                }
                else if (entry.Value > i)
                {
                    most = entry.Key;
                    i = entry.Value;
                }
            }
            Console.WriteLine("Word(s) that appeared most often: {0}\n\n", most);
        }
        //method to print the word(s) that occur more than once
        private static void WordsMoreOnce(Dictionary<string, int> myDict)
        {
            int more = 0;
            foreach (KeyValuePair<string, int> entry in myDict)
            {
                if(entry.Value > 1)
                {
                    more++;
                }
            }
            Console.WriteLine("\n\nNumber of words that appear more than once: {0}", more);
        }//end WordsMoreOnce method
        //method to allow user to enter sentance
        private static void UserSentance()
        {
            Dictionary<string, int> user = new Dictionary<string, int>();
            Console.Write("Enter your phrase: ");
            string phrase = Console.ReadLine();
            Console.WriteLine(phrase);
            ParseSentanceToWords(user, phrase);
            PrintDictionary(user);
            WordsMoreOnce(user);
            ShortestWords(user);
            MostWords(user);
        }
    }//end class program
}//end namespace A04
