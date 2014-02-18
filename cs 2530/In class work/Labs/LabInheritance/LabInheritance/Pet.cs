using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LabInheritance
{
   // Class Pet should NOT be modified
   public class Pet
   {
      public string Name { get; private set; }

      public Pet(string n)
      {
         Name = n;
      }

      public virtual string Communicate()
      {
         return "communicate";
      }

      public override string ToString()
      {
         return string.Format("{0} named {1}", this.GetType().Name, Name);
      }
   }

   // TODO 1) declare a class Dog that derives from Pet; 
   //         override the method Communicate to "bark"  

   // TODO 2) declare a class Cat that derives from Pet; 
   //         override the method Communicate to "meow"

}
