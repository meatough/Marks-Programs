using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoInterface
{
    class Program
    {
        static void Main(string[] args)
        {
            Animal pig = new Animal(4);
            Console.WriteLine(pig);
            pig.Move();

            Fish catFish = new Fish(false, 0);
            Console.WriteLine(catFish);
            catFish.Move();

            Point p1 = new Point(3, 4);
            Console.WriteLine(p1);
            p1.Move();
            Console.WriteLine(p1);

        }
    }
}
