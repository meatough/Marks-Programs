using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComplexNumbers
{
    class Complex
    {
        private int real;
        private int imaginary;

        public Complex (int real, int imaginary)
        {
            this.real = real;
            this.imaginary = imaginary;
        }

        public static Complex operator +(Complex lhs, Complex rhs)
        {
            int newReal = lhs.real + rhs.real;
            int newImaginary = lhs.imaginary + rhs.imaginary;

            return new Complex(newReal, newImaginary);
        }
        public override string ToString()
        {
 	        return string.Format("{0} + {1}i", real, imaginary);
        }
    }
}
