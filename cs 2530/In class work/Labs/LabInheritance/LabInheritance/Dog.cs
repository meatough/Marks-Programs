using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LabInheritance
{
    class Dog : Pet
    {
        public Dog(string n) : base(n)
        {

        }
        public override string Communicate()
        {
            return "bark";
        }
    }
}
