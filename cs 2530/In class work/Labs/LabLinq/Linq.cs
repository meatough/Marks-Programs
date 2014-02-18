using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
//linq examples:
//http://code.msdn.microsoft.com/101-LINQ-Samples-3fb9811b


namespace Linq1
{
   class Linq
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
         Console.WriteLine("\nL I N Q   E X E R C I S E"); 
         Console.WriteLine("~~~~~~~~~~~~~~~~~~~~~~~~~");

         Console.WriteLine("\n\n1) Graduation years of FA students:");
         ListGraudationYearOfFaStudents();

         Console.WriteLine("\n\n2) Names and graduation years of CS students:");
         ListNamesAndGraudationYearOfCsStudents();

         Console.WriteLine("\n\n3) Names of CS students who graduate after 2012:");
         ListNamesOfCsStudentsGraduatingAfter2012();

         Console.WriteLine("\n\n4) All Graduation years without duplicates:");
         ListGraduationYearsWithoutDuplicates();

         Console.WriteLine("\n\n5) Graduation years withoug duplicates in descending order:");
         ListGraduationYearsWithoutDuplicatesDescending();

         Console.WriteLine("\nL I N Q   E X E R C I S E Part 2:");

         Console.WriteLine("\n\n1) Group students by year:");
         GroupStudentsByYear();

         Console.WriteLine("\n\n2) Number of students per year:");
         NumberOfStudentsPerYear();

         Console.WriteLine("\n\nExtra Challange: Numbered Students:");
         ListNumberedStudents();

         Console.WriteLine("\n\n. . . press enter . . .");
         Console.Read();
      }
      #endregion

      #region TODO 1
      // TODO 1:	Write a query that lists the graduation years of all fine art (FA) students 
      //          then run the program to test the results
      private static void ListGraudationYearOfFaStudents()
      {
          var FaGradYear =
              from s in students
              where s.Major == "FA"
              select s.Year;

          Console.WriteLine(String.Join(", ", FaGradYear));
      }
      #endregion

      #region TODO 2
      // TODO 2:	Write a query that lists the names and graduation years of all computer science (CS) students
      //          then run the program to test the results
      private static void ListNamesAndGraudationYearOfCsStudents()
      {
          var CsNameAndGradYear =
              from s in students
              where s.Major == "CS"
              select new { s.Name, s.Year };

          foreach (var el in CsNameAndGradYear)
          {
              Console.WriteLine("{0,-5} {1}", el.Name, el.Year);
          }
      }
      #endregion

      #region TODO 3
      // TODO 3:	Write a query that lists the names of CS students that graduate after 2012 
      //          then run the program to test the results 
      private static void ListNamesOfCsStudentsGraduatingAfter2012()
      {
          var CsAfter2012 =
              from s in students
              where s.Major == "CS" && s.Year > 2012 
              select s.Name;

          Console.WriteLine(String.Join(", ", CsAfter2012));
      }
      #endregion

      #region TODO 4
      // TODO 4:	Write a query that lists all graduation years but no duplicates
      //          then run the program to test the results 
      private static void ListGraduationYearsWithoutDuplicates()
      {
          var uniqueYears =
              (from s in students
               select s.Year).Distinct();

          Console.WriteLine(String.Join(", ", uniqueYears));
      }
      #endregion

      #region TODO 5
      // TODO 5:	Write a query that lists all graduation years - but no duplicates - in descending order
      //          then run the program to test the results 
      private static void ListGraduationYearsWithoutDuplicatesDescending()
      {
          var uniqueOrderedYears =
              (from s in students
               orderby s.Year
               select s.Year).Distinct();

          Console.WriteLine(String.Join(", ", uniqueOrderedYears));
      }
      #endregion

      #region TODO 6
      private static void GroupStudentsByYear()
      {
          var studentsByYear =
              from s in students
              group s by s.Year;

          foreach (var group in studentsByYear)
          {

              Console.Write("{0}\n   ", group.Key);
              Console.WriteLine(String.Join("\n   ", group));
          }
      }
      #endregion

      #region TODO 7
      private static void NumberOfStudentsPerYear()
      {
          double totalStudents = students.Count;
          var numStudentsPerYear =
              from s in students
              orderby s.Year
              group s by s.Year into g
              select new { Year = g.Key, Students = g, Size = g.Count(), 
                            Percent = ((double)g.Count()/totalStudents)*100};

          foreach (var group in numStudentsPerYear)
          {

              Console.Write(" {0}: {1} students graduate which is {2}% of all students\n   ", 
                                                            group.Year, group.Size, (int)group.Percent);
              Console.WriteLine(String.Join("\n   ", group.Students));
          }
      }
      #endregion

      #region TODO EXTRA
      private static void ListNumberedStudents()
      {
          var names =
              from s in students
              select s.Name;

          string student = "Student";
          int i = 1;
          foreach(string s in names)
          {
              string num = student + i;
              Console.WriteLine("{0}: {1}", num, s);
              i++;
          }
      }
      #endregion
   }
}
