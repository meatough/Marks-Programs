using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExtensionMethodLab
{
    static class MyExtensions
    {
        //extension method Squared
        //extends the struct int and returns the number squared
        public static long Squared(this int number)
        {
            int squared = number * number;
            return (long)squared;
        }

        public static bool IsPalindrome(this string str)
        {
            int i = 0;
            int j = str.Length - 1;
            while (i < j)
            {
                while (char.IsLetter(str[i]) == false || char.IsLetter(str[j]) == false)
                {
                    if (char.IsLetter(str[i]) == false)
                    {
                        i++;
                    }

                    if (char.IsLetter(str[j]) == false)
                    {
                        j--;
                    }
                }
                if (char.ToLower(str[i]) != char.ToLower(str[j]))
                {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                TestSquared();
            }
            catch (Exception ex)
            {
                Console.WriteLine("A problem occurred . . . " + ex.Message);
            }
            TestPalindrome();

        }//end main method

        /*
         * TODO 0
         * Write an extension method called squared
         * It extends the struct int and returns the number squared
         * Test the method
         */
        #region  tests the extension Squared()
        private static void TestSquared()
        {
            Console.Write("Number: ");
            string input = Console.ReadLine();
            int number;
            if (int.TryParse(input, out number))
            {
                Console.WriteLine("number.Squared() = {0}", number.Squared());
            }
            else
            {
                Console.WriteLine("The input could not be parsed to an integer");
            }
        }
        
        private static int IsInt(string prompt)
        {
            Console.Write(prompt + ": ");
            string line = Console.ReadLine();
            int number;
            if (!(int.TryParse(line, out number)))
                throw new InvalidCastException(string.Format(
                   "{0} can't be converted to an integer", line));
            return number;
        }
        #endregion


        /*
         * TODO 1
         * Write an extension method called isPalindrome
         * It extends the class string and returns true if the word is a palindrome
         * e.g. car returns false
         * e.g. racecar returns true
         * Test the method
         */

        #region test extension method IsPalindrome()
        private static void TestPalindrome()
        {
            Console.Write("Word: ");
            string phrase = Console.ReadLine();
            if (phrase.IsPalindrome() == true)
            {
                Console.WriteLine("{0} is a palindrome", phrase);
            }
            else
            {
                Console.WriteLine("{0} is not a palindrome", phrase);
            }
        }

        #endregion
    }//end class program
}//end namespace
