using System;
using System.Collections.Generic;

namespace DelegateDemo
{
   delegate double ConversionDelegate(double d);

   class Program
   {
      static void Main(string[] args)
      {
         List<double> data = new List<double> { 2, 4, 6, 8, 10 };

         //Console.WriteLine("10 inches = {0} centimeters", LengthConverter.InchToCm(10));
         ConversionDelegate myConversionDelegate = LengthConverter.InchToCm;
         Console.WriteLine("10 inches = {0} centimeters", myConversionDelegate(10));
         // TODO d) convert list then call DisplayList
         DisplayList(ConvertList(data, myConversionDelegate), "Converted Data:");
         // TODO e) repeat for InchToM
         myConversionDelegate = LengthConverter.InchToM;
         DisplayList(ConvertList(data, myConversionDelegate), "Converted Data:");
         // TODO f) What about FeetToInch? (adapter method, anonymous method)
         //was delegate expression
         //myConversionDelegate = FeetToInchAdapter;
         //myConversionDelegate = (d => LengthConverter.FeetToInch((int)Math.Round(d)));
         DisplayList(ConvertList(data, d => LengthConverter.FeetToInch((int)Math.Round(d))), "Converted Data:");

         Console.WriteLine("\n");
      }
       //this is a delegateLengthConverter.FeetToInch((int)Math.Round(d));
      /*public static double FeetToInchAdapter(double d)
      {
          return LengthConverter.FeetToInch((int)Math.Round(d));
      }*/
      //this is a lambda expression
      

      private static void DisplayList<T>(List<T> list, string title)
      {
          Console.WriteLine(title);
          Console.WriteLine(String.Join(", ", list));
      }
      private static List<double> ConvertList(List<double> data, ConversionDelegate convert)
      {
          List<double> myList = new List<double>();
          foreach(double el in data)
          {
              myList.Add(convert(el));
          }
          return myList;
      }

   }
}
