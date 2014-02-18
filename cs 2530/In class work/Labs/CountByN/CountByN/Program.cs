using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CountByN
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int i = 1; i <= 5; i++)
            {
                int add = i;
                for (int j = 1; j <= i; j++)
                {
                    
                    Console.Write("{0,2} ", add);
                    add += i;
                    
                }
                Console.WriteLine();
            }
            Console.ReadKey();
        }
    }
}
