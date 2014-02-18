using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CS2530.ArrayTest
{
   public struct Point
   {
      // public set accessor for demo purpose
      public int X { get; set; }
      public int Y { get; set; }

      // ctor
      public Point(int xCoord, int yCoord)
         : this()
      {
         X = xCoord;
         Y = yCoord;
      }

      // ToString()
      public override string ToString()
      {
         return string.Format("({0},{1})", X, Y);
      }
   }
}
