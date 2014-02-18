using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text;
using System.Runtime.Serialization.Formatters.Binary;
using System.Threading.Tasks;

namespace BinarySerializationDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.SetWindowSize(80,25);

            Dictionary<string, long> population = new Dictionary<string, long>{
                {"Tokyo", 32450000},
                {"New York", 19750000},
                {"Mumbai", 19200000},
                {"London", 12875000},
                {"Paris", 12161000}, 
                {"Cambridge", 125700}                               
            };

            Console.WriteLine("Original population dictionary: ");
            Console.WriteLine(String.Join("\n", population));

            using (Stream stream = new FileStream("CityPopulation.bin", FileMode.OpenOrCreate))
            {
                BinaryFormatter formatter = new BinaryFormatter();
                formatter.Serialize(stream, population);
            }
            Console.WriteLine("\ndone serializing ... ");

            using (Stream stream = new FileStream("CityPopulation.bin", FileMode.Open))
            {
                Dictionary<string, long> cityPopulation;
                BinaryFormatter formatter = new BinaryFormatter();
                cityPopulation = formatter.Deserialize(stream) as Dictionary<string, long>;
                
                Console.WriteLine("\nCity population dictionary: ");
                Console.WriteLine(String.Join("\n", cityPopulation));
            }

        }//end method
    }//end class
}//end namespace
