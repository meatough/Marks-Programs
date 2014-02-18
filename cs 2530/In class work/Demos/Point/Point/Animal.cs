using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoInterface
{
    class Animal : Imovable
    {
        private int numberOfFeet;

        public Animal(int numberOfFeet)
        {
            this.numberOfFeet = numberOfFeet;
        }

        public virtual void Move()
        {
            Console.WriteLine("Moving along");
        }

        public override string ToString()
        {
            return this.GetType().Name;
        }
    }
}
