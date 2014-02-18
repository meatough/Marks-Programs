using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoGenerics
{
    class AsciiImage
    {
        public static void Bus()
        {
            Console.WriteLine(".----------------.");
            Console.WriteLine("|_I_I_I_I_I_I_I_I]___");
            Console.WriteLine("|  _          : ; _  )");
            Console.WriteLine("'-(_)----------=-(_)-'");
        }

        public static void Car()
        {
            Console.WriteLine("      .---;-,");
            Console.WriteLine("   __/_,{)|__;._");            
            Console.WriteLine(" .\"` _     :  _  `."); 
            Console.WriteLine(" '--(_)------(_)--'");
        }

        public static void Truck()
        {
            Console.WriteLine(".--------.__");
            Console.WriteLine("|::::::::|[_I___,");
            Console.WriteLine("|_.-.____I__.-~;|");
            Console.WriteLine(" `(_)--------(_)\"");
        }
    }
}
