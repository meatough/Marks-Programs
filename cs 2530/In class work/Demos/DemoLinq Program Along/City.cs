using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq1
{
   public enum UsState
   {
      AK, AL, AR, AZ, CA, CO, CT, DE, FL, GA,
      HI, IA, ID, IL, IN, KS, KY, LA, MA, MD,
      ME, MI, MN, MO, MS, MT, NC, ND, NE, NH,
      NJ, NM, NV, NY, OH, OK, OR, PA, RI, SC,
      SD, TN, TX, UT, VA, VT, WA, WI, WV, WY
   }

   public class City
   {
      public string Name { get; set; }
      public UsState State { get; set; }
      public int Population { get; set; }
      public double Area { get; set; }

      public City(string n, UsState s, int p, double a)
      {
         Name = n;
         State = s;
         Population = p;
         Area = a;
      }

      public override string ToString()
      {
         return string.Format("{0} ({1}) P:{2} A:{3}", Name, State, Population, Area);
      }
   }
}
