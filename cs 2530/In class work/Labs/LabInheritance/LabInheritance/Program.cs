using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LabInheritance
{
   public class Program
   {
      public static void Main()
      {
         Pet myPet = new Pet("Furry");
         Console.WriteLine("myPet: {0}", myPet);

         // TODO 3) create a Dog with the name "Snoopy"; print it
         Dog myDog = new Dog("Snoopy");
         // TODO 4) create a Cat with the name "Sylvester"; print it
         Cat myCat = new Cat("Sylvester");


         Console.WriteLine("\nDemonstrate Polymorphism:\n");

         // TODO 5) create an array of pets and initialize it with myPet, myDog, and myCat
         Pet[] ourPets = {myPet, myDog, myCat};


         // TODO 6) use a foreach loop to print all pets and how they communicate
         foreach (Pet p in ourPets)
         {
             Console.WriteLine("{0} {1}s", p, p.Communicate());
         }
         //myDog.Communicate();

      }
   }
}