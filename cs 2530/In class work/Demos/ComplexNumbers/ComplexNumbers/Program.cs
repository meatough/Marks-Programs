using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComplexNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            Complex c1 = new Complex(2, 3);
            Console.WriteLine("c1: " + c1);

            Complex c2 = new Complex(1, -6);
            Console.WriteLine("c2: " + c2);

            Console.WriteLine("c1 + c2 = " + (c1 + c2));
        }
    }
}
