using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fraction
{
    class Fraction
    {
        private int numerator;
        private int denominator;

        public Fraction (int numerator, int denominator)
        {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction Multiply(Fraction f)
        {

            return this * f;
        }

        public static Fraction operator *(Fraction lhs, Fraction rhs)
        {
            int newNumerator = lhs.numerator * rhs.numerator;
            int newDenominator = lhs.denominator * rhs.denominator;

            return new Fraction(newNumerator, newDenominator);
            
        }
    
        public override string ToString()
        {
 	        return string.Format("{0}/{1}", numerator, denominator);
        }
    }
}
