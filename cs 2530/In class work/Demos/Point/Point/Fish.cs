using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoInterface
{
    class Fish : Animal
    {
        private bool hasGills;

        public Fish(bool hasGills, int numberOfFeet)
            : base(numberOfFeet)
        {
            this.hasGills = hasGills;
        }

        public override void Move()
        {
            Console.WriteLine("swimm swimm");
        }
    }
}
