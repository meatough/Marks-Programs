using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace LabFile
{
    class Program
    {
        static void Main(string[] args)
        {
            SavePoemWithLineNumbers("poem.txt");
            PrintPoem("poem1.txt");
        }

        public static void PrintPoem(String fileName)
        {
            string poem;
            using (StreamReader reader = new StreamReader(fileName))
            {
                while((poem = reader.ReadLine()) != null)
                {
                    Console.WriteLine(poem);
                }
            }
        }

        public static void SavePoemWithLineNumbers(string fileName)
        {
            string poem;
            int lineNumber = 1;
            using (StreamReader reader = new StreamReader(fileName))
            {
                using (StreamWriter writer = new StreamWriter("poem1.txt"))
                {
                    while ((poem = reader.ReadLine()) != null)
                    {
                        writer.WriteLine("{0:00} {1}", lineNumber, poem);
                        lineNumber++;
                    
                    }
                }
            }
        }//end savepoemwithlinenumbers method
    }//end class
}//end namespace
