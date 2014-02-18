using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq1
{
   class Linq1
   {
      #region student list
      private static List<Student> students = new List<Student> {
            new Student("Don", "CS", 2015, true),
            new Student("Dan", "CS", 2012, true),
            new Student("Dee", "CS", 2013, false),
            new Student("Bob", "CJ", 2013, false),
            new Student("Ben", "CJ", 2013, true),
            new Student("Jan", "FA", 2012, true),
            new Student("Jim", "FA", 2014, false),
            new Student("Rob", "EE", 2015, true),
            new Student("Ray", "EE", 2012, true)
         };
      #endregion

      #region Main
      static void Main(string[] args)
      {
         Console.WriteLine("\n\nGroup students by honor (no group name):");
         groupStudentsByHonor();

         Console.WriteLine("\n\nGroup students that graduate by 2013 by major (with group name):");
         groupStudentsThatGraduateBy2013ByMajor();

         Console.WriteLine("\n\nGroup students by last letter of their name:");
         groupStudentsByLastLetterOfName();

         Console.WriteLine("\n\n. . . press enter . . .");
         Console.Read();
      }
      #endregion

      #region linq grouping demo
      private static void groupStudentsByHonor()
      {

      }

      private static void groupStudentsThatGraduateBy2013ByMajor()
      {

      }

      private static void groupStudentsByLastLetterOfName()
      {

      }
      #endregion

   }
}
