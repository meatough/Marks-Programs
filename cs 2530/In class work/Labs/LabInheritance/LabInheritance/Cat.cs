using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LabInheritance
{
    class Cat : Pet
    {
        public Cat(string n) : base(n)
        {

        }
        public override string Communicate()
        {
            return "meow";
        }
    }
}
